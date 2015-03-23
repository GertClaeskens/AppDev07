package finah_desktop;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestAandoeningDAO {
	private ArrayList<Aandoening> testAandoeningen;
	private ArrayList<Aandoening> controleAandoeningen;

	// private AandoeningDAO controller;

	@Before
	public void init() {
		testAandoeningen = GetTestAandoeningen();
		// controller = new AandoeningDAO();
	}

	@Test
	public void GetOverzicht_ShouldReturnAllAandoeningen() {
		testAandoeningen = AandoeningDAO.GetAandoeningen();
		controleAandoeningen = TestAandoeningDAO.GetTestAandoeningen();

		Assert.assertEquals(controleAandoeningen.size(),testAandoeningen.size());
	}

	@Test
	public void Get_ShouldReturnCorrectAandoening() {
        Aandoening aandoening = new Aandoening();
        Pathologie pt = new Pathologie();
        ArrayList<Pathologie> patLijst = new ArrayList<Pathologie>();

        pt.setId(1);
        pt.setOmschrijving("Pathologie");
        patLijst.add(pt);


        aandoening.setId(1);
        aandoening.setOmschrijving("Omschrijving");
        aandoening.voegPathologieLijstToe(patLijst);
		Aandoening test = AandoeningDAO.GetAandoening(1);
		Assert.assertNotNull(test);
		// Controleren of beide objecten uniek zijn (Comparable?)
		Assert.assertEquals(aandoening, test);
		
		
	}

	@Test
	public void Get_ShouldNotFindAandoening() {
		// Id meegeven die zeker niet in de database voorkomt
		Aandoening result = AandoeningDAO.GetAandoening(999999999);
		Assert.assertNull(result);
	}

	private static ArrayList<Aandoening> GetTestAandoeningen() {
		ArrayList<Aandoening> controleAandoeningen = new ArrayList<Aandoening>();
		 Aandoening ad1 = new Aandoening();
         Aandoening ad2 = new Aandoening();
         Aandoening ad3 = new Aandoening();
         Aandoening ad4 = new Aandoening();
         Aandoening ad5 = new Aandoening();

         ad1.setId(1);
         ad2.setId(2);
         ad3.setId(3);
         ad4.setId(4);
         ad5.setId(5);
         controleAandoeningen.add(ad1);
         controleAandoeningen.add(ad2);
         controleAandoeningen.add(ad3);
         controleAandoeningen.add(ad4);
         controleAandoeningen.add(ad5);
		// /
		// /
		// / Wanneer we daadwerkelijk gaan testen moeten we hier de gegevens
		// invullen zoals ze in de database staan
		// / Zo kunnen we deze 2 objecten vergelijken en zo de werking van de
		// controller testen
		// /
		// / Een lijst van 3-4 objecten volstaat

		return controleAandoeningen;
	}
}
