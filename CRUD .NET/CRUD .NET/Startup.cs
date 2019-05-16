using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(CRUD.NET.Startup))]
namespace CRUD.NET
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
