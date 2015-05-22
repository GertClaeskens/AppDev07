using System.Collections.Generic;
using System.Web.Http;
using System.Data.Entity;
using System.Data.Entity.Infrastructure;
using System.Linq;
using System.Net;
using System.Web.Http.Description;
using Finah_Backend.DAL;
using Finah_Backend.Models;

namespace Finah_Backend.Controllers
{
    using System.Web.Http.Cors;

    [EnableCors(origins: "http://finahweb4156.azurewebsites.net", headers: "*", methods: "*")]

    public class VragenController : ApiController
    {
        //TODO code opschonen
        //private List<Vraag> vragen = new List<Vraag>();

        private readonly ApplicationDbContext db;

        public VragenController()
        {
            db = new ApplicationDbContext();
        }

        //Constructor met als argument een List van Bevragingen, hierdoor kunnen we testdata aan
        //de Controller meegeven om zo unittesten voor de controller te schrijven.
        public VragenController(List<Vraag> vragen)
        {
            db = new ApplicationDbContext();
            //this.vragen = vragen;
        }

        [ResponseType(typeof(Vraag))]
        [Route("Vragen/{id}")]
        public IHttpActionResult Get(int id)
        {
            var vraag = db.Vragen.Find(id);
            if (vraag == null)
            {
                return NotFound();
            }

            return Ok(vraag);
        }

        [Route("Vragen/Overzicht")] //Geen Api/ meer nodig
        //public IQueryable<Vraag> GetOverzicht()
        public IEnumerable<Vraag> GetOverzicht()// return -> naderhand veranderen in Bevraging
        {
            db.Configuration.LazyLoadingEnabled = false;
            return db.Vragen.Include(p => p.Afbeelding).Include(p => p.Thema);//.Include(p => p.VragenLijst);
        }

        // PUT: api/Vragen/5
        [HttpPut]
        [Route("Vragen/{id}")]
        [ResponseType(typeof(void))]
        public IHttpActionResult Put(int id, [FromBody] Vraag vraag)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != vraag.Id)
            {
                return BadRequest();
            }
            var vr = new Vraag
                         {
                             Id = vraag.Id,
                             VraagStelling = vraag.VraagStelling,
                             Thema = this.db.Themas.Find(vraag.Thema.Id),
<<<<<<< HEAD
                             //Afbeelding = this.db.Fotos.Find(vraag.Afbeelding.Id),
=======
                             Afbeelding = this.db.Fotos.Find(vraag.Afbeelding.Id),
>>>>>>> c6a8f8ef3b93a1cfeb078f3902043d046bf9ddf0
                             VragenLijst = new List<VragenLijst>()
                         };
            if (vraag.VragenLijst != null)
            {
                foreach (var vl in vraag.VragenLijst)
                {
                    vr.VragenLijst.Add(db.VragenLijsten.Find(vl.Id));
                }
            }

            //db.Entry(vr).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!VraagBestaat(id))
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

        // POST: api/Courses
        [HttpPost]
        [ResponseType(typeof(Vraag))]
        public IHttpActionResult Post([FromBody] Vraag vraag)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }
            var vr = new Vraag
                         {
                             VraagStelling = vraag.VraagStelling,
                             Afbeelding = vraag.Afbeelding,
                             Thema = this.db.Themas.Find(vraag.Thema.Id)
                         };

            //bovenstaande moeten naar db refereren
            if (vraag.VragenLijst != null)
            {
                foreach (var vl in vraag.VragenLijst)
                {
                    vr.VragenLijst.Add(db.VragenLijsten.Find(vl.Id));

                }
            }


            db.Vragen.Add(vr);
            db.SaveChanges();

            return CreatedAtRoute("DefaultApi", new { id = vr.Id }, vr);
        }

        // DELETE: api/Courses/5
        [Route("Vragen/{id}")]
        [ResponseType(typeof(Vraag))]
        [HttpDelete]
        public IHttpActionResult Delete(int id)
        {
            var vraag = db.Vragen.Find(id);
            if (vraag == null)
            {
                return NotFound();
            }
            if (vraag.VragenLijst != null)
            {
                foreach (var vl in vraag.VragenLijst)
                {
                    vl.Vragen.Remove(vraag);
                }
                vraag.VragenLijst = null;
            }
            db.Vragen.Remove(vraag);
            db.SaveChanges();

            return Ok(vraag);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool VraagBestaat(int id)
        {
            return db.Vragen.Count(e => e.Id == id) > 0;
        }
    }
}