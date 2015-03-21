package finah_desktop;

public class LeeftijdsCategorie {

	private int leeftijdsCategorieId;
	private short van;
	private short tot;

	public LeeftijdsCategorie() {

	}

	public LeeftijdsCategorie(short van, short tot) {
		this.van = van;
		this.tot = tot;
	}

	public int getLeeftijdsCategorieId() {
		return leeftijdsCategorieId;
	}

	public void setLeeftijdsCategorieId(int leeftijdsCategorieId) {
		this.leeftijdsCategorieId = leeftijdsCategorieId;
	}

	public short getVan() {
		return van;
	}

	public void setVan(short van) {
		this.van = van;
	}

	public short getTot() {
		return tot;
	}

	public void setTot(short tot) {
		this.tot = tot;
	}
}
