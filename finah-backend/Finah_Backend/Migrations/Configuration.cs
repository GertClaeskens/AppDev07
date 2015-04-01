namespace Finah_Backend.Migrations
{
    using System.Runtime.InteropServices;

    using Finah_Backend.DAL;
    using Finah_Backend.Models;
    using System;
    using System.Collections.Generic;
    using System.Data.Entity.Migrations;
    using Excel = Microsoft.Office.Interop.Excel;

    public sealed class Configuration : DbMigrationsConfiguration<FinahDBContext>
    {
        public Configuration()
        {
            this.AutomaticMigrationsEnabled = true;
            this.AutomaticMigrationDataLossAllowed = true;
        }

        protected override void Seed(FinahDBContext context)
        {
            //Relaties toevoegen
            var relaties = new List<Relatie>
                               {
                                   new Relatie {Naam = "Partners" },
                                   new Relatie {Naam = "Ouder (met NAH) & kind"},
                                   new Relatie {Naam = "Kind (met NAH) & ouder"},
                                   new Relatie {Naam = "Andere familieband"},
                                   new Relatie {Naam = "Andere"}
                               };
            context.Relaties.AddOrUpdate(r => new { r.Naam }, relaties.ToArray());
            context.SaveChanges();
            //LeeftijdsCategorieen toevoegen
            var leeftijdsCategorie = new List<LeeftijdsCategorie>
            {
                new LeeftijdsCategorie{Van=0,Tot=19},
                new LeeftijdsCategorie{Van=20,Tot=29},
                new LeeftijdsCategorie{Van=30,Tot=39},
                new LeeftijdsCategorie{Van=40,Tot=49},
                new LeeftijdsCategorie{Van=50,Tot=59},
                new LeeftijdsCategorie{Van=60,Tot=69},
                new LeeftijdsCategorie{Van=70,Tot=79},
                new LeeftijdsCategorie{Van=80,Tot=99}
            };

            //leeftijdsCategorie.ForEach(s => context.LeeftijdsCategorieen.AddOrUpdate(s));
            context.LeeftijdsCategorieen.AddOrUpdate(l => new { l.Van, l.Tot }, leeftijdsCategorie.ToArray());
            context.SaveChanges();
            //Aandoening + Pathologie toevoegen
            var aandoening = new Aandoening { Omschrijving = "Niet-aangeboren Hersenaandoening" };

            var pat1 = new Pathologie { Omschrijving = "Traumatisch Hersenletsel" };
            var pat2 = new Pathologie { Omschrijving = "Hersenletsel met inwendige oorzaak" };
            var pat3 = new Pathologie { Omschrijving = "Progressief Hersenletsel" };

            var pathologieen = new List<Pathologie> { pat1, pat2, pat3 };

            aandoening.Patologieen = pathologieen;
            foreach (var p in pathologieen)
            {
                p.Aandoeningen = new List<Aandoening> { aandoening };
            }

            context.Aandoeningen.AddOrUpdate(a => new { a.Omschrijving }, aandoening);
            context.SaveChanges();

            //Code gevonden op : http://csharp.net-informations.com/excel/csharp-read-excel.htm
            //Postcodes Toevoegen
            var postcodelijst = new List<Postcode>();

            int rCnt;

            var xlApp = new Excel.Application();

            const string URL = @"http://www.bpost2.be/zipcodes/files/zipcodes_num_nl.xls";
            //xlWorkBook = xlApp.Workbooks.Open(@"D:\postcodes.xls", 0, true, 5, "", "", true, Excel.XlPlatform.xlWindows, "\t", false, false, 0, true, 1, 0);
            var xlWorkBook = xlApp.Workbooks.Open(URL, 0, true, 5, "", "", true, Excel.XlPlatform.xlWindows, "\t", false, false, 0, true, 1, 0);
            var xlWorkSheet = (Excel.Worksheet)xlWorkBook.Worksheets.Item[1];

            var range = xlWorkSheet.UsedRange;

            for (rCnt = 2; rCnt <= range.Rows.Count; rCnt++)
            {
                var pc = new Postcode
                {
                    Postnr = (int)(range.Cells[rCnt, 1] as Excel.Range).Value,
                    Gemeente = (string)(range.Cells[rCnt, 2] as Excel.Range).Value
                };
                postcodelijst.Add(pc);
            }

            xlWorkBook.Close(true, null, null);
            xlApp.Quit();

            this.releaseObject(xlWorkSheet);
            this.releaseObject(xlWorkBook);
            this.releaseObject(xlApp);

            postcodelijst.ForEach(p => context.Postcodes.AddOrUpdate(p));
            context.Postcodes.AddOrUpdate(p => new { p.Postnr, p.Gemeente }, postcodelijst.ToArray());
            context.SaveChanges();
        }

        private void releaseObject(object obj)
        {
            try
            {
                Marshal.ReleaseComObject(obj);
                obj = null;
            }
            catch (Exception ex)
            {
                obj = null;
            }
            finally
            {
                GC.Collect();
            }
        }
    }
}