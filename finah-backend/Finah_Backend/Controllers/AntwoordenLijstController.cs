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
    public class AntwoordenLijstController : ApiController
    {
        //TODO Code opschonen als alles bolt
        private ApplicationDbContext db = new ApplicationDbContext();

        [Route("AntwoordenLijst/Overzicht")]
        // GET: api/AntwoordenLijst
        //public IQueryable<AntwoordenLijst> GetOverzicht()
        public IEnumerable<AntwoordenLijst> GetOverzicht()
        {
            return db.AntwoordenLijsten.Include(a => a.LeeftijdsCategorie);

        }

        // GET: api/AntwoordenLijst/5
        //[Route("AntwoordenLijst/{id},{datum}")]
        [Route("AntwoordenLijst/{id}")]
        [ResponseType(typeof(AntwoordenLijst))]
        //public IHttpActionResult GetAntwoordenLijst(string id,DateTime datum)
        public IHttpActionResult GetAntwoordenLijst(string id)
        {
            var antwoordenLijst = db.AntwoordenLijsten.Where(c => c.BevragingId == id).Include(c => c.LeeftijdsCategorie).First();//var antwoordenLijst = db.AntwoordenLijsten.Where(c => c.Id == id && c.Datum == datum).Include(c => c.LeeftijdsCategorie).First();

            if (antwoordenLijst == null)
            {
                return NotFound();
            }

            return Ok(antwoordenLijst);
        }

        // PUT: api/AntwoordenLijst/5
        //[Route("AntwoordenLijst/{id},{datum}")]
        [Route("AntwoordenLijst/{id}")]
        [ResponseType(typeof(void))]
        //public IHttpActionResult PutAntwoordenLijst(string id, DateTime datum, AntwoordenLijst antwoordenLijst)
        public IHttpActionResult PutAntwoordenLijst(int id, AntwoordenLijst antwoordenLijst)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            //if (id != antwoordenLijst.Id && datum != antwoordenLijst.Datum)
            if (id != antwoordenLijst.Id)
            {
                return BadRequest();
            }

            db.Entry(antwoordenLijst).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!AntwoordenLijstExists(id))
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

        // POST: api/AntwoordenLijst
        [ResponseType(typeof(AntwoordenLijst))]
        public IHttpActionResult PostAntwoordenLijst([FromBody] AntwoordenLijst antwoordenLijst)
        {
            antwoordenLijst.LeeftijdsCategorie = db.LeeftijdsCategorieen.Find(antwoordenLijst.LeeftijdsCategorie.Id);
            antwoordenLijst.Bevraging = db.Bevragingen.Find(antwoordenLijst.Bevraging.Id);

            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.AntwoordenLijsten.Add(antwoordenLijst);

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateException)
            {
                if (AntwoordenLijstExists(antwoordenLijst.Id))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtRoute("DefaultApi", new { id = antwoordenLijst.Id }, antwoordenLijst);
        }

        // DELETE: api/AntwoordenLijst/5
        [ResponseType(typeof(AntwoordenLijst))]
        public IHttpActionResult DeleteAntwoordenLijst(string id)
        {
            var antwoordenLijst = db.AntwoordenLijsten.Find(id);
            if (antwoordenLijst == null)
            {
                return NotFound();
            }

            db.AntwoordenLijsten.Remove(antwoordenLijst);
            db.SaveChanges();

            return Ok(antwoordenLijst);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool AntwoordenLijstExists(int id)
        {
            return db.AntwoordenLijsten.Count(e => e.Id == id) > 0;
        }
    }
}