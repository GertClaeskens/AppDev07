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
            using (var client = new HttpClient())
            {
                //client.BaseAddress = new Uri("http://finahbackend1920.azurewebsites.net/");
                client.BaseAddress = new Uri("http://localhost:1695/");
                client.DefaultRequestHeaders.Accept.Clear();
                client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));

                //new code
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
            using (var client = new HttpClient())
            {
                //client.BaseAddress = new Uri("http://finahbackend1920.azurewebsites.net/");
                client.BaseAddress = new Uri("http://localhost:1695/");
                client.DefaultRequestHeaders.Accept.Clear();
                client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));

                //new code
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

        // GET: VragenLijst/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: VragenLijst/Create
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

        // GET: VragenLijst/Edit/5
        public ActionResult Edit(int id)
        {
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
        public ActionResult Delete(int id)
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
