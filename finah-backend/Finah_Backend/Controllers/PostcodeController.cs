using System.Collections.Generic;
using System.Linq;
using System.Web.Http;

namespace Finah_Backend.Controllers
{
    using Finah_Backend.DAL;
    using Finah_Backend.Models;

    public class PostcodeController : ApiController
    {
        ///
        /// Wordt gebruikt om de database te testen.
        ///

        private List<Bevraging> bevragingen = new List<Bevraging>();

        private readonly FinahDBContext _db = new FinahDBContext();

        //Geen Api/ meer nodig
        [Route("Postcode/{id}")]
        // return -> naderhand veranderen in Bevraging

        //
        // Andere methode om Get te doen met return type IHttpActionResult
        //
        public IHttpActionResult Get(int id)
        {
            var postcode = _db.Postcodes.FirstOrDefault((b) => b.Id == id);
            if (postcode == null)
            {
                return NotFound();
            }
            return Ok(postcode);
        }

        [Route("Postcode/Overzicht")] //Geen Api/ meer nodig
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

        // POST: api/Postcode
        public void Post([FromBody]string value)
        {
        }

        // PUT: api/Postcode/5
        public void Put(int id, [FromBody]string value)
        {
        }

        // DELETE: api/Postcode/5
        public void Delete(int id)
        {
        }
    }
}