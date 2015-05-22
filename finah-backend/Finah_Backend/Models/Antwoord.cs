using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Finah_Backend.Models
{
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Dynamic;

    public class Antwoord
    {
        public int Id { get; set; }
        public int Antword { get; set; }


    }
}