package finah_desktop;

public class Aanvraag extends SuperklasseAanvraagAccount {

	private Account beoordeeld_door;
	private boolean goedgekeurd;
	public Account getBeoordeeld_door() {
		return beoordeeld_door;
	}

	public void setBeoordeeld_door(Account beoordeeld_door) {
		this.beoordeeld_door = beoordeeld_door;
	}

	public boolean isGoedgekeurd() {
		return goedgekeurd;
	}

	public void setGoedgekeurd(boolean goedgekeurd) {
		this.goedgekeurd = goedgekeurd;
	}

	public Aanvraag() {
	}

	public Aanvraag(String naam, String voornaam, String rijksregisterNr,
			String adres, int telefoon, int gsm, String login, String password,
			String email, String geheimeVraag, String geheimAntwoord,TypeAccount typeAcc) {
		super(naam, voornaam, rijksregisterNr, adres, telefoon, gsm, login,
				password, email, geheimeVraag, geheimAntwoord,typeAcc);
	}

}
