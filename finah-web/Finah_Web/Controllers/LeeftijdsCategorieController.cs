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

        // GET: LeeftijdsCategorie/Details
        //public ActionResult Details(int id) --Voor als Db
        public ActionResult Details() //temp
        {
            return View();
        }

        // GET: LeeftijdsCategorie/Create
        [Route("LeeftijdsCategorie/Create")]
        public ActionResult Create() //Gets empty page for new aandoening
        {
            return View();
        }

        // POST: LeeftijdsCategorie/Create
        //[HttpPost]
        [Route("LeeftijdsCategorie/PCreate")] //Post new aandoening
        public async Task<ActionResult> Create(FormCollection collection)
        {
            try
            {
                using (var client = SharedFunctions.SetupClient())
                {
                    var leefCat = new LeeftijdsCategorie();

                    leefCat.Id = 1;
                    leefCat.Van = 0;
                    leefCat.Tot = 99;

                    HttpResponseMessage response = await client.PostAsJsonAsync("LeeftijdsCategorie/", leefCat);
                }

                return RedirectToAction("Overzicht");
            }
            catch
            {
                return RedirectToAction("Overzicht");
            }
        }

        // GET: LeeftijdsCategorie/Edit/5
        //public ActionResult Edit(int id) //Laad bestaande aandoening om aan te passen  -- Voor als DB live is
        public ActionResult Edit() //Temp
        {
            //Via Id aandoening ophalen om naderhand te updaten/editen
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
        //public ActionResult Delete(int id) -- Voor als DB live is
        public ActionResult Delete() //Temp
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
