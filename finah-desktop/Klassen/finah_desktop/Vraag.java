package finah_desktop;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;



public class Vraag {
	private int id;
	private String vraagstelling;
	private Foto afbeelding;
	private GeluidsFragment geluidsfragment;

	public Vraag() {

	}

	public Vraag(String vraagstelling, Foto afbeelding, GeluidsFragment geluidsfragment) {
		this.vraagstelling = vraagstelling;
		this.afbeelding = afbeelding;
		this.geluidsfragment = geluidsfragment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVraagstelling() {
		return vraagstelling;
	}

	public void setVraagstelling(String vraagstelling) {
		this.vraagstelling = vraagstelling;
	}

	public Foto getAfbeelding() {
		return afbeelding;
	}

	public void setAfbeelding(Foto afbeelding) {
		this.afbeelding = afbeelding;
	}

	public GeluidsFragment getGeluidsfragment() {
		return geluidsfragment;
	}

	public void setGeluidsfragment(GeluidsFragment geluidsfragment) {
		this.geluidsfragment = geluidsfragment;
	}

	public static ArrayList<String> getKolommen(){
		ArrayList<String> kol = new ArrayList<String>();
		kol.add("Id");
		kol.add("Vraagstelling");
		kol.add("Afbeelding");
		kol.add("Geluidsfragment");
		return kol;
	}
}
