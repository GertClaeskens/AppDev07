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
        private List<Vraag> testVragen;
        private VragenController controller;

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
            var result = controller.Get(testVragen[0].Id) as OkNegotiatedContentResult<Vraag>;
            Assert.IsNotNull(result);
            //Testen of de aanmaakdatum van beiden gelijk is, deze waarde is quasi uniek
            Assert.AreEqual(testVragen[0], result.Content);
        }


        [TestMethod]
        public void GetVraag_ShouldNotFindvragen()
        {
            //nummer meegeven die zeker niet in de database voorkomt
            var result = controller.Get(99999999);
            Assert.IsInstanceOfType(result, typeof(NotFoundResult));
        }

        private List<Vraag> GetTestVragen()
        {
            List<Vraag> vragen = new List<Vraag>();
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
