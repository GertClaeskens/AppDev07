using System.Collections.Generic;
using System.Web.Http;

namespace Finah_Backend.Controllers
{
    using System.Web.Http.Cors;

    using Finah_Backend.DAL;
    using Finah_Backend.Models;
    using System.Data.Entity;
    using System.Data.Entity.Infrastructure;
    using System.Linq;
    using System.Net;
    using System.Web.Http.Description;


    [EnableCors(origins: "http://finahweb4156.azurewebsites.net, http://localhost:63342", headers: "*", methods: "*")]
    [Authorize(Roles = "Admin, Onderzoeker")]
    public class PathologieController : ApiController
    {
        // GET: api/Pathologie
        private List<Pathologie> pathologieen = new List<Pathologie>();

        private ApplicationDbContext db;

        public PathologieController()
        {
            db = new ApplicationDbContext();
        }

        //Constructor met als argument een List van Bevragingen, hierdoor kunnen we testdata aan
        //de Controller meegeven om zo unittesten voor de controller te schrijven.
        public PathologieController(List<Pathologie> pathologieen)
        {
            db = new ApplicationDbContext();
            this.pathologieen = pathologieen;
        }

        [Route("Pathologie/Overzicht")] //Geen Api/ meer nodig
        public IQueryable<Pathologie> GetOverzicht()
        //public IEnumerable<Pathologie> GetOverzicht()// return -> naderhand veranderen in Bevraging
        {
            db.Configuration.LazyLoadingEnabled = false;
            return db.Pathologieen.Include(p => p.Aandoeningen);
        }

        [ResponseType(typeof(Pathologie))]
        //Geen Api/ meer nodig
        [Route("Pathologie/{id}")]
        public IHttpActionResult Get(int id)
        {
            var pathologie = db.Pathologieen.Find(id);
            if (pathologie == null)
            {
                return NotFound();
            }

            return Ok(pathologie);
        }

        // PUT: api/Pathologies/5
        [HttpPut]
        [Route("Pathologie/{id}")]
        [ResponseType(typeof(void))]
        public IHttpActionResult Put(int id, [FromBody] Pathologie pathologie)
        {
            //TODO nakijken of dit nog werkt als er aandoeningen zijn aan toegevoegd
            //TODO nog niet waterdicht -> Transactie?
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != pathologie.Id)
            {
                return BadRequest();
            }
            var p = db.Pathologieen.Find(id);
            p.Omschrijving = pathologie.Omschrijving;
            //Verwijder de verwijzing naar deze aandoening uit de pathologieen in de lijst.
            if (p.Aandoeningen.Count != 0 && p.Aandoeningen != null)
            {
                //Sla de pathologieen eerst op in een lijst -> anders problemen dat de verzamling veranderd is tijdens de foreach
                var adLijst = p.Aandoeningen.ToList();
                foreach (var ad in adLijst.Select(a => this.db.Aandoeningen.Find(a.Id)))
                {
                    ad.Patologieen.Remove(this.db.Pathologieen.Find(id));
                    this.db.Entry(ad).State = EntityState.Modified;
                }
            }
            //Maak de lijst leeg
            p.Aandoeningen = new List<Aandoening>();
            db.SaveChanges();


            if (pathologie.Aandoeningen != null && pathologie.Aandoeningen.Count != 0)
            {
                foreach (var a in pathologie.Aandoeningen)
                {
                    p.Aandoeningen.Add(db.Aandoeningen.Find(a.Id));
                    var ad = db.Aandoeningen.Find(a.Id);
                    ad.Patologieen.Add(db.Pathologieen.Find(p.Id));
                    db.Entry(ad).State = EntityState.Modified;
                }
            }
            db.Entry(p).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!PathologieBestaat(id))
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

        // POST: api/Pathologies
        [HttpPost]
        [ResponseType(typeof(Pathologie))]
        public void Post([FromBody] Pathologie pathologie)
        {
            //if (!ModelState.IsValid)
            //{
            //    return BadRequest(ModelState);
            //}
            var pat = new Pathologie { Omschrijving = pathologie.Omschrijving, Aandoeningen = new List<Aandoening>() };
            if (pathologie.Aandoeningen != null && pathologie.Aandoeningen.Count != 0)
            {
                foreach (var aand in pathologie.Aandoeningen)
                {
                    pat.Aandoeningen.Add(db.Aandoeningen.Find(aand.Id));

                }
            }
            db.Pathologieen.Add(pat);
            db.SaveChanges();

            if (pat.Aandoeningen == null || pat.Aandoeningen.Count != 0)
            {
                return;
            }
            foreach (var ad in pat.Aandoeningen.Select(ad => this.db.Aandoeningen.Find(ad.Id)))
            {
                ad.Patologieen.Add(db.Pathologieen.Find(pat.Id));
                this.db.SaveChanges();
            }



            //return CreatedAtRoute("DefaultApi", new { id = pathologie.Id }, pathologie);
        }

        // DELETE: api/Pathologies/5
        [HttpDelete]
        [Route("Pathologie/{id}")]
        [ResponseType(typeof(Pathologie))]
        public IHttpActionResult Delete(int id)
        {
            var pathologie = db.Pathologieen.Find(id);
            if (pathologie == null)
            {
                return NotFound();
            }

            db.Pathologieen.Remove(pathologie);
            db.SaveChanges();

            return Ok(pathologie);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool PathologieBestaat(int id)
        {
            return db.Pathologieen.Count(e => e.Id == id) > 0;
        }
    }
}