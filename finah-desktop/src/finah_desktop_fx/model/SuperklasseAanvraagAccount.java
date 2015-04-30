package finah_desktop_fx.model;

import finah_desktop_fx.enums.TypeAccount;

public abstract class SuperklasseAanvraagAccount {
	public int Id;

	public String Naam;
	public String VoorNaam;

	public String RijksRegisterNr;

	public String Adres;

	public String Telnr;

	public String Gsm;

	public String Login;

	public String Passwd;
	public String Email;

	public String GeheimeVraag;

	public String GeheimAntwoord;

	public TypeAccount TypeAcc;



	public Postcode Postcd;

	public SuperklasseAanvraagAccount() {
	}



	public SuperklasseAanvraagAccount(int id, String naam, String voorNaam,
			String rijksRegisterNr, String adres, String telnr, String gsm,
			String login, String passwd, String email, String geheimeVraag,
			String geheimAntwoord, TypeAccount typeAcc, Postcode postcd) {
		super();
		Id = id;
		Naam = naam;
		VoorNaam = voorNaam;
		RijksRegisterNr = rijksRegisterNr;
		Adres = adres;
		Telnr = telnr;
		Gsm = gsm;
		Login = login;
		Passwd = passwd;
		this.Email = email;
		GeheimeVraag = geheimeVraag;
		GeheimAntwoord = geheimAntwoord;
		TypeAcc = typeAcc;
		Postcd = postcd;
	}



	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getNaam() {
		return Naam;
	}

	public void setNaam(String naam) {
		Naam = naam;
	}

	public String getVoorNaam() {
		return VoorNaam;
	}

	public void setVoorNaam(String voorNaam) {
		VoorNaam = voorNaam;
	}

	public String getRijksRegisterNr() {
		return RijksRegisterNr;
	}

	public void setRijksRegisterNr(String rijksRegisterNr) {
		RijksRegisterNr = rijksRegisterNr;
	}

	public String getAdres() {
		return Adres;
	}

	public void setAdres(String adres) {
		Adres = adres;
	}

	public String getTelnr() {
		return Telnr;
	}

	public void setTelnr(String telnr) {
		Telnr = telnr;
	}

	public String getGsm() {
		return Gsm;
	}

	public void setGsm(String gsm) {
		Gsm = gsm;
	}

	public String getLogin() {
		return Login;
	}

	public void setLogin(String login) {
		Login = login;
	}

	public String getPasswd() {
		return Passwd;
	}

	public void setPasswd(String passwd) {
		Passwd = passwd;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return Email;
	}



	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.Email = email;
	}



	public String getGeheimeVraag() {
		return GeheimeVraag;
	}

	public void setGeheimeVraag(String geheimeVraag) {
		GeheimeVraag = geheimeVraag;
	}

	public String getGeheimAntwoord() {
		return GeheimAntwoord;
	}

	public void setGeheimAntwoord(String geheimAntwoord) {
		GeheimAntwoord = geheimAntwoord;
	}

	public TypeAccount getTypeAcc() {
		return TypeAcc;
	}

	public void setTypeAcc(TypeAccount typeAcc) {
		TypeAcc = typeAcc;
	}

	public Postcode getPostcd() {
		return Postcd;
	}

	public void setPostcd(Postcode postcd) {
		Postcd = postcd;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Adres == null) ? 0 : Adres.hashCode());
		result = prime * result
				+ ((GeheimAntwoord == null) ? 0 : GeheimAntwoord.hashCode());
		result = prime * result
				+ ((GeheimeVraag == null) ? 0 : GeheimeVraag.hashCode());
		result = prime * result + ((Gsm == null) ? 0 : Gsm.hashCode());
		result = prime * result + Id;
		result = prime * result + ((Login == null) ? 0 : Login.hashCode());
		result = prime * result + ((Naam == null) ? 0 : Naam.hashCode());
		result = prime * result + ((Passwd == null) ? 0 : Passwd.hashCode());
		result = prime * result + ((Postcd == null) ? 0 : Postcd.hashCode());
		result = prime * result
				+ ((RijksRegisterNr == null) ? 0 : RijksRegisterNr.hashCode());
		result = prime * result + ((Telnr == null) ? 0 : Telnr.hashCode());
		result = prime * result + ((TypeAcc == null) ? 0 : TypeAcc.hashCode());
		result = prime * result
				+ ((VoorNaam == null) ? 0 : VoorNaam.hashCode());
		result = prime * result + ((Email == null) ? 0 : Email.hashCode());
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
		if (Adres == null) {
			if (other.Adres != null)
				return false;
		} else if (!Adres.equals(other.Adres))
			return false;
		if (GeheimAntwoord == null) {
			if (other.GeheimAntwoord != null)
				return false;
		} else if (!GeheimAntwoord.equals(other.GeheimAntwoord))
			return false;
		if (GeheimeVraag == null) {
			if (other.GeheimeVraag != null)
				return false;
		} else if (!GeheimeVraag.equals(other.GeheimeVraag))
			return false;
		if (Gsm == null) {
			if (other.Gsm != null)
				return false;
		} else if (!Gsm.equals(other.Gsm))
			return false;
		if (Id != other.Id)
			return false;
		if (Login == null) {
			if (other.Login != null)
				return false;
		} else if (!Login.equals(other.Login))
			return false;
		if (Naam == null) {
			if (other.Naam != null)
				return false;
		} else if (!Naam.equals(other.Naam))
			return false;
		if (Passwd == null) {
			if (other.Passwd != null)
				return false;
		} else if (!Passwd.equals(other.Passwd))
			return false;
		if (Postcd == null) {
			if (other.Postcd != null)
				return false;
		} else if (!Postcd.equals(other.Postcd))
			return false;
		if (RijksRegisterNr == null) {
			if (other.RijksRegisterNr != null)
				return false;
		} else if (!RijksRegisterNr.equals(other.RijksRegisterNr))
			return false;
		if (Telnr == null) {
			if (other.Telnr != null)
				return false;
		} else if (!Telnr.equals(other.Telnr))
			return false;
		if (TypeAcc != other.TypeAcc)
			return false;
		if (VoorNaam == null) {
			if (other.VoorNaam != null)
				return false;
		} else if (!VoorNaam.equals(other.VoorNaam))
			return false;
		if (Email == null) {
			if (other.Email != null)
				return false;
		} else if (!Email.equals(other.Email))
			return false;
		return true;
	}





}
