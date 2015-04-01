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

            //return bevragingen;

            #region Hardcoded Objecten - commented

            //var overzichtPathologie = new List<Pathologie>
            //                                           {
            //                                               new Pathologie { Id = 1, Omschrijving = "Pathologie 1" },
            //                                               new Pathologie { Id = 2, Omschrijving = "Pathologie 2" },
            //                                               new Pathologie { Id = 3, Omschrijving = "Pathologie 3" },
            //                                               new Pathologie { Id = 4, Omschrijving = "Pathologie 4" },
            //                                               new Pathologie { Id = 5, Omschrijving = "Pathologie 5" }
            //                                           };

            //return overzichtPathologie;

            #endregion Hardcoded Objecten - commented
        }

        [ResponseType(typeof(Pathologie))]
        //Geen Api/ meer nodig
        [Route("Pathologie/{id}")]
        public IHttpActionResult Get(int id)
        {
            #region Hardcoded Objecten - commented

            //Pathologie pathologie = null;
            //var overzichtPathologie = new List<Pathologie>
            //                                           {
            //                                               new Pathologie { Id = 1, Omschrijving = "Pathologie 1" },
            //                                               new Pathologie { Id = 2, Omschrijving = "Pathologie 2" },
            //                                               new Pathologie { Id = 3, Omschrijving = "Pathologie 3" },
            //                                               new Pathologie { Id = 4, Omschrijving = "Pathologie 4" },
            //                                               new Pathologie { Id = 5, Omschrijving = "Pathologie 5" }
            //                                           };

            //pathologie = overzichtPathologie[id - 1];
            //Bovenstaande code dient om te testen
            //Als database in orde is bovenstaande code wissen en onderstaande regel uncommenten

            #endregion Hardcoded Objecten - commented

            var pathologie = db.Pathologieen.Find(id);
            if (pathologie == null)
            {
                return NotFound();
            }

            return Ok(pathologie);
        }

        // PUT: api/Pathologies/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutPathologie(int id, Pathologie pathologie)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != pathologie.Id)
            {
                return BadRequest();
            }

            db.Entry(pathologie).State = EntityState.Modified;

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
        public IHttpActionResult PostPathologie(Pathologie pathologie)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.Pathologieen.Add(pathologie);
            db.SaveChanges();

            return CreatedAtRoute("DefaultApi", new { id = pathologie.Id }, pathologie);
        }

        // DELETE: api/Pathologies/5
        [ResponseType(typeof(Pathologie))]
        public IHttpActionResult DeletePathologie(int id)
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