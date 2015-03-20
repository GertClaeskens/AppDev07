using System.Collections.Generic;
using System.Web.Http;

namespace Finah_Backend.Controllers
{
    using Finah_Backend.DAL;
    using Finah_Backend.Models;

    public class LeeftijdsCategorieController : ApiController
    {
        // GET: api/LeeftijdsCategorie
        private List<LeeftijdsCategorie> leeftijdsCategorieen = new List<LeeftijdsCategorie>();

        private FinahDBContext _db;

        public LeeftijdsCategorieController()
        {
            _db = new FinahDBContext();
        }

        //Constructor met als argument een List van Bevragingen, hierdoor kunnen we testdata aan
        //de Controller meegeven om zo unittesten voor de controller te schrijven.
        public LeeftijdsCategorieController(List<LeeftijdsCategorie> leeftijdsCategorieen)
        {
            _db = new FinahDBContext();
            this.leeftijdsCategorieen = leeftijdsCategorieen;
        }

        //Geen Api/ meer nodig
        [Route("LeeftijdsCategorie/{id}")]
        // return -> naderhand veranderen in Bevraging

        //
        // Andere methode om Get te doen met return type IHttpActionResult
        //
        public IHttpActionResult Get(int id)
        {
            LeeftijdsCategorie testCat = new LeeftijdsCategorie { Id = 1, Van = 0, Tot = 99 };

            //Bovenstaande code dient om te testen
            //Als database in orde is bovenstaande code wissen en onderstaande regel uncommenten
            //var bevraging = bevragingen.FirstOrDefault((b) => b.Id == id);
            if (testCat == null)
            {
                return NotFound();
            }
            return Ok(testCat);
        }

        [Route("LeeftijdsCategorie/Overzicht")] //Geen Api/ meer nodig
        public IEnumerable<LeeftijdsCategorie> GetOverzicht()// return -> naderhand veranderen in Bevraging
        {
            //return _db.Bevragingen.ToList(); Kijken dat de gegevens van bvb leeftijdscategorie der ook in zitten

            //return bevragingen;
            var lc1 = new LeeftijdsCategorie();
            var lc2 = new LeeftijdsCategorie();
            var lc3 = new LeeftijdsCategorie();
            var lc4 = new LeeftijdsCategorie();
            var lc5 = new LeeftijdsCategorie();

            lc1.Id = 1;
            lc2.Id = 2;
            lc3.Id = 3;
            lc4.Id = 4;
            lc5.Id = 5;

            var overzichtLeeftijdsCategorieen = new List<LeeftijdsCategorie>
                                                       {
                                                           lc1,lc2,lc3,lc4,lc5
                                                       };

            return overzichtLeeftijdsCategorieen;
        }

        // POST: api/LeeftijdsCategorie
        public void Post([FromBody]string value)
        {
        }

        // PUT: api/LeeftijdsCategorie/5
        public void Put(int id, [FromBody]string value)
        {
        }

        // DELETE: api/LeeftijdsCategorie/5
        public void Delete(int id)
        {
        }
    }
}