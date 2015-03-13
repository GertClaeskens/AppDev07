using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Finah_Web.Models
{
    public class Vraag
    {
        #region Public members
        public int Id { get; set; }

        public string VraagStelling { get; set; }

        public Foto Afbeelding { get; set; }

        public GeluidsFragment Geluid { get; set; }
        #endregion
    }
}