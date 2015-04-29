package finah_desktop_fx.model;

public class Aanvraag extends SuperklasseAanvraagAccount {

	
	public Status Sts;
	public Aanvraag() {
	}
	public Aanvraag(Status sts) {
		super();
		Sts = sts;
	}

	public Status getSts() {
		return Sts;
	}

	public void setSts(Status sts) {
		Sts = sts;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((Sts == null) ? 0 : Sts.hashCode());
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
		Aanvraag other = (Aanvraag) obj;
		if (Sts == null) {
			if (other.Sts != null)
				return false;
		} else if (!Sts.equals(other.Sts))
			return false;
		return true;
	}


}
