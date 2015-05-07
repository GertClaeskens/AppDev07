package finah_desktop;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import finah_desktop_fx.dao.AntwoordDAO;
import finah_desktop_fx.model.Antwoord;

public class TestAntwoordDAO {
	private ArrayList<Antwoord> testAntwoorden;
	private ArrayList<Antwoord> controleAntwoorden;

	// private AntwoordDAO controller;

	@Before
	public void init() {
		testAntwoorden = GetTestAntwoorden();
		// controller = new AntwoordDAO();
	}

	@Test
	public void GetAntwoorden_ShouldReturnAllAntwoorden() {
		testAntwoorden = AntwoordDAO.GetAntwoorden();
		controleAntwoorden = TestAntwoordDAO.GetTestAntwoorden();

		Assert.assertEquals(controleAntwoorden.size(),testAntwoorden.size());
	}
	@Test
	public void GetAntwoord_ShouldReturnCorrectAntwoord() {
        Antwoord antwoord = new Antwoord();

        antwoord.setId(1);
        antwoord.setAntword(4);
		Antwoord test = AntwoordDAO.GetAntwoord(1);
		Assert.assertNotNull(test);
		// Controleren of beide objecten uniek zijn (Comparable?)
		Assert.assertEquals(antwoord, test);
		
		
	}

	@Test
	public void GetAntwoord_ShouldNotFindAntwoord() {
		// Id meegeven die zeker niet in de database voorkomt
		Antwoord result = AntwoordDAO.GetAntwoord(999999999);
		Assert.assertNull(result);
	}

	private static ArrayList<Antwoord> GetTestAntwoorden() {
		ArrayList<Antwoord> controleAntwoorden = new ArrayList<Antwoord>();
		 Antwoord ad1 = new Antwoord();
         Antwoord ad2 = new Antwoord();
         Antwoord ad3 = new Antwoord();
         Antwoord ad4 = new Antwoord();
         Antwoord ad5 = new Antwoord();

         ad1.setId(1);
         ad2.setId(2);
         ad3.setId(3);
         ad4.setId(4);
         ad5.setId(5);
         controleAntwoorden.add(ad1);
         controleAntwoorden.add(ad2);
         controleAntwoorden.add(ad3);
         controleAntwoorden.add(ad4);
         controleAntwoorden.add(ad5);
		// /
		// /
		// / Wanneer we daadwerkelijk gaan testen moeten we hier de gegevens
		// invullen zoals ze in de database staan
		// / Zo kunnen we deze 2 objecten vergelijken en zo de werking van de
		// controller testen
		// /
		// / Een lijst van 3-4 objecten volstaat

		return controleAntwoorden;
	}
}
