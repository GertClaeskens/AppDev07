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

            var vl = db.VragenLijsten.Find(id);
            vl.Omschrijving = vragenLijst.Omschrijving;
            //Verwijder de verwijzing naar deze aandoening uit de pathologieen in de lijst.
            if (vl.Vragen.Count != 0 && vl.Vragen != null)
            {
                //Sla de pathologieen eerst op in een lijst -> anders problemen dat de verzamling veranderd is tijdens de foreach
                var vrLijst = vl.Vragen.ToList();
                foreach (var vr in vrLijst.Select(a => this.db.Vragen.Find(a.Id)))
                {
                    vr.VragenLijst.Remove(this.db.VragenLijsten.Find(id));
                    this.db.Entry(vr).State = EntityState.Modified;
                }
            }
            //Maak de lijst leeg
            vl.Vragen = new List<Vraag>();
            db.SaveChanges();


            if (vragenLijst.Vragen != null && vragenLijst.Vragen.Count != 0)
            {
                foreach (var a in vragenLijst.Vragen)
                {
                    vl.Vragen.Add(db.Vragen.Find(a.Id));
                    var ad = db.Vragen.Find(a.Id);
                    ad.VragenLijst.Add(db.VragenLijsten.Find(vl.Id));
                    db.Entry(ad).State = EntityState.Modified;
                }
            }
            db.Entry(vl).State = EntityState.Modified;



            try
            {
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
        public IHttpActionResult PostVragenLijst([FromBody] VragenLijst vragenLijst)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            var vrl = new VragenLijst { Omschrijving = vragenLijst.Omschrijving, Vragen = new List<Vraag>() };
            if (vragenLijst.Vragen != null && vragenLijst.Vragen.Count != 0)
            {
                foreach (var vrag in vragenLijst.Vragen)
                {
                    vrl.Vragen.Add(db.Vragen.Find(vrag.Id));

                }
            }
            db.VragenLijsten.Add(vrl);
            db.SaveChanges();

            if (vrl.Vragen == null || vrl.Vragen.Count != 0)
            {
                return this.Ok();
            }
            foreach (var vrg in vrl.Vragen.Select(ad => this.db.Vragen.Find(ad.Id)))
            {
                vrg.VragenLijst.Add(db.VragenLijsten.Find(vrl.Id));
                this.db.SaveChanges();
            }


            return this.Ok();

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