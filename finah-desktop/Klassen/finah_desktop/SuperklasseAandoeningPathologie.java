package finah_desktop;

public abstract class SuperklasseAandoeningPathologie {
	private int id;
	private String naam;

	public SuperklasseAandoeningPathologie() {

	}

	public SuperklasseAandoeningPathologie(String naam) {
		this.naam = naam;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}
}
