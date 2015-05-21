namespace Finah_Backend.Models
{
    using System.ComponentModel.DataAnnotations.Schema;

    using Finah_Backend.Models.Enums;

    public class Account
    {
        #region Public members
        public int Id { get; set; }

        public string Naam { get; set; }

        public string VoorNaam { get; set; }

        public string Adres { get; set; }

        [ForeignKey("Postcd")]
        public int PostcdId { get; set; }

        public virtual Postcode Postcd { get; set; }

        public string Telnr { get; set; }

        public string Login { get; set; }

        public string Passwd { get; set; }
        public string TypeAcc { get; set; }
        #endregion
    }
}