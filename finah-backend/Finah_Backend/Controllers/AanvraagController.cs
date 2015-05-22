using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace Finah_Backend.Controllers
{
    using System.Data.Entity;
    using System.Data.Entity.Infrastructure;
    using System.Linq;
    using System.Net;
    using System.Web.Http.Cors;
    using System.Web.Http.Description;

    using Finah_Backend.DAL;
    using Finah_Backend.Models;

    //[Authorize(Roles = "Admin, Onderzoeker")]
    [EnableCors(origins: "http://finahweb4156.azurewebsites.net, http://localhost:63342", headers: "*", methods: "*")]
    public class AanvraagController : ApiController
    {
        //TODO Code opschonen als alles bolt
        private readonly ApplicationDbContext db = new ApplicationDbContext();

        // GET: api/Aanvraag
        [Route("Aanvraag/Overzicht")]
        //public IQueryable<Aanvraag> GetOverzicht()
        public IEnumerable<Aanvraag> GetOverzicht()// return -> naderhand veranderen in bovenstaande
        {
            db.Configuration.LazyLoadingEnabled = false;
            return db.Aanvragen;
        }

        // GET: api/Aanvraag/5
        [HttpGet]
        [Route("Aanvraag/{id}")]
        [ResponseType(typeof(Aanvraag))]
        public IHttpActionResult Get(int id)
        {
            //Aanvraag aanvraag = null;
            //if (id == 1)
            //{
            //    aanvraag = new Aanvraag { Id = 1 };
            //}
            db.Configuration.LazyLoadingEnabled = false;
            var aanvraag = db.Aanvragen.Find(id);
            if (aanvraag == null)
            {
                return NotFound();
            }

            return Ok(aanvraag);
        }

        // PUT: api/Aanvraags/5
        [HttpPut]
        [Route("Aanvraag/{id}")]
        [ResponseType(typeof(void))]
        public IHttpActionResult PutAanvraag(int id, Aanvraag aanvraag)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != aanvraag.Id)
            {
                return BadRequest();
            }

            db.Entry(aanvraag).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!AanvraagBestaat(id))
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

        // POST: api/Aanvraags
        [HttpPost]
        [ResponseType(typeof(Aanvraag))]
        public IHttpActionResult Post([FromBody] Aanvraag aanvraag)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            aanvraag.Postcd = db.Postcodes.Find(aanvraag.Postcd.Id);
            db.Aanvragen.Add(aanvraag);
            db.SaveChanges();

            return CreatedAtRoute("DefaultApi", new { id = aanvraag.Id }, aanvraag);
        }


        // DELETE: api/Aanvraags/5
        [HttpDelete]
        [Route("Aanvraag/{id}")]
        [ResponseType(typeof(Aanvraag))]
        public IHttpActionResult DeleteAanvraag(int id)
        {
            var aanvraag = db.Aanvragen.Find(id);
            if (aanvraag == null)
            {
                return NotFound();
            }

            db.Aanvragen.Remove(aanvraag);
            db.SaveChanges();

            return Ok(aanvraag);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool AanvraagBestaat(int id)
        {
            return db.Aanvragen.Count(e => e.Id == id) > 0;
        }
    }
}