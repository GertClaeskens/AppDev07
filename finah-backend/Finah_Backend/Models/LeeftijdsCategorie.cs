using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Finah_Backend.Models
{
    using System.ComponentModel.DataAnnotations;

    public class LeeftijdsCategorie
    {
        //Hier ook eventueel een enum

        #region Public members
        [Key]
        public int Id;
        
        //Van en Tot : hiervoor volstaat een ushort : leeftijd kan niet negatief zijn 
        public ushort Van;
        public ushort Tot;
        #endregion

    }
}