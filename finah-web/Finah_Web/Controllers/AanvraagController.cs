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

    public class AanvraagController : Controller
    {
        // GET: Aanvraag
        [Route("Aanvraag/Overzicht")]
        public async Task<ActionResult> Overzicht()
        {
            using (var client = new HttpClient())
            {
                //client.BaseAddress = new Uri("http://finahbackend1920.azurewebsites.net/");
                client.BaseAddress = new Uri("http://localhost:1695/");
                client.DefaultRequestHeaders.Accept.Clear();
                client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));

                //new code
                string url = "Aanvraag/Overzicht";
                HttpResponseMessage response = await client.GetAsync(url);
                if (!response.IsSuccessStatusCode)
                {
                    return this.View();
                }
                List<Aanvraag> aanvragenLijst = await response.Content.ReadAsAsync<List<Aanvraag>>();
                return this.View(aanvragenLijst);
            }

        }

        // GET: Aanvraag/5
        [Route("Aanvraag/{id}")]
        public async Task<ActionResult> Aanvraag(string id)
        {
            using (var client = new HttpClient())
            {
                //client.BaseAddress = new Uri("http://finahbackend1920.azurewebsites.net/");
                client.BaseAddress = new Uri("http://localhost:1695/");
                client.DefaultRequestHeaders.Accept.Clear();
                client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));

                //new code
                string url = "Aanvraag/" + id;
                HttpResponseMessage response = await client.GetAsync(url);
                if (!response.IsSuccessStatusCode)
                {
                    return this.View();
                }
                Aanvraag aanvraag = await response.Content.ReadAsAsync<Aanvraag>();
                return this.View(aanvraag);
            }
        }

        // GET: Aanvraag/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: Aanvraag/Create
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

        // GET: Aanvraag/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: Aanvraag/Edit/5
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

        // GET: Aanvraag/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: Aanvraag/Delete/5
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
