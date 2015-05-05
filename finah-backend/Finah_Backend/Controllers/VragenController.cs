using System.Collections.Generic;
using System.Web.Http;
using System.Data.Entity;
using System.Data.Entity.Infrastructure;
using System.Linq;
using System.Net;
using System.Web.Http.Description;
using Finah_Backend.DAL;
using Finah_Backend.Models;

namespace Finah_Backend.Controllers
{


    public class VragenController : ApiController
    {
        //TODO code opschonen
        private List<Vraag> vragen = new List<Vraag>();

        private readonly FinahDBContext db;

        public VragenController()
        {
            db = new FinahDBContext();
        }

        //Constructor met als argument een List van Bevragingen, hierdoor kunnen we testdata aan
        //de Controller meegeven om zo unittesten voor de controller te schrijven.
        public VragenController(List<Vraag> vragen)
        {
            db = new FinahDBContext();
            this.vragen = vragen;
        }

        [ResponseType(typeof(Vraag))]
        [Route("Vragen/{id}")]
        public IHttpActionResult Get(int id)
        {
            var vraag = db.Vragen.Find(id);
            if (vraag == null)
            {
                return NotFound();
            }

            return Ok(vraag);
        }

        [Route("Vragen/Overzicht")] //Geen Api/ meer nodig
        //public IQueryable<Vraag> GetOverzicht()
        public IEnumerable<Vraag> GetOverzicht()// return -> naderhand veranderen in Bevraging
        {
            return db.Vragen;
        }

        // PUT: api/Vragen/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutCourse(int id, [FromBody] Vraag vraag)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != vraag.Id)
            {
                return BadRequest();
            }

            db.Entry(vraag).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!VraagBestaat(id))
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

        // POST: api/Courses
        [ResponseType(typeof(Vraag))]
        public IHttpActionResult PostCourse([FromBody] Vraag vraag)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.Vragen.Add(vraag);
            db.SaveChanges();

            return CreatedAtRoute("DefaultApi", new { id = vraag.Id }, vraag);
        }

        // DELETE: api/Courses/5
        [ResponseType(typeof(Vraag))]
        public IHttpActionResult DeleteCourse(int id)
        {
            var vraag = db.Vragen.Find(id);
            if (vraag == null)
            {
                return NotFound();
            }

            db.Vragen.Remove(vraag);
            db.SaveChanges();

            return Ok(vraag);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool VraagBestaat(int id)
        {
            return db.Vragen.Count(e => e.Id == id) > 0;
        }
    }
}