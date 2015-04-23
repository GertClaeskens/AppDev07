using System;

namespace Finah_Backend.Models
{
    using System.ComponentModel.DataAnnotations;

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

        public virtual AntwoordenLijst Antwoorden { get; set; }
        //Nodig om de juiste benamingen te tonen tijdens het invullen van de vragenlijst
        public bool IsPatient { get; set; }

        #endregion Public members
    }
}