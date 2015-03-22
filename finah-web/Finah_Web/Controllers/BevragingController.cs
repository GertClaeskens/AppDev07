using Finah_Web.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Threading.Tasks;
using System.Web;
using System.Web.Mvc;

namespace Finah_Web.Controllers
{
    public class BevragingController : Controller
    {
        // GET: Bevraging
        [Route("Bevraging/Overzicht")]
        public async Task<ActionResult> Overzicht()
        {
            using (var client = SharedFunctions.SetupClient())
            {
                string url = "Bevraging/Overzicht";
                HttpResponseMessage response = await client.GetAsync(url);
                if (!response.IsSuccessStatusCode)
                {
                    return this.View();
                }
                List<Bevraging> bevragingenLijst = await response.Content.ReadAsAsync<List<Bevraging>>();
                return this.View(bevragingenLijst);
            }

        }

        // GET: Bevraging/5
        [Route("Bevraging/{id}")]
        public async Task<ActionResult> Bevraging(string id)
        {
            using (var client = SharedFunctions.SetupClient())
            {
                string url = "Bevraging/" + id;
                HttpResponseMessage response = await client.GetAsync(url);
                if (!response.IsSuccessStatusCode)
                {
                    return this.View();
                }
                Bevraging bevraging = await response.Content.ReadAsAsync<Bevraging>();
                return this.View(bevraging);
            }
        }

        // GET: Bevraging/Create
        [Route("Bevraging/Create")]
        public async Task<ActionResult> Create()
        {
            using (var client = SharedFunctions.SetupClient())
            {
                string url = "Bevraging/Create";
                HttpResponseMessage response = await client.GetAsync(url);
                return RedirectToAction("Overzicht");
            }
        }

        // POST: Bevraging/Create
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

        // GET: Bevraging/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: Bevraging/Edit/5
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

        // GET: Bevraging/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: Bevraging/Delete/5
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
