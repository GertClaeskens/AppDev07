namespace Finah_Backend.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class Initial : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Aandoening",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Omschrijving = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Pathologie",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Omschrijving = c.String(),
                        Aandoening_Id = c.Int(),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Aandoening", t => t.Aandoening_Id)
                .Index(t => t.Aandoening_Id);
            
            CreateTable(
                "dbo.Aanvraag",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Naam = c.String(),
                        VoorNaam = c.String(),
                        RijksRegisterNr = c.String(),
                        Adres = c.String(),
                        Telnr = c.String(),
                        Gsm = c.String(),
                        Login = c.String(),
                        Passwd = c.String(),
                        GeheimeVraag = c.String(),
                        GeheimAntwoord = c.String(),
                        TypeAcc = c.Int(nullable: false),
                        Postcd_Id = c.Int(),
                        Sts_Id = c.Int(),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Postcode", t => t.Postcd_Id)
                .ForeignKey("dbo.Status", t => t.Sts_Id)
                .Index(t => t.Postcd_Id)
                .Index(t => t.Sts_Id);
            
            CreateTable(
                "dbo.Postcode",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Postnr = c.Int(nullable: false),
                        Gemeente = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Status",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        BeoordeeldOp = c.DateTime(nullable: false),
                        BeoordeeldDoor_Id = c.Int(),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Account", t => t.BeoordeeldDoor_Id)
                .Index(t => t.BeoordeeldDoor_Id);
            
            CreateTable(
                "dbo.Account",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Naam = c.String(),
                        VoorNaam = c.String(),
                        RijksRegisterNr = c.String(),
                        Adres = c.String(),
                        Telnr = c.String(),
                        Gsm = c.String(),
                        Login = c.String(),
                        Passwd = c.String(),
                        GeheimeVraag = c.String(),
                        GeheimAntwoord = c.String(),
                        TypeAcc = c.Int(nullable: false),
                        Eidnr_Id = c.Int(),
                        Postcd_Id = c.Int(),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.EID", t => t.Eidnr_Id)
                .ForeignKey("dbo.Postcode", t => t.Postcd_Id)
                .Index(t => t.Eidnr_Id)
                .Index(t => t.Postcd_Id);
            
            CreateTable(
                "dbo.EID",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Bevraging",
                c => new
                    {
                        Id = c.String(nullable: false, maxLength: 128),
                        Aangevraagd = c.DateTime(nullable: false),
                        Informatie = c.String(),
                        Relatie = c.String(),
                        AangemaaktDoor_Id = c.Int(),
                        LeeftijdsCatMantelZorger_Id = c.Int(),
                        LeeftijdsCatPatient_Id = c.Int(),
                        VragenMantelzorger_Id = c.Int(),
                        Vragenpatient_Id = c.Int(),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Account", t => t.AangemaaktDoor_Id)
                .ForeignKey("dbo.LeeftijdsCategorie", t => t.LeeftijdsCatMantelZorger_Id)
                .ForeignKey("dbo.LeeftijdsCategorie", t => t.LeeftijdsCatPatient_Id)
                .ForeignKey("dbo.VragenLijst", t => t.VragenMantelzorger_Id)
                .ForeignKey("dbo.VragenLijst", t => t.Vragenpatient_Id)
                .Index(t => t.AangemaaktDoor_Id)
                .Index(t => t.LeeftijdsCatMantelZorger_Id)
                .Index(t => t.LeeftijdsCatPatient_Id)
                .Index(t => t.VragenMantelzorger_Id)
                .Index(t => t.Vragenpatient_Id);
            
            CreateTable(
                "dbo.LeeftijdsCategorie",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.VragenLijst",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Aandoe_Id = c.Int(),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Aandoening", t => t.Aandoe_Id)
                .Index(t => t.Aandoe_Id);
            
            CreateTable(
                "dbo.Vraag",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        VraagStelling = c.String(),
                        Afbeelding_Id = c.Int(),
                        Geluid_Id = c.Int(),
                        VragenLijst_Id = c.Int(),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Foto", t => t.Afbeelding_Id)
                .ForeignKey("dbo.GeluidsFragment", t => t.Geluid_Id)
                .ForeignKey("dbo.VragenLijst", t => t.VragenLijst_Id)
                .Index(t => t.Afbeelding_Id)
                .Index(t => t.Geluid_Id)
                .Index(t => t.VragenLijst_Id);
            
            CreateTable(
                "dbo.Foto",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Omschrijving = c.String(),
                        Pad = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.GeluidsFragment",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Omschrijving = c.String(),
                        Pad = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Bevraging", "Vragenpatient_Id", "dbo.VragenLijst");
            DropForeignKey("dbo.Bevraging", "VragenMantelzorger_Id", "dbo.VragenLijst");
            DropForeignKey("dbo.Vraag", "VragenLijst_Id", "dbo.VragenLijst");
            DropForeignKey("dbo.Vraag", "Geluid_Id", "dbo.GeluidsFragment");
            DropForeignKey("dbo.Vraag", "Afbeelding_Id", "dbo.Foto");
            DropForeignKey("dbo.VragenLijst", "Aandoe_Id", "dbo.Aandoening");
            DropForeignKey("dbo.Bevraging", "LeeftijdsCatPatient_Id", "dbo.LeeftijdsCategorie");
            DropForeignKey("dbo.Bevraging", "LeeftijdsCatMantelZorger_Id", "dbo.LeeftijdsCategorie");
            DropForeignKey("dbo.Bevraging", "AangemaaktDoor_Id", "dbo.Account");
            DropForeignKey("dbo.Aanvraag", "Sts_Id", "dbo.Status");
            DropForeignKey("dbo.Status", "BeoordeeldDoor_Id", "dbo.Account");
            DropForeignKey("dbo.Account", "Postcd_Id", "dbo.Postcode");
            DropForeignKey("dbo.Account", "Eidnr_Id", "dbo.EID");
            DropForeignKey("dbo.Aanvraag", "Postcd_Id", "dbo.Postcode");
            DropForeignKey("dbo.Pathologie", "Aandoening_Id", "dbo.Aandoening");
            DropIndex("dbo.Vraag", new[] { "VragenLijst_Id" });
            DropIndex("dbo.Vraag", new[] { "Geluid_Id" });
            DropIndex("dbo.Vraag", new[] { "Afbeelding_Id" });
            DropIndex("dbo.VragenLijst", new[] { "Aandoe_Id" });
            DropIndex("dbo.Bevraging", new[] { "Vragenpatient_Id" });
            DropIndex("dbo.Bevraging", new[] { "VragenMantelzorger_Id" });
            DropIndex("dbo.Bevraging", new[] { "LeeftijdsCatPatient_Id" });
            DropIndex("dbo.Bevraging", new[] { "LeeftijdsCatMantelZorger_Id" });
            DropIndex("dbo.Bevraging", new[] { "AangemaaktDoor_Id" });
            DropIndex("dbo.Account", new[] { "Postcd_Id" });
            DropIndex("dbo.Account", new[] { "Eidnr_Id" });
            DropIndex("dbo.Status", new[] { "BeoordeeldDoor_Id" });
            DropIndex("dbo.Aanvraag", new[] { "Sts_Id" });
            DropIndex("dbo.Aanvraag", new[] { "Postcd_Id" });
            DropIndex("dbo.Pathologie", new[] { "Aandoening_Id" });
            DropTable("dbo.GeluidsFragment");
            DropTable("dbo.Foto");
            DropTable("dbo.Vraag");
            DropTable("dbo.VragenLijst");
            DropTable("dbo.LeeftijdsCategorie");
            DropTable("dbo.Bevraging");
            DropTable("dbo.EID");
            DropTable("dbo.Account");
            DropTable("dbo.Status");
            DropTable("dbo.Postcode");
            DropTable("dbo.Aanvraag");
            DropTable("dbo.Pathologie");
            DropTable("dbo.Aandoening");
        }
    }
}
