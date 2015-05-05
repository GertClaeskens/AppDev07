using System.Collections.Generic;

namespace Finah_Backend.Models
{
    public class VragenLijst
    {
        public VragenLijst()
        {
            this.Vragen = new List<Vraag>();
        }

        public int? Id { get; set; }

        public virtual ICollection<Vraag> Vragen { get; set; }

        public virtual Aandoening Aandoe { get; set; }

        //public virtual Pathologie Patholo { get; set; }
    }
}