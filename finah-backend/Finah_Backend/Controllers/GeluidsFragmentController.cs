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

    public class GeluidsFragmentController : ApiController
    {
        private FinahDBContext db;
        private List<GeluidsFragment> geluidsFragmenten = new List<GeluidsFragment>();

        public GeluidsFragmentController()
        {
            db = new FinahDBContext();
        }

        //Constructor met als argument een List van Bevragingen, hierdoor kunnen we testdata aan
        //de Controller meegeven om zo unittesten voor de controller te schrijven.
        public GeluidsFragmentController(List<GeluidsFragment> geluidsFragmenten)
        {
            db = new FinahDBContext();
            this.geluidsFragmenten = geluidsFragmenten;
        }
        [Route("GeluidsFragment/Overzicht")] //Geen Api/ meer nodig
        public IEnumerable<GeluidsFragment> GetOverzicht()// return -> naderhand veranderen in Bevraging
        //public IQueryable<GeluidsFragment> GetOverzicht()
        {
            //return db.Geluidsfragmenten;
            //return _db.Vragen.ToList();

            //return vragen;
            var g1 = new GeluidsFragment();
            var g2 = new GeluidsFragment();
            var g3 = new GeluidsFragment();
            var g4 = new GeluidsFragment();
            var g5 = new GeluidsFragment();

            g1.Id = 1;
            g2.Id = 2;
            g3.Id = 3;
            g4.Id = 4;
            g5.Id = 5;

            var overzichtGeluidsFragementen = new List<GeluidsFragment> { g1, g2, g3, g4, g5 };

            return overzichtGeluidsFragementen;
        }
        [Route("GeluidsFragment/{id}")]
        public IHttpActionResult Get(int id)
        {
            //code aangepast om te kunnen testen
            GeluidsFragment geluidsFragment = null;
            if (id == 1)
            {
                geluidsFragment = new GeluidsFragment
                                          {
                                              Id = 1,
                                              Omschrijving = "geluidsfragment vraag 1",
                                              Pad = "pad"
                                          };
            }
            //Bovenstaande code dient om te testen (op dit moment nutteloos)
            //Als database in orde is bovenstaande code wissen en onderstaande regel uncommenten
            //GeluidsFragment geluidsFragment = db.Geluidsfragmenten.Find(id);
            if (geluidsFragment == null)
            {
                return NotFound();
            }

            return Ok(geluidsFragment);
        }

        // PUT: api/GeluidsFragments/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutGeluidsFragment(int id, GeluidsFragment geluidsFragment)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != geluidsFragment.Id)
            {
                return BadRequest();
            }

            db.Entry(geluidsFragment).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!GeluidsFragmentBestaat(id))
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

        // POST: api/GeluidsFragments
        [ResponseType(typeof(GeluidsFragment))]
        public IHttpActionResult PostGeluidsFragment(GeluidsFragment geluidsFragment)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.Geluidsfragmenten.Add(geluidsFragment);
            db.SaveChanges();

            return CreatedAtRoute("DefaultApi", new { id = geluidsFragment.Id }, geluidsFragment);
        }

        // DELETE: api/GeluidsFragments/5
        [ResponseType(typeof(GeluidsFragment))]
        public IHttpActionResult DeleteGeluidsFragment(int id)
        {
            var geluidsFragment = db.Geluidsfragmenten.Find(id);
            if (geluidsFragment == null)
            {
                return NotFound();
            }

            db.Geluidsfragmenten.Remove(geluidsFragment);
            db.SaveChanges();

            return Ok(geluidsFragment);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool GeluidsFragmentBestaat(int id)
        {
            return db.Geluidsfragmenten.Count(e => e.Id == id) > 0;
        }
    }
}