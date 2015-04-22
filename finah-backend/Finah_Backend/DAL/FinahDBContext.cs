﻿namespace Finah_Backend.DAL
{
    using Finah_Backend.Models;
    using System.Data.Entity;
    using System.Data.Entity.ModelConfiguration.Conventions;

    public class FinahDBContext : DbContext
    {
        //public FinahDBContext()
        //    : base("FinahDBContext")
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
        }
    }
}