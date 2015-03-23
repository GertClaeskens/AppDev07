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
    /// <summary>
    /// Voor test doeleinden
    /// </summary>
    public class PostcodesController : ApiController
    {
        private FinahDBContext db = new FinahDBContext();

        // GET: api/Postcodes
        public IQueryable<Postcode> GetPostcodes()
        {
            return db.Postcodes;
        }

        // GET: api/Postcodes/5
        [ResponseType(typeof(Postcode))]
        public IHttpActionResult GetPostcode(int id)
        {
            var postcode = db.Postcodes.Find(id);
            if (postcode == null)
            {
                return NotFound();
            }

            return Ok(postcode);
        }

        // PUT: api/Postcodes/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutPostcode(int id, Postcode postcode)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != postcode.Id)
            {
                return BadRequest();
            }

            db.Entry(postcode).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!PostcodeExists(id))
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

        // POST: api/Postcodes
        [ResponseType(typeof(Postcode))]
        public IHttpActionResult PostPostcode(Postcode postcode)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.Postcodes.Add(postcode);
            db.SaveChanges();

            return CreatedAtRoute("DefaultApi", new { id = postcode.Id }, postcode);
        }

        // DELETE: api/Postcodes/5
        [ResponseType(typeof(Postcode))]
        public IHttpActionResult DeletePostcode(int id)
        {
            var postcode = db.Postcodes.Find(id);
            if (postcode == null)
            {
                return NotFound();
            }

            db.Postcodes.Remove(postcode);
            db.SaveChanges();

            return Ok(postcode);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool PostcodeExists(int id)
        {
            return db.Postcodes.Count(e => e.Id == id) > 0;
        }
    }
}