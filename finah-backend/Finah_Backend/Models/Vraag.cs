namespace Finah_Backend.Models
{
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;

    public class Vraag
    {
        #region Public members

        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public int? Id { get; set; }

        public string VraagStelling { get; set; }

        public virtual Foto Afbeelding { get; set; }

        public virtual GeluidsFragment Geluid { get; set; }

        #endregion Public members
    }
}