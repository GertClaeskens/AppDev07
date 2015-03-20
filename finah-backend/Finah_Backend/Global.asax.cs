using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Http;
using System.Web.Mvc;
using System.Web.Optimization;
using System.Web.Routing;

namespace Finah_Backend
{
    using System.Data.Entity;
    using System.Data.Entity.ModelConfiguration.Conventions;

    using Finah_Backend.DAL;
    using Finah_Backend.Migrations;
    using Finah_Backend.Models;

    public class WebApiApplication : System.Web.HttpApplication
    {
        protected void Application_Start()
        {
            AreaRegistration.RegisterAllAreas();
            GlobalConfiguration.Configure(WebApiConfig.Register);
            FilterConfig.RegisterGlobalFilters(GlobalFilters.Filters);
            RouteConfig.RegisterRoutes(RouteTable.Routes);
            BundleConfig.RegisterBundles(BundleTable.Bundles);

            //Toevoegen voor automatische update van database
            //Database.SetInitializer(new MigrateDatabaseToLatestVersion<FinahDBContext, Configuration>());

            
            //Database.SetInitializer(new DropCreateDatabaseAlways<FinahDBContext>());

            Database.SetInitializer(new CreateDatabaseIfNotExists<FinahDBContext>());

            
        }


    }
}
