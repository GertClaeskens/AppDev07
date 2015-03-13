using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(Finah_Web.Startup))]
namespace Finah_Web
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
