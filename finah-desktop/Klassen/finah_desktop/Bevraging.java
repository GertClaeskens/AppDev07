package finah_desktop;

import java.util.Date;

public class Bevraging {
	public String Id;
	public Date Aangevraagd;
	public LeeftijdsCategorie LeeftijdsCatPatient;
	public LeeftijdsCategorie LeeftijdsCatMantelZorger;
	public String Informatie;

	// Ook eventueel enum van maken
	public String Relatie;
	public Account AangemaaktDoor;
	public VragenLijst Vragenpatient;
	public VragenLijst VragenMantelzorger;
	
	public Bevraging() {
	}

	public Bevraging(String id, Date aangevraagd,
			LeeftijdsCategorie leeftijdsCatPatient,
			LeeftijdsCategorie leeftijdsCatMantelZorger, String informatie,
			String relatie, Account aangemaaktDoor, VragenLijst vragenpatient,
			VragenLijst vragenMantelzorger) {
		super();
		Id = id;
		Aangevraagd = aangevraagd;
		LeeftijdsCatPatient = leeftijdsCatPatient;
		LeeftijdsCatMantelZorger = leeftijdsCatMantelZorger;
		Informatie = informatie;
		Relatie = relatie;
		AangemaaktDoor = aangemaaktDoor;
		Vragenpatient = vragenpatient;
		VragenMantelzorger = vragenMantelzorger;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public Date getAangevraagd() {
		return Aangevraagd;
	}

	public void setAangevraagd(Date aangevraagd) {
		Aangevraagd = aangevraagd;
	}

	public LeeftijdsCategorie getLeeftijdsCatPatient() {
		return LeeftijdsCatPatient;
	}

	public void setLeeftijdsCatPatient(LeeftijdsCategorie leeftijdsCatPatient) {
		LeeftijdsCatPatient = leeftijdsCatPatient;
	}

	public LeeftijdsCategorie getLeeftijdsCatMantelZorger() {
		return LeeftijdsCatMantelZorger;
	}

	public void setLeeftijdsCatMantelZorger(
			LeeftijdsCategorie leeftijdsCatMantelZorger) {
		LeeftijdsCatMantelZorger = leeftijdsCatMantelZorger;
	}

	public String getInformatie() {
		return Informatie;
	}

	public void setInformatie(String informatie) {
		Informatie = informatie;
	}

	public String getRelatie() {
		return Relatie;
	}

	public void setRelatie(String relatie) {
		Relatie = relatie;
	}

	public Account getAangemaaktDoor() {
		return AangemaaktDoor;
	}

	public void setAangemaaktDoor(Account aangemaaktDoor) {
		AangemaaktDoor = aangemaaktDoor;
	}

	public VragenLijst getVragenpatient() {
		return Vragenpatient;
	}

	public void setVragenpatient(VragenLijst vragenpatient) {
		Vragenpatient = vragenpatient;
	}

	public VragenLijst getVragenMantelzorger() {
		return VragenMantelzorger;
	}

	public void setVragenMantelzorger(VragenLijst vragenMantelzorger) {
		VragenMantelzorger = vragenMantelzorger;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((AangemaaktDoor == null) ? 0 : AangemaaktDoor.hashCode());
		result = prime * result
				+ ((Aangevraagd == null) ? 0 : Aangevraagd.hashCode());
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		result = prime * result
				+ ((Informatie == null) ? 0 : Informatie.hashCode());
		result = prime
				* result
				+ ((LeeftijdsCatMantelZorger == null) ? 0
						: LeeftijdsCatMantelZorger.hashCode());
		result = prime
				* result
				+ ((LeeftijdsCatPatient == null) ? 0 : LeeftijdsCatPatient
						.hashCode());
		result = prime * result + ((Relatie == null) ? 0 : Relatie.hashCode());
		result = prime
				* result
				+ ((VragenMantelzorger == null) ? 0 : VragenMantelzorger
						.hashCode());
		result = prime * result
				+ ((Vragenpatient == null) ? 0 : Vragenpatient.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
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
		Bevraging other = (Bevraging) obj;
		if (AangemaaktDoor == null) {
			if (other.AangemaaktDoor != null)
				return false;
		} else if (!AangemaaktDoor.equals(other.AangemaaktDoor))
			return false;
		if (Aangevraagd == null) {
			if (other.Aangevraagd != null)
				return false;
		} else if (!Aangevraagd.equals(other.Aangevraagd))
			return false;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		if (Informatie == null) {
			if (other.Informatie != null)
				return false;
		} else if (!Informatie.equals(other.Informatie))
			return false;
		if (LeeftijdsCatMantelZorger == null) {
			if (other.LeeftijdsCatMantelZorger != null)
				return false;
		} else if (!LeeftijdsCatMantelZorger
				.equals(other.LeeftijdsCatMantelZorger))
			return false;
		if (LeeftijdsCatPatient == null) {
			if (other.LeeftijdsCatPatient != null)
				return false;
		} else if (!LeeftijdsCatPatient.equals(other.LeeftijdsCatPatient))
			return false;
		if (Relatie == null) {
			if (other.Relatie != null)
				return false;
		} else if (!Relatie.equals(other.Relatie))
			return false;
		if (VragenMantelzorger == null) {
			if (other.VragenMantelzorger != null)
				return false;
		} else if (!VragenMantelzorger.equals(other.VragenMantelzorger))
			return false;
		if (Vragenpatient == null) {
			if (other.Vragenpatient != null)
				return false;
		} else if (!Vragenpatient.equals(other.Vragenpatient))
			return false;
		return true;
	}

}
