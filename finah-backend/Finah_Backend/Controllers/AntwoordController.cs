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
        private FinahDBContext db = new FinahDBContext();

        // GET: api/Antwoord
        public IQueryable<Antwoord> GetOverzicht()
        {
            return db.Antwoords;
        }

        // GET: api/Antwoord/5
        [ResponseType(typeof(Antwoord))]
        public IHttpActionResult GetAntwoord(int id)
        {
            Antwoord antwoord = db.Antwoords.Find(id);
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

            db.Antwoords.Add(antwoord);
            db.SaveChanges();

            return CreatedAtRoute("DefaultApi", new { id = antwoord.Id }, antwoord);
        }

        // DELETE: api/Antwoord/5
        [ResponseType(typeof(Antwoord))]
        public IHttpActionResult DeleteAntwoord(int id)
        {
            Antwoord antwoord = db.Antwoords.Find(id);
            if (antwoord == null)
            {
                return NotFound();
            }

            db.Antwoords.Remove(antwoord);
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
            return db.Antwoords.Count(e => e.Id == id) > 0;
        }
    }
}