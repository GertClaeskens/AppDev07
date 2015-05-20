using System.Collections.Generic;

namespace Finah_Backend.Models
{
    using System.ComponentModel.DataAnnotations.Schema;

    public class VragenLijst
    {

        public VragenLijst()
        {
            this.Vragen = new List<Vraag>();
        }

        public int Id { get; set; }
        public string Omschrijving { get; set; }

        public virtual ICollection<Vraag> Vragen { get; set; }

        //[ForeignKey("Aandoe")]
        //public int AandoeId { get; set; }
        public virtual Aandoening Aandoe { get; set; }

        //public virtual Pathologie Patholo { get; set; }
    }
}