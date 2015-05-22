package finah_desktop_fx.model;

import java.util.ArrayList;

public class Postcode {
	private int Id;
	private int Postnr;
	private String Gemeente;

	public Postcode() {

	}

	public Postcode(int postcode, String gemeente) {
		this.Postnr = postcode;
		this.Gemeente = gemeente;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getPostnr() {
		return Postnr;
	}

	public void setPostnr(int postnr) {
		Postnr = postnr;
	}

	public String getGemeente() {
		return Gemeente;
	}

	public void setGemeente(String gemeente) {
		Gemeente = gemeente;
	}
	public static ArrayList<String> getKolommen(){
		ArrayList<String> kol = new ArrayList<String>();
		kol.add("Id");
		kol.add("Postnr");
		kol.add("Gemeente");
		
		return kol;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((Gemeente == null) ? 0 : Gemeente.hashCode());
		result = prime * result + Id;
		result = prime * result + Postnr;
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
		Postcode other = (Postcode) obj;
		if (Gemeente == null) {
			if (other.Gemeente != null)
				return false;
		} else if (!Gemeente.equals(other.Gemeente))
			return false;
		if (Id != other.Id)
			return false;
		if (Postnr != other.Postnr)
			return false;
		return true;
	}

}
