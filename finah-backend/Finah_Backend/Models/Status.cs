using System;

namespace Finah_Backend.Models
{
    public class Status
    {
        public int Id { get; set; }

        public virtual Account BeoordeeldDoor { get; set; }

        public DateTime BeoordeeldOp { get; set; }
    }
}