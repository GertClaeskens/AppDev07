using System.Data.Entity;
using System.Security.Claims;
using System.Threading.Tasks;
using Microsoft.AspNet.Identity;
using Microsoft.AspNet.Identity.EntityFramework;

namespace Finah_Web.Models
{
    // You can add profile data for the user by adding more properties to your ApplicationUser class, please visit http://go.microsoft.com/fwlink/?LinkID=317594 to learn more.
    public class ApplicationUser : IdentityUser
    {
        public async Task<ClaimsIdentity> GenerateUserIdentityAsync(UserManager<ApplicationUser> manager)
        {
            // Note the authenticationType must match the one defined in CookieAuthenticationOptions.AuthenticationType
            var userIdentity = await manager.CreateIdentityAsync(this, DefaultAuthenticationTypes.ApplicationCookie);
            // Add custom user claims here
            return userIdentity;
        }
    }

    public class ApplicationDbContext : IdentityDbContext<ApplicationUser>
    {
        public ApplicationDbContext()
            : base("DefaultConnection", throwIfV1Schema: false)
        {
        }

        public static ApplicationDbContext Create()
        {
            return new ApplicationDbContext();
        }

        public DbSet<Aandoening> Aandoeningen { get; set; }
        public DbSet<Aanvraag> Aanvragen { get; set; }
        public DbSet<Account> Accounts { get; set; }
        public DbSet<Bevraging> Bevragingen { get; set; }
        public DbSet<EID> EIDs { get; set; }
        public DbSet<Foto> Fotos { get; set; }
        public DbSet<GeluidsFragment> Geluidsfragmenten { get; set; }
        public DbSet<LeeftijdsCategorie> LeeftijdsCategorieen { get; set; }
        public DbSet<Pathologie> Pathologieen { get; set; }
        public DbSet<Postcode> Postcodes { get; set; }
        public DbSet<Status> Statussen { get; set; }
        public DbSet<Vraag> Vragen { get; set; }
        public DbSet<VragenLijst> VragenLijsten { get; set; }
    }
}