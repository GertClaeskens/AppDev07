using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Finah_Web.Models
{
    public class LeeftijdsCategorie
    {
        //Hier ook eventueel een enum

        #region Public members
        public int Id { get; set; }

        //Van en Tot : hiervoor volstaat een ushort : leeftijd kan niet negatief zijn 
        public ushort Van { get; set; }
        public ushort Tot { get; set; }
        #endregion
    }
}