using Finah_Backend.Controllers;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Collections.Generic;
using System.Web.Http.Results;

namespace Finah_Backend.Tests.Controllers
{
    using Finah_Backend.Models;

    [TestClass]
    internal class TestAandoeningController
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
        public void Get_ShouldReturnCorrectAandoening()
        {
            var result = controller.Get(testAandoeningen[0].Id) as OkNegotiatedContentResult<Aandoening>;
            Assert.IsNotNull(result);
            //Controleren of beide objecten uniek zijn (Comparable?)
            Assert.AreEqual(testAandoeningen[0], result.Content);
        }

        [TestMethod]
        public void Get_ShouldNotFindAandoening()
        {
            // Id meegeven die zeker niet in de database voorkomt
            var result = controller.Get(999999999);
            Assert.IsInstanceOfType(result, typeof(NotFoundResult));
        }

        private List<Aandoening> GetTestAandoeningen()
        {
            var aandoeningen = new List<Aandoening>();
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