using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Finah_Web.Models
{
    public class Account : SuperKlasseAanvraagAccount
    {
        //Kijken of we daadwerkelijk iets moeten opslaan van EIDs of dat we via het rijksregisternr dit controleren
        private EID eidnr;

        public EID Eidnr { get; set; }
    }
}