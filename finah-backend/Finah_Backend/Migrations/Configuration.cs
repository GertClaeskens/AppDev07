namespace Finah_Backend.Migrations
{
    using System;
    using System.Collections.Generic;
    using System.Data.Entity;
    using System.Data.Entity.Migrations;
    using System.Linq;

    using Finah_Backend.DAL;
    using Finah_Backend.Models;

    public sealed class Configuration : DbMigrationsConfiguration<FinahDBContext>
    {
        public Configuration()
        {
            AutomaticMigrationsEnabled = true;
        }

        protected override void Seed(FinahDBContext context)
        {
            var leeftijdsCategorie = new List<LeeftijdsCategorie>
            {
                new LeeftijdsCategorie{Van=18,Tot=25},
                new LeeftijdsCategorie{Van=26,Tot=35}
            };

            leeftijdsCategorie.ForEach(s => context.LeeftijdsCategorieen.AddOrUpdate(s));
            context.SaveChanges();
        }
    }
}
