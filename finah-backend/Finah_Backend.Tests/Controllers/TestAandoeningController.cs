using Finah_Backend.Controllers;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Collections.Generic;
using System.Web.Http.Results;

namespace Finah_Backend.Tests.Controllers
{
    using Finah_Backend.Models;

    [TestClass]
    public class TestAandoeningController
    {
        private List<Aandoening> testAandoeningen;
        private AandoeningController controller;

        [TestInitialize]
        public void TestInitialize()
        {
            testAandoeningen = GetTestAandoeningen();
            controller = new AandoeningController(testAandoeningen);
        }

        [TestMethod]
        public void TestGetOverzicht_ShouldReturnAllAandoeningen()
        {
            var result = controller.GetOverzicht() as List<Aandoening>;
            Assert.AreEqual(testAandoeningen.Count, result.Count);
        }

        [TestMethod]
        public void Get_ShouldReturnCorrectAandoening()
        {
            var aandoening = new Aandoening
                                        {
                                            Id = 1,
                                            Omschrijving = "Pathologie",
                                            Patologieen =
                                                new List<Pathologie>
                                                    {
                                                        new Pathologie
                                                            {
                                                                Id = 1,
                                                                Omschrijving =
                                                                    "Omschrijving"
                                                            }
                                                    }
                                        };

            var result = controller.Get(aandoening.Id) as OkNegotiatedContentResult<Aandoening>;
            Assert.IsNotNull(result);
            //Controleren of beide objecten uniek zijn (Comparable?)
            Assert.AreEqual(aandoening, result.Content);
        }

        [TestMethod]
        public void Get_ShouldNotFindAandoening()
        {
            // Id meegeven die zeker niet in de database voorkomt
            var result = controller.Get(999999999);
            Assert.IsInstanceOfType(result, typeof(NotFoundResult));
        }

        private static List<Aandoening> GetTestAandoeningen()
        {
            //
            //
            // Wanneer we daadwerkelijk gaan testen moeten we hier de gegevens invullen zoals ze in de database staan
            // Zo kunnen we deze 2 objecten vergelijken en zo de werking van de controller testen
            //
            // Een lijst van 3-4 objecten volstaat
            var ad1 = new Aandoening { Id = 1 };
            var ad2 = new Aandoening { Id = 2 };
            var ad3 = new Aandoening { Id = 3 };
            var ad4 = new Aandoening { Id = 4 };
            var ad5 = new Aandoening { Id = 5 };
            var controleAandoeningen = new List<Aandoening> { ad1, ad2, ad3, ad4, ad5 };

            return controleAandoeningen;
        }
    }
}