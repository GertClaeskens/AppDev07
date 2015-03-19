using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Finah_Backend.Tests
{
    using System.Web.Http.Results;

    using Finah_Backend.Controllers;
    using Finah_Backend.Models;

    using Microsoft.VisualStudio.TestTools.UnitTesting;
    [TestClass]
    class TestGeluidsFragmentController
    {
        private List<GeluidsFragment> testGeluidsFragmenten;
        private GeluidsFragmentController controller;

        [TestInitialize]
        public void TestInitialize()
        {
            testGeluidsFragmenten = GetTestGeluidsFragmenten();
            controller = new GeluidsFragmentController(testGeluidsFragmenten);
        }


        [TestMethod]
        public void GetOverzicht_ShouldReturnAllFoto()
        {
            var result = controller.GetOverzicht() as List<GeluidsFragment>;
            Assert.AreEqual(testGeluidsFragmenten.Count, result.Count);
        }


        [TestMethod]
        public void Get_ShouldReturnCorrectGeluidsFragment()
        {
            var result = controller.Get(testGeluidsFragmenten[0].Id) as OkNegotiatedContentResult<GeluidsFragment>;
            Assert.IsNotNull(result);
            //Controleren of beide objecten uniek zijn (Comparable?)
            Assert.AreEqual(testGeluidsFragmenten[0], result.Content);
        }


        [TestMethod]
        public void Get_ShouldNotFindGeluidsFragment()
        {
            // Id meegeven die zeker niet in de database voorkomt
            var result = controller.Get(999999999);
            Assert.IsInstanceOfType(result, typeof(NotFoundResult));
        }

        private static List<GeluidsFragment> GetTestGeluidsFragmenten()
        {
            var geluidsFragmenten = new List<GeluidsFragment>();
            ///
            /// 
            /// Wanneer we daadwerkelijk gaan testen moeten we hier de gegevens invullen zoals ze in de database staan
            /// Zo kunnen we deze 2 objecten vergelijken en zo de werking van de controller testen
            /// 
            /// Een lijst van 3-4 objecten volstaat

            return geluidsFragmenten;
        }
    }
}
