namespace Finah_Backend.Models
{
    using System.Collections.Generic;

    using Newtonsoft.Json;

    //[JsonObject(IsReference = true)]
    public class Pathologie
    {
        private ICollection<Aandoening> aandoeningen;
        public int Id { get; set; }

        public string Omschrijving { get; set; }
        public virtual ICollection<Aandoening> Aandoeningen { get; set; }

        public Pathologie()
        {
            aandoeningen = new List<Aandoening>();
        }
        public void voegAandoeningToe(Aandoening aand)
        {
            aandoeningen.Add(aand);
        }

        public void verwijderAandoening(Aandoening aand)
        {
            aandoeningen.Remove(aand);
        }
    }
}