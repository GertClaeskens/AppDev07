using Finah_Backend.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace Finah_Backend.Controllers
{
    using Finah_Backend.DAL;

    using Newtonsoft.Json.Linq;

    //[Authorize]
    public class BevragingController : ApiController
    {
        private const string sourceUrl = "http://finahbackend1920.azurewebsites.net/Bevraging/";

        private string link = null;
        List<Bevraging> bevragingen = new List<Bevraging>();

        private FinahDBContext _db;

        public BevragingController()
        {
            _db = new FinahDBContext();
        }

        //Constructor met als argument een List van Bevragingen, hierdoor kunnen we testdata aan 
        //de Controller meegeven om zo unittesten voor de controller te schrijven.
        public BevragingController(List<Bevraging> bevragingen) 
        {
            _db = new FinahDBContext();
            this.bevragingen = bevragingen;
        }


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


        //
        // Andere methode om Get te doen met return type IHttpActionResult
        //
        public IHttpActionResult GetBevraging(String id)
        {
            Bevraging bevraging = new Bevraging();
            Account testAccount = new Account();
            LeeftijdsCategorie testCat = new LeeftijdsCategorie();
            VragenLijst testVragenlijst = new VragenLijst();

            testCat.Id = 1;
            testCat.Van = 0;
            testCat.Tot = 99;

            testAccount.Id = 1;
            testAccount.Naam = "Thys";
            testAccount.VoorNaam = "Brian";


            bevraging.Id = id;
            bevraging.Aangevraagd = DateTime.Now;
            bevraging.AangemaaktDoor = testAccount;
            bevraging.LeeftijdsCatMantelZorger = testCat;
            bevraging.LeeftijdsCatPatient = testCat;
            bevraging.Informatie = "Test bevraging";
            bevraging.Relatie = "Test relatie";
            bevraging.VragenMantelzorger = testVragenlijst;
            bevraging.Vragenpatient = testVragenlijst;
            //Bovenstaande code dient om te testen
            //Als database in orde is bovenstaande code wissen en onderstaande regel uncommenten
            //var bevraging = bevragingen.FirstOrDefault((b) => b.Id == id);
            if (bevraging == null)
            {
                return NotFound();
            }
            return Ok(bevraging);
        }
        //public Bevraging Get(String id)
        //{
        //    Bevraging testBevraging = new Bevraging();
        //    Account testAccount = new Account();
        //    LeeftijdsCategorie testCat = new LeeftijdsCategorie();
        //    VragenLijst testVragenlijst = new VragenLijst();

        //    testCat.Id = 1;
        //    testCat.Van = 0;
        //    testCat.Tot = 99;

        //    testAccount.Id = 1;
        //    testAccount.Naam = "Thys";
        //    testAccount.VoorNaam = "Brian";


        //    testBevraging.Id = id;
        //    testBevraging.Aangevraagd = DateTime.Now;
        //    testBevraging.AangemaaktDoor = testAccount;
        //    testBevraging.LeeftijdsCatMantelZorger = testCat;
        //    testBevraging.LeeftijdsCatPatient = testCat;
        //    testBevraging.Informatie = "Test bevraging";
        //    testBevraging.Relatie = "Test relatie";
        //    testBevraging.VragenMantelzorger = testVragenlijst;
        //    testBevraging.Vragenpatient = testVragenlijst;

        //    return testBevraging;
        //}

        [Route("Bevraging/Overzicht")] //Geen Api/ meer nodig
        public IEnumerable<Bevraging> GetOverzicht()// return -> naderhand veranderen in Bevraging
        {
            //return _db.Bevragingen.ToList(); Kijken dat de gegevens van bvb leeftijdscategorie der ook in zitten
            
            //return bevragingen;
            Bevraging testBevraging1 = new Bevraging();
            Bevraging testBevraging2 = new Bevraging();
            Bevraging testBevraging3 = new Bevraging();
            Bevraging testBevraging4 = new Bevraging();
            Bevraging testBevraging5 = new Bevraging();

            testBevraging1.Id = "1";
            testBevraging2.Id = "2";
            testBevraging3.Id = "3";
            testBevraging4.Id = "4";
            testBevraging5.Id = "5";

            List<Bevraging> overzichtBevragingen = new List<Bevraging>();
            overzichtBevragingen.Add(testBevraging1);
            overzichtBevragingen.Add(testBevraging2);
            overzichtBevragingen.Add(testBevraging3);
            overzichtBevragingen.Add(testBevraging4);
            overzichtBevragingen.Add(testBevraging5);

            return overzichtBevragingen;
        }

        // POST: api/Vragen
        public void Post([FromBody]JObject value)
        {
            //Voorbeeld van tijdens de les
            //
            //In de les werd in de constructor een variabele _db gedeclareerd: 
            //FinahDBContext _db = new FinahDBContext();
            //
            //Bevraging bevraging = value.ToObject<Bevraging>();
            //_db.Courses.Add(bevraging);
            //Savechanges() zorgt ervoor dat de Add vertaald wordt naar een INSERT-statement
            //_db.SaveChanges();
            //return value;


        }

        // PUT: api/Vragen/5
        public void Put(string id, [FromBody]string value)
        {
        }

        // DELETE: api/Vragen/5
        public void Delete(string id)
        {
        }

        //Test voor duplicaat link
        //
        //
        //mailke naar Mr. Hermans sturen of we wel moeten testen op duplicate waarden of er van mogen uitgaan dat deze uniek is
        //omdat de kans op collisions onnoemelijk klein zijn
        //
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
