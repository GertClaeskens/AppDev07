using System.Collections.Generic;

namespace Finah_Backend.Tests.Controllers
{
    using Finah_Backend.Controllers;
    using Finah_Backend.Models;
    using Microsoft.VisualStudio.TestTools.UnitTesting;
    using System.Web.Http.Results;

    [TestClass]
    internal class TestLeeftijdsCategorieController
    {
        private List<LeeftijdsCategorie> testLeeftijdsCategorieen;
        private LeeftijdsCategorieController controller;

        [TestInitialize]
        public void TestInitialize()
        {
            testLeeftijdsCategorieen = GetTestAandoeningen();
            controller = new LeeftijdsCategorieController(testLeeftijdsCategorieen);
        }

        [TestMethod]
        public void GetOverzicht_ShouldReturnAllLeeftijdsCategorieen()
        {
            var result = controller.GetOverzicht() as List<LeeftijdsCategorie>;
            Assert.AreEqual(testLeeftijdsCategorieen.Count, result.Count);
        }

        [TestMethod]
        public void Get_ShouldReturnCorrectLeeftijdsCategorie()
        {
            var result = controller.Get(testLeeftijdsCategorieen[0].Id) as OkNegotiatedContentResult<LeeftijdsCategorie>;
            Assert.IsNotNull(result);
            //Controleren of beide objecten uniek zijn (Comparable?)
            Assert.AreEqual(testLeeftijdsCategorieen[0], result.Content);
        }

        [TestMethod]
        public void Get_ShouldNotFindLeeftijdsCategorie()
        {
            // Id meegeven die zeker niet in de database voorkomt
            var result = controller.Get(999999999);
            Assert.IsInstanceOfType(result, typeof(NotFoundResult));
        }

        private static List<LeeftijdsCategorie> GetTestAandoeningen()
        {
            var leeftijdsCategorieen = new List<LeeftijdsCategorie>();
            ///
            ///
            /// Wanneer we daadwerkelijk gaan testen moeten we hier de gegevens invullen zoals ze in de database staan
            /// Zo kunnen we deze 2 objecten vergelijken en zo de werking van de controller testen
            ///
            /// Een lijst van 3-4 objecten volstaat

            return leeftijdsCategorieen;
        }
    }
}