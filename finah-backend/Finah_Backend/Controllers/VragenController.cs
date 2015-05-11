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
            var vr = new Vraag
                         {
                             Id = vraag.Id,
                             VraagStelling = vraag.VraagStelling,
                             Thema = this.db.Themas.Find(vraag.Thema.Id),
                             Afbeelding = this.db.Fotos.Find(vraag.Afbeelding.Id),
                             Geluid = this.db.Geluidsfragmenten.Find(vraag.Geluid.Id)
                         };
            foreach (var vl in vraag.VragenLijst)
            {
                vr.VragenLijst.Add(db.VragenLijsten.Find(vl.Id));
            }


            //db.Entry(vraag).State = EntityState.Modified;

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
        [HttpDelete]
        [ResponseType(typeof(Vraag))]
        public IHttpActionResult PostVraag([FromBody] Vraag vraag)
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
        [HttpDelete]
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