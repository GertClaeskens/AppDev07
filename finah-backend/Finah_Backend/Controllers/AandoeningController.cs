using System.Collections.Generic;
using System.Web.Http;

namespace Finah_Backend.Controllers
{
    using System.Runtime.CompilerServices;
    using System.Web.Http.Cors;

    using Finah_Backend.DAL;
    using Finah_Backend.Models;
    using System.Data.Entity;
    using System.Data.Entity.Infrastructure;
    using System.Linq;
    using System.Net;
    using System.Web.Http.Description;

    //TODO aanpassen naar azure website
    [EnableCors(origins: "http://localhost:63342", headers: "*", methods: "*")]
    public class AandoeningController : ApiController
    {
        //TODO code opschonen als alles bolt
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


        [Route("Aandoening/{id}/Pathologie")]
        public IEnumerable<Pathologie> GetPathologieen(int id)
        {
            return db.Aandoeningen.Find(id).Patologieen;
        }

        [Route("Aandoening/{id}/VragenLijst")]
        public VragenLijst GetVragenLijst(int id)
        {
            //Er is een vragenlijst per aandoening.

            var v = (from vr in db.VragenLijsten where vr.Aandoe.Id == id select vr).First();
            return v;
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
        [HttpPut]
        [Route("Aandoening/{id}")]
        [ResponseType(typeof(void))]
        public IHttpActionResult Put(int id, Aandoening aandoening)
        {

            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != aandoening.Id)
            {
                return BadRequest();
            }


            Aandoening a = new Aandoening();
            a.Id = aandoening.Id;
            a.Omschrijving = aandoening.Omschrijving;
            a.Patologieen = new List<Pathologie>();
            if (aandoening.Patologieen.Count != 0 && aandoening.Patologieen != null)
            {
                foreach (Pathologie p in aandoening.Patologieen)
                {
                    a.Patologieen.Add(db.Pathologieen.Find(p.Id));

                }
            }
            //db.Entry(aandoening).State = EntityState.Modified;

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
        [HttpPost]
        [ResponseType(typeof(Aandoening))]
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
            if (aandoening.Patologieen.Count != 0)
            {
                foreach (var pathologie in aandoening.Patologieen)
                {
                    aand.Patologieen.Add(db.Pathologieen.Single(p => p.Id == pathologie.Id));

                }
            }

            db.Aandoeningen.Add(aand);
            db.SaveChanges();
            if (aandoening.Patologieen.Count == 0)
            {
                return;
            }
            foreach (var pat in aandoening.Patologieen.Select(pathologie => this.db.Pathologieen.Find(pathologie.Id)))
            {
                pat.Aandoeningen.Add(this.db.Aandoeningen.Find(aandoening.Id));
                this.db.SaveChanges();
            }

            //return Ok(aand);
            //return CreatedAtRoute("DefaultApi", new { id = aandoening.Id }, aandoening);
        }

        // DELETE: api/Aandoenings/5
        [HttpDelete]
        [Route("Aandoening/{id}")]
        [ResponseType(typeof(Aandoening))]
        public IHttpActionResult Delete(int id)
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