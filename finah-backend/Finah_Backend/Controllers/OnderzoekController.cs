using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Data.Entity.Infrastructure;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Http.Description;
using Finah_Backend.DAL;
using Finah_Backend.Models;

namespace Finah_Backend.Controllers
{
    using System.Web.Http.Cors;

    [EnableCors(origins: "http://finahweb4156.azurewebsites.net", headers: "*", methods: "*")]
    public class OnderzoekController : ApiController
    {
        private ApplicationDbContext db = new ApplicationDbContext();

        // GET: api/Onderzoek
        [Route("Onderzoek/Overzicht")]
        public IQueryable<Onderzoek> GetOnderzoeken()
        {
            db.Configuration.LazyLoadingEnabled = false;
            return db.Onderzoeken.Include(o => o.Bevraging_Man).Include(o => o.Pathologie).Include(o => o.Bevraging_Pat).Include(o => o.AangemaaktDoor).Include(o => o.Relatie).Include(o => o.Vragen).Include(o => o.Aandoening).Include(o => o.Pathologie);
        }

        [Route("Onderzoek/{id}")]

        public IHttpActionResult GetOnderzoek(int id)
        {
            db.Configuration.LazyLoadingEnabled = false;
            var onderzoek = (from o in db.Onderzoeken.Include(o => o.Bevraging_Man).Include(o => o.Pathologie).Include(o => o.Bevraging_Pat).Include(o => o.AangemaaktDoor).Include(o => o.Relatie).Include(o => o.Vragen).Include(o => o.Aandoening).Include(o => o.Pathologie)
                             where (o.Id == id)
                             select o).Include(o => o.Vragen.Vragen);



            if (onderzoek == null)
            {
                return this.NotFound();
            }

            return this.Ok(onderzoek);
        }
        // GET: api/Onderzoek/5
        [Route("Onderzoek/Bevraging/{id}")]
        [ResponseType(typeof(Onderzoek))]
        public IHttpActionResult GetOnderzoekDoorBevragingId(string id)
        {
            //var onderzoek = db.Onderzoeken.Where(c => c.Id == id).Include(c => c.Bevraging_Man).Include(c => c.Bevraging_Pat).Include(c => c.Vragen).Include(c => c.Relatie);
            var onderzoek = (from o in db.Onderzoeken.Include(o => o.Bevraging_Man).Include(o => o.Pathologie).Include(o => o.Bevraging_Pat).Include(o => o.AangemaaktDoor).Include(o => o.Relatie).Include(o => o.Vragen).Include(o => o.Aandoening).Include(o => o.Pathologie)
                             where (o.Bevraging_Man.Id.Equals(id) || o.Bevraging_Pat.Id.Equals(id))
                             select o).ToList();
            //var antwoorden = db.AntwoordenLijsten.Where(a => a.BevragingId == id).OrderBy(a => a.Datum).ToList();
            if (onderzoek == null)
            {
                return NotFound();
            }

            //for (var i = 0; i < antwoorden.Count; i++)
            //{
            //    onderzoek[i].Datum = antwoorden[i].Datum;
            //}


            return Ok(onderzoek);
        }
        [Route("Onderzoek/RecenteBevraging")]
        // GET: api/Onderzoek/5
        [ResponseType(typeof(Onderzoek))]
        public IHttpActionResult GetRecenteOnderzoek(string id)
        {
            //var onderzoek = db.Onderzoeken.Where(c => c.Id == id).Include(c => c.Bevraging_Man).Include(c => c.Bevraging_Pat).Include(c => c.Vragen).Include(c => c.Relatie);
            var onderzoek =
                (from o in db.Onderzoeken.Include(o => o.Bevraging_Man).Include(o => o.Pathologie).Include(o => o.Bevraging_Pat).Include(o => o.AangemaaktDoor).Include(o => o.Relatie).Include(o => o.Vragen).Include(o => o.Aandoening).Include(o => o.Pathologie)
                 where (o.Bevraging_Man.Id.Equals(id) || o.Bevraging_Pat.Id.Equals(id))
                 select o).First();
            //var bevraging = db.AntwoordenLijsten.Where(a => a.BevragingId == id).OrderBy(a => a.Datum).ToList();
            // onderzoek.Datum = bevraging[0].Datum;


            if (onderzoek == null)
            {
                return NotFound();
            }

            return Ok(onderzoek);
        }

