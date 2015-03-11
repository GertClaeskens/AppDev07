package finah_desktop;

public class Account extends SuperklasseAanvraagAccount {

	private EID gekoppelde_eid;
	public EID getGekoppelde_eid() {
		return gekoppelde_eid;
	}

	public void setGekoppelde_eid(EID gekoppelde_eid) {
		this.gekoppelde_eid = gekoppelde_eid;
	}

	public Account() {
	}

	public Account(String naam, String voornaam, String rijksregisterNr,
			String adres, int telefoon, int gsm, String login, String password,
			String email, String geheimeVraag, String geheimAntwoord,TypeAccount typeAcc) {
		super(naam, voornaam, rijksregisterNr, adres, telefoon, gsm, login,
				password, email, geheimeVraag, geheimAntwoord,typeAcc);

	}
	
}
