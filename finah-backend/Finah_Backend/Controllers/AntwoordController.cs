using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Data.Entity.Infrastructure;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Http.Description;
using Finah_Backend.DAL;
using Finah_Backend.Models;

namespace Finah_Backend.Controllers
{
    public class AntwoordController : ApiController
    {
        //TODO Code opschonen als alles bolt
        private ApplicationDbContext db = new ApplicationDbContext();

        // GET: api/Antwoord
        [Route("Antwoord/Overzicht")] //Geen Api/ meer nodig

        //public IQueryable<Antwoord> GetOverzicht()
        public IEnumerable<Antwoord> GetOverzicht()
        {
            return db.Antwoorden;
            //var ad1 = new Antwoord { Id = 1 };
            //var ad2 = new Antwoord { Id = 2 };
            //var ad3 = new Antwoord { Id = 3 };
            //var ad4 = new Antwoord { Id = 4 };
            //var ad5 = new Antwoord { Id = 5 };

            //var controleAntwoorden = new List<Antwoord> { ad1, ad2, ad3, ad4, ad5 };
            //return controleAntwoorden;
        }

        // GET: api/Antwoord/5
        [ResponseType(typeof(Antwoord))]
        public IHttpActionResult Get(int id)
        {
            //Antwoord antwoord = null;
            //if (id == 1)
            //{
            //    antwoord = new Antwoord { Id = 1, Antword = 4 };
            //}
            var antwoord = db.Antwoorden.Find(id);
            if (antwoord == null)
            {
                return NotFound();
            }

            return Ok(antwoord);
        }

        // PUT: api/Antwoord/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutAntwoord(int id, Antwoord antwoord)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != antwoord.Id)
            {
                return BadRequest();
            }

            db.Entry(antwoord).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!AntwoordExists(id))
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

        // POST: api/Antwoord
        [ResponseType(typeof(Antwoord))]
        public IHttpActionResult PostAntwoord(Antwoord antwoord)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.Antwoorden.Add(antwoord);
            db.SaveChanges();

            return CreatedAtRoute("DefaultApi", new { id = antwoord.Id }, antwoord);
        }

        // DELETE: api/Antwoord/5
        [ResponseType(typeof(Antwoord))]
        public IHttpActionResult DeleteAntwoord(int id)
        {
            var antwoord = db.Antwoorden.Find(id);
            if (antwoord == null)
            {
                return NotFound();
            }

            db.Antwoorden.Remove(antwoord);
            db.SaveChanges();

            return Ok(antwoord);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool AntwoordExists(int id)
        {
            return db.Antwoorden.Count(e => e.Id == id) > 0;
        }
    }
}