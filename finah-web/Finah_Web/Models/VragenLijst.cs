using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Finah_Web.Models
{
    public class VragenLijst
    {
        public int Id { get; set; }
        public List<Vraag> Vragen { get; set; }

        public Aandoening Aandoe { get; set; }

        public Pathologie Patholo { get; set; }
    }
}