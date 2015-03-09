namespace Finah_Backend.Models
{
   public class SuperKlasseAanvraagAccount
    {
        #region Private members
        // Aanvraag en Account laten overerven van superklasse.
        private int id;

        private string naam;
        private string voorNaam;

        //controle uitvoeren op rijksregisternr;
        private string rijksRegisterNr;

        private string adres;

        private Postcode postcd;

        //controle uitvoeren op telnr en gsmnr
        private string telnr;

        private string gsm;
        private string login;

        //Paswoord wordt als een hash opgeslagen
        private string passwd;

        private string geheimeVraag;
        private string geheimAntwoord;

        private TypeAccount typeAcc;
        #endregion

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