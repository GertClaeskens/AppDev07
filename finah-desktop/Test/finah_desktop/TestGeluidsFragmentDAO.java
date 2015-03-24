package finah_desktop;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestGeluidsFragmentDAO {
	private ArrayList<GeluidsFragment> testGeluidsFragmenten;
	private ArrayList<GeluidsFragment> controleGeluidsFragmenten;	

	@Before
	public void init() {
		testGeluidsFragmenten = GetTestGeluidsFragmenten();		
	}

	@Test
	public void GetOverzicht_ShouldReturnAllGeluidsFragmenten() {
		testGeluidsFragmenten = GeluidsFragmentDAO.GetGeluidsFragmenten();
		controleGeluidsFragmenten = TestGeluidsFragmentDAO.GetTestGeluidsFragmenten();

		Assert.assertEquals(controleGeluidsFragmenten.size(), testGeluidsFragmenten.size());
	}

	@Test
	public void Get_ShouldReturnCorrectGeluidsFragment() {
		GeluidsFragment geluidsFragment = new GeluidsFragment();
		geluidsFragment.setId(1);
		GeluidsFragment test = GeluidsFragmentDAO.GetGeluidsFragment(1);
		Assert.assertNotNull(test);
		// Controleren of beide objecten gelijk zijn (Comparable?)
		Assert.assertEquals(geluidsFragment.getId(), test.getId());
	}

	@Test
	public void Get_ShouldNotFindGeluidsFragment() {
		// Id meegeven die zeker niet in de database voorkomt
		GeluidsFragment result = GeluidsFragmentDAO.GetGeluidsFragment(999999999);
		Assert.assertNull(result);
	}

	private static ArrayList<GeluidsFragment> GetTestGeluidsFragmenten() {
		ArrayList<GeluidsFragment> geluidsFragmenten = new ArrayList<GeluidsFragment>();
		GeluidsFragment bv1 = new GeluidsFragment();
		GeluidsFragment bv2 = new GeluidsFragment();
		GeluidsFragment bv3 = new GeluidsFragment();
		GeluidsFragment bv4 = new GeluidsFragment();
		GeluidsFragment bv5 = new GeluidsFragment();
		
		geluidsFragmenten.add(bv1);
		geluidsFragmenten.add(bv2);
		geluidsFragmenten.add(bv3);
		geluidsFragmenten.add(bv4);
		geluidsFragmenten.add(bv5);
		// /
		// /
		// / Wanneer we daadwerkelijk gaan testen moeten we hier de gegevens
		// invullen zoals ze in de database staan
		// / Zo kunnen we deze 2 objecten vergelijken en zo de werking van de
		// controller testen
		// /
		// / Een lijst van 3-4 objecten volstaat

		return geluidsFragmenten;
	}
}
