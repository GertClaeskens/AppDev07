namespace Finah_Backend.Tests.Controllers
{
    using System.Collections.Generic;
    using System.Web.Http.Results;

    using Finah_Backend.Controllers;
    using Finah_Backend.Models;

    using Microsoft.VisualStudio.TestTools.UnitTesting;

    internal class TestPathologieController
    {
        private List<Pathologie> testPathologieen;
        private PathologieController controller;

        [TestInitialize]
        public void TestInitialize()
        {
            testPathologieen = this.GetTestPathologie();
            controller = new PathologieController(testPathologieen);
        }

        [TestMethod]
        public void GetOverzicht_ShouldReturnAllPathologie()
        {
            var result = controller.GetOverzicht() as List<Pathologie>;
            Assert.AreEqual(testPathologieen.Count, result.Count);
        }

        [TestMethod]
        public void Get_ShouldReturnCorrectPathologie()
        {
            var result = controller.Get(testPathologieen[0].Id) as OkNegotiatedContentResult<Pathologie>;
            Assert.IsNotNull(result);
            //Controleren of beide objecten uniek zijn (Comparable?)
            Assert.AreEqual(testPathologieen[0], result.Content);
        }

        [TestMethod]
        public void Get_ShouldNotFindPathologie()
        {
            // Id meegeven die zeker niet in de database voorkomt
            var result = controller.Get(999999999);
            Assert.IsInstanceOfType(result, typeof(NotFoundResult));
        }

        private List<Pathologie> GetTestPathologie()
        {
            var pathologieen = new List<Pathologie>();
            ///
            ///
            /// Wanneer we daadwerkelijk gaan testen moeten we hier de gegevens invullen zoals ze in de database staan
            /// Zo kunnen we deze 2 objecten vergelijken en zo de werking van de controller testen
            ///
            /// Een lijst van 3-4 objecten volstaat

            return pathologieen;
        }
    }
}