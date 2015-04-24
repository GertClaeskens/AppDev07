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
    public class AntwoordenLijstController : ApiController
    {
        //TODO Code opschonen als alles bolt
        private FinahDBContext db = new FinahDBContext();

        [Route("AntwoordenLijst/Overzicht")]
        // GET: api/AntwoordenLijst
        //public IQueryable<AntwoordenLijst> GetOverzicht()
        public IEnumerable<AntwoordenLijst> GetOverzicht()
        {
            return db.AntwoordenLijsten;
            //var al1 = new AntwoordenLijst { Id = "1" };
            //var al2 = new AntwoordenLijst { Id = "1" };
            //var al3 = new AntwoordenLijst { Id = "1" };
            //var al4 = new AntwoordenLijst { Id = "1" };
            //var al5 = new AntwoordenLijst { Id = "1" };

            //var controleAntwoordenLijst = new List<AntwoordenLijst> { al1, al2, al3, al4, al5 };
            //return controleAntwoordenLijst;
        }

        // GET: api/AntwoordenLijst/5
        [Route("AntwoordenLijst/{id}")]
        [ResponseType(typeof(AntwoordenLijst))]
        public IHttpActionResult GetAntwoordenLijst(string id)
        {
            AntwoordenLijst antwoordenLijst = db.AntwoordenLijsten.Find(id);
            //AntwoordenLijst antwoordenLijst = null;
            //if (id.Equals("1"))
            //{
            //    antwoordenLijst = new AntwoordenLijst { Id = "1" };//, Antwoorden = new List<Antwoord> { new Antwoord { Id = 1, Antword = 4 } } };
            //}
            if (antwoordenLijst == null)
            {
                return NotFound();
            }

            return Ok(antwoordenLijst);
        }

        // PUT: api/AntwoordenLijst/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutAntwoordenLijst(string id, AntwoordenLijst antwoordenLijst)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

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
            AntwoordenLijst antwoordenLijst = db.AntwoordenLijsten.Find(id);
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

        private bool AntwoordenLijstExists(string id)
        {
            return db.AntwoordenLijsten.Count(e => e.Id == id) > 0;
        }
    }
}