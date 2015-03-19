using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace Finah_Backend.Controllers
{
    using Finah_Backend.DAL;
    using Finah_Backend.Models;

    public class GeluidsFragmentController : ApiController
    {
        private FinahDBContext _db;
        private List<GeluidsFragment> geluidsFragmenten = new List<GeluidsFragment>();

        public GeluidsFragmentController()
        {
            _db = new FinahDBContext();
        }

        //Constructor met als argument een List van Bevragingen, hierdoor kunnen we testdata aan 
        //de Controller meegeven om zo unittesten voor de controller te schrijven.
        public GeluidsFragmentController(List<GeluidsFragment> geluidsFragmenten)
        {
            _db = new FinahDBContext();
            this.geluidsFragmenten = geluidsFragmenten;
        }


        [Route("Aandoening/{id}")]
        public IHttpActionResult Get(int id)
        {
            var geluidsFragment = new GeluidsFragment { Id = 1, Omschrijving = "geluidsfragment vraag 1", Pad = "pad" };

            //Bovenstaande code dient om te testen (op dit moment nutteloos)
            //Als database in orde is bovenstaande code wissen en onderstaande regel uncommenten
            //var bevraging = bevragingen.FirstOrDefault((b) => b.Id == id);
            if (geluidsFragment == null)
            {
                return NotFound();
            }
            return Ok(geluidsFragment);
        }
        [Route("Aandoening/Overzicht")] //Geen Api/ meer nodig
        public IEnumerable<GeluidsFragment> GetOverzicht()// return -> naderhand veranderen in Bevraging
        {
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


        // POST: api/GeluidsFragment
        public void Post([FromBody]string value)
        {
        }

        // PUT: api/GeluidsFragment/5
        public void Put(int id, [FromBody]string value)
        {
        }

        // DELETE: api/GeluidsFragment/5
        public void Delete(int id)
        {
        }
    }
}
