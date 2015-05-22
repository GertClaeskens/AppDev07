package finah_desktop_fx.model;

public abstract class SuperklasseAandoeningPathologie {
	protected int Id;
	protected String Omschrijving;

	public SuperklasseAandoeningPathologie() {

	}

	public SuperklasseAandoeningPathologie(String omschrijving) {
		this.Omschrijving = omschrijving;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		this.Id = id;
	}



	public String getOmschrijving() {
		return Omschrijving;
	}

	public void setOmschrijving(String omschrijving) {
		this.Omschrijving = omschrijving;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Id;
		result = prime * result
				+ ((Omschrijving == null) ? 0 : Omschrijving.hashCode());
		return result;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SuperklasseAandoeningPathologie other = (SuperklasseAandoeningPathologie) obj;
		if (Id != other.Id)
			return false;
		if (Omschrijving == null) {
			if (other.Omschrijving != null)
				return false;
		} else if (!Omschrijving.equals(other.Omschrijving))
			return false;
		return true;
	}
}
