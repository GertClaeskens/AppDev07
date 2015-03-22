package finah_desktop;

import java.util.List;

public class VragenLijst {

	private int id;
	private List<Vraag> vragen;

	public VragenLijst() {
	}

	public VragenLijst(List<Vraag> vragen) {
		this.vragen = vragen;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Vraag> getVragen() {
		return vragen;
	}

	public void setVragen(List<Vraag> vragen) {
		this.vragen = vragen;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		VragenLijst other = (VragenLijst) obj;
		if (id != other.id)
			return false;
		if (vragen == null) {
			if (other.vragen != null)
				return false;
		} else if (!vragen.equals(other.vragen))
			return false;
		return true;
	}
	
}
