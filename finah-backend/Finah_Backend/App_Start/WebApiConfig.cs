using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Web.Http;
using Microsoft.Owin.Security.OAuth;
using Newtonsoft.Json.Serialization;

namespace Finah_Backend
{
    using System.Net.Http.Headers;

    using Microsoft.Ajax.Utilities;

    using Newtonsoft.Json;

    public static class WebApiConfig
    {
        public static void Register(HttpConfiguration config)
        {
            // Web API configuration and servicesz
            // Configure Web API to use only bearer token authentication.
            config.SuppressDefaultHostAuthentication();
            config.Filters.Add(new HostAuthenticationFilter(OAuthDefaults.AuthenticationType));

            // Web API routes
            config.MapHttpAttributeRoutes();

            //config.Routes.MapHttpRoute(
            //    name: "DefaultApi",
            //    routeTemplate: "api/{controller}/{id}",
            //    defaults: new { id = RouteParameter.Optional }
            //);


            //Routes zonder Api
            config.Routes.MapHttpRoute(
                name: "DefaultApi",
                routeTemplate: "{controller}/{id}",
                defaults: new { id = RouteParameter.Optional });

            //Json output
            config.Formatters.JsonFormatter.SupportedMediaTypes.Add(new MediaTypeHeaderValue("text/html"));
            //config.Formatters.JsonFormatter.SerializerSettings = new JsonSerializerSettings
            //                                                         {
            //                                                             ReferenceLoopHandling =
            //                                                                 ReferenceLoopHandling
            //                                                                 .Ignore,
            //                                                             PreserveReferencesHandling
            //                                                                 =
            //                                                                 PreserveReferencesHandling
            //                                                                 .Objects
            //                                                         };
        }
    }
}
