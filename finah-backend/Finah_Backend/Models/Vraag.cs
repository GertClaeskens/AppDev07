﻿namespace Finah_Backend.Models
{
    using System.Collections;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;

    public class Vraag
    {
        #region Public members

        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public int Id { get; set; }

        public string VraagStelling { get; set; }

        //public int ThemaId { get; set; }
        public virtual Thema Thema { get; set; }
        public virtual Foto Afbeelding { get; set; }

        public virtual GeluidsFragment Geluid { get; set; }
        public virtual ICollection<VragenLijst> VragenLijst { get; set; }

        #endregion Public members
    }
}