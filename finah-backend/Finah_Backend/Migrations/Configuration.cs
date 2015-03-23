namespace Finah_Backend.Migrations
{
    using Finah_Backend.Controllers;
    using Finah_Backend.DAL;
    using System;
    using System.Collections.Generic;
    using System.Data.Entity;
    using System.Data.Entity.Migrations;
    using System.Linq;

    using Finah_Backend.Models;

    using Excel = Microsoft.Office.Interop.Excel;

    public sealed class Configuration : DbMigrationsConfiguration<Finah_Backend.DAL.FinahDBContext>
    {
        public Configuration()
        {
            AutomaticMigrationsEnabled = true;
        }

        //Code gevonden op : http://csharp.net-informations.com/excel/csharp-read-excel.htm
        protected override void Seed(FinahDBContext context)
        {
            var leeftijdsCategorie = new List<LeeftijdsCategorie>
            {
                new LeeftijdsCategorie{Van=18,Tot=25},
                new LeeftijdsCategorie{Van=26,Tot=35}
            };

            //leeftijdsCategorie.ForEach(s => context.LeeftijdsCategorieen.AddOrUpdate(s));
            context.LeeftijdsCategorieen.AddOrUpdate(l => new{l.Van,l.Tot},leeftijdsCategorie.ToArray());
            context.SaveChanges();

            //var postcodelijst = new List<Postcode>();

            //int rCnt;

            //Excel.Application xlApp = new Excel.Application();

            //string url = @"http://www.bpost2.be/zipcodes/files/zipcodes_num_nl.xls";
            ////xlWorkBook = xlApp.Workbooks.Open(@"D:\postcodes.xls", 0, true, 5, "", "", true, Excel.XlPlatform.xlWindows, "\t", false, false, 0, true, 1, 0);
            //Excel.Workbook xlWorkBook = xlApp.Workbooks.Open(url, 0, true, 5, "", "", true, Excel.XlPlatform.xlWindows, "\t", false, false, 0, true, 1, 0);
            //Excel.Worksheet xlWorkSheet = (Excel.Worksheet)xlWorkBook.Worksheets.Item[1];

            //Excel.Range range = xlWorkSheet.UsedRange;

            //for (rCnt = 2; rCnt <= range.Rows.Count; rCnt++)
            //{
            //    Postcode pc = new Postcode
            //    {
            //        Postnr = (int)(range.Cells[rCnt, 1] as Excel.Range).Value,
            //        Gemeente = (string)(range.Cells[rCnt, 2] as Excel.Range).Value
            //    };
            //    postcodelijst.Add(pc);
            //}

            //xlWorkBook.Close(true, null, null);
            //xlApp.Quit();

            //releaseObject(xlWorkSheet);
            //releaseObject(xlWorkBook);
            //releaseObject(xlApp);

            //postcodelijst.ForEach(p => context.Postcodes.AddOrUpdate(p));
            //context.Postcodes.AddOrUpdate(p => new { p.Postnr,p.Gemeente }, postcodelijst.ToArray());
        //    context.SaveChanges();
        //}

        //private void releaseObject(object obj)
        //{
        //    try
        //    {
        //        System.Runtime.InteropServices.Marshal.ReleaseComObject(obj);
        //        obj = null;
        //    }
        //    catch (Exception ex)
        //    {
        //        obj = null;
        //    }
        //    finally
        //    {
        //        GC.Collect();
        //    }
        }
    }
}
