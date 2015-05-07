package finah_desktop;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import finah_desktop_fx.dao.AntwoordenLijstDAO;
import finah_desktop_fx.model.AntwoordenLijst;

public class TestAntwoordenLijstDAO {
	private ArrayList<AntwoordenLijst> testAntwoordenLijsten;
	private ArrayList<AntwoordenLijst> controleAntwoordenLijsten;

	// private AntwoordenLijstDAO controller;

	@Before
	public void init() {
		testAntwoordenLijsten = GetTestAntwoordenLijsten();
		// controller = new AntwoordenLijstDAO();
	}

	@Test
	public void GetAntwoordenLijsten_ShouldReturnAllAntwoordenLijsten() {
		testAntwoordenLijsten = AntwoordenLijstDAO.GetAntwoordenLijsten();
		controleAntwoordenLijsten = TestAntwoordenLijstDAO.GetTestAntwoordenLijsten();
		Assert.assertEquals(controleAntwoordenLijsten.size(),testAntwoordenLijsten.size());
	}
	@Test
	public void GetAntwoordenLijst_ShouldReturnCorrectAntwoordenLijst() {
        AntwoordenLijst antwoordenLijstenLijst = new AntwoordenLijst();

        antwoordenLijstenLijst.setId("1");        
		AntwoordenLijst test = AntwoordenLijstDAO.GetAntwoordenLijst("1");
		Assert.assertNotNull(test);
		// Controleren of beide objecten uniek zijn (Comparable?)
		Assert.assertEquals(antwoordenLijstenLijst, test);
		
		
	}

	@Test
	public void GetAntwoordenLijst_ShouldNotFindAntwoordenLijst() {
		// Id meegeven die zeker niet in de database voorkomt
		AntwoordenLijst result = AntwoordenLijstDAO.GetAntwoordenLijst("fhjafhj");
		Assert.assertNull(result);
	}

	private static ArrayList<AntwoordenLijst> GetTestAntwoordenLijsten() {
		ArrayList<AntwoordenLijst> controleAntwoordenLijsten = new ArrayList<AntwoordenLijst>();
		 AntwoordenLijst al1 = new AntwoordenLijst();
         AntwoordenLijst al2 = new AntwoordenLijst();
         AntwoordenLijst al3 = new AntwoordenLijst();
         AntwoordenLijst al4 = new AntwoordenLijst();
         AntwoordenLijst al5 = new AntwoordenLijst();

         al1.setId("1");
         al2.setId("2");
         al3.setId("3");
         al4.setId("4");
         al5.setId("5");
         controleAntwoordenLijsten.add(al1);
         controleAntwoordenLijsten.add(al2);
         controleAntwoordenLijsten.add(al3);
         controleAntwoordenLijsten.add(al4);
         controleAntwoordenLijsten.add(al5);
		// /
		// /
		// / Wanneer we daadwerkelijk gaan testen moeten we hier de gegevens
		// invullen zoals ze in de database staan
		// / Zo kunnen we deze 2 objecten vergelijken en zo de werking van de
		// controller testen
		// /
		// / Een lijst van 3-4 objecten volstaat

		return controleAntwoordenLijsten;
	}
}
