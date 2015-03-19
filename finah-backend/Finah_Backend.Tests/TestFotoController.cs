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
    class TestFotoController
    {
        private List<Foto> testfotos;
        private FotoController controller;

        [TestInitialize]
        public void TestInitialize()
        {
            testfotos = this.GetTestFotos();
            controller = new FotoController(testfotos);
        }
        [TestMethod]
        public void GetOverzicht_ShouldReturnAllFoto()
        {
            var result = controller.GetOverzicht() as List<Foto>;
            Assert.AreEqual(testfotos.Count, result.Count);
        }


        [TestMethod]
        public void Get_ShouldReturnCorrectFoto()
        {
            var result = controller.Get(testfotos[0].Id) as OkNegotiatedContentResult<Foto>;
            Assert.IsNotNull(result);
            //Controleren of beide objecten uniek zijn (Comparable?)
            Assert.AreEqual(testfotos[0], result.Content);
        }


        [TestMethod]
        public void Get_ShouldNotFindFoto()
        {
            // Id meegeven die zeker niet in de database voorkomt
            var result = controller.Get(999999999);
            Assert.IsInstanceOfType(result, typeof(NotFoundResult));
        }

        private List<Foto> GetTestFotos()
        {
            var fotos = new List<Foto>();
            ///
            /// 
            /// Wanneer we daadwerkelijk gaan testen moeten we hier de gegevens invullen zoals ze in de database staan
            /// Zo kunnen we deze 2 objecten vergelijken en zo de werking van de controller testen
            /// 
            /// Een lijst van 3-4 objecten volstaat

            return fotos;

        }
    }
}
