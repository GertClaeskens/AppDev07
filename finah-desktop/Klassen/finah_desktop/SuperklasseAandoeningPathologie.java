package finah_desktop;

public abstract class SuperklasseAandoeningPathologie {
	private int Id;
	private String Omschrijving;

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
}
