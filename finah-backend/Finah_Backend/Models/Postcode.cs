namespace Finah_Backend.Models
{
    public class Postcode
    {
        #region Private members
        private int id;

        private int postnr;

        private string gemeente;
        #endregion
        #region Public members
        public int Id { get; set; }

        public int Postnr { get; set; }

        public string Gemeente { get; set; }
        #endregion
    }
}