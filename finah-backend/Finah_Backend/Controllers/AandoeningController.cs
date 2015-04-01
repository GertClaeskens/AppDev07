using System.Collections.Generic;
using System.Web.Http;

namespace Finah_Backend.Controllers
{
    using Finah_Backend.DAL;
    using Finah_Backend.Models;
    using System.Data.Entity;
    using System.Data.Entity.Infrastructure;
    using System.Linq;
    using System.Net;
    using System.Web.Http.Description;

    public class AandoeningController : ApiController
    {
        private FinahDBContext db;
        private List<Aandoening> aandoeningen = new List<Aandoening>();

        public AandoeningController()
        {
            db = new FinahDBContext();
        }

        //Constructor met als argument een List van Bevragingen, hierdoor kunnen we testdata aan
        //de Controller meegeven om zo unittesten voor de controller te schrijven.
        public AandoeningController(List<Aandoening> aandoeningen)
        {
            db = new FinahDBContext();
            this.aandoeningen = aandoeningen;
        }

        [ResponseType(typeof(Aandoening))]
        [Route("Aandoening/{id}")]
        public IHttpActionResult Get(int id)
        {
            #region Hardcoded object voor testing - commented

            //Aandoening aandoening = null;
            //if (id == 1)
            //{
            //    aandoening = new Aandoening();
            //    var pt = new Pathologie();
            //    var patLijst = new List<Pathologie>();

            //    pt.Id = 1;
            //    pt.Omschrijving = "Pathologie";
            //    patLijst.Add(pt);

            //    aandoening.Id = 1;
            //    aandoening.Omschrijving = "Omschrijving";
            //    aandoening.Patologieen = patLijst;
            //}
            //Bovenstaande code dient om te testen
            //Als database in orde is bovenstaande code wissen en onderstaande regel uncommenten

            #endregion Hardcoded object voor testing - commented

            var aandoening = db.Aandoeningen.Find(id);
            if (aandoening == null)
            {
                return NotFound();
            }

            return Ok(aandoening);
        }

        [Route("Aandoening/Overzicht")] //Geen Api/ meer nodig
        //public IQueryable<Aandoening> GetAandoeningen()
        public IEnumerable<Aandoening> GetOverzicht()
        {
            return db.Aandoeningen;

            //
            //return vragen;
            //aandoeningen = db.Aandoeningen.ToList();

            #region Hardcoded objecten - Commented

            //var ad1 = new Aandoening
            //{
            //    Id = 1,
            //    Omschrijving = "Aandoening 1",

            //    Patologieen =
            //        new List<Pathologie>
            //                                        {
            //                                            new Pathologie
            //                                                {
            //                                                    Id = 1,
            //                                                    Omschrijving =
            //                                                        "Omschrijving"
            //                                                }
            //                                        }
            //};
            //var ad2 = new Aandoening
            //                            {
            //                                Id = 2,
            //                                Omschrijving = "Aandoening 2",

            //                                Patologieen =
            //                                    new List<Pathologie>
            //                                        {
            //                                            new Pathologie
            //                                                {
            //                                                    Id = 2,
            //                                                    Omschrijving =
            //                                                        "Omschrijving"
            //                                                },
            //                                            new Pathologie
            //                                                {
            //                                                    Id = 3,
            //                                                    Omschrijving =
            //                                                        "Omschrijving"
            //                                                }
            //                                        }
            //                            };
            //var ad3 = new Aandoening
            //{
            //    Id = 3,
            //    Omschrijving = "Aandoening 3",
            //    Patologieen =
            //        new List<Pathologie>
            //                                            {
            //                                                new Pathologie
            //                                                    {
            //                                                        Id = 2,
            //                                                        Omschrijving =
            //                                                            "OmschrijvingP2"
            //                                                    }
            //                                            }
            //};
            //var ad4 = new Aandoening
            //{
            //    Id = 4,
            //    Omschrijving = "Aandoening 4",

            //    Patologieen =
            //        new List<Pathologie>
            //                                        {
            //                                            new Pathologie
            //                                                {
            //                                                    Id = 1,
            //                                                    Omschrijving =
            //                                                        "OmschrijvingP1"
            //                                                }
            //                                        }
            //};
            //var ad5 = new Aandoening
            //{
            //    Id = 5,
            //    Omschrijving = "Aandoening 5",
            //    Patologieen =
            //        new List<Pathologie>
            //                                        {
            //                                            new Pathologie
            //                                                {
            //                                                    Id = 1,
            //                                                    Omschrijving =
            //                                                        "OmschrijvingP1"
            //                                                },new Pathologie
            //                                                {
            //                                                    Id = 2,
            //                                                    Omschrijving =
            //                                                        "OmschrijvingP2"
            //                                                },new Pathologie
            //                                                {
            //                                                    Id = 3,
            //                                                    Omschrijving =
            //                                                        "OmschrijvingP3"
            //                                                }
            //                                        }
            //};
            //var overzichtAandoeningen = new List<Aandoening> { ad1, ad2, ad3, ad4, ad5 };

            //return overzichtAandoeningen;

            #endregion Hardcoded objecten - Commented
        }

        // PUT: api/Aandoenings/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutAandoening(int id, Aandoening aandoening)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != aandoening.Id)
            {
                return BadRequest();
            }

            db.Entry(aandoening).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!AandoeningBestaat(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return StatusCode(HttpStatusCode.NoContent);
        }

        // POST: api/Aandoenings
        [ResponseType(typeof(Aandoening))]
        [Route("Aandoening/")]
        //public IHttpActionResult PostAandoening(Aandoening aandoening)
        //public async Task<IHttpActionResult> PostAandoening([FromBody] Aandoening aandoening)
        public void Post([FromBody] Aandoening aandoening)
        {
            //if (!ModelState.IsValid)
            //{
            //    //throw new HttpResponseException(Request.CreateErrorResponse(HttpStatusCode.BadRequest, this.ModelState));
            //    return BadRequest(ModelState);
            //}

            var aand = new Aandoening { Omschrijving = aandoening.Omschrijving, Patologieen = new List<Pathologie>() };
            foreach (var pathologie in aandoening.Patologieen)
            {
                aand.Patologieen.Add(db.Pathologieen.Single(p => p.Id == pathologie.Id));
            }

            //var patlijst = aandoening.Patologieen.Select(p => this.db.Pathologieen.Find(p.Id)).ToList();
            //aand.Patologieen = patlijst;
            //    var patologieen =
            //        aandoening.Patologieen.Select(
            //            p => new Pathologie { Id = p.Id, Omschrijving = p.Omschrijving })
            //        .ToList()
            //};
            //, Patologieen = aandoening.Patologieen };

            db.Aandoeningen.Add(aand);
            db.SaveChanges();

            //return Ok(aand);
            //return CreatedAtRoute("DefaultApi", new { id = aandoening.Id }, aandoening);
        }

        // DELETE: api/Aandoenings/5
        [ResponseType(typeof(Aandoening))]
        public IHttpActionResult DeleteAandoening(int id)
        {
            var aandoening = db.Aandoeningen.Find(id);
            if (aandoening == null)
            {
                return NotFound();
            }

            db.Aandoeningen.Remove(aandoening);
            db.SaveChanges();

            return Ok(aandoening);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool AandoeningBestaat(int id)
        {
            return db.Aandoeningen.Count(e => e.Id == id) > 0;
        }
    }
}