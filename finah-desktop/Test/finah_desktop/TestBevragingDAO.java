package finah_desktop;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestBevragingDAO {
	private ArrayList<Bevraging> testBevragingen;
	private ArrayList<Bevraging> controleBevragingen;

	

	@Before
	public void init() {
		testBevragingen = GetTestBevragingen();
		
	}

	@Test
	public void GetOverzicht_ShouldReturnAllAandoeningen() {
		testBevragingen = BevragingDAO.GetBevragingen();
		controleBevragingen = TestBevragingDAO.GetTestBevragingen();

		Assert.assertEquals(controleBevragingen.size(), testBevragingen.size());
	}

	@Test
	public void Get_ShouldReturnCorrectBevraging() {
		Bevraging bevraging = new Bevraging();
		bevraging.setId("1");
		Bevraging test = BevragingDAO.GetBevraging("1");
		Assert.assertNotNull(test);
		// Controleren of beide objecten gelijk zijn (Comparable?)
		Assert.assertEquals(bevraging.getId(), test.getId());
	}

	@Test
	public void Get_ShouldNotFindBevraging() {
		// Id meegeven die zeker niet in de database voorkomt
		Bevraging result = BevragingDAO.GetBevraging("999999999");
		Assert.assertNull(result);
	}

	private static ArrayList<Bevraging> GetTestBevragingen() {
		ArrayList<Bevraging> bevragingen = new ArrayList<Bevraging>();
		Bevraging bv1 = new Bevraging();
		Bevraging bv2 = new Bevraging();
		Bevraging bv3 = new Bevraging();
		Bevraging bv4 = new Bevraging();
		Bevraging bv5 = new Bevraging();
		
		bevragingen.add(bv1);
		bevragingen.add(bv2);
		bevragingen.add(bv3);
		bevragingen.add(bv4);
		bevragingen.add(bv5);
		// /
		// /
		// / Wanneer we daadwerkelijk gaan testen moeten we hier de gegevens
		// invullen zoals ze in de database staan
		// / Zo kunnen we deze 2 objecten vergelijken en zo de werking van de
		// controller testen
		// /
		// / Een lijst van 3-4 objecten volstaat

		return bevragingen;
	}
}
