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
        private string link;
        // GET api/vragen/5
        [Route("Vragen/{id}")] //Geen Api/ meer nodig
        public string Get(String id) // return -> naderhand veranderen in Bevraging
        {
            string testLink;
            //return "Ingegeven ID: " + id;
            //vragen ophalen en antwoorden linken aan persoon
            //Test genereren Unique ID (Source = http://stackoverflow.com/questions/11313205/generate-a-unique-id)
            link = string.Format("{0}{1:N}", sourceUrl, Guid.NewGuid());
            for (int i = 0; i < 1000; i++) //alle waardes ophalen uit DB en controleren op duplicate (word foreach)
            {
                testLink = string.Format("{0}{1:N}", sourceUrl, Guid.NewGuid()); //testlink genereren om te controleren;
                if (testLink.Equals(link)) //Controle op duplicate
                {
                    link = string.Format("{0}{1:N}", sourceUrl, Guid.NewGuid()); //nieuwe link genereren
                    i = 0; //restart loop om nieuwe link te controleren
                }
            }
                return link; //Momenteel gegenereerde link tonen
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
