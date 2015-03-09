using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Finah_Backend.Models
{
    public class Vraag
    {
        #region Private members
        private int id;

        private string vraagStelling;

        private Foto afbeelding;

        private GeluidsFragment geluid;
        #endregion

        #region Public members
        public int Id;

        public string VraagStelling;

        public Foto Afbeelding;

        public GeluidsFragment Geluid;
        #endregion
    }
}