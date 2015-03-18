using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Finah_Backend.DAL;

namespace FinahConsole
{
   
    using System.Data.Entity;

    using Finah_Backend.Migrations;

    class Program
    {
        static void Main(string[] args)
        {
            Database.SetInitializer(new MigrateDatabaseToLatestVersion<FinahDBContext, Configuration>());
        }

        private static void GetLeeftijd()
        {
            using (var context = new FinahDBContext())
            {
                var leeftijd = context.LeeftijdsCategorieen.ToList();
                foreach (var l in leeftijd)
                {
                    Console.WriteLine(l.Van + " - " + l.Tot);
                }
                Console.ReadLine();
            }
        }
    }
}
