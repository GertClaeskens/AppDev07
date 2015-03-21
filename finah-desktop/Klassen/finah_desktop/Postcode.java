package finah_desktop;

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

}
