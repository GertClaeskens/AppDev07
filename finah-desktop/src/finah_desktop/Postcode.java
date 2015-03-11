package finah_desktop;

public class Postcode {
	private int postcode_id;
	private int postcode;
	private String gemeente;

	public Postcode() {

	}

	public Postcode(int postcode, String gemeente) {
		this.postcode = postcode;
		this.gemeente = gemeente;
	}

	public int getPostcode_id() {
		return postcode_id;
	}

	public void setPostcode_id(int postcode_id) {
		this.postcode_id = postcode_id;
	}

	public int getPostcode() {
		return postcode;
	}

	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}

	public String getGemeente() {
		return gemeente;
	}

	public void setGemeente(String gemeente) {
		this.gemeente = gemeente;
	}
}
