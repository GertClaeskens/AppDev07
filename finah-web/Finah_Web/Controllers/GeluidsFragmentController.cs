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

    public class GeluidsFragmentController : Controller
    {
        // GET: GeluidsFragment
        [Route("GeluidsFragment/Overzicht")]
        public async Task<ActionResult> Overzicht()
        {
            using (var client = SharedFunctions.SetupClient())
            {
                string url = "GeluidsFragment/Overzicht";
                HttpResponseMessage response = await client.GetAsync(url);
                if (!response.IsSuccessStatusCode)
                {
                    return this.View();
                }
                List<GeluidsFragment> geluidsFragmentLijst = await response.Content.ReadAsAsync<List<GeluidsFragment>>();
                return this.View(geluidsFragmentLijst);
            }

        }

        // GET: GeluidsFragment/5
        [Route("GeluidsFragment/{id}")]
        public async Task<ActionResult> GeluidsFragment(string id)
        {
            using (var client = SharedFunctions.SetupClient())
            {
                string url = "GeluidsFragment/" + id;
                HttpResponseMessage response = await client.GetAsync(url);
                if (!response.IsSuccessStatusCode)
                {
                    return this.View();
                }
                GeluidsFragment geluidsFragment = await response.Content.ReadAsAsync<GeluidsFragment>();
                return this.View(geluidsFragment);
            }
        }

        // GET: GeluidsFragment/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: GeluidsFragment/Create
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

        // GET: GeluidsFragment/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: GeluidsFragment/Edit/5
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

        // GET: GeluidsFragment/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: GeluidsFragment/Delete/5
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
