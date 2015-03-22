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
		Assert.assertEquals(testAandoeningen.size(),
				controleAandoeningen.size());
	}

	@Test
	public void Get_ShouldReturnCorrectAandoening() {
		Aandoening test = AandoeningDAO.GetAandoening(1);
		Assert.assertNotNull(test);
		// Controleren of beide objecten uniek zijn (Comparable?)
		Assert.assertEquals(controleAandoeningen.get(0), test);
	}

	@Test
	public void Get_ShouldNotFindAandoening() {
		// Id meegeven die zeker niet in de database voorkomt
		Aandoening result = AandoeningDAO.GetAandoening(999999999);
		Assert.assertNotNull(result);
	}

	private ArrayList<Aandoening> GetTestAandoeningen() {
		ArrayList<Aandoening> controleAandoeningen = new ArrayList<Aandoening>();
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