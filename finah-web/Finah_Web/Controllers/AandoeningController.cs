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

    public class AandoeningController : Controller
    {
        [Route("Aandoening/Overzicht")]
        public async Task<ActionResult> Overzicht()
        {
            using (var client = SharedFunctions.SetupClient())
            {
                const string URL = "Aandoening/Overzicht";
                HttpResponseMessage response = await client.GetAsync(URL);
                if (!response.IsSuccessStatusCode)
                {
                    return this.View();
                }
                List<Aandoening> aandoeningenLijst = await response.Content.ReadAsAsync<List<Aandoening>>();
                return this.View(aandoeningenLijst);
            }
        }

        // GET: Aandoening/5
        [Route("Aandoening/{id}")]
        public async Task<ActionResult> Aandoening(string id)
        {
            using (var client = SharedFunctions.SetupClient())
            {
                string url = "Aandoening/" + id;
                HttpResponseMessage response = await client.GetAsync(url);
                if (!response.IsSuccessStatusCode)
                {
                    return this.View();
                }
                Aandoening aandoening = await response.Content.ReadAsAsync<Aandoening>();
                return this.View(aandoening);
            }
        }

        // GET: Aandoening/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: Aandoening/Create
        [HttpPost]
        public ActionResult Create(FormCollection collection)
        {
            try
            {
                // TODO: Add insert logic here

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Aandoening/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: Aandoening/Edit/5
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

        // GET: Aandoening/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: Aandoening/Delete/5
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
