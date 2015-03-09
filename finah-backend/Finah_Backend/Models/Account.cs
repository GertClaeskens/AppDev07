namespace Finah_Backend.Models
{
    public class Account : SuperKlasseAanvraagAccount
    {
        //Kijken of we daadwerkelijk iets moeten opslaan van EIDs of dat we via het rijksregisternr dit controleren
        private EID eidnr;

        public EID Eidnr { get; set; }
    }
}