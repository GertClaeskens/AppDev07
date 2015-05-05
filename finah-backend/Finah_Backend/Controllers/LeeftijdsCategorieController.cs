using System.Collections.Generic;
using System.Web.Http;

namespace Finah_Backend.Controllers
{
    using System.Data.Entity;
    using System.Data.Entity.Infrastructure;
    using System.Linq;
    using System.Net;
    using System.Web.Http.Cors;
    using System.Web.Http.Description;

    using Finah_Backend.DAL;
    using Finah_Backend.Models;


    //TODO aanpassen naar azure website
    [EnableCors(origins: "http://localhost:63342", headers: "*", methods: "*")]
    public class LeeftijdsCategorieController : ApiController
    {
        //TODO code opschonen
        // GET: api/LeeftijdsCategorie
        private List<LeeftijdsCategorie> leeftijdsCategorieen = new List<LeeftijdsCategorie>();

        private FinahDBContext db;

        public LeeftijdsCategorieController()
        {
            db = new FinahDBContext();
        }

        //Constructor met als argument een List van Bevragingen, hierdoor kunnen we testdata aan
        //de Controller meegeven om zo unittesten voor de controller te schrijven.
        public LeeftijdsCategorieController(List<LeeftijdsCategorie> leeftijdsCategorieen)
        {
            db = new FinahDBContext();
            this.leeftijdsCategorieen = leeftijdsCategorieen;
        }


        [Route("LeeftijdsCategorie/Overzicht")] //Geen Api/ meer nodig
        //public IQueryable<LeeftijdsCategorie> GetOverzicht()// return -> naderhand veranderen in Bevraging
        public IEnumerable<LeeftijdsCategorie> GetOverzicht()
        {
            return db.LeeftijdsCategorieen;
        }
        //Geen Api/ meer nodig
        [ResponseType(typeof(LeeftijdsCategorie))]
        [Route("LeeftijdsCategorie/{id}")]
        public IHttpActionResult Get(int id)
        {
            var leeftijdsCategorie = db.LeeftijdsCategorieen.Find(id);
            if (leeftijdsCategorie == null)
            {
                return NotFound();
            }

            return Ok(leeftijdsCategorie);
        }
        // PUT: api/LeeftijdsCategories/5
        [Route("LeeftijdsCategorie/{id}")]
        [ResponseType(typeof(void))]
        public IHttpActionResult PutLeeftijdsCategorie(int id, [FromBody] LeeftijdsCategorie leeftijdsCategorie)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != leeftijdsCategorie.Id)
            {
                return BadRequest();
            }

            db.Entry(leeftijdsCategorie).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!LeeftijdsCategorieBestaat(id))
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

        // POST: api/LeeftijdsCategories
        [ResponseType(typeof(LeeftijdsCategorie))]
        public IHttpActionResult PostLeeftijdsCategorie(LeeftijdsCategorie leeftijdsCategorie)
        {
            //if (!ModelState.IsValid)
            //{
            //    return BadRequest(ModelState);
            //}

            db.LeeftijdsCategorieen.Add(leeftijdsCategorie);
            db.SaveChanges();

            return CreatedAtRoute("DefaultApi", new { id = leeftijdsCategorie.Id }, leeftijdsCategorie);
        }

        // DELETE: api/LeeftijdsCategories/5
        [HttpDelete]
        [Route("LeeftijdsCategorie/{id}")]
        [ResponseType(typeof(LeeftijdsCategorie))]
        public IHttpActionResult DeleteLeeftijdsCategorie(int id)
        {
            var leeftijdsCategorie = db.LeeftijdsCategorieen.Find(id);
            if (leeftijdsCategorie == null)
            {
                return NotFound();
            }

            db.LeeftijdsCategorieen.Remove(leeftijdsCategorie);
            db.SaveChanges();

            return Ok(leeftijdsCategorie);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool LeeftijdsCategorieBestaat(int id)
        {
            return db.LeeftijdsCategorieen.Count(e => e.Id == id) > 0;
        }
    }
}