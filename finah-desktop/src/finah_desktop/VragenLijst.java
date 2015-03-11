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
}
