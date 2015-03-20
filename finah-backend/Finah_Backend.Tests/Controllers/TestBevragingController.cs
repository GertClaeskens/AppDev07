using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Finah_Backend.Tests.Controllers
{
    using Finah_Backend.Controllers;

    using Finah_Backend.Controllers;
    using Finah_Backend.Models;

    using Microsoft.VisualStudio.TestTools.UnitTesting;
    using System.Web.Http.Results;

    /// <summary>
    ///
    /// Gert Claeskens
    /// Voorbeeldcode gevonden op internet
    /// http://www.asp.net/web-api/overview/testing-and-debugging/unit-testing-with-aspnet-web-api#setupproject
    ///
    /// </summary>

    [TestClass]
    internal class TestBevragingController
    {
        private List<Bevraging> testBevragingen;
        private BevragingController controller;

        [TestInitialize]
        public void TestInitialize()
        {
            testBevragingen = this.GetTestBevragingen();
            controller = new BevragingController(testBevragingen);
        }

        [TestMethod]
        public void GetOverzicht_ShouldReturnAllBevragingen()
        {
            var result = controller.GetOverzicht() as List<Bevraging>;
            Assert.AreEqual(testBevragingen.Count, result.Count);
        }

        [TestMethod]
        public void GetBevraging_ShouldReturnCorrectBevraging()
        {
            var result = controller.Get(testBevragingen[0].Id) as OkNegotiatedContentResult<Bevraging>;
            Assert.IsNotNull(result);
            //Testen of de aanmaakdatum van beiden gelijk is, deze waarde is quasi uniek
            Assert.AreEqual(testBevragingen[0], result.Content);
        }

        [TestMethod]
        public void GetBevraging_ShouldNotFindBevraging()
        {
            // "jjjj" is onmogelijk als id, want de id is hexadecimaal
            var result = controller.Get("jjjjj");
            Assert.IsInstanceOfType(result, typeof(NotFoundResult));
        }

        private List<Bevraging> GetTestBevragingen()
        {
            ///
            ///
            /// Wanneer we daadwerkelijk gaan testen moeten we hier de gegevens invullen zoals ze in de database staan
            /// Zo kunnen we deze 2 objecten vergelijken en zo de werking van de controller testen
            ///
            /// Een lijst van 3-4 objecten volstaat
            var testBevragingen = new List<Bevraging>();
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

            testBevraging.Id = "hgdghdghghdshdghghd";
            testBevraging.Aangevraagd = DateTime.Now;
            testBevraging.AangemaaktDoor = testAccount;
            testBevraging.LeeftijdsCatMantelZorger = testCat;
            testBevraging.LeeftijdsCatPatient = testCat;
            testBevraging.Informatie = "Test bevraging";
            testBevraging.Relatie = "Test relatie";
            testBevraging.VragenMantelzorger = testVragenlijst;
            testBevraging.Vragenpatient = testVragenlijst;
            testBevragingen.Add(testBevraging);

            return testBevragingen;
        }
    }
}