package finah_desktop_fx.model;

import java.util.Date;

public class Status {
    public int Id;

    public Account BeoordeeldDoor;

    public Status(int id, Account beoordeeldDoor, Date beoordeeldOp) {
		super();
		Id = id;
		BeoordeeldDoor = beoordeeldDoor;
		BeoordeeldOp = beoordeeldOp;
	}

	public Date BeoordeeldOp;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Account getBeoordeeldDoor() {
		return BeoordeeldDoor;
	}

	public void setBeoordeeldDoor(Account beoordeeldDoor) {
		BeoordeeldDoor = beoordeeldDoor;
	}

	public Date getBeoordeeldOp() {
		return BeoordeeldOp;
	}

	public void setBeoordeeldOp(Date beoordeeldOp) {
		BeoordeeldOp = beoordeeldOp;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((BeoordeeldDoor == null) ? 0 : BeoordeeldDoor.hashCode());
		result = prime * result
				+ ((BeoordeeldOp == null) ? 0 : BeoordeeldOp.hashCode());
		result = prime * result + Id;
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
		Status other = (Status) obj;
		if (BeoordeeldDoor == null) {
			if (other.BeoordeeldDoor != null)
				return false;
		} else if (!BeoordeeldDoor.equals(other.BeoordeeldDoor))
			return false;
		if (BeoordeeldOp == null) {
			if (other.BeoordeeldOp != null)
				return false;
		} else if (!BeoordeeldOp.equals(other.BeoordeeldOp))
			return false;
		if (Id != other.Id)
			return false;
		return true;
	}
}
