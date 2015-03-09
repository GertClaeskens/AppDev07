using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Finah_Backend.Models
{
    public class MediaFile
    {
        /// <summary>
        /// Foto's en geluidsfragmenten erven van deze klasse over
        /// </summary>
        #region Private members
        private int id;

        private string omschrijving;

        private string pad;
        #endregion

        #region Public members
        public int Id { get; set; }
        public string Omschrijving { get; set; }

        public string Pad;
        #endregion
    }
}