﻿using System.Collections.Generic;
using System.Linq;
using System.Web.Http;

namespace Finah_Backend.Controllers
{
    using Finah_Backend.DAL;
    using Finah_Backend.Models;

    public class PostcodeController : ApiController
    {
        ///
        /// Wordt gebruikt om de database te testen.
        ///

        private List<Postcode> bevragingen = new List<Postcode>();

        private readonly FinahDBContext _db = new FinahDBContext();

        //Geen Api/ meer nodig
        [Route("Postcode/{id}")]
        // return -> naderhand veranderen in Bevraging

        //
        // Andere methode om Get te doen met return type IHttpActionResult
        //
        public IHttpActionResult Get(int id)
        {
            var postcode = _db.Postcodes.FirstOrDefault(b => b.Id == id);
            
            if (postcode == null)
            {
                return NotFound();
            }
            return Ok(postcode);
        }

        [Route("Postcode/Overzicht")] //Geen Api/ meer nodig
        public IEnumerable<Postcode> GetOverzicht()// return -> naderhand veranderen in Bevraging
        {
            return _db.Postcodes.ToList(); //Kijken dat de gegevens van bvb leeftijdscategorie der ook in zitten

        }

        // POST: api/Postcode
        public void Post([FromBody]string value)
        {
        }

        // PUT: api/Postcode/5
        public void Put(int id, [FromBody]string value)
        {
        }

        // DELETE: api/Postcode/5
        public void Delete(int id)
        {
        }
    }
}