using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace Finah_Backend.Controllers
{
    //[Authorize]
    public class VragenController : ApiController
    {
        private string sourceUrl = "Http://www.ExampleSite.be/Vragen/";
        // GET api/vragen/5
        [Route("Vragen/{id}")] //Geen Api/ meer nodig
        public string Get(String id) // return -> naderhand veranderen in Bevraging
        {
            //return "Ingegeven ID: " + id;
            //vragen ophalen en antwoorden linken aan persoon
            //Test genereren Unique ID (Source = http://stackoverflow.com/questions/11313205/generate-a-unique-id)
            return string.Format("{0}{1:N}", sourceUrl, Guid.NewGuid());
        }

        // GET api/vragen/Overzicht
        [Route("Vragen/Overzicht")] //Geen Api/ meer nodig
        public string GetOverzicht()// return -> naderhand veranderen in Bevraging
        {
            return "Test";
        }

        // POST: api/Vragen
        public void Post([FromBody]string value)
        {
        }

        // PUT: api/Vragen/5
        public void Put(int id, [FromBody]string value)
        {
        }

        // DELETE: api/Vragen/5
        public void Delete(int id)
        {
        }
    }
}
