using System.Collections.Generic;
using System.Web.Http;

namespace Finah_Backend.Controllers
{
    using Finah_Backend.DAL;
    using Finah_Backend.Models;

    public class VragenLijstController : ApiController
    {
        private List<VragenLijst> vragenlijsten = new List<VragenLijst>();

        private FinahDBContext _db;

        public VragenLijstController()
        {
            _db = new FinahDBContext();
        }

        //Constructor met als argument een List van Bevragingen, hierdoor kunnen we testdata aan
        //de Controller meegeven om zo unittesten voor de controller te schrijven.
        public VragenLijstController(List<VragenLijst> vragenlijst)
        {
            _db = new FinahDBContext();
            this.vragenlijsten = vragenlijst;
        }

        // GET: api/VragenLijst
        //public IEnumerable<string> Get()
        //{
        //    return new string[] { "value1", "value2" };
        //}

        // GET: api/VragenLijst/5
        //public string Get(int id)
        //{
        //    return "value";
        //}

        [Route("VragenLijst/{id}")]
        public IHttpActionResult Get(int id)
        {
            VragenLijst vl = new VragenLijst();
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
            vl.Id = 1;
            vl.Vragen = vragen;
            vl.Aandoe = ad;

            //Bovenstaande code dient om te testen
            //Als database in orde is bovenstaande code wissen en onderstaande regel uncommenten
            //var bevraging = bevragingen.FirstOrDefault((b) => b.Id == id);
            if (vl == null)
            {
                return NotFound();
            }
            return Ok(vl);
        }

        [Route("VragenLijst/Overzicht")] //Geen Api/ meer nodig
        public IEnumerable<VragenLijst> GetOverzicht()// return -> naderhand veranderen in Bevraging
        {
            //return _db.Vragen.ToList();

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

        // POST: api/VragenLijst
        public void Post([FromBody]string value)
        {
        }

        // PUT: api/VragenLijst/5
        public void Put(int id, [FromBody]string value)
        {
        }

        // DELETE: api/VragenLijst/5
        public void Delete(int id)
        {
        }
    }
}