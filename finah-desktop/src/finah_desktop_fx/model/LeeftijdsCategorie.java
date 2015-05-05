package finah_desktop_fx.model;

public class LeeftijdsCategorie {

	private int Id;
	private int Van;
	private int Tot;

	public LeeftijdsCategorie() {

	}

	public LeeftijdsCategorie(int van, int tot) {
		this.Van = van;
		this.Tot = tot;
	}

	public int getId() {
		return Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}

	public int getVan() {
		return Van;
	}

	public void setVan(int van) {
		this.Van = van;
	}

	public int getTot() {
		return Tot;
	}

	public void setTot(int tot) {
		this.Tot = tot;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Id;
		result = prime * result + Tot;
		result = prime * result + Van;
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
		LeeftijdsCategorie other = (LeeftijdsCategorie) obj;
		if (Id != other.Id)
			return false;
		if (Tot != other.Tot)
			return false;
		if (Van != other.Van)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return Van + " - " + Tot;
	}


}
