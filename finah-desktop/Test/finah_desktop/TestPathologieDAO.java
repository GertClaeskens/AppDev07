package finah_desktop;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import finah_desktop_fx.dao.PathologieDAO;
import finah_desktop_fx.model.Pathologie;
public class TestPathologieDAO {
	private ArrayList<Pathologie> testPathologieen;
	private ArrayList<Pathologie> controlePathologieen;

	

	@Before
	public void init() {
		testPathologieen = GetTestPathologieen();
		
	}

	@Test
	public void GetOverzicht_ShouldReturnAllPathologieen() {
		testPathologieen = PathologieDAO.GetPathologieen();
		controlePathologieen = TestPathologieDAO.GetTestPathologieen();

		Assert.assertEquals(controlePathologieen.size(), testPathologieen.size());
	}

	@Test
	public void Get_ShouldReturnCorrectPathologie() {
		Pathologie pathologie = new Pathologie();
		pathologie.setId(1);
		Pathologie test = PathologieDAO.GetPathologie(1);
		Assert.assertNotNull(test);
		// Controleren of beide objecten gelijk zijn (Comparable?)
		Assert.assertEquals(pathologie.getId(), test.getId());
	}

	@Test
	public void Get_ShouldNotFindPathologie() {
		// Id meegeven die zeker niet in de database voorkomt
		Pathologie result = PathologieDAO.GetPathologie(999999999);
		Assert.assertNull(result);
	}

	private static ArrayList<Pathologie> GetTestPathologieen() {
		ArrayList<Pathologie> pathologieen = new ArrayList<Pathologie>();
		Pathologie bv1 = new Pathologie();
		Pathologie bv2 = new Pathologie();
		Pathologie bv3 = new Pathologie();
		Pathologie bv4 = new Pathologie();
		Pathologie bv5 = new Pathologie();
		
		pathologieen.add(bv1);
		pathologieen.add(bv2);
		pathologieen.add(bv3);
		pathologieen.add(bv4);
		pathologieen.add(bv5);
		// /
		// /
		// / Wanneer we daadwerkelijk gaan testen moeten we hier de gegevens
		// invullen zoals ze in de database staan
		// / Zo kunnen we deze 2 objecten vergelijken en zo de werking van de
		// controller testen
		// /
		// / Een lijst van 3-4 objecten volstaat

		return pathologieen;
	}
}
