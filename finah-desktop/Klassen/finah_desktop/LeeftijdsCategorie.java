package finah_desktop;

public class LeeftijdsCategorie {

	private int Id;
	private int van;
	private int tot;

	public LeeftijdsCategorie() {

	}

	public LeeftijdsCategorie(int van, int tot) {
		this.van = van;
		this.tot = tot;
	}

	public int getId() {
		return Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}

	public int getVan() {
		return van;
	}

	public void setVan(int van) {
		this.van = van;
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Id;
		result = prime * result + tot;
		result = prime * result + van;
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
		if (tot != other.tot)
			return false;
		if (van != other.van)
			return false;
		return true;
	}
}
