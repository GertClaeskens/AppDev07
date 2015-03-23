using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Finah_Web.Controllers
{
    using System.Net.Http;
    using System.Net.Http.Headers;
    using System.Threading.Tasks;

    using Finah_Web.Models;

    public class VragenLijstController : Controller
    {
        // GET: VragenLijst
        [Route("VragenLijst/Overzicht")]
        public async Task<ActionResult> Overzicht()
        {
            using (var client = SharedFunctions.SetupClient())
            {
                string url = "VragenLijst/Overzicht";
                HttpResponseMessage response = await client.GetAsync(url);
                if (!response.IsSuccessStatusCode)
                {
                    return this.View();
                }
                List<VragenLijst> vragenLijsten = await response.Content.ReadAsAsync<List<VragenLijst>>();
                return this.View(vragenLijsten);
            }

        }

        // GET: VragenLijst/5
        [Route("VragenLijst/{id}")]
        public async Task<ActionResult> VragenLijst(string id)
        {
            using (var client = SharedFunctions.SetupClient())
            {
                string url = "VragenLijst/" + id;
                HttpResponseMessage response = await client.GetAsync(url);
                if (!response.IsSuccessStatusCode)
                {
                    return this.View();
                }
                VragenLijst vragenLijst = await response.Content.ReadAsAsync<VragenLijst>();
                return this.View(vragenLijst);
            }
        }

        // GET: VragenLijst/Details
        //public ActionResult Details(int id) --Voor als Db
        public ActionResult Details() //temp
        {
            return View();
        }

        // GET: VragenLijst/Create
        [Route("VragenLijst/Create")]
        public ActionResult Create() //Gets empty page for new aandoening
        {
            return View();
        }

        // POST: VragenLijst/Create
        //[HttpPost]
        [Route("VragenLijst/PCreate")] //Post new aandoening
        public async Task<ActionResult> Create(FormCollection collection)
        {
            try
            {
                using (var client = SharedFunctions.SetupClient())
                {
                    var vragenLijst = new VragenLijst();
                    var patho = new Pathologie();
                    var aandoening = new Aandoening();

                    patho.Id = 1;
                    patho.Omschrijving = "Omschrijving";

                    aandoening.Id = 1;
                    aandoening.Omschrijving = "Omschrijving";

                    vragenLijst.Id = 1;
                    vragenLijst.Patholo = patho;
                    vragenLijst.Aandoe = aandoening;

                    HttpResponseMessage response = await client.PostAsJsonAsync("VragenLijst/", vragenLijst);
                }

                return RedirectToAction("Overzicht");
            }
            catch
            {
                return RedirectToAction("Overzicht");
            }
        }

        // GET: VragenLijst/Edit/5
        //public ActionResult Edit(int id) //Laad bestaande aandoening om aan te passen  -- Voor als DB live is
        public ActionResult Edit() //Temp
        {
            //Via Id aandoening ophalen om naderhand te updaten/editen
            return View();
        }

        // POST: VragenLijst/Edit/5
        [HttpPost]
        public ActionResult Edit(int id, FormCollection collection)
        {
            try
            {
                // TODO: Add update logic here

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: VragenLijst/Delete/5
        //public ActionResult Delete(int id) -- Voor als DB live is
        public ActionResult Delete() //Temp
        {
            return View();
        }

        // POST: VragenLijst/Delete/5
        [HttpPost]
        public ActionResult Delete(int id, FormCollection collection)
        {
            try
            {
                // TODO: Add delete logic here

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }
    }
}
