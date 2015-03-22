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

    public class LeeftijdsCategorieController : Controller
    {
        // GET: LeeftijdsCategorie
        [Route("LeeftijdsCategorie/Overzicht")]
        public async Task<ActionResult> Overzicht()
        {
            using (var client = SharedFunctions.SetupClient())
            {
                string url = "LeeftijdsCategorie/Overzicht";
                HttpResponseMessage response = await client.GetAsync(url);
                if (!response.IsSuccessStatusCode)
                {
                    return this.View();
                }
                List<LeeftijdsCategorie> leeftijdsCategorieenLijst = await response.Content.ReadAsAsync<List<LeeftijdsCategorie>>();
                return this.View(leeftijdsCategorieenLijst);
            }

        }

        // GET: LeeftijdsCategorie/5
        [Route("LeeftijdsCategorie/{id}")]
        public async Task<ActionResult> LeeftijdsCategorie(string id)
        {
            using (var client = SharedFunctions.SetupClient())
            {
                string url = "LeeftijdsCategorie/" + id;
                HttpResponseMessage response = await client.GetAsync(url);
                if (!response.IsSuccessStatusCode)
                {
                    return this.View();
                }
                LeeftijdsCategorie leeftijdsCategorie = await response.Content.ReadAsAsync<LeeftijdsCategorie>();
                return this.View(leeftijdsCategorie);
            }
        }

        // GET: LeeftijdsCategorie/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: LeeftijdsCategorie/Create
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

        // GET: LeeftijdsCategorie/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: LeeftijdsCategorie/Edit/5
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

        // GET: LeeftijdsCategorie/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: LeeftijdsCategorie/Delete/5
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
