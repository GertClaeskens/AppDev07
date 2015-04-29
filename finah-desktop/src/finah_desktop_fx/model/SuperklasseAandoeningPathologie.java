package finah_desktop_fx.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public abstract class SuperklasseAandoeningPathologie {
	protected IntegerProperty Id;
	protected StringProperty Omschrijving;

	public SuperklasseAandoeningPathologie() {

	}

	public SuperklasseAandoeningPathologie(String omschrijving) {
		this.Omschrijving.set(omschrijving);
	}

	public int getId() {
		return Id.get();
	}

	public void setId(int id) {
		this.Id.set(id);
	}
	public String getOmschrijving() {
		return Omschrijving.get();
	}

	public void setOmschrijving(String omschrijving) {
		this.Omschrijving.set(omschrijving);
	}
    public StringProperty omschrijvingProperty() {
        return Omschrijving;
    }
    public IntegerProperty idProperty() {
        return Id;
    }
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Id.get();
		result = prime * result
				+ ((Omschrijving == null) ? 0 : Omschrijving.hashCode());
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
