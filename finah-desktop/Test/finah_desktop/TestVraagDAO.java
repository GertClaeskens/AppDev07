package finah_desktop;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class TestVraagDAO {
	private ArrayList<Vraag> testVragen;
	private ArrayList<Vraag> controleVragen;

	

	@Before
	public void init() {
		testVragen = GetTestVragen();
		
	}

	@Test
	public void GetOverzicht_ShouldReturnAllVragen() {
		testVragen = VraagDAO.GetVragen();
		controleVragen = TestVraagDAO.GetTestVragen();

		Assert.assertEquals(controleVragen.size(), testVragen.size());
	}

	@Test
	public void Get_ShouldReturnCorrectVraag() {
		Vraag vraag = new Vraag();
		vraag.setId(1);
		Vraag test = VraagDAO.GetVraag(1);
		Assert.assertNotNull(test);
		// Controleren of beide objecten gelijk zijn (Comparable?)
		Assert.assertEquals(vraag.getId(), test.getId());
	}

	@Test
	public void Get_ShouldNotFindVraag() {
		// Id meegeven die zeker niet in de database voorkomt
		Vraag result = VraagDAO.GetVraag(999999999);
		Assert.assertNull(result);
	}

	private static ArrayList<Vraag> GetTestVragen() {
		ArrayList<Vraag> vragen = new ArrayList<Vraag>();
		Vraag bv1 = new Vraag();
		Vraag bv2 = new Vraag();
		Vraag bv3 = new Vraag();
		Vraag bv4 = new Vraag();
		Vraag bv5 = new Vraag();
		
		vragen.add(bv1);
		vragen.add(bv2);
		vragen.add(bv3);
		vragen.add(bv4);
		vragen.add(bv5);
		// /
		// /
		// / Wanneer we daadwerkelijk gaan testen moeten we hier de gegevens
		// invullen zoals ze in de database staan
		// / Zo kunnen we deze 2 objecten vergelijken en zo de werking van de
		// controller testen
		// /
		// / Een lijst van 3-4 objecten volstaat

		return vragen;
	}
}