        // GET: api/Onderzoek/{id}
        [Route("Onderzoek/Aandoening/{id}")]
        [ResponseType(typeof(Aandoening))]
        public IHttpActionResult GetAandoening(string id)
        {
            var aandoening =
                (from o in
                     db.Onderzoeken.Include(o => o.Bevraging_Man)
                     .Include(o => o.Pathologie)
                     .Include(o => o.Bevraging_Pat)
                     .Include(o => o.AangemaaktDoor)
                     .Include(o => o.Relatie)
                     .Include(o => o.Vragen)
                     .Include(o => o.Aandoening)
                     .Include(o => o.Pathologie)
                 where (o.Bevraging_Man.Id.Equals(id) || o.Bevraging_Pat.Id.Equals(id))
                 select o.Aandoening);
            if (aandoening == null)
            {
                return NotFound();
            }

            return Ok(aandoening);
        }
        //[Route("Onderzoek/{id}/Vragen")]
        //public IQueryable<VragenLijst> GetVragen(string id)
        //{
        //    var vragen =
        //        (from o in db.Onderzoeken
        //         where (o.Bevraging_Man.Id.Equals(id) || o.Bevraging_Pat.Id.Equals(id))
        //         select o.Vragen);
        //    return vragen;
        //}

        [Route("Onderzoek/{id}/Vragen/")]
        public IEnumerable<ICollection<Vraag>> GetVraag(string id)
        {
            db.Configuration.LazyLoadingEnabled = false;
            var vragen =
                (from o in
                     db.Onderzoeken.Include(o => o.Vragen.Vragen)
                 where (o.Bevraging_Man.Id.Equals(id) || o.Bevraging_Pat.Id.Equals(id))
                 select o.Vragen.Vragen).ToList();
            foreach (Vraag v in vragen[0])
            {
                v.Thema = db.Themas.Find(v.ThemaId);
            }
            return vragen;
        }
        // PUT: api/Onderzoek/5
        [HttpPut]
        [ResponseType(typeof(void))]
        public IHttpActionResult Put(int id, Onderzoek onderzoek)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != onderzoek.Id)
            {
                return BadRequest();
            }

            //Onderzoek o = db.Onderzoeken.Find(onderzoek.Id);
            //o.Vragen = db.VragenLijsten.Find(onderzoek.Vragen.Id);
            //o.Informatie = onderzoek.Informatie;
            //o.Relatie = db.Relaties.Find(onderzoek.Relatie.Id);
            //o.Pathologie = db.Pathologieen.Find(onderzoek.Pathologie.Id);
            //o.Aandoening = db.Aandoeningen.Find(onderzoek.Aandoening.Id);
            //o.
            db.Entry(onderzoek).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!OnderzoekExists(id))
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

        // POST: api/Onderzoek
        [HttpPost]
        [ResponseType(typeof(Onderzoek))]
        public IHttpActionResult Post([FromBody] Onderzoek onderzoek)
        {
            //if (!ModelState.IsValid)
            //{
            //    return BadRequest(ModelState);
            //}
            onderzoek.Datum = DateTime.Now;

            onderzoek.Pathologie = db.Pathologieen.Find(onderzoek.Pathologie.Id);
            onderzoek.Relatie = db.Relaties.Find(onderzoek.Relatie.Id);
            onderzoek.Aandoening = db.Aandoeningen.Find(onderzoek.Aandoening.Id);
            onderzoek.Vragen = db.VragenLijsten.Find(onderzoek.Vragen.Id);
            onderzoek.PathologieId = onderzoek.Pathologie.Id;
            onderzoek.RelatieId = onderzoek.Relatie.Id;
            onderzoek.AandoeningId = onderzoek.Aandoening.Id;
            onderzoek.VragenId = onderzoek.Vragen.Id;
            onderzoek.Bevraging_Man = db.Bevragingen.Find(onderzoek.Bevraging_Man.Id);
            onderzoek.Bevraging_ManId = onderzoek.Bevraging_Man.Id;
            onderzoek.Bevraging_Pat = db.Bevragingen.Find(onderzoek.Bevraging_Pat.Id);
            onderzoek.Bevraging_PatId = onderzoek.Bevraging_Pat.Id;

            //onderzoek.AangemaaktDoor = db.Accounts.Find(onderzoek.AangemaaktDoor.Id);
            db.Onderzoeken.Add(onderzoek);
            db.SaveChanges();

            return CreatedAtRoute("DefaultApi", new { id = onderzoek.Id }, onderzoek);
        }

        // DELETE: api/Onderzoek/5
        [HttpDelete]
        [ResponseType(typeof(Onderzoek))]
        public IHttpActionResult Delete(int id)
        {
            var onderzoek = db.Onderzoeken.Find(id);
            if (onderzoek == null)
            {
                return NotFound();
            }

            db.Onderzoeken.Remove(onderzoek);
            db.SaveChanges();

            return Ok(onderzoek);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool OnderzoekExists(int id)
        {
            return db.Onderzoeken.Count(e => e.Id == id) > 0;
        }
    }
}