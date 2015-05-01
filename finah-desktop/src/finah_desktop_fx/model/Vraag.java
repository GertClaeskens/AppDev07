package finah_desktop_fx.model;

public class Vraag {
	private int Id;
	private String VraagStelling;
	private Foto Afbeelding;
	private GeluidsFragment Geluid;

	public Vraag() {

	}

	public Vraag(int id, String vraagstelling, Foto afbeelding,
			GeluidsFragment geluid) {
		super();
		Id = id;
		VraagStelling = vraagstelling;
		Afbeelding = afbeelding;
		Geluid = geluid;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getVraagstelling() {
		return VraagStelling;
	}

	public void setVraagstelling(String vraagstelling) {
		VraagStelling = vraagstelling;
	}

	public Foto getAfbeelding() {
		return Afbeelding;
	}

	public void setAfbeelding(Foto afbeelding) {
		Afbeelding = afbeelding;
	}

	public GeluidsFragment getGeluid() {
		return Geluid;
	}

	public void setGeluid(GeluidsFragment geluid) {
		Geluid = geluid;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((Afbeelding == null) ? 0 : Afbeelding.hashCode());
		result = prime * result + ((Geluid == null) ? 0 : Geluid.hashCode());
		result = prime * result + Id;
		result = prime * result
				+ ((VraagStelling == null) ? 0 : VraagStelling.hashCode());
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
		if (Afbeelding == null) {
			if (other.Afbeelding != null)
				return false;
		} else if (!Afbeelding.equals(other.Afbeelding))
			return false;
		if (Geluid == null) {
			if (other.Geluid != null)
				return false;
		} else if (!Geluid.equals(other.Geluid))
			return false;
		if (Id != other.Id)
			return false;
		if (VraagStelling == null) {
			if (other.VraagStelling != null)
				return false;
		} else if (!VraagStelling.equals(other.VraagStelling))
			return false;
		return true;
	}
}