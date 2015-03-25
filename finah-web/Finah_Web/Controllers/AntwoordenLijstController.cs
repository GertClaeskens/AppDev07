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

    public class AntwoordenLijstController : Controller
    {
        // GET: AntwoordenLijst
        public async Task<ActionResult> Index()
        {
            using (var client = SharedFunctions.SetupClient())
            {
                const string URL = "AntwoordenLijst/Overzicht";
                var response = await client.GetAsync(URL);
                if (!response.IsSuccessStatusCode)
                {
                    return this.View();
                }
                var antwoordenLijst = await response.Content.ReadAsAsync<List<AntwoordenLijst>>();
                return this.View(antwoordenLijst);
            }
        }

        // GET: AntwoordenLijst/Details/5
        [Route("AntwoordenLijst/{id}")]
        public async Task<ActionResult> Details(int id)
        {
            using (var client = SharedFunctions.SetupClient())
            {
                var url = "AntwoordenLijst/" + id;
                var response = await client.GetAsync(url);
                if (!response.IsSuccessStatusCode)
                {
                    return this.View();
                }
                var antwoordenLijst = await response.Content.ReadAsAsync<AntwoordenLijst>();
                return this.View(antwoordenLijst);
            }
        }

        // GET: AntwoordenLijst/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: AntwoordenLijst/Create
        [HttpPost]
        public async Task<ActionResult> Create(FormCollection collection)
        {
            try
            {
                using (var client = SharedFunctions.SetupClient())
                {
                    var antwoordenLijst = new AntwoordenLijst
                                              {
                                                  Id = "1",
                                                  Antwoorden =
                                                      new List<Antwoord>
                                                          {
                                                              new Antwoord
                                                                  {
                                                                      Id = 1,
                                                                      Antword = 4
                                                                  }
                                                          }
                                              };

                    var response = await client.PostAsJsonAsync("AntwoordenLijst/", antwoordenLijst);
                }

                return RedirectToAction("Overzicht");
            }
            catch
            {
                return RedirectToAction("Overzicht");
            }
        }

        // GET: AntwoordenLijst/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: AntwoordenLijst/Edit/5
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

        // GET: AntwoordenLijst/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: AntwoordenLijst/Delete/5
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
