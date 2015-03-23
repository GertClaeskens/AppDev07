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

    public class VragenController : Controller
    {
        // GET: Vragen
        
        [Route("Vragen/Overzicht")]
        public async Task<ActionResult> Overzicht()
        {
            using (var client = SharedFunctions.SetupClient())
            {
                string url = "Vragen/Overzicht";
                HttpResponseMessage response = await client.GetAsync(url);
                if (!response.IsSuccessStatusCode)
                {
                    return this.View();
                }
                List<Vraag> vragenlijst = await response.Content.ReadAsAsync<List<Vraag>>();
                return this.View(vragenlijst);
            }

        }

        // GET: Vragen/5
        [Route("Vragen/{id}")]
        public async Task<ActionResult> Vragen(string id)
        {
            using (var client = SharedFunctions.SetupClient())
            {
                string url = "Vragen/" + id;
                HttpResponseMessage response = await client.GetAsync(url);
                if (!response.IsSuccessStatusCode)
                {
                    return this.View();
                }
                Vraag vraag = await response.Content.ReadAsAsync<Vraag>();
                return this.View(vraag);
            }
        }

        // GET: Vraag/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: Vraag/Create
        [HttpPost]
        public async Task<ActionResult> Create(FormCollection collection)
        {
            try
            {
                using (var client = SharedFunctions.SetupClient())
                {
                    var vraag = new Vraag { Id = 1, VraagStelling = "Test vraag1" };

                    HttpResponseMessage response = await client.PostAsJsonAsync("Vragen/", vraag);
                }

                return RedirectToAction("Overzicht");
            }
            catch
            {
                return RedirectToAction("Overzicht");
            }
        }

        // GET: Vraag/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: Vraag/Edit/5
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

        // GET: Vraag/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: Vraag/Delete/5
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
