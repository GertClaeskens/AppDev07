﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Finah_Backend.Models
{
    using System.ComponentModel.DataAnnotations;

    public class GeluidsFragment : MediaFile
    {
        [Key]
        public override int Id { get; set; }
    }
}