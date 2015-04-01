using Finah_Backend.DAL;
using Finah_Backend.Models;
using System.Data.Entity;
using System.Data.Entity.Infrastructure;
using System.Linq;
using System.Net;
using System.Web.Http;
using System.Web.Http.Description;

namespace Finah_Backend.Controllers
{
    public class RelatieController : ApiController
    {
        private FinahDBContext db = new FinahDBContext();

        // GET: api/Relatie
        [Route("Relatie/Overzicht")]
        public IQueryable<Relatie> GetRelaties()
        {
            return db.Relaties;
        }

        // GET: api/Relatie/5
        [ResponseType(typeof(Relatie))]
        public IHttpActionResult GetRelatie(int id)
        {
            var relatie = db.Relaties.Find(id);
            if (relatie == null)
            {
                return NotFound();
            }

            return Ok(relatie);
        }

        // PUT: api/Relatie/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutRelatie(int id, Relatie relatie)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != relatie.Id)
            {
                return BadRequest();
            }

            db.Entry(relatie).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!RelatieExists(id))
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

        // POST: api/Relatie
        [ResponseType(typeof(Relatie))]
        public IHttpActionResult PostRelatie(Relatie relatie)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.Relaties.Add(relatie);
            db.SaveChanges();

            return CreatedAtRoute("DefaultApi", new { id = relatie.Id }, relatie);
        }

        // DELETE: api/Relatie/5
        [ResponseType(typeof(Relatie))]
        public IHttpActionResult DeleteRelatie(int id)
        {
            var relatie = db.Relaties.Find(id);
            if (relatie == null)
            {
                return NotFound();
            }

            db.Relaties.Remove(relatie);
            db.SaveChanges();

            return Ok(relatie);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool RelatieExists(int id)
        {
            return db.Relaties.Count(e => e.Id == id) > 0;
        }
    }
}