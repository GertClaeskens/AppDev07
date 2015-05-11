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
    public class ThemaController : ApiController
    {
        private FinahDBContext db = new FinahDBContext();

        // GET: api/Thema
        [Route("Thema/Overzicht")]
        public IQueryable<Thema> GetThemas()
        {
            return db.Themas;
        }

        // GET: api/Thema/5
        [ResponseType(typeof(Thema))]
        public IHttpActionResult GetThema(int id)
        {
            var thema = db.Themas.Find(id);
            if (thema == null)
            {
                return NotFound();
            }

            return Ok(thema);
        }

        // PUT: api/Thema/5
        [ResponseType(typeof(void))]
        [HttpPut]
        public IHttpActionResult PutThema(int id, Thema thema)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != thema.Id)
            {
                return BadRequest();
            }

            db.Entry(thema).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!ThemaExists(id))
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

        // POST: api/Thema
        [ResponseType(typeof(Thema))]
        public IHttpActionResult PostThema(Thema thema)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.Themas.Add(thema);
            db.SaveChanges();

            return CreatedAtRoute("DefaultApi", new { id = thema.Id }, thema);
        }

        // DELETE: api/Thema/5
        [HttpDelete]
        [ResponseType(typeof(Thema))]
        public IHttpActionResult DeleteThema(int id)
        {
            var thema = db.Themas.Find(id);
            if (thema == null)
            {
                return NotFound();
            }

            db.Themas.Remove(thema);
            db.SaveChanges();

            return Ok(thema);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool ThemaExists(int id)
        {
            return db.Themas.Count(e => e.Id == id) > 0;
        }
    }
}