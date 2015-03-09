﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Finah_Backend.Models
{
    using System.ComponentModel.DataAnnotations;

    public abstract class MediaFile
    {
        /// <summary>
        /// Foto's en geluidsfragmenten erven van deze klasse over
        /// </summary>

        #region Public members
        [Key]
        public virtual int Id { get; set; }
        public string Omschrijving { get; set; }

        public string Pad;
        #endregion
    }
}