using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Finah_Web.Models
{
    public class Bevraging
    {
        #region Public members
        public String Id { get; set; }

        public DateTime Aangevraagd { get; set; }
        //onderstaande members -> berekenen uit VragenLijst
        //public int AantalIngevuldPatient;

        public LeeftijdsCategorie LeeftijdsCat { get; set; }

        public string Informatie { get; set; }
        //Ook eventueel enum van maken
        public string Relatie { get; set; }

        public Account AangemaaktDoor { get; set; }

        public VragenLijst Vragen { get; set; }

        public bool IsPatient { get; set; }
        #endregion
    }
}