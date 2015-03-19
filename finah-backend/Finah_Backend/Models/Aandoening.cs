using System.Collections.Generic;

namespace Finah_Backend.Models
{
    public class Aandoening
    {
        private ICollection<Pathologie> patologieen;

        public Aandoening()
        {
            patologieen = new List<Pathologie>();
        }

        public int Id { get; set; }

        public string Omschrijving { get; set; }

        public virtual ICollection<Pathologie> Patologieen { get; set; }
    }
}