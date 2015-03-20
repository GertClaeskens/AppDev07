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
            //return db.VragenLijsten;

            //return vragen;
            VragenLijst vl1 = new VragenLijst();
            VragenLijst vl2 = new VragenLijst();
            VragenLijst vl3 = new VragenLijst();
            VragenLijst vl4 = new VragenLijst();
            VragenLijst vl5 = new VragenLijst();

            vl1.Id = 1;
            vl2.Id = 2;
            vl3.Id = 3;
            vl4.Id = 4;
            vl5.Id = 5;

            List<VragenLijst> overzichtVragenLijst = new List<VragenLijst> { vl1, vl2, vl3, vl4, vl5 };

            return overzichtVragenLijst;
        }
        [Route("VragenLijst/{id}")]
        [ResponseType(typeof(VragenLijst))]
        public IHttpActionResult Get(int id)
        {
            VragenLijst vragenLijst = new VragenLijst();
            List<Vraag> vragen = new List<Vraag>();
            Vraag vraag = new Vraag();
            Foto foto = new Foto();
            GeluidsFragment gf = new GeluidsFragment();
            Aandoening ad = new Aandoening();
            Pathologie pt = new Pathologie();
            List<Pathologie> patLijst = new List<Pathologie>();

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

            pt.Id = 1;
            patLijst.Add(pt);

            ad.Id = 1;
            ad.Patologieen = patLijst;

            vragen.Add(vraag);
            vragenLijst.Id = 1;
            vragenLijst.Vragen = vragen;
            vragenLijst.Aandoe = ad;

            //Bovenstaande code dient om te testen
            //Als database in orde is bovenstaande code wissen en onderstaande regel uncommenten
            //VragenLijst vragenLijst = db.VragenLijsten.Find(id);
            if (vragenLijst == null)
            {
                return NotFound();
            }

            return Ok(vragenLijst);
        }

        // PUT: api/VragenLijsts/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutVragenLijst(int id, VragenLijst vragenLijst)
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
        public IHttpActionResult PostVragenLijst(VragenLijst vragenLijst)
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
            VragenLijst vragenLijst = db.VragenLijsten.Find(id);
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