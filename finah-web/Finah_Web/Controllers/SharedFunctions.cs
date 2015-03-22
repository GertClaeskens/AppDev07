using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Finah_Web.Controllers
{
    using System.Net.Http;
    using System.Net.Http.Headers;
    using System.Threading.Tasks;

    public class SharedFunctions
    {
        public static HttpClient SetupClient()
        {
            var client = new HttpClient();

            client.BaseAddress = new Uri("http://finahbackend1920.azurewebsites.net/");
            //client.BaseAddress = new Uri("http://localhost:1695/");
            client.DefaultRequestHeaders.Accept.Clear();
            client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
            return client;
            //new code
            //const string url = "Aandoening/Overzicht";
            //return await client.GetAsync(url);

            //return response;

        }
    }
}