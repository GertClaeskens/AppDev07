using System;

namespace Finah_Backend.Models
{
    using System.ComponentModel.DataAnnotations;

    public class Bevraging
    {
        #region Public members

        [Key]
        public String Id { get; set; }

        public DateTime Aangevraagd { get; set; }

        //onderstaande members -> berekenen uit VragenLijst
        //public int AantalIngevuldPatient;

        //public int AantalIngevuldMantelzorger;

        public virtual LeeftijdsCategorie LeeftijdsCat { get; set; }


        public string Informatie { get; set; }

        //Ook eventueel enum van maken
        public string Relatie { get; set; }

        public virtual Account AangemaaktDoor { get; set; }

        public virtual VragenLijst Vragen { get; set; }
        public virtual AntwoordenLijst Antwoorden { get; set; }
        public bool IsPatient { get; set; }

        #endregion Public members
    }
}