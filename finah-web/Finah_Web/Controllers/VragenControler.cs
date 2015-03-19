using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Finah_Web.Controllers
{
    public class VragenControler : Controller
    {
        // GET: Vraag
        public ActionResult Index()
        {
            return View();
        }

        // GET: Vraag/Details/5
        public ActionResult Details(int id)
        {
            return View();
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
