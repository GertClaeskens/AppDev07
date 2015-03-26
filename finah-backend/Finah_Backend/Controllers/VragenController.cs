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


    public class VragenController : ApiController
    {
        private List<Vraag> vragen = new List<Vraag>();

        private readonly FinahDBContext db;

        public VragenController()
        {
            db = new FinahDBContext();
        }

        //Constructor met als argument een List van Bevragingen, hierdoor kunnen we testdata aan
        //de Controller meegeven om zo unittesten voor de controller te schrijven.
        public VragenController(List<Vraag> vragen)
        {
            db = new FinahDBContext();
            this.vragen = vragen;
        }

        [ResponseType(typeof(Vraag))]
        [Route("Vragen/{id}")]
        public IHttpActionResult Get(int id)
        {
            Vraag vraag = null;
            if (id == 1)
            {
                vraag = new Vraag();
                var foto = new Foto();
                var gf = new GeluidsFragment();

                foto.Id = 1;
                foto.Omschrijving = "foto vraag 1";
                foto.Pad = "pad";

                gf.Id = 1;
                gf.Omschrijving = "geluid vraag 1";
                gf.Pad = "geluidpad";

                vraag.Id = 1;
                vraag.VraagStelling = "Lorem ipsum bladibla";
                vraag.Afbeelding = foto;
                vraag.Geluid = gf;
            }
            //Bovenstaande code dient om te testen
            //Als database in orde is bovenstaande code wissen en onderstaande regel uncommenten
            //Vraag vraag = db.Vragen.Find(id);
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
            //return db.Vragen;

            //return vragen;
            var testVraag1 = new Vraag { Id = 1, VraagStelling = "Lorem ipsum bladibla" };
            var testVraag2 = new Vraag { Id = 2, VraagStelling = "Voorbeeld vraag" };
            var testVraag3 = new Vraag { Id = 3, VraagStelling = "Lorem ipsum nougae bollus" };
            var testVraag4 = new Vraag { Id = 4, VraagStelling = "Lorem ipsum jupsum nummum" };
            var testVraag5 = new Vraag { Id = 5, VraagStelling = "Lorem ipsum blaedibladibus" };


            var overzichtVragen = new List<Vraag> { testVraag1, testVraag2, testVraag3, testVraag4, testVraag5 };

            return overzichtVragen;
        }

        // PUT: api/Vragen/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutCourse(int id, Vraag vraag)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != vraag.Id)
            {
                return BadRequest();
            }

            db.Entry(vraag).State = EntityState.Modified;

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
        [ResponseType(typeof(Vraag))]
        public IHttpActionResult PostCourse(Vraag vraag)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.Vragen.Add(vraag);
            db.SaveChanges();

            return CreatedAtRoute("DefaultApi", new { id = vraag.Id }, vraag);
        }

        // DELETE: api/Courses/5
        [ResponseType(typeof(Vraag))]
        public IHttpActionResult DeleteCourse(int id)
        {
            var vraag = db.Vragen.Find(id);
            if (vraag == null)
            {
                return NotFound();
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