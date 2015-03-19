using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Finah_Web.Controllers
{
    public class PathologieController : Controller
    {
        // GET: Pathologie
        public ActionResult Index()
        {
            return View();
        }

        // GET: Pathologie/Details/5
        public ActionResult Details(int id)
        {
            return View();
        }

        // GET: Pathologie/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: Pathologie/Create
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

        // GET: Pathologie/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: Pathologie/Edit/5
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

        // GET: Pathologie/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: Pathologie/Delete/5
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
