using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Finah_Web.Controllers
{
    public class AandoeningController : Controller
    {
        // GET: Aandoening
        public ActionResult Index()
        {
            return View();
        }

        // GET: Aandoening/Details/5
        public ActionResult Details(int id)
        {
            return View();
        }

        // GET: Aandoening/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: Aandoening/Create
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

        // GET: Aandoening/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: Aandoening/Edit/5
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

        // GET: Aandoening/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: Aandoening/Delete/5
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
