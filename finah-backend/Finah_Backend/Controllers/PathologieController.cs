using System.Collections.Generic;
using System.Web.Http;

namespace Finah_Backend.Controllers
{
    using Finah_Backend.DAL;
    using Finah_Backend.Models;

    public class PathologieController : ApiController
    {
        // GET: api/Pathologie
        private List<Pathologie> pathologieen = new List<Pathologie>();

        private FinahDBContext _db;

        public PathologieController()
        {
            _db = new FinahDBContext();
        }

        //Constructor met als argument een List van Bevragingen, hierdoor kunnen we testdata aan
        //de Controller meegeven om zo unittesten voor de controller te schrijven.
        public PathologieController(List<Pathologie> pathologieen)
        {
            _db = new FinahDBContext();
            this.pathologieen = pathologieen;
        }

        //Geen Api/ meer nodig
        [Route("Pathologie/{id}")]
        // return -> naderhand veranderen in Bevraging

        //
        // Andere methode om Get te doen met return type IHttpActionResult
        //
        public IHttpActionResult Get(int id)
        {
            Pathologie testPat = new Pathologie { Id = 1, Omschrijving = "test" };

            //Bovenstaande code dient om te testen
            //Als database in orde is bovenstaande code wissen en onderstaande regel uncommenten
            //var bevraging = bevragingen.FirstOrDefault((b) => b.Id == id);
            if (testPat == null)
            {
                return NotFound();
            }
            return Ok(testPat);
        }

        [Route("Pathologie/Overzicht")] //Geen Api/ meer nodig
        public IEnumerable<Pathologie> GetOverzicht()// return -> naderhand veranderen in Bevraging
        {
            //return _db.Bevragingen.ToList(); Kijken dat de gegevens van bvb leeftijdscategorie der ook in zitten

            //return bevragingen;
            var pt1 = new Pathologie();
            var pt2 = new Pathologie();
            var pt3 = new Pathologie();
            var pt4 = new Pathologie();
            var pt5 = new Pathologie();

            pt1.Id = 1;
            pt2.Id = 2;
            pt3.Id = 3;
            pt4.Id = 4;
            pt5.Id = 5;

            var overzichtPathologie = new List<Pathologie>
                                                       {
                                                           pt1,pt2,pt3,pt4,pt5
                                                       };

            return overzichtPathologie;
        }

        // POST: api/Pathologie
        public void Post([FromBody]string value)
        {
        }

        // PUT: api/Pathologie/5
        public void Put(int id, [FromBody]string value)
        {
        }

        // DELETE: api/Pathologie/5
        public void Delete(int id)
        {
        }
    }
}