using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Finah_Web.Models
{
    public abstract class SuperKlasseAanvraagAccount
    {

        #region Public members
        public int Id { get; set; }

        public string Naam { get; set; }

        public string VoorNaam { get; set; }

        public string RijksRegisterNr { get; set; }

        public string Adres { get; set; }

        public Postcode Postcd { get; set; }

        public string Telnr { get; set; }

        public string Gsm { get; set; }

        public string Login { get; set; }

        public string Passwd { get; set; }

        public string GeheimeVraag { get; set; }

        public string GeheimAntwoord { get; set; }
        public TypeAccount TypeAcc { get; set; }
        #endregion
    }


    #region Enum
    public enum TypeAccount
    {
        Hulpverlener,
        Onderzoeker
    }
    #endregion
}