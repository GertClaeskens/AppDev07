using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Finah_Backend.DAL
{
    using System.Data.Entity;
    using System.Data.Entity.ModelConfiguration.Conventions;

    using Finah_Backend.Controllers;
    using Finah_Backend.Models;

    public class FinahDBContext : DbContext
    {
        public FinahDBContext()
            : base("FinahDBContext")
        {
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
        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Conventions.Remove<PluralizingTableNameConvention>();
        }
    }
}