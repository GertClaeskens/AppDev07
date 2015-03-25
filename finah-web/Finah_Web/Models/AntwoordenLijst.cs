using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Finah_Web.Models
{
    public class AntwoordenLijst
    {
        public String Id { get; set; }

        public ICollection<Antwoord> Antwoorden { get; set; }

        public AntwoordenLijst()
        {
            this.Antwoorden = new List<Antwoord>();
        }

        
    }
}