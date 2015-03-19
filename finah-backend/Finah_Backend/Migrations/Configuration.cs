namespace Finah_Backend.Migrations
{
    using System;
    using System.Collections.Generic;
    using System.Data.Entity;
    using System.Data.Entity.Migrations;
    using System.Linq;
    using Excel = Microsoft.Office.Interop.Excel;
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

            var postcodelijst = new List<Postcode>();
            Excel.Application xlApp;
            Excel.Workbook xlWorkBook;
            Excel.Worksheet xlWorkSheet;
            Excel.Range range;

            string str;
            int rCnt;
            int cCnt;

            xlApp = new Excel.Application();
            //Bestandslocatie voorlopig hardcoded
            //http://www.bpost2.be/zipcodes/files/zipcodes_alpha_nl.xls
            string url = @"http://www.bpost2.be/zipcodes/files/zipcodes_num_nl.xls";
            //xlWorkBook = xlApp.Workbooks.Open(@"D:\postcodes.xls", 0, true, 5, "", "", true, Excel.XlPlatform.xlWindows, "\t", false, false, 0, true, 1, 0);
            xlWorkBook = xlApp.Workbooks.Open(url, 0, true, 5, "", "", true, Excel.XlPlatform.xlWindows, "\t", false, false, 0, true, 1, 0);
            xlWorkSheet = (Excel.Worksheet)xlWorkBook.Worksheets.Item[1];

            range = xlWorkSheet.UsedRange;

            for (rCnt = 2; rCnt <= range.Rows.Count; rCnt++)
            {
                Postcode pc = new Postcode
                                  {
                                      Postnr = (int)(range.Cells[rCnt, 1] as Excel.Range).Value,
                                      Gemeente = (string)(range.Cells[rCnt, 2] as Excel.Range).Value
                                  };
                postcodelijst.Add(pc);
                //for (cCnt = 1; cCnt <= range.Columns.Count; cCnt++)
                //{
                //    str = (string)(range.Cells[rCnt, cCnt] as Excel.Range).Value2;
                //}
            }
            
         
            xlWorkBook.Close(true, null, null);
            xlApp.Quit();

            releaseObject(xlWorkSheet);
            releaseObject(xlWorkBook);
            releaseObject(xlApp);

            postcodelijst.ForEach(p => context.Postcodes.AddOrUpdate(p));
            context.SaveChanges();
        }

        private void releaseObject(object obj)
        {
            try
            {
                System.Runtime.InteropServices.Marshal.ReleaseComObject(obj);
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
