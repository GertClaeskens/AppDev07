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

        // GET: api/Postcode
        public IEnumerable<Postcode> Get()
        {
            return _db.Postcodes.ToList();
        }

        // GET: api/Postcode/5
        public string Get(int id)
        {
            return "value";
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