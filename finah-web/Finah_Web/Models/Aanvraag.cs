using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Finah_Web.Models
{
    public class Aanvraag : SuperKlasseAanvraagAccount
    {
        private Status sts;

        public Status Sts { get; set; }

    }
}