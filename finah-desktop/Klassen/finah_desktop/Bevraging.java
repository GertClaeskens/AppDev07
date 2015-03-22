package finah_desktop;

import java.util.Date;

public class Bevraging {
	private String id; // 150311095101
	private Date datum_aangevraagd; // evt. berekend veld uit de id halen
	private int aantal_ingevuld;
	private String info;
	private String Relatie;
	private boolean patient; // true voor patient, false voor mantelzorger
	private Account aangemaakt_door;
	private VragenLijst vragen;

	public Bevraging(Date datum_aangevraagd, int aantal_ingevuld, String info,
			String relatie, boolean patient, Account aangemaakt_door,
			VragenLijst vragen) {
		super();
		this.datum_aangevraagd = datum_aangevraagd;
		this.aantal_ingevuld = aantal_ingevuld;
		this.info = info;
		Relatie = relatie;
		this.patient = patient;
		this.aangemaakt_door = aangemaakt_door;
		this.vragen = vragen;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDatum_aangevraagd() {
		return datum_aangevraagd;
	}

	public void setDatum_aangevraagd(Date datum_aangevraagd) {
		this.datum_aangevraagd = datum_aangevraagd;
	}

	public int getAantal_ingevuld() {
		return aantal_ingevuld;
	}

	public void setAantal_ingevuld(int aantal_ingevuld) {
		this.aantal_ingevuld = aantal_ingevuld;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getRelatie() {
		return Relatie;
	}

	public void setRelatie(String relatie) {
		Relatie = relatie;
	}

	public boolean isPatient() {
		return patient;
	}

	public void setPatient(boolean patient) {
		this.patient = patient;
	}

	public Account getAangemaakt_door() {
		return aangemaakt_door;
	}

	public void setAangemaakt_door(Account aangemaakt_door) {
		this.aangemaakt_door = aangemaakt_door;
	}

	public VragenLijst getVragen() {
		return vragen;
	}

	public void setVragen(VragenLijst vragen) {
		this.vragen = vragen;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Relatie == null) ? 0 : Relatie.hashCode());
		result = prime * result
				+ ((aangemaakt_door == null) ? 0 : aangemaakt_door.hashCode());
		result = prime * result + aantal_ingevuld;
		result = prime
				* result
				+ ((datum_aangevraagd == null) ? 0 : datum_aangevraagd
						.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((info == null) ? 0 : info.hashCode());
		result = prime * result + (patient ? 1231 : 1237);
		result = prime * result + ((vragen == null) ? 0 : vragen.hashCode());
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
		Bevraging other = (Bevraging) obj;
		if (Relatie == null) {
			if (other.Relatie != null)
				return false;
		} else if (!Relatie.equals(other.Relatie))
			return false;
		if (aangemaakt_door == null) {
			if (other.aangemaakt_door != null)
				return false;
		} else if (!aangemaakt_door.equals(other.aangemaakt_door))
			return false;
		if (aantal_ingevuld != other.aantal_ingevuld)
			return false;
		if (datum_aangevraagd == null) {
			if (other.datum_aangevraagd != null)
				return false;
		} else if (!datum_aangevraagd.equals(other.datum_aangevraagd))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (info == null) {
			if (other.info != null)
				return false;
		} else if (!info.equals(other.info))
			return false;
		if (patient != other.patient)
			return false;
		if (vragen == null) {
			if (other.vragen != null)
				return false;
		} else if (!vragen.equals(other.vragen))
			return false;
		return true;
	}
	

}
