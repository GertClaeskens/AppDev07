using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Finah_Backend.Models
{
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;

    public class VragenLijst
    {
        [Key]
        public int Id { get; set; }
        public List<Vraag> Vragen { get; set; }

        [ForeignKey("Id")]
        public Aandoening Aandoe { get; set; }

        [ForeignKey("Id")]
        public Pathologie Patholo { get; set; }
    }
}