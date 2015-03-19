﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace Finah_Backend.Controllers
{
    using Finah_Backend.Models;

    public class VragenController : ApiController
    {
        // GET: api/Vragen
        public IEnumerable<string> Get()
        {
            return new string[] { "value1", "value2" };
        }

        // GET: api/Vragen/5
        //public string Get(int id)
        //{
        //    return "value";
        //}

        [Route("Vragen/{id}")]
        public IHttpActionResult GetVraag(int id)
        {
            Vraag vraag = new Vraag();
            Foto foto = new Foto();
            GeluidsFragment gf = new GeluidsFragment();

            foto.Id = 1;
            foto.Omschrijving = "foto vraag 1";
            foto.Pad = "pad";

            gf.Id = 1;
            gf.Omschrijving = "geluid vraag 1";
            gf.Pad="geluidpad";

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

            List<Vraag> overzichtVragen = new List<Vraag>();
            overzichtVragen.Add(testVraag1);
            overzichtVragen.Add(testVraag2);
            overzichtVragen.Add(testVraag3);
            overzichtVragen.Add(testVraag4);
            overzichtVragen.Add(testVraag5);

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
