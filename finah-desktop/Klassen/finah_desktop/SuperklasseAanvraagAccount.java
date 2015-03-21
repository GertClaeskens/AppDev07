package finah_desktop;

public abstract class SuperklasseAanvraagAccount {
	private int id;
	private String naam;
	private String voornaam;
	private String rijksregisterNr;
	private String adres;
	private int telefoon;
	private int gsm;
	private String login;
	private String password;
	private String email;
	private String geheimeVraag;
	private String geheimAntwoord;
	private TypeAccount typeAcc;

	public SuperklasseAanvraagAccount() {
	}

	public SuperklasseAanvraagAccount(String naam, String voornaam,
			String rijksregisterNr, String adres, int telefoon, int gsm,
			String login, String password, String email, String geheimeVraag,
			String geheimAntwoord,TypeAccount typeAcc) {
		this.naam = naam;
		this.voornaam = voornaam;
		this.rijksregisterNr = rijksregisterNr;
		this.adres = adres;
		this.telefoon = telefoon;
		this.gsm = gsm;
		this.login = login;
		this.password = password;
		this.email = email;
		this.geheimeVraag = geheimeVraag;
		this.geheimAntwoord = geheimAntwoord;
		this.typeAcc=typeAcc;
	}

	public TypeAccount getTypeAcc() {
		return typeAcc;
	}

	public void setTypeAcc(TypeAccount typeAcc) {
		this.typeAcc = typeAcc;
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

	public String getVoornaam() {
		return voornaam;
	}

	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}

	public String getRijksregisterNr() {
		return rijksregisterNr;
	}

	public void setRijksregisterNr(String rijksregisterNr) {
		this.rijksregisterNr = rijksregisterNr;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public int getTelefoon() {
		return telefoon;
	}

	public void setTelefoon(int telefoon) {
		this.telefoon = telefoon;
	}

	public int getGsm() {
		return gsm;
	}

	public void setGsm(int gsm) {
		this.gsm = gsm;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGeheimeVraag() {
		return geheimeVraag;
	}

	public void setGeheimeVraag(String geheimeVraag) {
		this.geheimeVraag = geheimeVraag;
	}

	public String getGeheimAntwoord() {
		return geheimAntwoord;
	}

	public void setGeheimAntwoord(String geheimAntwoord) {
		this.geheimAntwoord = geheimAntwoord;
	}
}
