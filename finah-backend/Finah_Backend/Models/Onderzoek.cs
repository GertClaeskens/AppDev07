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
        [ForeignKey("Relatie")]
        public int RelatieId { get; set; }
        public virtual Relatie Relatie { get; set; }
        [ForeignKey("Vragen")]
        public int VragenId { get; set; }
        public virtual VragenLijst Vragen { get; set; }

        public virtual Account AangemaaktDoor { get; set; }

        [ForeignKey("Bevraging_Pat")]
        public string Bevraging_PatId { get; set; }
        public virtual Bevraging Bevraging_Pat { get; set; }
        [ForeignKey("Bevraging_Man")]
        public string Bevraging_ManId { get; set; }
        public virtual Bevraging Bevraging_Man { get; set; }

        [ForeignKey("Aandoening")]
        public int AandoeningId { get; set; }
        public virtual Aandoening Aandoening { get; set; }
        [ForeignKey("Pathologie")]
        public int PathologieId { get; set; }
        public virtual Pathologie Pathologie { get; set; }


        public DateTime Datum { get; set; }

        public string Rapport { get; set; }

        #endregion Public members
    }
}