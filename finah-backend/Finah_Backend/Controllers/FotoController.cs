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

    public class FotoController : ApiController
    {
        private FinahDBContext db;
        private List<Foto> fotos = new List<Foto>();

        public FotoController()
        {
            db = new FinahDBContext();
        }

        //Constructor met als argument een List van Bevragingen, hierdoor kunnen we testdata aan
        //de Controller meegeven om zo unittesten voor de controller te schrijven.
        public FotoController(List<Foto> fotos)
        {
            db = new FinahDBContext();
            this.fotos = fotos;
        }

        [Route("Foto/{id}")]
        [ResponseType(typeof(Foto))]
        public IHttpActionResult Get(int id)
        {
            var foto = new Foto { Id = 1, Omschrijving = "foto vraag 1", Pad = "pad" };

            //Bovenstaande code dient om te testen (op dit moment nutteloos)
            //Als database in orde is bovenstaande code wissen en onderstaande regel uncommenten
            //Foto foto = db.Fotos.Find(id);
            if (foto == null)
            {
                return NotFound();
            }

            return Ok(foto);
        }

        [Route("Foto/Overzicht")] //Geen Api/ meer nodig
        //public IQueryable<Foto> GetOverzicht()
        public IEnumerable<Foto> GetOverzicht()// return -> naderhand veranderen in Bevraging
        {
            //return db.Fotos;


            //return vragen;
            Foto f1 = new Foto();
            Foto f2 = new Foto();
            Foto f3 = new Foto();
            Foto f4 = new Foto();
            Foto f5 = new Foto();

            f1.Id = 1;
            f2.Id = 2;
            f3.Id = 3;
            f4.Id = 4;
            f5.Id = 5;

            List<Foto> overzichtFotos = new List<Foto> { f1, f2, f3, f4, f5 };

            return overzichtFotos;
        }



        // PUT: api/Fotoes/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutFoto(int id, Foto foto)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != foto.Id)
            {
                return BadRequest();
            }

            db.Entry(foto).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!FotoBestaat(id))
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

        // POST: api/Fotoes
        [ResponseType(typeof(Foto))]
        public IHttpActionResult PostFoto(Foto foto)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.Fotos.Add(foto);
            db.SaveChanges();

            return CreatedAtRoute("DefaultApi", new { id = foto.Id }, foto);
        }

        // DELETE: api/Fotoes/5
        [ResponseType(typeof(Foto))]
        public IHttpActionResult DeleteFoto(int id)
        {
            Foto foto = db.Fotos.Find(id);
            if (foto == null)
            {
                return NotFound();
            }

            db.Fotos.Remove(foto);
            db.SaveChanges();

            return Ok(foto);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool FotoBestaat(int id)
        {
            return db.Fotos.Count(e => e.Id == id) > 0;
        }
    }
}