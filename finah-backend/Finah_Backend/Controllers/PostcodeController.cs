using System.Collections.Generic;
using System.Linq;
using System.Web.Http;

namespace Finah_Backend.Controllers
{
    using System.Web.Http.Cors;

    using Finah_Backend.DAL;
    using Finah_Backend.Models;


    [EnableCors(origins: "http://finahweb4156.azurewebsites.net", headers: "*", methods: "*")]
    [Authorize]
    public class PostcodeController : ApiController
    {
        ///
        /// Wordt gebruikt om de database te testen.
        ///

        private readonly ApplicationDbContext _db = new ApplicationDbContext();

        //Geen Api/ meer nodig
        [Route("Postcode/{id}")]
        public IHttpActionResult Get(int id)
        {
            var postcode = _db.Postcodes.FirstOrDefault(b => b.Id == id);

            if (postcode == null)
            {
                return NotFound();
            }
            return Ok(postcode);
        }

        [Route("Postcode/Overzicht")] //Geen Api/ meer nodig
        public IEnumerable<Postcode> GetOverzicht()
        {

            return _db.Postcodes;

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