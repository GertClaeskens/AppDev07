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

    public class VraagController : Controller
    {
        // GET: Vraag
        [Route("Vraag/Overzicht")]
        public async Task<ActionResult> Overzicht()
        {
            using (var client = new HttpClient())
            {
                //client.BaseAddress = new Uri("http://finahbackend1920.azurewebsites.net/");
                client.BaseAddress = new Uri("http://localhost:1695/");
                client.DefaultRequestHeaders.Accept.Clear();
                client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));

                //new code
                string url = "Vraag/Overzicht";
                HttpResponseMessage response = await client.GetAsync(url);
                if (!response.IsSuccessStatusCode)
                {
                    return this.View();
                }
                List<Vraag> vragenLijst = await response.Content.ReadAsAsync<List<Vraag>>();
                return this.View(vragenLijst);
            }

        }

        // GET: Vraag/5
        [Route("Vraag/{id}")]
        public async Task<ActionResult> Vraag(string id)
        {
            using (var client = new HttpClient())
            {
                //client.BaseAddress = new Uri("http://finahbackend1920.azurewebsites.net/");
                client.BaseAddress = new Uri("http://localhost:1695/");
                client.DefaultRequestHeaders.Accept.Clear();
                client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));

                //new code
                string url = "Vraag/" + id;
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
