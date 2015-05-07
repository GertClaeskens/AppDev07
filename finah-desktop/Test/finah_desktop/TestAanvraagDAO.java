package finah_desktop;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import finah_desktop_fx.dao.AanvraagDAO;
import finah_desktop_fx.model.Aanvraag;

public class TestAanvraagDAO {
	private ArrayList<Aanvraag> testAanvragen;
	private ArrayList<Aanvraag> controleAanvragen;

	// private AandoeningDAO controller;

	@Before
	public void init() {
		testAanvragen = GetTestAanvragen();
		// controller = new AandoeningDAO();
	}

	@Test
	public void GetOverzicht_ShouldReturnAllAanvragen() {
		testAanvragen = AanvraagDAO.GetAanvragen();
		controleAanvragen = TestAanvraagDAO.GetTestAanvragen();

		Assert.assertEquals(controleAanvragen.size(), testAanvragen.size());
	}

	@Test
	public void Get_ShouldReturnCorrectAanvraag() {
		Aanvraag aanvraag = new Aanvraag();
		aanvraag.setId(1);
		Aanvraag test = AanvraagDAO.GetAanvraag(1);
		Assert.assertNotNull(test);
		// Controleren of beide objecten gelijk zijn (Comparable?)
		Assert.assertEquals(aanvraag, test);
	}

	@Test
	public void Get_ShouldNotFindAanvraag() {
		// Id meegeven die zeker niet in de database voorkomt
		Aanvraag result = AanvraagDAO.GetAanvraag(999999999);
		Assert.assertNull(result);
	}

	private static ArrayList<Aanvraag> GetTestAanvragen() {
		ArrayList<Aanvraag> aanvragen = new ArrayList<Aanvraag>();
		Aanvraag av1 = new Aanvraag();
		Aanvraag av2 = new Aanvraag();
		Aanvraag av3 = new Aanvraag();
		Aanvraag av4 = new Aanvraag();
		Aanvraag av5 = new Aanvraag();
		
		aanvragen.add(av1);
		aanvragen.add(av2);
		aanvragen.add(av3);
		aanvragen.add(av4);
		aanvragen.add(av5);
		// /
		// /
		// / Wanneer we daadwerkelijk gaan testen moeten we hier de gegevens
		// invullen zoals ze in de database staan
		// / Zo kunnen we deze 2 objecten vergelijken en zo de werking van de
		// controller testen
		// /
		// / Een lijst van 3-4 objecten volstaat

		return aanvragen;
	}
}
