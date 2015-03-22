package finah_desktop;

import java.util.ArrayList;
import java.util.List;

public class Aandoening extends SuperklasseAandoeningPathologie {

	private List<Pathologie> bijhorende_pathologie;
	public List<Pathologie> getBijhorende_pathologie() {
		return bijhorende_pathologie;
	}

	public void setBijhorende_pathologie(List<Pathologie> bijhorende_pathologie) {
		this.bijhorende_pathologie = bijhorende_pathologie;
	}

	public Aandoening() {
		bijhorende_pathologie = new ArrayList<Pathologie>();
	}

//	public Aandoening(String naam) {
//		super(naam);
//	}
//	public Aandoening(String naam,Pathologie patholog) {
//		super(naam);
//	}
}
