using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Finah_Web.Models
{
    public class Bevraging
    {
        #region Public members
        public int Id { get; set; }

        public DateTime Aangevraagd { get; set; }
        //onderstaande members -> berekenen uit VragenLijst
        //public int AantalIngevuldPatient;

        //public int AantalIngevuldMantelzorger;

        public LeeftijdsCategorie LeeftijdsCatPatient { get; set; }

        public LeeftijdsCategorie LeeftijdsCatMantelZorger { get; set; }

        public string Informatie { get; set; }
        //Ook eventueel enum van maken
        public string Relatie { get; set; }

        public Account AangemaaktDoor { get; set; }

        public VragenLijst Vragenpatient { get; set; }

        public VragenLijst VragenMantelzorger { get; set; }
        #endregion
    }
}