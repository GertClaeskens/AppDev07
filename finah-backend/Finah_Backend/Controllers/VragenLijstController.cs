using System.Collections.Generic;
using System.Web.Http;

namespace Finah_Backend.Controllers
{
    using System.Data.Entity;
    using System.Data.Entity.Infrastructure;
    using System.Linq;
    using System.Net;
    using System.Web.Http.Description;

    using Finah_Backend.DAL;
    using Finah_Backend.Models;

    public class VragenLijstController : ApiController
    {
        //TODO code opschonen
        private List<VragenLijst> vragenlijsten = new List<VragenLijst>();

        private FinahDBContext db;

        public VragenLijstController()
        {
            db = new FinahDBContext();
        }

        //Constructor met als argument een List van Bevragingen, hierdoor kunnen we testdata aan
        //de Controller meegeven om zo unittesten voor de controller te schrijven.
        public VragenLijstController(List<VragenLijst> vragenlijst)
        {
            db = new FinahDBContext();
            this.vragenlijsten = vragenlijst;
        }




        [Route("VragenLijst/Overzicht")] //Geen Api/ meer nodig
        public IEnumerable<VragenLijst> GetOverzicht()
        //public IQueryable<VragenLijst> GetOverzicht()
        {
            return db.VragenLijsten;

        }
        [Route("VragenLijst/{id}")]
        [ResponseType(typeof(VragenLijst))]
        public IHttpActionResult Get(int id)
        {

            var vragenLijst = db.VragenLijsten.Find(id);
            if (vragenLijst == null)
            {
                return NotFound();
            }

            return Ok(vragenLijst);
        }

        [Route("VragenLijst/{id}/{vr}")]
        [ResponseType(typeof(Vraag))]
        public IHttpActionResult Get(int id, int vr)
        {

            var vraag = db.VragenLijsten.Find(id).Vragen.Where(c => c.Id == vr);

            if (vraag == null)
            {
                return NotFound();
            }

            return Ok(vraag);
        }

        // PUT: api/VragenLijsts/5
        [Route("VragenLijst/{id}")]
        [ResponseType(typeof(void))]
        public IHttpActionResult PutVragenLijst(int id, [FromBody] VragenLijst vragenLijst)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != vragenLijst.Id)
            {
                return BadRequest();
            }

            db.Entry(vragenLijst).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!VragenLijstBestaat(id))
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

        // POST: api/VragenLijsts
        [ResponseType(typeof(VragenLijst))]
        public IHttpActionResult PostVragenLijst([FromBody] VragenLijst vragenLijst)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.VragenLijsten.Add(vragenLijst);
            db.SaveChanges();

            return CreatedAtRoute("DefaultApi", new { id = vragenLijst.Id }, vragenLijst);
        }

        // DELETE: api/VragenLijsts/5
        [ResponseType(typeof(VragenLijst))]
        public IHttpActionResult DeleteVragenLijst(int id)
        {
            var vragenLijst = db.VragenLijsten.Find(id);
            if (vragenLijst == null)
            {
                return NotFound();
            }

            db.VragenLijsten.Remove(vragenLijst);
            db.SaveChanges();

            return Ok(vragenLijst);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool VragenLijstBestaat(int id)
        {
            return db.VragenLijsten.Count(e => e.Id == id) > 0;
        }
    }
}