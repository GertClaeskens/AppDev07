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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adres == null) ? 0 : adres.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((geheimAntwoord == null) ? 0 : geheimAntwoord.hashCode());
		result = prime * result
				+ ((geheimeVraag == null) ? 0 : geheimeVraag.hashCode());
		result = prime * result + gsm;
		result = prime * result + id;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((naam == null) ? 0 : naam.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((rijksregisterNr == null) ? 0 : rijksregisterNr.hashCode());
		result = prime * result + telefoon;
		result = prime * result + ((typeAcc == null) ? 0 : typeAcc.hashCode());
		result = prime * result
				+ ((voornaam == null) ? 0 : voornaam.hashCode());
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
		SuperklasseAanvraagAccount other = (SuperklasseAanvraagAccount) obj;
		if (adres == null) {
			if (other.adres != null)
				return false;
		} else if (!adres.equals(other.adres))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (geheimAntwoord == null) {
			if (other.geheimAntwoord != null)
				return false;
		} else if (!geheimAntwoord.equals(other.geheimAntwoord))
			return false;
		if (geheimeVraag == null) {
			if (other.geheimeVraag != null)
				return false;
		} else if (!geheimeVraag.equals(other.geheimeVraag))
			return false;
		if (gsm != other.gsm)
			return false;
		if (id != other.id)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (naam == null) {
			if (other.naam != null)
				return false;
		} else if (!naam.equals(other.naam))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (rijksregisterNr == null) {
			if (other.rijksregisterNr != null)
				return false;
		} else if (!rijksregisterNr.equals(other.rijksregisterNr))
			return false;
		if (telefoon != other.telefoon)
			return false;
		if (typeAcc != other.typeAcc)
			return false;
		if (voornaam == null) {
			if (other.voornaam != null)
				return false;
		} else if (!voornaam.equals(other.voornaam))
			return false;
		return true;
	}
}
