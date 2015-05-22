using Microsoft.AspNet.Identity;
using Microsoft.AspNet.Identity.EntityFramework;
using System.Security.Claims;
using System.Threading.Tasks;

namespace Finah_Backend.Models
{
    using System;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity;
    using System.Data.Entity.ModelConfiguration.Conventions;

    // You can add profile data for the user by adding more properties to your ApplicationUser class, please visit http://go.microsoft.com/fwlink/?LinkID=317594 to learn more.
    public class ApplicationUser : IdentityUser
    {
        public string Naam { get; set; }

        public string VoorNaam { get; set; }

        public string Adres { get; set; }

        public string Telnr { get; set; }

        public string Login { get; set; }

        public string Passwd { get; set; }

        public string TypeAcc { get; set; }

        [ForeignKey("Postcd")]
        public int PostcdId { get; set; }
        public virtual Postcode Postcd { get; set; }

        public async Task<ClaimsIdentity> GenerateUserIdentityAsync(UserManager<ApplicationUser> manager, string authenticationType)
        {
            // Note the authenticationType must match the one defined in CookieAuthenticationOptions.AuthenticationType
            var userIdentity = await manager.CreateIdentityAsync(this, authenticationType);
            // Add custom user claims here
            return userIdentity;
        }
    }

    public class ApplicationDbContext : IdentityDbContext<ApplicationUser>
    {
        public ApplicationDbContext()
            : base("Finah_Backend", throwIfV1Schema: false)
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

        public DbSet<LeeftijdsCategorie> LeeftijdsCategorieen { get; set; }

        public DbSet<Pathologie> Pathologieen { get; set; }

        public DbSet<Postcode> Postcodes { get; set; }

        public DbSet<Vraag> Vragen { get; set; }

        public DbSet<VragenLijst> VragenLijsten { get; set; }

        

        //public DbSet<AntwoordenLijst> AntwoordenLijsten { get; set; }

        public DbSet<Relatie> Relaties { get; set; }
        public DbSet<Onderzoek> Onderzoeken { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            base.OnModelCreating(modelBuilder);
            modelBuilder.Conventions.Remove<PluralizingTableNameConvention>();

            //modelBuilder.Entity<AntwoordenLijst>().HasKey(e => new { e.Id, e.Datum });
            ////modelBuilder.Entity<AntwoordenLijst>().HasRequired(e => e.Id).WithRequiredPrincipal();
            //modelBuilder.Entity<AntwoordenLijst>()
            //            .Property(e => e.Id)
            //            .HasDatabaseGeneratedOption(DatabaseGeneratedOption.None);
            //modelBuilder.Entity<AntwoordenLijst>()
            //            .HasRequired(e => e.Bevraging)
            //            .WithRequiredDependent(r => r.Antwoorden);
            //modelBuilder.Entity<Bevraging>()
            //.HasRequired(e => e.Antwoorden)
            //.WithRequiredDependent(r => r.Bevraging);

        }

        public DbSet<Thema> Themas { get; set; }
    }
}