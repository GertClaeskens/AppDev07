using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Finah_Backend.Models
{
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;

    public class Vraag
    {
        #region Public members
        [Key]
        public int Id;

        public string VraagStelling;

        [ForeignKey("Id")]
        public Foto Afbeelding;

        [ForeignKey("Id")]
        public GeluidsFragment Geluid;
        #endregion
    }
}