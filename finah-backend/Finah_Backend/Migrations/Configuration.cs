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
            #region Aandoening + Pathologie
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
            #endregion
            #region Vragen + VragenLijst toevoegen
            var vragenLijst = new VragenLijst
            {
                Aandoe = context.Aandoeningen.Find(1),
                Vragen = new List<Vraag>
                             {
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Iets nieuws leren (zoals het leren omgaan met bijv. een nieuwe GSM, vaatwasmachine of afstandsbediening; leren ikv een hobby)"
                                     },
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Zich kunnen concentreren zonder te worden afgeleid (zoals het volgen van een gesprek in een drukke omgeving, of het volgen van een Tv-programma)"
                                     },
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Denken (zoals fantaseren, een mening vormen, met ideeën spelen, of nadenken)"
                                     },
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Lezen (zoals boeken, instructies, kranten, in tekst of in braille)"
                                     },
                                 new Vraag
                                     {
                                         VraagStelling = "Rekenen (zoals gepast betalen bij een winkel)"
                                     },
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Oplossen van problemen (zoals een afspraak bij de dokter verzetten, of weten wat je moet doen als er iets stuk gaat in huis)"
                                     },
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Keuzes maken (zoals kiezen wat je wil eten, welk TV-programma je wil zien)"
                                     },
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Uitvoeren van dagelijkse routinehandelingen (zoals zich wassen, ontbijten)"
                                     },
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Ondernemen van een eenvoudige taak op eigen initiatief (zoals een boodschappenlijstje opmaken, de vuilzak buitenzetten, de tafel dekken)"
                                     },
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Ondernemen van complexe taken op eigen initiatief (zoals autorijden, boodschappen doen, uitgebreid koken)"
                                     },
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Omgaan met stressvolle situaties(zoals het autorijden in druk verkeer of het verzorgen van meerdere kinderen)"
                                     },
                                 new Vraag { VraagStelling = "Begrijpen wat iemand vertelt of vraagt" },
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Begrijpen van non-verbale (niet gesproken) boodschappen (zoals pictogrammen, afbeeldingen, symbolen, lichaamstaal en gezichtsuitdrukkingen)"
                                     },
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Begrijpen van geschreven boodschappen (zoals het lezen van de krant)"
                                     },
                                 new Vraag { VraagStelling = "Spreken" },
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Zich uiten dmv lichaamstaal, handgebaren en gezichtsuitdrukkingen)"
                                     },
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Schrijven van berichten (bijv. een boodschappenlijstje maken, een email schrijven)"
                                     },
                                 new Vraag { VraagStelling = "Het voeren van een gesprek" },
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Gebruiken van communicatieapparatuur en - technieken (zoals gebruik van telefoon, GSM, computer, hoorapparaat, etc)"
                                     },
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Zich kunnen bewegen en verplaatsen, met of zonder gebruik van hulpmiddelen zoals rolstoel, wandelstok of rollator (bijv. uit bed komen, wandelen, opstaan uit stoel)"
                                     },
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Gebruiken van hand en arm (grote bewegingen, zoals voorwerpen optillen en meenemen)"
                                     },
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Nauwkeurig gebruiken van handen (kleine bewegingen zoals grijpen en loslaten, schrijven, gebruik van sleutels of GSM, iets snijden met een mes)"
                                     },
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Gebruiken van openbaar vervoer (zoals de bus of de trein nemen)"
                                     },
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Besturen van vervoermiddel (zoals de auto of de fiets)"
                                     },
                                 new Vraag { VraagStelling = "Zich wassen" },
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Verzorgen van lichaamsdelen (bijv. tanden poetsen, nagels knippen, make-up gebruiken)"
                                     },
                                 new Vraag { VraagStelling = "Zelfstandig naar het toilet kunnen gaan" },
                                 new Vraag { VraagStelling = "Zich aankleden" },
                                 new Vraag { VraagStelling = "Eten" },
                                 new Vraag { VraagStelling = "Drinken" },
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Letten op de gezondheid (gevarieerd eten, voldoende lichaamsbeweging, gezondheidsrisico’s vermijden)"
                                     },
                                 new Vraag { VraagStelling = "Gaan winkelen" },
                                 new Vraag { VraagStelling = "Bereiden van maaltijden" },
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Huishouden doen (onderhoud van huis en tuin, schoonmaken, kleren wassen)"
                                     },
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Op sociaal gepaste wijze contact maken met bekende en onbekende mensen (respectvol, rekening houden met"
                                     },
                                 new Vraag { VraagStelling = "Intieme relaties en seksualiteit" },
                                 new Vraag { VraagStelling = "Omgaan met familieleden" },
                                 new Vraag { VraagStelling = "Omgaan met vrienden en kennissen" },
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Formele relaties (zoals omgang met collega’s, werkgever, dokters en verzorgenden)"
                                     },
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Het volgen van een vorming, training en/of opleiding"
                                     },
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Werken of andere zinvolle dagbesteding (zoals vrijwilligerswerk, het huishouden)"
                                     },
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Financiële mogelijkheden voor jezelf en je gezin"
                                     },
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Deelnemen aan het maatschappelijk leven (zoals gaan stemmen, een huwelijk of begrafenis bijwonen, lid zijn van een vereniging"
                                     },
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Ontspanning en vrije tijd (activiteiten gericht op amusement)"
                                     },
                                 new Vraag { VraagStelling = "Religie en spiritualiteit" },
                                 new Vraag { VraagStelling = "Somber, neerslachtig, depressief" },
                                 new Vraag { VraagStelling = "Angstgevoelens" },
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Onrealistische verwachtingen - Sneller emotioneel (bijv. huilen)"
                                     },
                                 new Vraag { VraagStelling = "Sneller geïrriteerd en prikkelbaar" },
                                 new Vraag { VraagStelling = "Onverschilligheid" },
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Ontremming en problemen met controle van gedag (zoals het maken van ongepaste opmerkingen, overmatig eten,…)"
                                     },
                                 new Vraag { VraagStelling = "Sneller en vaker moe" }
                             }
            };
            context.VragenLijsten.AddOrUpdate(vl => new { vl.Id }, vragenLijst);
            context.SaveChanges();
            
            #endregion
            #region Relaties toevoegen
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
            #endregion
            #region LeeftijdsCategorieen toevoegen
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
            #endregion
            #region Postcodes Toevoegen
            //Code gevonden op : http://csharp.net-informations.com/excel/csharp-read-excel.htm

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
            #endregion
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