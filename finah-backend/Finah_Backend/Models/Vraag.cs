namespace Finah_Backend.Models
{
    public class Vraag
    {
        #region Public members

        public int Id { get; set; }

        public string VraagStelling { get; set; }

        public virtual Foto Afbeelding { get; set; }

        public virtual GeluidsFragment Geluid { get; set; }

        #endregion Public members
    }
}