package finah_desktop;

public abstract class Media {
	private int id;
	private String omschrijving;
	private String pad;

	public Media() {

	}

	public Media(String omschrijving, String pad) {
		this.omschrijving = omschrijving;
		this.pad = pad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOmschrijving() {
		return omschrijving;
	}

	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}

	public String getPad() {
		return pad;
	}

	public void setPad(String pad) {
		this.pad = pad;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result
				+ ((omschrijving == null) ? 0 : omschrijving.hashCode());
		result = prime * result + ((pad == null) ? 0 : pad.hashCode());
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
		if (id != other.id)
			return false;
		if (omschrijving == null) {
			if (other.omschrijving != null)
				return false;
		} else if (!omschrijving.equals(other.omschrijving))
			return false;
		if (pad == null) {
			if (other.pad != null)
				return false;
		} else if (!pad.equals(other.pad))
			return false;
		return true;
	}
}
