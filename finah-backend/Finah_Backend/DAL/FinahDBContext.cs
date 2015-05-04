namespace Finah_Backend.DAL
{
    using System.ComponentModel.DataAnnotations.Schema;

    using Finah_Backend.Models;
    using System.Data.Entity;
    using System.Data.Entity.ModelConfiguration.Conventions;

    using Microsoft.AspNet.Identity.EntityFramework;

    public class FinahDBContext : IdentityDbContext
    {
        //public FinahDBContext()
        //    : base("FinahDBContext")
        //{
        //}

        public FinahDBContext()
            : base("Finah_Backend.DAL.FinahDBContext.")
        {
        }

        //public FinahDBContext()
        //    : base("DefaultConnection")
        //{
        //}

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

        public DbSet<Antwoord> Antwoorden { get; set; }

        public DbSet<AntwoordenLijst> AntwoordenLijsten { get; set; }

        public DbSet<Relatie> Relaties { get; set; }
        public DbSet<Onderzoek> Onderzoeken { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            base.OnModelCreating(modelBuilder);
            modelBuilder.Conventions.Remove<PluralizingTableNameConvention>();

            modelBuilder.Entity<AntwoordenLijst>().HasKey(e => new { e.Id, e.Datum });
            //modelBuilder.Entity<AntwoordenLijst>().HasRequired(e => e.Id).WithRequiredPrincipal();
            modelBuilder.Entity<AntwoordenLijst>()
                        .Property(e => e.Id)
                        .HasDatabaseGeneratedOption(DatabaseGeneratedOption.None);
            //modelBuilder.Entity<AntwoordenLijst>()
            //            .HasRequired(e => e.Bevraging)
            //            .WithRequiredDependent(r => r.Antwoorden);
            //modelBuilder.Entity<Bevraging>()
            //.HasRequired(e => e.Antwoorden)
            //.WithRequiredDependent(r => r.Bevraging);

        }
    }
}