using System;

namespace Finah_Backend.Models
{
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;

    public class Bevraging
    {
        #region Public members

        //unieke genereren id 
        [Key]
        public String Id { get; set; }

        #region verborgen velden
        //public DateTime Aangevraagd { get; set; }

        //onderstaande members -> berekenen uit VragenLijst
        //public int AantalIngevuldPatient;

        //public int AantalIngevuldMantelzorger;

        //public virtual LeeftijdsCategorie LeeftijdsCat { get; set; }


        //public string Informatie { get; set; }

        //Ook eventueel enum van maken
        //public string Relatie { get; set; }

        //public virtual Account AangemaaktDoor { get; set; }
        #endregion
        //[ForeignKey("Antwoorden")]
        //public int AntwoordenId { get; set; }
        //public virtual ICollection<AntwoordenLijst> Antwoorden { get; set; }
        //Nodig om de juiste benamingen te tonen tijdens het invullen van de vragenlijst
        public bool IsPatient { get; set; }
        public string Antwoorden { get; set; }

        [ForeignKey("LeeftijdsCategorie")]
        public int LeeftijdsCategorieId { get; set; }
        public virtual LeeftijdsCategorie LeeftijdsCategorie { get; set; }
        #endregion Public members
    }
}