using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Finah_Backend.Models
{
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    public class Status
    {
        [Key]
        public int Id { get; set; }


        [ForeignKey("Id")]
        public Account BeoordeeldDoor { get; set; }

        public DateTime BeoordeeldOp { get; set; }
    
    }
}