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

    public class FotoController : Controller
    {
        // GET: Bevraging
        [Route("Foto/Overzicht")]
        public async Task<ActionResult> Overzicht()
        {
            using (var client = SharedFunctions.SetupClient())
            {
                string url = "Foto/Overzicht";
                HttpResponseMessage response = await client.GetAsync(url);
                if (!response.IsSuccessStatusCode)
                {
                    return this.View();
                }
                List<Foto> fotoLijst = await response.Content.ReadAsAsync<List<Foto>>();
                return this.View(fotoLijst);
            }

        }

        // GET: Foto/5
        [Route("Foto/{id}")]
        public async Task<ActionResult> Foto(string id)
        {
            using (var client = SharedFunctions.SetupClient())
            {
                string url = "Foto/" + id;
                HttpResponseMessage response = await client.GetAsync(url);
                if (!response.IsSuccessStatusCode)
                {
                    return this.View();
                }
                Foto foto = await response.Content.ReadAsAsync<Foto>();
                return this.View(foto);
            }
        }

        // GET: Foto/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: Foto/Create
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

        // GET: Foto/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: Foto/Edit/5
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

        // GET: Foto/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: Foto/Delete/5
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
