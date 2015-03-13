using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Finah_Web.Models
{
    public class MediaFile
    {
        /// <summary>
        /// Foto's en geluidsfragmenten erven van deze klasse over
        /// </summary>

        #region Public members
        public virtual int Id { get; set; }
        public string Omschrijving { get; set; }

        public string Pad { get; set; }
        #endregion
    }
}