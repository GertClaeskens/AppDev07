package finah_desktop_fx.model;

public class Antwoord {
	private int Id;
    private int Antword;
    
	public Antwoord() {
		super();
	}

	public Antwoord(int antword) {
		super();
		Antword = antword;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getAntword() {
		return Antword;
	}

	public void setAntword(int antword) {
		Antword = antword;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Antword;
		result = prime * result + Id;
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
		Antwoord other = (Antwoord) obj;
		if (Antword != other.Antword)
			return false;
		if (Id != other.Id)
			return false;
		return true;
	}
}
