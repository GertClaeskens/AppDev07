package finah_desktop;

import java.util.ArrayList;



public class Vraag {
	private int id;
	private String vraagstelling;
	private Foto afbeelding;
	private GeluidsFragment geluidsfragment;

	public Vraag() {

	}

	public Vraag(String vraagstelling, Foto afbeelding, GeluidsFragment geluidsfragment) {
		this.vraagstelling = vraagstelling;
		this.afbeelding = afbeelding;
		this.geluidsfragment = geluidsfragment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVraagstelling() {
		return vraagstelling;
	}

	public void setVraagstelling(String vraagstelling) {
		this.vraagstelling = vraagstelling;
	}

	public Foto getAfbeelding() {
		return afbeelding;
	}

	public void setAfbeelding(Foto afbeelding) {
		this.afbeelding = afbeelding;
	}

	public GeluidsFragment getGeluidsfragment() {
		return geluidsfragment;
	}

	public void setGeluidsfragment(GeluidsFragment geluidsfragment) {
		this.geluidsfragment = geluidsfragment;
	}

	public static ArrayList<String> getKolommen(){
		ArrayList<String> kol = new ArrayList<String>();
		kol.add("Id");
		kol.add("Vraagstelling");
		kol.add("Afbeelding");
		kol.add("Geluidsfragment");
		return kol;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((afbeelding == null) ? 0 : afbeelding.hashCode());
		result = prime * result
				+ ((geluidsfragment == null) ? 0 : geluidsfragment.hashCode());
		result = prime * result + id;
		result = prime * result
				+ ((vraagstelling == null) ? 0 : vraagstelling.hashCode());
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
		Vraag other = (Vraag) obj;
		if (afbeelding == null) {
			if (other.afbeelding != null)
				return false;
		} else if (!afbeelding.equals(other.afbeelding))
			return false;
		if (geluidsfragment == null) {
			if (other.geluidsfragment != null)
				return false;
		} else if (!geluidsfragment.equals(other.geluidsfragment))
			return false;
		if (id != other.id)
			return false;
		if (vraagstelling == null) {
			if (other.vraagstelling != null)
				return false;
		} else if (!vraagstelling.equals(other.vraagstelling))
			return false;
		return true;
	}
}
