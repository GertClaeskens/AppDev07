using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Finah_Backend.Models
{
    using System.ComponentModel.DataAnnotations;

    public class Foto
    {
        #region Public members
        public int Id { get; set; }
        public string Omschrijving { get; set; }

        public string Pad { get; set; }
        #endregion
    }
}