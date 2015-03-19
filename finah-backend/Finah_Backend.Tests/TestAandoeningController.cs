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
    class TestAandoeningController
    {

        private List<Aandoening> testAandoeningen;
        private AandoeningController controller;

        [TestInitialize]
        public void TestInitialize()
        {
            testAandoeningen = this.GetTestAandoeningen();
            controller = new AandoeningController(testAandoeningen);
        }
        [TestMethod]
        public void GetOverzicht_ShouldReturnAllAandoeningen()
        {
            var result = controller.GetOverzicht() as List<Aandoening>;
            Assert.AreEqual(testAandoeningen.Count, result.Count);
        }


        [TestMethod]
        public void GetAandoeningLijst_ShouldReturnCorrectAandoening()
        {
            var result = controller.GetAandoening(testAandoeningen[0].Id) as OkNegotiatedContentResult<Aandoening>;
            Assert.IsNotNull(result);
            //Testen of de aanmaakdatum van beiden gelijk is, deze waarde is quasi uniek
            Assert.AreEqual(testAandoeningen[0].Aangevraagd, result.Content.Aangevraagd);
        }


        [TestMethod]
        public void GetVraagLijst_ShouldNotFindAandoening()
        {
            // Id meegeven die zeker niet in de database voorkomt
            var result = controller.GetAandoening(999999999);
            Assert.IsInstanceOfType(result, typeof(NotFoundResult));
        }

        private List<Aandoening> GetTestAandoeningen()
        {
            ///
            /// 
            /// Wanneer we daadwerkelijk gaan testen moeten we hier de gegevens invullen zoals ze in de database staan
            /// Zo kunnen we deze 2 objecten vergelijken en zo de werking van de controller testen
            /// 
            /// Een lijst van 3-4 objecten volstaat

            return aandoeningen;

        }
    }
}
