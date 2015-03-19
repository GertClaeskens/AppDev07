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
    class TestVragenLijstController
    {
        private List<VragenLijst> testVragenLijst;
        private VragenLijstController controller;

        [TestInitialize]
        public void TestInitialize()
        {
            testVragenLijst = GetTestVragenLijsten();
            controller = new VragenLijstController(testVragenLijst);
        }
        [TestMethod]
        public void GetOverzicht_ShouldReturnAllVragenLijsten()
        {
            var result = controller.GetOverzicht() as List<VragenLijst>;
            Assert.AreEqual(testVragenLijst.Count, result.Count);
        }


        [TestMethod]
        public void GetVraagLijst_ShouldReturnCorrectVragenLijst()
        {
            var result = controller.Get(testVragenLijst[0].Id) as OkNegotiatedContentResult<VragenLijst>;
            Assert.IsNotNull(result);
            //Testen of de aanmaakdatum van beiden gelijk is, deze waarde is quasi uniek
            Assert.AreEqual(testVragenLijst[0], result.Content);
        }


        [TestMethod]
        public void GetVraagLijst_ShouldNotFindVragenLijst()
        {
            // Id meegeven die zeker niet in de database voorkomt
            var result = controller.Get(999999999);
            Assert.IsInstanceOfType(result, typeof(NotFoundResult));
        }

        private static List<VragenLijst> GetTestVragenLijsten()
        {
            var vragenlijsten = new List<VragenLijst>();
            ///
            /// 
            /// Wanneer we daadwerkelijk gaan testen moeten we hier de gegevens invullen zoals ze in de database staan
            /// Zo kunnen we deze 2 objecten vergelijken en zo de werking van de controller testen
            /// 
            /// Een lijst van 3-4 objecten volstaat

            return vragenlijsten;

        }
    }
}
