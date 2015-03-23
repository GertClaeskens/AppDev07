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

    public class PathologieController : Controller
    {
        // GET: Pathologie
        [Route("Pathologie/Overzicht")]
        public async Task<ActionResult> Overzicht()
        {
            using (var client = SharedFunctions.SetupClient())
            {
                string url = "Pathologie/Overzicht";
                HttpResponseMessage response = await client.GetAsync(url);
                if (!response.IsSuccessStatusCode)
                {
                    return this.View();
                }
                List<Pathologie> pathologieenLijst = await response.Content.ReadAsAsync<List<Pathologie>>();
                return this.View(pathologieenLijst);
            }

        }

        // GET: Pathologie/5
        [Route("Pathologie/{id}")]
        public async Task<ActionResult> Pathologie(string id)
        {
            using (var client = SharedFunctions.SetupClient())
            {
                string url = "Pathologie/" + id;
                HttpResponseMessage response = await client.GetAsync(url);
                if (!response.IsSuccessStatusCode)
                {
                    return this.View();
                }
                Pathologie pathologie = await response.Content.ReadAsAsync<Pathologie>();
                return this.View(pathologie);
            }
        }

        // GET: Pathologie/Details
        //public ActionResult Details(int id) --Voor als Db
        public ActionResult Details() //temp
        {
            return View();
        }

        // GET: Pathologie/Create
        [Route("Pathologie/Create")]
        public ActionResult Create() //Gets empty page for new aandoening
        {
            return View();
        }

        // POST: Pathologie/Create
        //[HttpPost]
        [Route("Pathologie/PCreate")] //Post new aandoening
        public async Task<ActionResult> Create(FormCollection collection)
        {
            try
            {
                using (var client = SharedFunctions.SetupClient())
                {
                    var pt = new Pathologie();

                    pt.Id = 1;
                    pt.Omschrijving = "Pathologie";

                    HttpResponseMessage response = await client.PostAsJsonAsync("Pathologie/", pt);
                }

                return RedirectToAction("Overzicht");
            }
            catch
            {
                return RedirectToAction("Overzicht");
            }
        }

        // GET: Pathologie/Edit/5
        //public ActionResult Edit(int id) //Laad bestaande aandoening om aan te passen  -- Voor als DB live is
        public ActionResult Edit() //Temp
        {
            //Via Id aandoening ophalen om naderhand te updaten/editen
            return View();
        }

        // POST: Pathologie/Edit/5
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

        // GET: Pathologie/Delete/5
        //public ActionResult Delete(int id) -- Voor als DB live is
        public ActionResult Delete() //Temp
        {
            return View();
        }

        // POST: Pathologie/Delete/5
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
