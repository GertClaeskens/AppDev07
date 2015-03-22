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

//	public Aandoening(String naam) {
//		super(naam);
//	}
//	public Aandoening(String naam,Pathologie patholog) {
//		super(naam);
//	}
}
