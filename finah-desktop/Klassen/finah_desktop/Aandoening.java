package finah_desktop;

import java.util.ArrayList;
import java.util.List;

public class Aandoening extends SuperklasseAandoeningPathologie {

	private List<Pathologie> Patologieen;
	public List<Pathologie> getBijhorende_pathologie() {
		return Patologieen;
	}

	public void setBijhorende_pathologie(List<Pathologie> bijhorende_pathologie) {
		this.Patologieen = bijhorende_pathologie;
	}

	public Aandoening() {
		Patologieen = new ArrayList<Pathologie>();
	}
	@Override
	public String toString(){
		return this.getId() + " : " + this.getOmschrijving() + ": " + this.getBijhorende_pathologie().get(0);
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + this.getId();
		result = prime * result
				+ ((this.getOmschrijving() == null) ? 0 : this.getOmschrijving().hashCode());
		result = prime * result
				+ ((Patologieen == null) ? 0 : Patologieen.hashCode());
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
		Aandoening other = (Aandoening) obj;
		if (this.getId() != other.getId())
			return false;
		if (this.getOmschrijving() == null) {
			if (other.getOmschrijving() != null)
				return false;
		} else if (!this.getOmschrijving().equals(other.getOmschrijving()))
			return false;
		if (Patologieen == null) {
			if (other.Patologieen != null)
				return false;
		} else if (!Patologieen.equals(other.Patologieen))
			return false;
		return true;
	}



//	public Aandoening(String naam) {
//		super(naam);
//	}
//	public Aandoening(String naam,Pathologie patholog) {
//		super(naam);
//	}
}
