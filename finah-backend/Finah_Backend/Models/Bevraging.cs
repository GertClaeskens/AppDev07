using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Finah_Backend.Models
{
    public class Bevraging
    {
        #region Private members
        private int id;

        private DateTime aangevraagd;

        //onderstaande members -> berekenen uit VragenLijst
        //private int aantalIngevuldPatient;
        
        //private int aantalIngevuldMantelzorger;

        private LeeftijdsCategorie leeftijdsCatPatient;

        private LeeftijdsCategorie leeftijdsCatMantelZorger;

        private string informatie;

        //Ook eventueel enum van maken
        private string relatie;

        private Account aangemaaktDoor;

        private VragenLijst vragenpatient;

        private VragenLijst vragenMantelzorger;
        #endregion
        #region Public members
        public int Id;

        public DateTime Aangevraagd;

        //public int AantalIngevuldPatient;

        //public int AantalIngevuldMantelzorger;

        public LeeftijdsCategorie LeeftijdsCatPatient;

        public LeeftijdsCategorie LeeftijdsCatMantelZorger;

        public string Informatie;
        
        public string Relatie;

        public Account AangemaaktDoor;

        public VragenLijst Vragenpatient;

        public VragenLijst VragenMantelzorger;
        #endregion
    }
}