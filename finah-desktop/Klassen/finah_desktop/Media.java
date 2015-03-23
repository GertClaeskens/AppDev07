package finah_desktop;

public abstract class Media {
	private int Id;
	private String Omschrijving;
	private String Pad;

	public Media() {

	}

	public Media(int id, String omschrijving, String pad) {
		super();
		Id = id;
		Omschrijving = omschrijving;
		Pad = pad;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getOmschrijving() {
		return Omschrijving;
	}

	public void setOmschrijving(String omschrijving) {
		Omschrijving = omschrijving;
	}

	public String getPad() {
		return Pad;
	}

	public void setPad(String pad) {
		Pad = pad;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Id;
		result = prime * result
				+ ((Omschrijving == null) ? 0 : Omschrijving.hashCode());
		result = prime * result + ((Pad == null) ? 0 : Pad.hashCode());
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
		Media other = (Media) obj;
		if (Id != other.Id)
			return false;
		if (Omschrijving == null) {
			if (other.Omschrijving != null)
				return false;
		} else if (!Omschrijving.equals(other.Omschrijving))
			return false;
		if (Pad == null) {
			if (other.Pad != null)
				return false;
		} else if (!Pad.equals(other.Pad))
			return false;
		return true;
	}

	
}
