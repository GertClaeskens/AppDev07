using System.Collections.Generic;
using System.Web.Http;

namespace Finah_Backend.Controllers
{
    using Finah_Backend.DAL;
    using Finah_Backend.Models;

    public class FotoController : ApiController
    {
        private FinahDBContext _db;
        private List<Foto> fotos = new List<Foto>();

        public FotoController()
        {
            _db = new FinahDBContext();
        }

        //Constructor met als argument een List van Bevragingen, hierdoor kunnen we testdata aan
        //de Controller meegeven om zo unittesten voor de controller te schrijven.
        public FotoController(List<Foto> fotos)
        {
            _db = new FinahDBContext();
            this.fotos = fotos;
        }

        [Route("Aandoening/{id}")]
        public IHttpActionResult Get(int id)
        {
            var foto = new Foto { Id = 1, Omschrijving = "foto vraag 1", Pad = "pad" };

            //Bovenstaande code dient om te testen (op dit moment nutteloos)
            //Als database in orde is bovenstaande code wissen en onderstaande regel uncommenten
            //var bevraging = bevragingen.FirstOrDefault((b) => b.Id == id);
            if (foto == null)
            {
                return NotFound();
            }
            return Ok(foto);
        }

        [Route("Aandoening/Overzicht")] //Geen Api/ meer nodig
        public IEnumerable<Foto> GetOverzicht()// return -> naderhand veranderen in Bevraging
        {
            //return _db.Vragen.ToList();

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

        // POST: api/Foto
        public void Post([FromBody]string value)
        {
        }

        // PUT: api/Foto/5
        public void Put(int id, [FromBody]string value)
        {
        }

        // DELETE: api/Foto/5
        public void Delete(int id)
        {
        }
    }
}