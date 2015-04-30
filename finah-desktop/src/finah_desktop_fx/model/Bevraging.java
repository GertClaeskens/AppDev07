package finah_desktop_fx.model;

import java.util.Date;

public class Bevraging {
	public String Id;
	public Date Aangevraagd;
	public LeeftijdsCategorie LeeftijdsCat;
	public String Informatie;

	// Ook eventueel enum van maken
	public String Relatie;
	public Account AangemaaktDoor;
	public VragenLijst Vragen;
	public boolean IsPatient;
	
	public Bevraging() {
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

	public LeeftijdsCategorie getLeeftijdsCat() {
		return LeeftijdsCat;
	}

	public void setLeeftijdsCat(LeeftijdsCategorie leeftijdsCat) {
		LeeftijdsCat = leeftijdsCat;
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

	public VragenLijst getVragen() {
		return Vragen;
	}

	public void setVragen(VragenLijst vragen) {
		Vragen = vragen;
	}

	public boolean isIsPatient() {
		return IsPatient;
	}

	public void setIsPatient(boolean isPatient) {
		IsPatient = isPatient;
	}

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
		result = prime * result + (IsPatient ? 1231 : 1237);
		result = prime * result
				+ ((LeeftijdsCat == null) ? 0 : LeeftijdsCat.hashCode());
		result = prime * result + ((Relatie == null) ? 0 : Relatie.hashCode());
		result = prime * result + ((Vragen == null) ? 0 : Vragen.hashCode());
		return result;
	}

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
		if (IsPatient != other.IsPatient)
			return false;
		if (LeeftijdsCat == null) {
			if (other.LeeftijdsCat != null)
				return false;
		} else if (!LeeftijdsCat.equals(other.LeeftijdsCat))
			return false;
		if (Relatie == null) {
			if (other.Relatie != null)
				return false;
		} else if (!Relatie.equals(other.Relatie))
			return false;
		if (Vragen == null) {
			if (other.Vragen != null)
				return false;
		} else if (!Vragen.equals(other.Vragen))
			return false;
		return true;
	}

}
