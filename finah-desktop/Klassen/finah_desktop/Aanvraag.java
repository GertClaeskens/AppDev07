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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((beoordeeld_door == null) ? 0 : beoordeeld_door.hashCode());
		result = prime * result + (goedgekeurd ? 1231 : 1237);
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aanvraag other = (Aanvraag) obj;
		if (beoordeeld_door == null) {
			if (other.beoordeeld_door != null)
				return false;
		} else if (!beoordeeld_door.equals(other.beoordeeld_door))
			return false;
		if (goedgekeurd != other.goedgekeurd)
			return false;
		return true;
	}



}
