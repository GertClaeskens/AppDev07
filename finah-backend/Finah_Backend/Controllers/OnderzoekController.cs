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
    public class OnderzoekController : ApiController
    {
        private FinahDBContext db = new FinahDBContext();

        // GET: api/Onderzoek
        public IQueryable<Onderzoek> GetOnderzoeken()
        {
            return db.Onderzoeken;
        }

        // GET: api/Onderzoek/5
        [ResponseType(typeof(Onderzoek))]
        public IHttpActionResult GetOnderzoek(int id)
        {
            Onderzoek onderzoek = db.Onderzoeken.Find(id);
            if (onderzoek == null)
            {
                return NotFound();
            }

            return Ok(onderzoek);
        }

        // PUT: api/Onderzoek/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutOnderzoek(int id, Onderzoek onderzoek)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != onderzoek.Id)
            {
                return BadRequest();
            }

            db.Entry(onderzoek).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!OnderzoekExists(id))
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

        // POST: api/Onderzoek
        [ResponseType(typeof(Onderzoek))]
        public void PostOnderzoek([FromBody] Onderzoek onderzoek)
        {
            //if (!ModelState.IsValid)
            //{
            //    return BadRequest(ModelState);
            //}

            onderzoek.Pathologie = db.Pathologieen.Find(onderzoek.Pathologie.Id);
            onderzoek.Relatie = db.Relaties.Find(onderzoek.Relatie.Id);
            onderzoek.Aandoening = db.Aandoeningen.Find(onderzoek.Aandoening.Id);
            onderzoek.Vragen = db.VragenLijsten.Find(onderzoek.Vragen.Id);
            //onderzoek.AangemaaktDoor = db.Accounts.Find(onderzoek.AangemaaktDoor.Id);
            db.Onderzoeken.Add(onderzoek);
            db.SaveChanges();

            //return CreatedAtRoute("DefaultApi", new { id = onderzoek.Id }, onderzoek);
        }

        // DELETE: api/Onderzoek/5
        [ResponseType(typeof(Onderzoek))]
        public IHttpActionResult DeleteOnderzoek(int id)
        {
            Onderzoek onderzoek = db.Onderzoeken.Find(id);
            if (onderzoek == null)
            {
                return NotFound();
            }

            db.Onderzoeken.Remove(onderzoek);
            db.SaveChanges();

            return Ok(onderzoek);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool OnderzoekExists(int id)
        {
            return db.Onderzoeken.Count(e => e.Id == id) > 0;
        }
    }
}