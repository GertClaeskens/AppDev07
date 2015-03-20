using System.Collections.Generic;
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

    public class AanvraagController : ApiController
    {
        private readonly FinahDBContext db = new FinahDBContext();

        // GET: api/Aanvraag
        [Route("Aanvraag/Overzicht")]
        public IQueryable<Aanvraag> GetOverzicht()
        {
            return db.Aanvragen;
        }

        // GET: api/Aanvraag/5
        [Route("Aanvraag/{id}")]
        [ResponseType(typeof(Aanvraag))]
        public IHttpActionResult Get(int id)
        {
            Aanvraag aanvraag = db.Aanvragen.Find(id);
            if (aanvraag == null)
            {
                return NotFound();
            }

            return Ok(aanvraag);
        }

        // PUT: api/Aanvraags/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutAanvraag(int id, Aanvraag aanvraag)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != aanvraag.Id)
            {
                return BadRequest();
            }

            db.Entry(aanvraag).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!AanvraagBestaat(id))
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

        // POST: api/Aanvraags
        [ResponseType(typeof(Aanvraag))]
        public IHttpActionResult PostAanvraag(Aanvraag aanvraag)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.Aanvragen.Add(aanvraag);
            db.SaveChanges();

            return CreatedAtRoute("DefaultApi", new { id = aanvraag.Id }, aanvraag);
        }

        // DELETE: api/Aanvraags/5
        [ResponseType(typeof(Aanvraag))]
        public IHttpActionResult DeleteAanvraag(int id)
        {
            Aanvraag aanvraag = db.Aanvragen.Find(id);
            if (aanvraag == null)
            {
                return NotFound();
            }

            db.Aanvragen.Remove(aanvraag);
            db.SaveChanges();

            return Ok(aanvraag);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool AanvraagBestaat(int id)
        {
            return db.Aanvragen.Count(e => e.Id == id) > 0;
        }
    }
}