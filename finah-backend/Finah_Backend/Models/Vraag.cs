using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Finah_Backend.Models
{

    public class Vraag
    {
        #region Public members
        public int Id;

        public string VraagStelling;

        public Foto Afbeelding;

        public GeluidsFragment Geluid;
        #endregion
    }
}