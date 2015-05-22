using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace Finah_Backend.Controllers
{
    using System;
    using System.Data.Entity;
    using System.Data.Entity.Infrastructure;
    using System.Data.Entity.Migrations;
    using System.Linq;
    using System.Net;
    using System.Threading.Tasks;
    using System.Web.Http.Cors;
    using System.Web.Http.Description;

    using Finah_Backend.DAL;
    using Finah_Backend.Models;

    [EnableCors(origins: "http://finahweb4156.azurewebsites.net, http://localhost:63342", headers: "*", methods: "*")]
    [Authorize(Roles = "Admin, Onderzoeker")]
    public class VragenLijstController : ApiController
    {
        //TODO code opschonen
        private List<VragenLijst> vragenlijsten = new List<VragenLijst>();

        private ApplicationDbContext db;

        public VragenLijstController()
        {
            db = new ApplicationDbContext();
        }

        //Constructor met als argument een List van Bevragingen, hierdoor kunnen we testdata aan
        //de Controller meegeven om zo unittesten voor de controller te schrijven.
        public VragenLijstController(List<VragenLijst> vragenlijst)
        {
            db = new ApplicationDbContext();
            this.vragenlijsten = vragenlijst;
        }




        [Route("VragenLijst/Overzicht")] //Geen Api/ meer nodig
        public IEnumerable<VragenLijst> GetOverzicht()
        //public IQueryable<VragenLijst> GetOverzicht()
        {
            db.Configuration.LazyLoadingEnabled = false;
            return db.VragenLijsten.Include(vl => vl.Vragen).Include(vl => vl.Aandoe);

        }
        [Route("VragenLijst/{id}")]
        [ResponseType(typeof(VragenLijst))]
        public IHttpActionResult Get(int id)
        {

            var vragenLijst = db.VragenLijsten.Find(id);
            if (vragenLijst == null)
            {
                return NotFound();
            }

            return Ok(vragenLijst);
        }

        [Route("VragenLijst/{id}/{vr}")]
        [ResponseType(typeof(Vraag))]
        public IHttpActionResult Get(int id, int vr)
        {

            var vraag = db.VragenLijsten.Find(id).Vragen.Where(c => c.Id == vr);

            if (vraag == null)
            {
                return NotFound();
            }

            return Ok(vraag);
        }

        // PUT: api/VragenLijsts/5
        [HttpPut]
        [Route("VragenLijst/{id}")]
        [ResponseType(typeof(void))]
        public IHttpActionResult PutVragenLijst(int id, [FromBody] VragenLijst vragenLijst)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != vragenLijst.Id)
            {
                return BadRequest();
            }
            //vragenLijst.Aandoe = db.Aandoeningen.Find(vragenLijst.Aandoe.Id);
            var vrgLijst = new VragenLijst
            {
                Id = vragenLijst.Id,
                Omschrijving = vragenLijst.Omschrijving,
                Aandoe = this.db.Aandoeningen.Find(vragenLijst.Aandoe.Id),
                Vragen = new List<Vraag>()
            };

            foreach (var v in vragenLijst.Vragen)
            {
                var vr = db.Vragen.Find(v.Id);
                vr.Thema = db.Themas.Find(v.Thema.Id);
                vr.VragenLijst.Add(db.VragenLijsten.Find(vrgLijst.Id));
                vrgLijst.Vragen.Add(vr);
                //db.Entry(vr).State = EntityState.Modified;
            }
            //db.Entry(vragenLijst.Aandoe).State = EntityState.Added;
            //db.Entry(vragenLijst.Vragen).State = EntityState.Added;

            try
            {
                //db.VragenLijsten.Attach(vrgLijst);
                //db.Entry(vrgLijst.Aandoe).State = EntityState.Modified;
                //db.Entry(vrgLijst.Vragen).State = EntityState.Modified;
                //db.Entry(vrgLijst).State = EntityState.Modified;
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!VragenLijstBestaat(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return StatusCode(HttpStatusCode.NoContent);
        }

        // POST: api/VragenLijsts
        //[Route("VragenLijst")]
        [ResponseType(typeof(VragenLijst))]
        public async Task<IHttpActionResult> PostVragenLijst([FromBody] VragenLijst vragenLijst)
        {
            var vrgLijst = new VragenLijst
                               {
                                   Omschrijving = vragenLijst.Omschrijving,
                                   Aandoe = this.db.Aandoeningen.Find(vragenLijst.Aandoe.Id)
                               };
            foreach (var v in vragenLijst.Vragen)
            {
                vrgLijst.Vragen.Add(db.Vragen.Find(v.Id));
            }


            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.VragenLijsten.Add(vrgLijst);
            await db.SaveChangesAsync();

            return CreatedAtRoute("DefaultApi", new { id = vragenLijst.Id }, vragenLijst);
        }

        [HttpDelete]
        [Route("Vragenlijst/{id}")]
        [ResponseType(typeof(VragenLijst))]
        public IHttpActionResult Delete(int id)
        {
            var vragenLijst = db.VragenLijsten.Find(id);
            if (vragenLijst == null)
            {
                return NotFound();
            }

            db.VragenLijsten.Remove(vragenLijst);
            db.SaveChanges();

            return Ok(vragenLijst);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool VragenLijstBestaat(int id)
        {
            return db.VragenLijsten.Count(e => e.Id == id) > 0;
        }
    }
}