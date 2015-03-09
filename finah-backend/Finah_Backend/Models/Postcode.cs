namespace Finah_Backend.Models
{
    using System.ComponentModel.DataAnnotations;

    public class Postcode
    {
        [Key]
        #region Public members
        public int Id { get; set; }

        public int Postnr { get; set; }

        public string Gemeente { get; set; }
        #endregion
    }
}