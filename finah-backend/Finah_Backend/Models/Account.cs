namespace Finah_Backend.Models
{
    using Finah_Backend.Models.Enums;

    public class Account 
    {
        #region Public members
        public int Id { get; set; }

        public string Naam { get; set; }

        public string VoorNaam { get; set; }

        public string RijksRegisterNr { get; set; }

        public string Adres { get; set; }

        public virtual Postcode Postcd { get; set; }

        public string Telnr { get; set; }

        public string Gsm { get; set; }

        public string Login { get; set; }

        public string Passwd { get; set; }

        public string GeheimeVraag { get; set; }

        public string GeheimAntwoord { get; set; }
        public TypeAccount TypeAcc { get; set; }
        
        //Kijken of we daadwerkelijk iets moeten opslaan van EIDs of dat we via het rijksregisternr dit controleren
        public virtual EID Eidnr { get; set; }
        #endregion
    }
}