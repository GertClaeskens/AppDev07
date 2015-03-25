using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Finah_Backend.Models
{
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;

    public class AntwoordenLijst
    {
        [Key, ForeignKey("Bevraging")]
        public String Id { get; set; }

        public virtual ICollection<Antwoord> Antwoorden { get; set; }

        public AntwoordenLijst()
        {
            this.Antwoorden = new List<Antwoord>();
        }

        public virtual Bevraging Bevraging { get; set; }
    
    }
}