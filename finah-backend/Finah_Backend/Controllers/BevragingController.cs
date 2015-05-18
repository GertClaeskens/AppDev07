using System;
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

    //[Authorize]
    public class BevragingController : ApiController
    {
        //private const string sourceUrl = "http://finahbackend1920.azurewebsites.net/Bevraging/";
        //TODO code opschonen

        private List<Bevraging> bevragingen = new List<Bevraging>();
        private ApplicationDbContext db;

        public BevragingController()
        {
            db = new ApplicationDbContext();
        }

        //Constructor met als argument een List van Bevragingen, hierdoor kunnen we testdata aan
        //de Controller meegeven om zo unittesten voor de controller te schrijven.
        public BevragingController(List<Bevraging> bevragingen)
        {
            db = new ApplicationDbContext();
            this.bevragingen = bevragingen;
        }

        //GetLink
        //Geen Api/ meer nodig
        [Route("Bevraging/UniekeIds")]
        // return -> naderhand veranderen in Bevraging
        public IHttpActionResult GetUniekeIds()
        {
            //Code staat hier maar ter info
            //return "Ingegeven ID: " + id;
            //vragen ophalen en antwoorden linken aan persoon
            //Test genereren Unique ID (Source = http://stackoverflow.com/questions/11313205/generate-a-unique-id)
            var linken = new List<string>();
            for (var i = 0; i < 2; i++)
            {
                var link = string.Format("{0:N}", Guid.NewGuid());
                linken.Add(link);

                //while (link == null)
                //{
                //    //nieuwe link genereren
                //    link = string.Format("{0}{1:N}", sourceUrl, Guid.NewGuid());
                //    //Methode aanspreken voor testen op duplicaat
                //    TestLinkOnDuplicate(link);
                //}
            }
            //Momenteel gegenereerde link tonen
            return this.Ok(linken);
        }

        //Geen Api/ meer nodig
        [Route("Bevraging/{id}")]
        [ResponseType(typeof(Bevraging))]
        public IHttpActionResult Get(String id)
        {

            var bevraging = db.Bevragingen.FirstOrDefault((b) => b.Id == id);

            if (bevraging == null)
            {
                return NotFound();
            }
            return Ok(bevraging);
        }

        [Route("Bevraging/Overzicht")] //Geen Api/ meer nodig
        //public IQueryable<Bevraging> GetOverzicht()
        public IEnumerable<Bevraging> GetOverzicht()// return -> naderhand veranderen in Bevraging
        {
            return db.Bevragingen;
        }

        // PUT: api/Bevragings/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutBevraging(string id, Bevraging bevraging)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != bevraging.Id)
            {
                return BadRequest();
            }

            db.Entry(bevraging).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!BevragingBestaat(id))
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

        // POST: api/Bevragings
        [ResponseType(typeof(Bevraging))]
        public IHttpActionResult PostBevraging([FromBody] Bevraging bevraging)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.Bevragingen.Add(bevraging);

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateException)
            {
                if (BevragingBestaat(bevraging.Id))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtRoute("DefaultApi", new { id = bevraging.Id }, bevraging);
        }

        // DELETE: api/Bevragings/5
        [ResponseType(typeof(Bevraging))]
        public IHttpActionResult DeleteBevraging(string id)
        {
            var bevraging = db.Bevragingen.Find(id);
            if (bevraging == null)
            {
                return NotFound();
            }

            db.Bevragingen.Remove(bevraging);
            db.SaveChanges();

            return Ok(bevraging);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool BevragingBestaat(string id)
        {
            return db.Bevragingen.Count(e => e.Id == id) > 0;
        }

        //Test voor duplicaat link
        //
        //
        //mailke naar Mr. Hermans sturen of we wel moeten testen op duplicate waarden of er van mogen uitgaan dat deze uniek is
        //omdat de kans op collisions onnoemelijk klein zijn
        //
        //private void TestLinkOnDuplicate(string linkToTest)
        //{
        //    //var voor genereren tijdelijke fake link om DB na te bootsen
        //    string fakeDBLink;

        //    //List = alle waardes uit DB ophalen (als DB in werking is)
        //    //run foreach, for now use For loop
        //    for (var i = 0; i < 1000; i++)
        //    {
        //        //Momenteel fake link gebruiken voor controle
        //        fakeDBLink = string.Format("{0}{1:N}", sourceUrl, Guid.NewGuid());
        //        //controleren als duplicaat
        //        if (linkToTest.Equals(fakeDBLink))
        //        {
        //            //private link binne class op null zetten zodat hij terug door de while gaat.
        //            link = null;
        //            //In geval van duplicaat, verlaat loop
        //            break;
        //        }
        //    }
        //    return;
        //}
    }
}