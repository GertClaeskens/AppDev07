using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace Finah_Backend.Controllers
{
    //[Authorize]
    public class BevragingController : ApiController
    {
        private string sourceUrl = "Http://www.ExampleSite.be/Bevraging/";
        private string link = null;
        // GET api/vragen/5
        //Geen Api/ meer nodig
        [Route("Bevraging/{id}")]
        // return -> naderhand veranderen in Bevraging
        public string Get(String id) 
        {
            //return "Ingegeven ID: " + id;
            //vragen ophalen en antwoorden linken aan persoon
            //Test genereren Unique ID (Source = http://stackoverflow.com/questions/11313205/generate-a-unique-id)
            link = string.Format("{0}{1:N}", sourceUrl, Guid.NewGuid());

            while (link == null)
            {
                //nieuwe link genereren
                link = string.Format("{0}{1:N}", sourceUrl, Guid.NewGuid());
                //Methode aanspreken voor testen op duplicaat
                TestLinkOnDuplicate(link); 
            }

            //Momenteel gegenereerde link tonen
            return link; 
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
            //var voor genereren tijdelijke fake link om DB na te bootsen
            string fakeDBLink; 

            //List = alle waardes uit DB ophalen (als DB in werking is)
            //run foreach, for now use For loop
            for (int i = 0; i < 1000; i++)
            {
                //Momenteel fake link gebruiken voor controle
                fakeDBLink = string.Format("{0}{1:N}", sourceUrl, Guid.NewGuid());
                //controleren als duplicaat
                if (linkToTest.Equals(fakeDBLink)) 
                {
                    //private link binne class op null zetten zodat hij terug door de while gaat.
                    link = null; 
                    //In geval van duplicaat, verlaat loop
                    break;
                }
            }
            return;
        }
    }
}
