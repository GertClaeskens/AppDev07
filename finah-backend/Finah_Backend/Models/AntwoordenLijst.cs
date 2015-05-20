using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Finah_Backend.Models
{
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;

    [NotMapped]
    public class AntwoordenLijst
    {
        //public int Id { get; set; }
        //[ForeignKey("Bevraging")]
        //public string BevragingId { get; set; }
        ////[Key, Column(Order = 1)]
        //public DateTime Datum { get; set; }

        //[ForeignKey("LeeftijdsCategorie")]
        //public int LeeftijdsCategorieId { get; set; }
        //public virtual LeeftijdsCategorie LeeftijdsCategorie { get; set; }

        ////Klasse Antwoord gebruikt omdat er geen array van ints kan gezet worden in db
        //// public virtual ICollection<Antwoord> Antwoorden { get; set; }

        ////Antwoorden opgelagen als csv_string
        //public string Antwoorden { get; set; }

        //public AntwoordenLijst()
        //{
        //    //this.Antwoorden = new List<int>();

        //}


        //public virtual Bevraging Bevraging { get; set; }

    }
}