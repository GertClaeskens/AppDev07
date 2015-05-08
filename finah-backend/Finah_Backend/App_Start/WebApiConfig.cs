using Microsoft.Owin.Security.OAuth;
using System.Web.Http;

namespace Finah_Backend
{
    using System.Web.Http.Cors;

    using Newtonsoft.Json;
    using System.Net.Http.Headers;

    public static class WebApiConfig
    {
        public static void Register(HttpConfiguration config)
        {
            //Om problemen met XMLHttpRequest in Javascript te voorkomen
            var cors = new EnableCorsAttribute("http://localhost:63342", "*", "GET,POST,DELETE,PUT");
            config.EnableCors(cors);

            // Web API configuration and servicesz
            // Configure Web API to use only bearer token authentication.
            config.SuppressDefaultHostAuthentication();

            //config.Filters.Add(new HostAuthenticationFilter(OAuthDefaults.AuthenticationType));

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

            config.Formatters.JsonFormatter.SerializerSettings = new JsonSerializerSettings
                                                                     {
                                                                         ReferenceLoopHandling =
                                                                             ReferenceLoopHandling
                                                                             .Ignore
                                                                     };
            //,
            //                                                             PreserveReferencesHandling
            //                                                                 =
            //                                                                 PreserveReferencesHandling
            //                                                                 .Objects
            //                                                         };
        }
    }
}