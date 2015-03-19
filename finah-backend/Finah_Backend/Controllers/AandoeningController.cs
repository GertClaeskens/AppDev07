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

    public class AandoeningController : ApiController
    {

        private FinahDBContext _db;
        private List<Aandoening> aandoeningen = new List<Aandoening>();

        public AandoeningController()
        {
            _db = new FinahDBContext();
        }

        //Constructor met als argument een List van Bevragingen, hierdoor kunnen we testdata aan 
        //de Controller meegeven om zo unittesten voor de controller te schrijven.
        public AandoeningController(List<Aandoening> aandoeningen)
        {
            _db = new FinahDBContext();
            this.aandoeningen = aandoeningen;
        }
        //// GET: api/Aandoening
        //public IEnumerable<string> Get()
        //{
        //    return new string[] { "value1", "value2" };
        //}

        //// GET: api/Aandoening/5
        //public string Get(int id)
        //{
        //    return "value";
        //}

        [Route("Aandoening/{id}")]
        public IHttpActionResult Get(int id)
        {
            Aandoening ad = new Aandoening();
            Pathologie pt = new Pathologie();
            List<Pathologie> patLijst = new List<Pathologie>();



            pt.Id = 1;
            patLijst.Add(pt);

            ad.Id = 1;
            ad.Omschrijving = "Omschrijving";
            ad.Patologieen = patLijst;

            //Bovenstaande code dient om te testen
            //Als database in orde is bovenstaande code wissen en onderstaande regel uncommenten
            //var bevraging = bevragingen.FirstOrDefault((b) => b.Id == id);
            if (ad == null)
            {
                return NotFound();
            }
            return Ok(ad);
        }
        [Route("Aandoening/Overzicht")] //Geen Api/ meer nodig
        public IEnumerable<Aandoening> GetOverzicht()// return -> naderhand veranderen in Bevraging
        {
            //return _db.Vragen.ToList(); 

            //return vragen;

            Aandoening ad1 = new Aandoening();
            Aandoening ad2 = new Aandoening();
            Aandoening ad3 = new Aandoening(); 
            Aandoening ad4 = new Aandoening(); 
            Aandoening ad5 = new Aandoening();


            ad1.Id = 1;
            ad2.Id = 2;
            ad3.Id = 3;
            ad4.Id = 4;
            ad5.Id = 5;

            List<Aandoening> overzichtAandoeningen = new List<Aandoening> { ad1,ad2,ad3,ad4,ad5 };

            return overzichtAandoeningen;
        }
        // POST: api/Aandoening
        public void Post([FromBody]string value)
        {
        }

        // PUT: api/Aandoening/5
        public void Put(int id, [FromBody]string value)
        {
        }

        // DELETE: api/Aandoening/5
        public void Delete(int id)
        {
        }
    }
}
