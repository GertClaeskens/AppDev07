using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using Finah_Web.Models;

namespace Finah_Web.Controllers
{
    public class PostcodesController : Controller
    {
        private ApplicationDbContext db = new ApplicationDbContext();

        // GET: Postcodes
        public ActionResult Index()
        {
            return View(db.Postcodes.ToList());
        }

        // GET: Postcodes/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Postcode postcode = db.Postcodes.Find(id);
            if (postcode == null)
            {
                return HttpNotFound();
            }
            return View(postcode);
        }

        // GET: Postcodes/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: Postcodes/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "Id,Postnr,Gemeente")] Postcode postcode)
        {
            if (!this.ModelState.IsValid)
            {
                return this.View(postcode);
            }
            this.db.Postcodes.Add(postcode);
            this.db.SaveChanges();
            return this.RedirectToAction("Index");
        }

        // GET: Postcodes/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Postcode postcode = db.Postcodes.Find(id);
            if (postcode == null)
            {
                return HttpNotFound();
            }
            return View(postcode);
        }

        // POST: Postcodes/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "Id,Postnr,Gemeente")] Postcode postcode)
        {
            if (!this.ModelState.IsValid)
            {
                return this.View(postcode);
            }
            this.db.Entry(postcode).State = EntityState.Modified;
            this.db.SaveChanges();
            return this.RedirectToAction("Index");
        }

        // GET: Postcodes/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Postcode postcode = db.Postcodes.Find(id);
            if (postcode == null)
            {
                return HttpNotFound();
            }
            return View(postcode);
        }

        // POST: Postcodes/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            Postcode postcode = db.Postcodes.Find(id);
            db.Postcodes.Remove(postcode);
            db.SaveChanges();
            return RedirectToAction("Index");
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }
    }
}
