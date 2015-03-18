namespace Finah_Backend.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class Initial1 : DbMigration
    {
        public override void Up()
        {
            AddColumn("dbo.LeeftijdsCategorie", "Van", c => c.Int(nullable: false));
            AddColumn("dbo.LeeftijdsCategorie", "Tot", c => c.Int(nullable: false));
        }
        
        public override void Down()
        {
            DropColumn("dbo.LeeftijdsCategorie", "Tot");
            DropColumn("dbo.LeeftijdsCategorie", "Van");
        }
    }
}
