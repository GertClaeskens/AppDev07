using System.Collections.Generic;
using System.Web.Http;

namespace Finah_Backend.Controllers
{
    using Finah_Backend.DAL;
    using Finah_Backend.Models;
    using System.Data.Entity;
    using System.Data.Entity.Infrastructure;
    using System.Linq;
    using System.Net;
    using System.Web.Http.Description;

    public class PathologieController : ApiController
    {
        // GET: api/Pathologie
        private List<Pathologie> pathologieen = new List<Pathologie>();

        private FinahDBContext db;

        public PathologieController()
        {
            db = new FinahDBContext();
        }

        //Constructor met als argument een List van Bevragingen, hierdoor kunnen we testdata aan
        //de Controller meegeven om zo unittesten voor de controller te schrijven.
        public PathologieController(List<Pathologie> pathologieen)
        {
            db = new FinahDBContext();
            this.pathologieen = pathologieen;
        }

        [Route("Pathologie/Overzicht")] //Geen Api/ meer nodig
        public IQueryable<Pathologie> GetOverzicht()
        //public IEnumerable<Pathologie> GetOverzicht()// return -> naderhand veranderen in Bevraging
        {
            return db.Pathologieen;
        }

        [ResponseType(typeof(Pathologie))]
        //Geen Api/ meer nodig
        [Route("Pathologie/{id}")]
        public IHttpActionResult Get(int id)
        {
            var pathologie = db.Pathologieen.Find(id);
            if (pathologie == null)
            {
                return NotFound();
            }

            return Ok(pathologie);
        }

        // PUT: api/Pathologies/5
        [HttpPut]
        [Route("Pathologie/{id}")]
        [ResponseType(typeof(void))]
        public IHttpActionResult PutPathologie(int id, [FromBody] Pathologie pathologie)
        {
            //TODO nakijken of dit nog werkt als er aandoeningen zijn aan toegevoegd
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != pathologie.Id)
            {
                return BadRequest();
            }

            var p = new Pathologie { Id = pathologie.Id, Omschrijving = pathologie.Omschrijving };
            foreach (var a in pathologie.Aandoeningen)
            {
                pathologie.Aandoeningen.Add(db.Aandoeningen.Find(a.Id));
            }
            //db.Entry(pathologie).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!PathologieBestaat(id))
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

        // POST: api/Pathologies
        [ResponseType(typeof(Pathologie))]
        public void PostPathologie([FromBody] Pathologie pathologie)
        {
            //if (!ModelState.IsValid)
            //{
            //    return BadRequest(ModelState);
            //}
            var pat = new Pathologie { Omschrijving = pathologie.Omschrijving, Aandoeningen = new List<Aandoening>() };
            foreach (var aand in pathologie.Aandoeningen)
            {
                pat.Aandoeningen.Add(db.Aandoeningen.Find(aand.Id));
            }
            db.Pathologieen.Add(pat);
            db.SaveChanges();

            //return CreatedAtRoute("DefaultApi", new { id = pathologie.Id }, pathologie);
        }

        // DELETE: api/Pathologies/5
        [HttpDelete]
        [Route("Pathologie/{id}")]
        [ResponseType(typeof(Pathologie))]
        public IHttpActionResult Delete(int id)
        {
            var pathologie = db.Pathologieen.Find(id);
            if (pathologie == null)
            {
                return NotFound();
            }

            db.Pathologieen.Remove(pathologie);
            db.SaveChanges();

            return Ok(pathologie);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool PathologieBestaat(int id)
        {
            return db.Pathologieen.Count(e => e.Id == id) > 0;
        }
    }
}