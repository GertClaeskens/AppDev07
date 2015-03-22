﻿using System.Collections.Generic;
using System.Web.Http;

namespace Finah_Backend.Controllers
{
    using System.Data.Entity;
    using System.Data.Entity.Infrastructure;
    using System.Linq;
    using System.Net;
    using System.Web.Http.Description;

    using Finah_Backend.DAL;
    using Finah_Backend.Models;

    public class AandoeningController : ApiController
    {
        private FinahDBContext db;
        private List<Aandoening> aandoeningen = new List<Aandoening>();

        public AandoeningController()
        {
            db = new FinahDBContext();
        }

        //Constructor met als argument een List van Bevragingen, hierdoor kunnen we testdata aan
        //de Controller meegeven om zo unittesten voor de controller te schrijven.
        public AandoeningController(List<Aandoening> aandoeningen)
        {
            db = new FinahDBContext();
            this.aandoeningen = aandoeningen;
        }

        [ResponseType(typeof(Aandoening))]
        [Route("Aandoening/{id}")]
        public IHttpActionResult Get(int id)
        {
            Aandoening aandoening = new Aandoening();
            Pathologie pt = new Pathologie();
            List<Pathologie> patLijst = new List<Pathologie>();

            pt.Id = 1;
            pt.Omschrijving = "Pathologie";
            patLijst.Add(pt);


            aandoening.Id = 1;
            aandoening.Omschrijving = "Omschrijving";
            aandoening.Patologieen = patLijst;

            //Bovenstaande code dient om te testen
            //Als database in orde is bovenstaande code wissen en onderstaande regel uncommenten
            //Aandoening aandoening = db.Aandoeningen.Find(id);
            if (aandoening == null)
            {
                return NotFound();
            }

            return Ok(aandoening);
        }

        [Route("Aandoening/Overzicht")] //Geen Api/ meer nodig
        //public IQueryable<Aandoening> GetAandoeningen()
        public IEnumerable<Aandoening> GetOverzicht()// return -> naderhand veranderen in Bevraging
        {
            //return db.Aandoeningen;

            //return vragen;

            Aandoening ad1 = new Aandoening();
            Aandoening ad2 = new Aandoening();
            Aandoening ad3 = new Aandoening();
            Aandoening ad4 = new Aandoening();
            Aandoening ad5 = new Aandoening();

            ad1.Id = 1;
            ad2.Id = 2;
            ad3.Id = 3;
            ad4.Id = 4;
            ad5.Id = 5;

            List<Aandoening> overzichtAandoeningen = new List<Aandoening> { ad1, ad2, ad3, ad4, ad5 };

            return overzichtAandoeningen;
        }

        // PUT: api/Aandoenings/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutAandoening(int id, Aandoening aandoening)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != aandoening.Id)
            {
                return BadRequest();
            }

            db.Entry(aandoening).State = EntityState.Modified;

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
        [ResponseType(typeof(Aandoening))]
        public IHttpActionResult PostAandoening(Aandoening aandoening)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.Aandoeningen.Add(aandoening);
            db.SaveChanges();

            return CreatedAtRoute("DefaultApi", new { id = aandoening.Id }, aandoening);
        }

        // DELETE: api/Aandoenings/5
        [ResponseType(typeof(Aandoening))]
        public IHttpActionResult DeleteAandoening(int id)
        {
            Aandoening aandoening = db.Aandoeningen.Find(id);
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