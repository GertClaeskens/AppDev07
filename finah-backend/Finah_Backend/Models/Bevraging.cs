using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Finah_Backend.Models
{

    public class Bevraging
    {
        #region Public members
        public int Id { get; set; }

        public DateTime Aangevraagd { get; set; }
        //onderstaande members -> berekenen uit VragenLijst
        //public int AantalIngevuldPatient;

        //public int AantalIngevuldMantelzorger;

        public virtual LeeftijdsCategorie LeeftijdsCatPatient { get; set; }

        public virtual LeeftijdsCategorie LeeftijdsCatMantelZorger { get; set; }

        public string Informatie { get; set; }
        //Ook eventueel enum van maken
        public string Relatie { get; set; }

        public virtual Account AangemaaktDoor { get; set; }

        public virtual VragenLijst Vragenpatient { get; set; }

        public virtual VragenLijst VragenMantelzorger { get; set; }
        #endregion
    }
}