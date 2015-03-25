using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Finah_Web.Models
{
    public class Aandoening : SuperKlasseAandoeningPathologie
    {
        private ICollection<Pathologie> patologieen;

        public Aandoening()
        {
            patologieen = new List<Pathologie>();
        }

        public virtual ICollection<Pathologie> Patologieen { get; set; }
    }
}
