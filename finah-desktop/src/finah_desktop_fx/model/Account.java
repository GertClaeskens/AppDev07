package finah_desktop_fx.model;

import finah_desktop_fx.enums.TypeAccount;

public class Account extends SuperklasseAanvraagAccount {

	public Account() {
	}

	public Account(int id,String naam, String voornaam, String rijksregisterNr,
			String adres, String telefoon, String gsm, String login, String password,
			String email, String geheimeVraag, String geheimAntwoord,TypeAccount typeAcc,Postcode postcd) {
		super(id,naam, voornaam, rijksregisterNr, adres, telefoon, gsm, login,
				password, email, geheimeVraag, geheimAntwoord,typeAcc,postcd);

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
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
		Account other = (Account) obj;
		return true;
	}
	
}
