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
}
