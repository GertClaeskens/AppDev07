using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Finah_Web.Controllers
{
    using System.Net.Http;
    using System.Threading.Tasks;

    using Finah_Web.Models;

    public class AntwoordController : Controller
    {
        // GET: Antwoord
        public async Task<ActionResult> Overzicht()
        {
            using (var client = SharedFunctions.SetupClient())
            {
                const string URL = "Antwoord/Overzicht";
                var response = await client.GetAsync(URL);
                if (!response.IsSuccessStatusCode)
                {
                    return this.View();
                }
                var antwoordenLijst = await response.Content.ReadAsAsync<List<Antwoord>>();
                return this.View(antwoordenLijst);
            }
        }

        // GET: Antwoord/Details/5
        [Route("Antwoord/{id}")]
        public async Task<ActionResult> Antwoord(int id)
        {
            using (var client = SharedFunctions.SetupClient())
            {
                var url = "Antwoord/" + id;
                var response = await client.GetAsync(url);
                if (!response.IsSuccessStatusCode)
                {
                    return this.View();
                }
                var antwoord = await response.Content.ReadAsAsync<Antwoord>();
                return this.View(antwoord);
            }
        }

        // GET: Antwoord/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: Antwoord/Create
        [HttpPost]
        public async Task<ActionResult> Create(FormCollection collection)
        {
            try
            {
                using (var client = SharedFunctions.SetupClient())
                {
                    var antwoord = new Antwoord { Id = 1, Antword = 4 };

                    var response = await client.PostAsJsonAsync("Antwoord/", antwoord);
                }

                return RedirectToAction("Overzicht");
            }
            catch
            {
                return RedirectToAction("Overzicht");
            }
        }

        // GET: Antwoord/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: Antwoord/Edit/5
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

        // GET: Antwoord/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: Antwoord/Delete/5
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
