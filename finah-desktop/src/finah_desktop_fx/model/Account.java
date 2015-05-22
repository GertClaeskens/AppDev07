package finah_desktop_fx.model;

import finah_desktop_fx.enums.TypeAccount;

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

	public Account(int id,String naam, String voornaam, String rijksregisterNr,
			String adres, String telefoon, String gsm, String login, String password,
			String email, String geheimeVraag, String geheimAntwoord,TypeAccount typeAcc,Postcode postcd) {
		super(id,naam, voornaam, rijksregisterNr, adres, telefoon, gsm, login,
				password, email, geheimeVraag, geheimAntwoord,typeAcc,postcd);

	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((gekoppelde_eid == null) ? 0 : gekoppelde_eid.hashCode());
		return result;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (gekoppelde_eid == null) {
			if (other.gekoppelde_eid != null)
				return false;
		} else if (!gekoppelde_eid.equals(other.gekoppelde_eid))
			return false;
		return true;
	}
	
}
