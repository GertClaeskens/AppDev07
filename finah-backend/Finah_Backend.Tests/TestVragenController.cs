using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Web.Http.Results;

using Finah_Backend.Controllers;
using Finah_Backend.Models;

using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Finah_Backend.Tests
{
    [TestClass]
    class TestVragenController
    {
        private List<Bevraging> testVragen;
        private BevragingController controller;

        [TestInitialize]
        public void TestInitialize()
        {
            testVragen = this.GetTestVragen();
            controller = new VragenController(testVragen);
        }
        [TestMethod]
        public void GetOverzicht_ShouldReturnAllVragen()
        {
            var result = controller.GetOverzicht() as List<Vraag>;
            Assert.AreEqual(testVragen.Count, result.Count);
        }


        [TestMethod]
        public void GetVraag_ShouldReturnCorrectVraag()
        {
            var result = controller.GetVraag(testVragen[0].Id) as OkNegotiatedContentResult<Vraag>;
            Assert.IsNotNull(result);
            //Testen of de aanmaakdatum van beiden gelijk is, deze waarde is quasi uniek
            Assert.AreEqual(testVragen[0].Aangevraagd, result.Content.Aangevraagd);
        }


        [TestMethod]
        public void GetVraag_ShouldNotFindvragen()
        {
            //nummer meegeven die zeker niet in de database voorkomt
            var result = controller.GetVraag(99999999);
            Assert.IsInstanceOfType(result, typeof(NotFoundResult));
        }

        private List<Bevraging> GetTestVragen()
        {
            ///
            /// 
            /// Wanneer we daadwerkelijk gaan testen moeten we hier de gegevens invullen zoals ze in de database staan
            /// Zo kunnen we deze 2 objecten vergelijken en zo de werking van de controller testen
            /// 
            /// Een lijst van 3-4 objecten volstaat

            return vragen;

        }
    }
}
