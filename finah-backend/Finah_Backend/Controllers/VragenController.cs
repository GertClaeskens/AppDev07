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
        private string sourceUrl = "Http://www.ExampleSite.be/Bevraging/";
        private string link = null;
        // GET api/vragen/5
        [Route("Bevraging/{id}")] //Geen Api/ meer nodig
        public string Get(String id) // return -> naderhand veranderen in Bevraging
        {
            //return "Ingegeven ID: " + id;
            //vragen ophalen en antwoorden linken aan persoon
            //Test genereren Unique ID (Source = http://stackoverflow.com/questions/11313205/generate-a-unique-id)
            link = string.Format("{0}{1:N}", sourceUrl, Guid.NewGuid());

            while (link == null)
            {
                link = string.Format("{0}{1:N}", sourceUrl, Guid.NewGuid()); //nieuwe link genereren
                TestLinkOnDuplicate(link); //Methode aanspreken voor testen op duplicaat
            }
            
            return link; //Momenteel gegenereerde link tonen
        }

        // GET api/vragen/Overzicht
        [Route("Bevraging/Overzicht")] //Geen Api/ meer nodig
        public string GetOverzicht()// return -> naderhand veranderen in Bevraging
        {
            return "Toon Hier Overzicht";
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

        //Test voor duplicaat link
        private void TestLinkOnDuplicate(string linkToTest)
        {
            string fakeDBLink; //var voor genereren tijdelijke fake link om DB na te bootsen

            //List = alle waardes uit DB ophalen (als DB in werking is)
            //run foreach, for now use For loop
            for (int i = 0; i < 1000; i++)
            {
                fakeDBLink = string.Format("{0}{1:N}", sourceUrl, Guid.NewGuid()); //Momenteel fake link gebruiken voor controle
                if (linkToTest.Equals(fakeDBLink)) //controleren als duplicaat
                {
                    link = null; //private link binne class op null zetten zodat hij terug door de while gaat.
                    return;
                }
            }
        }
    }
}
