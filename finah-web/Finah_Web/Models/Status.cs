using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Finah_Web.Models
{
    public class Status
    {
        public int Id { get; set; }

        public Account BeoordeeldDoor { get; set; }

        public DateTime BeoordeeldOp { get; set; }
    }
}