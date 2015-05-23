using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace Finah_Backend.Controllers
{
    using System.Runtime.CompilerServices;
    using System.Web.Http.Cors;

    using Finah_Backend.DAL;
    using Finah_Backend.Models;
    using System.Data.Entity;
    using System.Data.Entity.Infrastructure;
    using System.Linq;
    using System.Net;
    using System.Web.Http.Description;

    //TODO aanpassen naar azure website
    [EnableCors(origins: "http://finahweb4156.azurewebsites.net, http://localhost:63342", headers: "*", methods: "*")]
    [Authorize(Roles = "Admin, Onderzoeker")]
    public class AandoeningController : ApiController
    {
        //TODO code opschonen als alles bolt
        private ApplicationDbContext db;
        private List<Aandoening> aandoeningen = new List<Aandoening>();

        public AandoeningController()
        {
            db = new ApplicationDbContext();
        }

        //Constructor met als argument een List van Bevragingen, hierdoor kunnen we testdata aan
        //de Controller meegeven om zo unittesten voor de controller te schrijven.
        public AandoeningController(List<Aandoening> aandoeningen)
        {
            db = new ApplicationDbContext();
            this.aandoeningen = aandoeningen;
        }


        [Route("Aandoening/{id}/Pathologie")]
        public IEnumerable<Pathologie> GetPathologieen(int id)
        {
            return db.Aandoeningen.Find(id).Patologieen;
        }

        [Route("Aandoening/{id}/VragenLijst")]
        public IEnumerable<VragenLijst> GetVragenLijst(int id)
        {
            //Er is een vragenlijst per aandoening.
            db.Configuration.LazyLoadingEnabled = false;
            var v = (from vr in db.VragenLijsten where vr.Aandoe.Id == id select vr).Include(vr => vr.Aandoe).Include(vr => vr.Vragen).Include(vr => vr.Vragen);

            return v;
        }
        [HttpGet]
        [ResponseType(typeof(Aandoening))]
        [Route("Aandoening/{id}")]
        public IHttpActionResult Get(int id)
        {
            #region Hardcoded object voor testing - commented

            //Aandoening aandoening = null;
            //if (id == 1)
            //{
            //    aandoening = new Aandoening();
            //    var pt = new Pathologie();
            //    var patLijst = new List<Pathologie>();

            //    pt.Id = 1;
            //    pt.Omschrijving = "Pathologie";
            //    patLijst.Add(pt);

            //    aandoening.Id = 1;
            //    aandoening.Omschrijving = "Omschrijving";
            //    aandoening.Patologieen = patLijst;
            //}
            //Bovenstaande code dient om te testen
            //Als database in orde is bovenstaande code wissen en onderstaande regel uncommenten

            #endregion Hardcoded object voor testing - commented

            var aandoening = db.Aandoeningen.Find(id);
            if (aandoening == null)
            {
                return NotFound();
            }

            return Ok(aandoening);
        }

        [Route("Aandoening/Overzicht")] //Geen Api/ meer nodig
        //public IQueryable<Aandoening> GetAandoeningen()
        public IEnumerable<Aandoening> GetOverzicht()
        {
            db.Configuration.LazyLoadingEnabled = false;
            return db.Aandoeningen.Include(a => a.Patologieen);
        }

        // PUT: api/Aandoenings/5
        [HttpPut]
        [Route("Aandoening/{id}")]
        [ResponseType(typeof(void))]
        public IHttpActionResult Put(int id, Aandoening aandoening)
        {
            db = new ApplicationDbContext();
            //TODO nog niet waterdicht? -> Transactie?
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != aandoening.Id)
            {
                return BadRequest();
            }

            var a = db.Aandoeningen.Find(id);
            a.Omschrijving = aandoening.Omschrijving;
            //
            //Verwijder de verwijzing naar deze aandoening uit de pathologieen in de lijst.
            if (a.Patologieen.Count != 0 && a.Patologieen != null)
            {
                //Sla de pathologieen eerst op in een lijst -> anders problemen dat de verzamling veranderd is tijdens de foreach
                var patLijst = a.Patologieen.ToList();
                foreach (var pa in patLijst.Select(p => this.db.Pathologieen.Find(p.Id)))
                {
                    pa.Aandoeningen.Remove(this.db.Aandoeningen.Find(id));
                    this.db.Entry(pa).State = EntityState.Modified;
                }
            }
            //Maak de lijst leeg
            a.Patologieen = new List<Pathologie>();
            db.SaveChanges();

            if (aandoening.Patologieen.Count != 0 && aandoening.Patologieen != null)
            {
                foreach (var p in aandoening.Patologieen)
                {
                    a.Patologieen.Add(db.Pathologieen.Find(p.Id));
                    var pa = db.Pathologieen.Find(p.Id);
                    pa.Aandoeningen.Add(db.Aandoeningen.Find(a.Id));
                    db.Entry(pa).State = EntityState.Modified;
                }
            }
            db.Entry(a).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!AandoeningBestaat(id))
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

        // POST: api/Aandoenings
        [HttpPost]
        [ResponseType(typeof(Aandoening))]
        //public IHttpActionResult PostAandoening(Aandoening aandoening)
        //public async Task<IHttpActionResult> PostAandoening([FromBody] Aandoening aandoening)
        public IHttpActionResult Post([FromBody] Aandoening aandoening)
        {
            if (!ModelState.IsValid)
            {
                //throw new HttpResponseException(Request.CreateErrorResponse(HttpStatusCode.BadRequest, this.ModelState));
                return BadRequest(ModelState);
            }

            var aand = new Aandoening { Omschrijving = aandoening.Omschrijving, Patologieen = new List<Pathologie>() };
            if (aandoening.Patologieen.Count != 0)
            {
                foreach (var pathologie in aandoening.Patologieen)
                {
                    aand.Patologieen.Add(db.Pathologieen.Single(p => p.Id == pathologie.Id));

                }
            }

            db.Aandoeningen.Add(aand);
            db.SaveChanges();
            if (aandoening.Patologieen.Count == 0)
            {
                return this.Ok();
            }
            foreach (var pat in aandoening.Patologieen.Select(pathologie => this.db.Pathologieen.Find(pathologie.Id)))
            {
                pat.Aandoeningen.Add(this.db.Aandoeningen.Find(aandoening.Id));
                this.db.SaveChanges();
            }

            //return Ok(aand);
            return CreatedAtRoute("DefaultApi", new { id = aandoening.Id }, aandoening);
        }

        // DELETE: api/Aandoenings/5
        [HttpDelete]
        [Route("Aandoening/{id}")]
        [ResponseType(typeof(Aandoening))]
        public IHttpActionResult Delete(int id)
        {
            var aandoening = db.Aandoeningen.Find(id);
            if (aandoening == null)
            {
                return NotFound();
            }

            db.Aandoeningen.Remove(aandoening);
            db.SaveChanges();

            return Ok(aandoening);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool AandoeningBestaat(int id)
        {
            return db.Aandoeningen.Count(e => e.Id == id) > 0;
        }
    }
}