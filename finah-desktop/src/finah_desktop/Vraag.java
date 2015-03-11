package finah_desktop;

public class Vraag {
	private int id;
	private String vraagstelling;
	private Foto afbeelding;
	private Geluid geluidsfragment;

	public Vraag() {

	}

	public Vraag(String vraagstelling, Foto afbeelding, Geluid geluidsfragment) {
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

	public Geluid getGeluidsfragment() {
		return geluidsfragment;
	}

	public void setGeluidsfragment(Geluid geluidsfragment) {
		this.geluidsfragment = geluidsfragment;
	}
}
