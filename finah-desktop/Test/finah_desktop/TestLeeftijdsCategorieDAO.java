package finah_desktop;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import finah_desktop_fx.dao.LeeftijdsCategorieDAO;
import finah_desktop_fx.model.LeeftijdsCategorie;
public class TestLeeftijdsCategorieDAO {
	private ArrayList<LeeftijdsCategorie> testLeeftijdsCategorieen;
	private ArrayList<LeeftijdsCategorie> controleLeeftijdsCategorieen;

	

	@Before
	public void init() {
		testLeeftijdsCategorieen = GetTestLeeftijdsCategorieen();
		
	}

	@Test
	public void GetOverzicht_ShouldReturnAllLeeftijdsCategorieen() {
		testLeeftijdsCategorieen = LeeftijdsCategorieDAO.GetLeeftijdsCategorieen();
		controleLeeftijdsCategorieen = TestLeeftijdsCategorieDAO.GetTestLeeftijdsCategorieen();

		Assert.assertEquals(controleLeeftijdsCategorieen.size(), testLeeftijdsCategorieen.size());
	}

	@Test
	public void Get_ShouldReturnCorrectLeeftijdsCategorie() {
		LeeftijdsCategorie leeftijdscategorie = new LeeftijdsCategorie();
		leeftijdscategorie.setId(1);
		LeeftijdsCategorie test = LeeftijdsCategorieDAO.GetLeeftijdsCategorie(1);
		Assert.assertNotNull(test);
		// Controleren of beide objecten gelijk zijn (Comparable?)
		Assert.assertEquals(leeftijdscategorie.getId(), test.getId());
	}

	@Test
	public void Get_ShouldNotFindLeeftijdsCategorie() {
		// Id meegeven die zeker niet in de database voorkomt
		LeeftijdsCategorie result = LeeftijdsCategorieDAO.GetLeeftijdsCategorie(999999999);
		Assert.assertNull(result);
	}

	private static ArrayList<LeeftijdsCategorie> GetTestLeeftijdsCategorieen() {
		ArrayList<LeeftijdsCategorie> leeftijdscategorieen = new ArrayList<LeeftijdsCategorie>();
		LeeftijdsCategorie bv1 = new LeeftijdsCategorie();
		LeeftijdsCategorie bv2 = new LeeftijdsCategorie();
		LeeftijdsCategorie bv3 = new LeeftijdsCategorie();
		LeeftijdsCategorie bv4 = new LeeftijdsCategorie();
		LeeftijdsCategorie bv5 = new LeeftijdsCategorie();
		
		leeftijdscategorieen.add(bv1);
		leeftijdscategorieen.add(bv2);
		leeftijdscategorieen.add(bv3);
		leeftijdscategorieen.add(bv4);
		leeftijdscategorieen.add(bv5);
		// /
		// /
		// / Wanneer we daadwerkelijk gaan testen moeten we hier de gegevens
		// invullen zoals ze in de database staan
		// / Zo kunnen we deze 2 objecten vergelijken en zo de werking van de
		// controller testen
		// /
		// / Een lijst van 3-4 objecten volstaat

		return leeftijdscategorieen;
	}
}
