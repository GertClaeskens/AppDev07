package finah_desktop;

public class LeeftijdsCategorie {

	private int leeftijdsCategorieId;
	private int van;
	private int tot;

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

	public int getVan() {
		return van;
	}

	public void setVan(int van) {
		this.van = van;
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}
}
