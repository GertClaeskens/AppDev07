using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Finah_Web.Models
{
    public class Postcode
    {
        #region Public members
        public int Id { get; set; }

        public int Postnr { get; set; }

        public string Gemeente { get; set; }
        #endregion
    }
}