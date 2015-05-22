namespace Finah_Backend.Migrations
{
    using Finah_Backend.DAL;
    using Finah_Backend.Models;
    using Microsoft.AspNet.Identity;
    using Microsoft.AspNet.Identity.EntityFramework;
    using System;
    using System.Collections.Generic;
    using System.Data.Entity.Migrations;
    using System.Runtime.InteropServices;
    using Excel = Microsoft.Office.Interop.Excel;

    public sealed class Configuration : DbMigrationsConfiguration<ApplicationDbContext>
    {
        public Configuration()
        {
            this.AutomaticMigrationsEnabled = true;
            this.AutomaticMigrationDataLossAllowed = true;
        }

        protected override void Seed(ApplicationDbContext context)
        {
            #region Thema's

            var themas = new List<Thema>
                             {
                                 new Thema { Naam = "Leren en toepassen van kennis" },
                                 new Thema { Naam = "Algemene taken en activiteiten" },
                                 new Thema { Naam = "Communicatie" },
                                 new Thema { Naam = "Mobiliteit" },
                                 new Thema { Naam = "Zelfverzorging" },
                                 new Thema { Naam = "Huishouden" },
                                 new Thema { Naam = "Omgaan met andere mensen" },
                                 new Thema
                                     {
                                         Naam =
                                             "Belangrijke levensgebieden (Opleiding, werk of financiele zaken)"
                                     },
                                 new Thema { Naam = "Maatschappelijk, sociaal en burgerlijk leven" },
                                 new Thema { Naam = "Emoties en gedrag" }
                             };
            context.Themas.AddOrUpdate(t => new { t.Naam }, themas.ToArray());
            context.SaveChanges();

            #endregion Thema's

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

            #endregion Aandoening + Pathologie

            #region Vragen + VragenLijst toevoegen

            var vragenLijst = new VragenLijst
            {
                Omschrijving = "Uitgebreide vragenlijst Niet-aangeboren Hersenaandoening",
                Aandoe = context.Aandoeningen.Find(1),
                Vragen = new List<Vraag>
                             {
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Iets nieuws leren (zoals het leren omgaan met bijv. een nieuwe GSM, vaatwasmachine of afstandsbediening; leren ikv een hobby)"
                                             ,Thema =  context.Themas.Find(1)
                                     },
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Zich kunnen concentreren zonder te worden afgeleid (zoals het volgen van een gesprek in een drukke omgeving, of het volgen van een Tv-programma)"
                                             ,Thema =  context.Themas.Find(1)
                                     },
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Denken (zoals fantaseren, een mening vormen, met ideeën spelen, of nadenken)"
                                             ,Thema =  context.Themas.Find(1)
                                     },
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Lezen (zoals boeken, instructies, kranten, in tekst of in braille)"
                                             ,Thema =  context.Themas.Find(1)
                                     },
                                 new Vraag
                                     {
                                         VraagStelling = "Rekenen (zoals gepast betalen bij een winkel)",Thema =  context.Themas.Find(1)
                                     },
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Oplossen van problemen (zoals een afspraak bij de dokter verzetten, of weten wat je moet doen als er iets stuk gaat in huis)",Thema =  context.Themas.Find(1)
                                     },
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Keuzes maken (zoals kiezen wat je wil eten, welk TV-programma je wil zien)",Thema =  context.Themas.Find(1)
                                     },
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Uitvoeren van dagelijkse routinehandelingen (zoals zich wassen, ontbijten)",Thema =  context.Themas.Find(2)
                                     },
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Ondernemen van een eenvoudige taak op eigen initiatief (zoals een boodschappenlijstje opmaken, de vuilzak buitenzetten, de tafel dekken)",Thema =  context.Themas.Find(2)
                                     },
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Ondernemen van complexe taken op eigen initiatief (zoals autorijden, boodschappen doen, uitgebreid koken)",Thema =  context.Themas.Find(2)
                                     },
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Omgaan met stressvolle situaties(zoals het autorijden in druk verkeer of het verzorgen van meerdere kinderen)",Thema =  context.Themas.Find(2)
                                     },
                                 new Vraag { VraagStelling = "Begrijpen wat iemand vertelt of vraagt" ,Thema =  context.Themas.Find(3)},
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Begrijpen van non-verbale (niet gesproken) boodschappen (zoals pictogrammen, afbeeldingen, symbolen, lichaamstaal en gezichtsuitdrukkingen)",Thema =  context.Themas.Find(3)
                                     },
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Begrijpen van geschreven boodschappen (zoals het lezen van de krant)",Thema =  context.Themas.Find(3)
                                     },
                                 new Vraag { VraagStelling = "Spreken" ,Thema =  context.Themas.Find(3)},
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Zich uiten dmv lichaamstaal, handgebaren en gezichtsuitdrukkingen)",Thema =  context.Themas.Find(3)
                                     },
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Schrijven van berichten (bijv. een boodschappenlijstje maken, een email schrijven)",Thema =  context.Themas.Find(3)
                                     },
                                 new Vraag { VraagStelling = "Het voeren van een gesprek" ,Thema =  context.Themas.Find(3)},
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Gebruiken van communicatieapparatuur en - technieken (zoals gebruik van telefoon, GSM, computer, hoorapparaat, etc)",Thema =  context.Themas.Find(3)
                                     },
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Zich kunnen bewegen en verplaatsen, met of zonder gebruik van hulpmiddelen zoals rolstoel, wandelstok of rollator (bijv. uit bed komen, wandelen, opstaan uit stoel)",Thema =  context.Themas.Find(4)
                                     },
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Gebruiken van hand en arm (grote bewegingen, zoals voorwerpen optillen en meenemen)",Thema =  context.Themas.Find(4)
                                     },
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Nauwkeurig gebruiken van handen (kleine bewegingen zoals grijpen en loslaten, schrijven, gebruik van sleutels of GSM, iets snijden met een mes)",Thema =  context.Themas.Find(4)
                                     },
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Gebruiken van openbaar vervoer (zoals de bus of de trein nemen)",Thema =  context.Themas.Find(4)
                                     },
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Besturen van vervoermiddel (zoals de auto of de fiets)",Thema =  context.Themas.Find(4)
                                     },
                                 new Vraag { VraagStelling = "Zich wassen" ,Thema =  context.Themas.Find(5)},
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Verzorgen van lichaamsdelen (bijv. tanden poetsen, nagels knippen, make-up gebruiken)",Thema =  context.Themas.Find(5)
                                     },
                                 new Vraag { VraagStelling = "Zelfstandig naar het toilet kunnen gaan" ,Thema =  context.Themas.Find(5)},
                                 new Vraag { VraagStelling = "Zich aankleden",Thema =  context.Themas.Find(5) },
                                 new Vraag { VraagStelling = "Eten" ,Thema =  context.Themas.Find(5)},
                                 new Vraag { VraagStelling = "Drinken" ,Thema =  context.Themas.Find(5)},
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Letten op de gezondheid (gevarieerd eten, voldoende lichaamsbeweging, gezondheidsrisico’s vermijden)",Thema =  context.Themas.Find(5)
                                     },
                                 new Vraag { VraagStelling = "Gaan winkelen" ,Thema =  context.Themas.Find(6)},
                                 new Vraag { VraagStelling = "Bereiden van maaltijden" ,Thema =  context.Themas.Find(6)},
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Huishouden doen (onderhoud van huis en tuin, schoonmaken, kleren wassen)",Thema =  context.Themas.Find(6)
                                     },
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Op sociaal gepaste wijze contact maken met bekende en onbekende mensen (respectvol, rekening houden met",Thema =  context.Themas.Find(7)
                                     },
                                 new Vraag { VraagStelling = "Intieme relaties en seksualiteit" ,Thema =  context.Themas.Find(7)},
                                 new Vraag { VraagStelling = "Omgaan met familieleden" ,Thema =  context.Themas.Find(7)},
                                 new Vraag { VraagStelling = "Omgaan met vrienden en kennissen" ,Thema =  context.Themas.Find(7)},
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Formele relaties (zoals omgang met collega’s, werkgever, dokters en verzorgenden)",Thema =  context.Themas.Find(7)
                                     },
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Het volgen van een vorming, training en/of opleiding",Thema =  context.Themas.Find(8)
                                     },
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Werken of andere zinvolle dagbesteding (zoals vrijwilligerswerk, het huishouden)",Thema =  context.Themas.Find(8)
                                     },
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Financiële mogelijkheden voor jezelf en je gezin",Thema =  context.Themas.Find(8)
                                     },
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Deelnemen aan het maatschappelijk leven (zoals gaan stemmen, een huwelijk of begrafenis bijwonen, lid zijn van een vereniging",Thema =  context.Themas.Find(9)
                                     },
                                 new Vraag
                                     {
                                         VraagStelling =
                                             "Ontspanning en vrije tijd (activiteiten gericht op amusement)",Thema =  context.Themas.Find(9)
                                     },
                                 new Vraag { VraagStelling = "Religie en spiritualiteit" ,Thema =  context.Themas.Find(9)},
                                 new Vraag { VraagStelling = "Somber, neerslachtig, depressief" ,Thema =  context.Themas.Find(10)},
                                 new Vraag { VraagStelling = "Angstgevoelens" ,Thema =  context.Themas.Find(10)},
                                 new Vraag
                                     {
                                         VraagStelling ="Onrealistische verwachtingen - Sneller emotioneel (bijv. huilen)",Thema =  context.Themas.Find(10)
                                     },
                                 new Vraag { VraagStelling = "Sneller geïrriteerd en prikkelbaar" ,Thema =  context.Themas.Find(10)},
                                 new Vraag { VraagStelling = "Onverschilligheid" ,Thema =  context.Themas.Find(10)},
                                 new Vraag
                                     {
                                         VraagStelling ="Ontremming en problemen met controle van gedag (zoals het maken van ongepaste opmerkingen, overmatig eten,…)",Thema =  context.Themas.Find(10)
                                     },
                                 new Vraag { VraagStelling = "Sneller en vaker moe" ,Thema =  context.Themas.Find(10)}
                             }
            };
            context.VragenLijsten.AddOrUpdate(vl => new { vl.Id }, vragenLijst);
            context.SaveChanges();
            var vrLijst = new VragenLijst
            {
                Omschrijving =
                    "Korte vragenlijst Niet-aangeboren Hersenaandoening",
                Aandoe = context.Aandoeningen.Find(1),
                Vragen =
                    new List<Vraag>
                                              {
                                                  new Vraag
                                                      {
                                                          VraagStelling =
                                                              "Iets nieuws leren (zoals het leren omgaan met bijv. een nieuwe GSM, vaatwasmachine of afstandsbediening; leren ikv een hobby)",
                                                          Thema = context.Themas.Find(1)
                                                      },
                                                  new Vraag
                                                      {
                                                          VraagStelling =
                                                              "Zich kunnen concentreren zonder te worden afgeleid (zoals het volgen van een gesprek in een drukke omgeving, of het volgen van een Tv-programma)",
                                                          Thema = context.Themas.Find(1)
                                                      },
                                                  new Vraag
                                                      {
                                                          VraagStelling =
                                                              "Denken (zoals fantaseren, een mening vormen, met ideeën spelen, of nadenken)",
                                                          Thema = context.Themas.Find(1)
                                                      }
                                              }
            };
            #endregion Vragen + VragenLijst toevoegen
            context.VragenLijsten.AddOrUpdate(vl => new { vl.Id }, vrLijst);
            context.SaveChanges();
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

            #endregion Relaties toevoegen

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

            #endregion LeeftijdsCategorieen toevoegen

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
                var range1 = range.Cells[rCnt, 1] as Excel.Range;
                if (range1 == null)
                {
                    continue;
                }
                var range2 = range.Cells[rCnt, 2] as Excel.Range;
                if (range2 == null)
                {
                    continue;
                }
                var pc = new Postcode
                {
                    Postnr = (int)range1.Value,
                    Gemeente = (string)range2.Value
                };
                postcodelijst.Add(pc);
            }

            xlWorkBook.Close(true, null, null);
            xlApp.Quit();

            releaseObject(xlWorkSheet);
            releaseObject(xlWorkBook);
            releaseObject(xlApp);

            postcodelijst.ForEach(p => context.Postcodes.AddOrUpdate(p));
            context.Postcodes.AddOrUpdate(p => new { p.Postnr, p.Gemeente }, postcodelijst.ToArray());
            context.SaveChanges();

            #endregion Postcodes Toevoegen

            #region Roles Aanmaken
            AddUsersAndRoles(context);
            #endregion
        }

        private bool AddUsersAndRoles(Finah_Backend.Models.ApplicationDbContext context)
        {
            IdentityResult ir;
            //Roles
            var rm = new RoleManager<IdentityRole>
                (new RoleStore<IdentityRole>(context));
            ir = rm.Create(new IdentityRole("Admin")); //Just in Case
            ir = rm.Create(new IdentityRole("Onderzoeker"));
            ir = rm.Create(new IdentityRole("Hulpverlener"));
            //Users
            var um = new UserManager<ApplicationUser>(
                new UserStore<ApplicationUser>(context));
            //Admin
            var testUserAdmin = new ApplicationUser()
            {
                UserName = "TestProfileAdmin",
                Postcd = context.Postcodes.Find(1)
            };
            ir = um.Create(testUserAdmin, "S3cur3P@ssw0rd");
            //Onderzoeker
            var testUserOnderzoeker = new ApplicationUser()
            {
                UserName = "TestProfileOnderzoeker",
                Postcd = context.Postcodes.Find(1)
            };
            ir = um.Create(testUserOnderzoeker, "S3cur3P@ssw0rd");
            //Hulpverlener
            var testUserHulpverlener = new ApplicationUser()
            {
                UserName = "TestProfileHulpverlener",
                Postcd = context.Postcodes.Find(1)
            };
            ir = um.Create(testUserHulpverlener, "S3cur3P@ssw0rd");

            if (ir.Succeeded == false)
                return ir.Succeeded;
            //Add users to Role
            ir = um.AddToRole(testUserAdmin.Id, "Admin");
            ir = um.AddToRole(testUserOnderzoeker.Id, "Onderzoeker");
            ir = um.AddToRole(testUserHulpverlener.Id, "Hulpverlener");

            return ir.Succeeded;
        }

        private static void releaseObject(object obj)
        {
            try
            {
                Marshal.ReleaseComObject(obj);
                obj = null;
            }
            catch (Exception)
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