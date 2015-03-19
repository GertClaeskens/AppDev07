using System.Collections.Generic;
using System.Web.Http;

namespace Finah_Backend.Controllers
{
    using Finah_Backend.DAL;
    using Finah_Backend.Models;

    public class VragenController : ApiController
    {
        private List<Vraag> vragen = new List<Vraag>();

        private FinahDBContext _db;

        public VragenController()
        {
            _db = new FinahDBContext();
        }

        //Constructor met als argument een List van Bevragingen, hierdoor kunnen we testdata aan
        //de Controller meegeven om zo unittesten voor de controller te schrijven.
        public VragenController(List<Vraag> vragen)
        {
            _db = new FinahDBContext();
            this.vragen = vragen;
        }

        // GET: api/Vragen
        //public IEnumerable<string> Get()
        //{
        //    return new string[] { "value1", "value2" };
        //}

        // GET: api/Vragen/5
        //public string Get(int id)
        //{
        //    return "value";
        //}

        [Route("Vragen/{id}")]
        public IHttpActionResult Get(int id)
        {
            Vraag vraag = new Vraag();
            Foto foto = new Foto();
            GeluidsFragment gf = new GeluidsFragment();

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

            //Bovenstaande code dient om te testen
            //Als database in orde is bovenstaande code wissen en onderstaande regel uncommenten
            //var bevraging = bevragingen.FirstOrDefault((b) => b.Id == id);
            if (vraag == null)
            {
                return NotFound();
            }
            return Ok(vraag);
        }

        [Route("Vragen/Overzicht")] //Geen Api/ meer nodig
        public IEnumerable<Vraag> GetOverzicht()// return -> naderhand veranderen in Bevraging
        {
            //return _db.Vragen.ToList();

            //return vragen;
            Vraag testVraag1 = new Vraag();
            Vraag testVraag2 = new Vraag();
            Vraag testVraag3 = new Vraag();
            Vraag testVraag4 = new Vraag();
            Vraag testVraag5 = new Vraag();

            testVraag1.Id = 1;
            testVraag2.Id = 2;
            testVraag3.Id = 3;
            testVraag4.Id = 4;
            testVraag5.Id = 5;

            List<Vraag> overzichtVragen = new List<Vraag> { testVraag1, testVraag2, testVraag3, testVraag4, testVraag5 };

            return overzichtVragen;
        }

        // POST: api/Vragen
        public void Post([FromBody]string value)
        {
        }

        // PUT: api/Vragen/5
        public void Put(int id, [FromBody]string value)
        {
        }

        // DELETE: api/Vragen/5
        public void Delete(int id)
        {
        }
    }
}