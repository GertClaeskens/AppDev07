package finah_desktop;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class TestVragenLijstDAO {
	private ArrayList<VragenLijst> testVragenLijsten;
	private ArrayList<VragenLijst> controleVragenLijsten;

	

	@Before
	public void init() {
		testVragenLijsten = GetTestVragenLijsten();
		
	}

	@Test
	public void GetOverzicht_ShouldReturnAllVragenLijsten() {
		testVragenLijsten = VragenLijstDAO.GetVragenLijsten();
		controleVragenLijsten = TestVragenLijstDAO.GetTestVragenLijsten();

		Assert.assertEquals(controleVragenLijsten.size(), testVragenLijsten.size());
	}

	@Test
	public void Get_ShouldReturnCorrectVragenLijst() {
		VragenLijst vragenLijstenLijst = new VragenLijst();
		vragenLijstenLijst.setId(1);
		VragenLijst test = VragenLijstDAO.GetVragenLijst(1);
		Assert.assertNotNull(test);
		// Controleren of beide objecten gelijk zijn (Comparable?)
		Assert.assertEquals(vragenLijstenLijst.getId(), test.getId());
	}

	@Test
	public void Get_ShouldNotFindVragenLijst() {
		// Id meegeven die zeker niet in de database voorkomt
		VragenLijst result = VragenLijstDAO.GetVragenLijst(999999999);
		Assert.assertNull(result);
	}

	private static ArrayList<VragenLijst> GetTestVragenLijsten() {
		ArrayList<VragenLijst> vragenLijsten = new ArrayList<VragenLijst>();
		VragenLijst bv1 = new VragenLijst();
		VragenLijst bv2 = new VragenLijst();
		VragenLijst bv3 = new VragenLijst();
		VragenLijst bv4 = new VragenLijst();
		VragenLijst bv5 = new VragenLijst();
		
		vragenLijsten.add(bv1);
		vragenLijsten.add(bv2);
		vragenLijsten.add(bv3);
		vragenLijsten.add(bv4);
		vragenLijsten.add(bv5);
		// /
		// /
		// / Wanneer we daadwerkelijk gaan testen moeten we hier de gegevens
		// invullen zoals ze in de database staan
		// / Zo kunnen we deze 2 objecten vergelijken en zo de werking van de
		// controller testen
		// /
		// / Een lijst van 3-4 objecten volstaat

		return vragenLijsten;
	}
}
