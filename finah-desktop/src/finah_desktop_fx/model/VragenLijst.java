package finah_desktop_fx.model;

import java.util.List;

public class VragenLijst {

	private int Id;
	private List<Vraag> Vragen;
	private Aandoening Aandoe;
	private int aantalVragen;
	private String Omschrijving;
	

	public VragenLijst() {
	}

	public VragenLijst(int id, List<Vraag> vragen, Aandoening aandoe,String omschrijving) {
		super();
		Id = id;
		Vragen = vragen;
		Aandoe = aandoe;
		Omschrijving = omschrijving;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public List<Vraag> getVragen() {
		return Vragen;
	}

	public void setVragen(List<Vraag> vragen) {
		Vragen = vragen;
	}

	public Aandoening getAandoe() {
		return Aandoe;
	}

	public void setAandoe(Aandoening aandoe) {
		Aandoe = aandoe;
	}

	public String getOmschrijving() {
		return Omschrijving;
	}

	public void setOmschrijving(String omschrijving) {
		Omschrijving = omschrijving;
	}

	public int getAantalVragen() {
		return Vragen.size();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Aandoe == null) ? 0 : Aandoe.hashCode());
		result = prime * result + Id;
		result = prime * result
				+ ((Omschrijving == null) ? 0 : Omschrijving.hashCode());
		result = prime * result + ((Vragen == null) ? 0 : Vragen.hashCode());
		result = prime * result + aantalVragen;
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
		VragenLijst other = (VragenLijst) obj;
		if (Aandoe == null) {
			if (other.Aandoe != null)
				return false;
		} else if (!Aandoe.equals(other.Aandoe))
			return false;
		if (Id != other.Id)
			return false;
		if (Omschrijving == null) {
			if (other.Omschrijving != null)
				return false;
		} else if (!Omschrijving.equals(other.Omschrijving))
			return false;
		if (Vragen == null) {
			if (other.Vragen != null)
				return false;
		} else if (!Vragen.equals(other.Vragen))
			return false;
		if (aantalVragen != other.aantalVragen)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return Omschrijving;
	}
}
