package finah_desktop;

import java.util.Date;

public class Bevraging {
	private long id; // 150311095101
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

}
