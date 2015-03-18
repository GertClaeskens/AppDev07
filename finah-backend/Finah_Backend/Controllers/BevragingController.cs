using Finah_Backend.Models;
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
        private string sourceUrl = "http://finahbackend1920.azurewebsites.net/Bevraging/";
        private string link = null;

        //GetLink
        //Geen Api/ meer nodig
        [Route("Bevraging/GetLink")]
        // return -> naderhand veranderen in Bevraging
        public string Get() 
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

        //Geen Api/ meer nodig
        [Route("Bevraging/{id}")]
        // return -> naderhand veranderen in Bevraging
        public Bevraging Get(String id)
        {
            Bevraging testBevraging = new Bevraging();
            Account testAccount = new Account();
            LeeftijdsCategorie testCat = new LeeftijdsCategorie();
            VragenLijst testVragenlijst = new VragenLijst();

            testCat.Id = 1;
            testCat.Van = 0;
            testCat.Tot = 99;

            testAccount.Id = 1;
            testAccount.Naam = "Thys";
            testAccount.VoorNaam = "Brian";


            testBevraging.Id = id;
            testBevraging.Aangevraagd = DateTime.Now;
            testBevraging.AangemaaktDoor = testAccount;
            testBevraging.LeeftijdsCatMantelZorger = testCat;
            testBevraging.LeeftijdsCatPatient = testCat;
            testBevraging.Informatie = "Test bevraging";
            testBevraging.Relatie = "Test relatie";
            testBevraging.VragenMantelzorger = testVragenlijst;
            testBevraging.Vragenpatient = testVragenlijst;

            return testBevraging;
        }

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
