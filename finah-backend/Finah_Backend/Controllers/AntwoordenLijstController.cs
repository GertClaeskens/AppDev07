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
        private FinahDBContext db = new FinahDBContext();

        // GET: api/AntwoordenLijst
        public IQueryable<AntwoordenLijst> GetOverzicht()
        {
            return db.AntwoordenLijsts;
        }

        // GET: api/AntwoordenLijst/5
        [ResponseType(typeof(AntwoordenLijst))]
        public IHttpActionResult GetAntwoordenLijst(string id)
        {
            AntwoordenLijst antwoordenLijst = db.AntwoordenLijsts.Find(id);
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
        public IHttpActionResult PostAntwoordenLijst(AntwoordenLijst antwoordenLijst)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.AntwoordenLijsts.Add(antwoordenLijst);

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
            AntwoordenLijst antwoordenLijst = db.AntwoordenLijsts.Find(id);
            if (antwoordenLijst == null)
            {
                return NotFound();
            }

            db.AntwoordenLijsts.Remove(antwoordenLijst);
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
            return db.AntwoordenLijsts.Count(e => e.Id == id) > 0;
        }
    }
}