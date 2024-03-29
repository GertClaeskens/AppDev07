package finah_desktop_fx.model;

public class Thema {

	
	private int Id;
	private String Naam;
	public Thema() {
		super();
	}
	public Thema(String naam) {
		super();
		Naam = naam;
	}
	public String getNaam() {
		return Naam;
	}
	public void setNaam(String naam) {
		Naam = naam;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Id;
		result = prime * result + ((Naam == null) ? 0 : Naam.hashCode());
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
		Thema other = (Thema) obj;
		if (Id != other.Id)
			return false;
		if (Naam == null) {
			if (other.Naam != null)
				return false;
		} else if (!Naam.equals(other.Naam))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return Naam;
	}
	
	
}
