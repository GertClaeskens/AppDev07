using System;

namespace Finah_Backend.Models
{
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;

    public class Onderzoek
    {
        #region Public members

        [Key]
        public int Id { get; set; }

        //public DateTime Aangevraagd { get; set; }

        public string Informatie { get; set; }

        //Ook eventueel enum van maken
        //Relatie eventueel ook ergens anders zetten.
        public Relatie Relatie { get; set; }
        public virtual VragenLijst Vragen { get; set; }

        public virtual Account AangemaaktDoor { get; set; }

        public virtual Bevraging Bevraging_Pat { get; set; }
        public virtual Bevraging Bevraging_Man { get; set; }
        public virtual Aandoening Aandoening { get; set; }
        public virtual Pathologie Pathologie { get; set; }

        [NotMapped]
        public DateTime Datum { get; set; }

        #endregion Public members
    }
}