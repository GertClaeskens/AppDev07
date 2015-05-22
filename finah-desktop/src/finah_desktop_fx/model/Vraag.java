package finah_desktop_fx.model;

public class Vraag {
	private int Id;
	private String VraagStelling;
	private Thema Thema;
	private Foto Afbeelding;
	private GeluidsFragment Geluid;
	private Aandoening Aandoening;

	public Vraag() {

	}

	public Vraag(String vraagStelling) {
		VraagStelling = vraagStelling;
	}

	public Vraag(int id, String vraagstelling, Thema thema,Foto afbeelding,
			GeluidsFragment geluid, Aandoening aandoening) {
		super();
		Id = id;
		VraagStelling = vraagstelling;
		Thema = thema;
		Afbeelding = afbeelding;
		Geluid = geluid;
		Aandoening = aandoening;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Foto getAfbeelding() {
		return Afbeelding;
	}

	public void setAfbeelding(Foto afbeelding) {
		Afbeelding = afbeelding;
	}

	public GeluidsFragment getGeluid() {
		return Geluid;
	}

	public void setGeluid(GeluidsFragment geluid) {
		Geluid = geluid;
	}

	public String getVraagStelling() {
		return VraagStelling;
	}

	public void setVraagStelling(String vraagStelling) {
		VraagStelling = vraagStelling;
	}

	public Thema getThema() {
		return Thema;
	}

	public void setThema(Thema thema) {
		Thema = thema;
	}
	
	public Aandoening getAandoening() {
		return Aandoening;
	}

	public void setAandoening(Aandoening aandoening) {
		Aandoening = aandoening;
	}
	
	public String getVraagstelling() {
		return VraagStelling;
	}

	public void setVraagstelling(String vraagstelling) {
		VraagStelling = vraagstelling;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((Afbeelding == null) ? 0 : Afbeelding.hashCode());
		result = prime * result + ((Geluid == null) ? 0 : Geluid.hashCode());
		result = prime * result + Id;
		result = prime * result + ((Thema == null) ? 0 : Thema.hashCode());
		result = prime * result
				+ ((VraagStelling == null) ? 0 : VraagStelling.hashCode());
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
		Vraag other = (Vraag) obj;
		if (Afbeelding == null) {
			if (other.Afbeelding != null)
				return false;
		} else if (!Afbeelding.equals(other.Afbeelding))
			return false;
		if (Geluid == null) {
			if (other.Geluid != null)
				return false;
		} else if (!Geluid.equals(other.Geluid))
			return false;
		if (Id != other.Id)
			return false;
		if (Thema == null) {
			if (other.Thema != null)
				return false;
		} else if (!Thema.equals(other.Thema))
			return false;
		if (VraagStelling == null) {
			if (other.VraagStelling != null)
				return false;
		} else if (!VraagStelling.equals(other.VraagStelling))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vraag [Id=" + Id + ", VraagStelling=" + VraagStelling
				+ ", Afbeelding=" + Afbeelding + ", Geluid=" + Geluid + "]";
	}

	// @Override
	// public String toString() {
	// return VraagStelling;
	// }
}
