using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Finah_Backend.Models
{
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;

    public class Bevraging
    {
        #region Public members
        [Key]
        public int Id;

        public DateTime Aangevraagd;
        //onderstaande members -> berekenen uit VragenLijst
        //public int AantalIngevuldPatient;

        //public int AantalIngevuldMantelzorger;

        [ForeignKey("Id")]
        public LeeftijdsCategorie LeeftijdsCatPatient;

        [ForeignKey("Id")]
        public LeeftijdsCategorie LeeftijdsCatMantelZorger;

        public string Informatie;
        //Ook eventueel enum van maken
        public string Relatie;

        [ForeignKey("Id")]
        public Account AangemaaktDoor;

        [ForeignKey("Id")]
        public VragenLijst Vragenpatient;

        [ForeignKey("Id")]
        public VragenLijst VragenMantelzorger;
        #endregion
    }
}