package finah_desktop;

import java.util.ArrayList;

public class AntwoordenLijst {

    private String Id;

    public ArrayList<Antwoord> Antwoorden;

    public AntwoordenLijst()
    {
        this.Antwoorden = new ArrayList<Antwoord>();
    }
	public AntwoordenLijst(String id) {
		this();
		Id = id;
		
	}
	public AntwoordenLijst(String id, ArrayList<Antwoord> antwoorden) {
		this(id);
		Antwoorden = antwoorden;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((Antwoorden == null) ? 0 : Antwoorden.hashCode());
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AntwoordenLijst other = (AntwoordenLijst) obj;
		if (Antwoorden == null) {
			if (other.Antwoorden != null)
				return false;
		} else if (!Antwoorden.equals(other.Antwoorden))
			return false;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		return true;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public ArrayList<Antwoord> getAntwoorden() {
		return Antwoorden;
	}
	public void setAntwoorden(ArrayList<Antwoord> antwoorden) {
		Antwoorden = antwoorden;
	}
}
