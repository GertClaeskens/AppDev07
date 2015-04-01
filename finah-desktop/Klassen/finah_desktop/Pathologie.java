package finah_desktop;

import java.util.ArrayList;
import java.util.List;

public class Pathologie extends SuperklasseAandoeningPathologie {

	private List<Aandoening> Aandoeningen;
	public List<Aandoening> getBijhorende_aandoening() {
		return Aandoeningen;
	}
	public void voegPathologieToe(Aandoening aand){
		Aandoeningen.add(aand);
		
	}
	public void voegPathologieLijstToe(ArrayList<Aandoening> aandLijst){
		Aandoeningen = aandLijst;
	}
	public void setBijhorende_pathologie(List<Aandoening> bijhorende_aandoening) {
		this.Aandoeningen = bijhorende_aandoening;
	}

	public Pathologie() {
		Aandoeningen = new ArrayList<Aandoening>();
	}


	public Pathologie(String naam) {
		super(naam);
		// TODO Auto-generated constructor stub
	}

}
