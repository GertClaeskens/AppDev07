using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Finah_Backend.Models
{
    using System.Web.Http.Results;

    public class Aanvraag : SuperKlasseAanvraagAccount
    {
        private Status sts;

        public Status Sts { get; set; }
    
    }
}