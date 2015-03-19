using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Finah_Web.Controllers
{
    public class LeeftijdsCategorieController : Controller
    {
        // GET: LeeftijdsCategorie
        public ActionResult Index()
        {
            return View();
        }

        // GET: LeeftijdsCategorie/Details/5
        public ActionResult Details(int id)
        {
            return View();
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
