package finah_desktop;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import finah_desktop_fx.dao.FotoDAO;
import finah_desktop_fx.model.Foto;
public class TestFotoDAO {
	private ArrayList<Foto> testFotos;
	private ArrayList<Foto> controleFotos;

	

	@Before
	public void init() {
		testFotos = GetTestFotos();
		
	}

	@Test
	public void GetOverzicht_ShouldReturnAllFotos() {
		testFotos = FotoDAO.GetFotos();
		controleFotos = TestFotoDAO.GetTestFotos();

		Assert.assertEquals(controleFotos.size(), testFotos.size());
	}

	@Test
	public void Get_ShouldReturnCorrectFoto() {
		Foto foto = new Foto();
		foto.setId(1);
		Foto test = FotoDAO.GetFoto(1);
		Assert.assertNotNull(test);
		// Controleren of beide objecten gelijk zijn (Comparable?)
		Assert.assertEquals(foto.getId(), test.getId());
	}

	@Test
	public void Get_ShouldNotFindFoto() {
		// Id meegeven die zeker niet in de database voorkomt
		Foto result = FotoDAO.GetFoto(999999999);
		Assert.assertNull(result);
	}

	private static ArrayList<Foto> GetTestFotos() {
		ArrayList<Foto> fotos = new ArrayList<Foto>();
		Foto bv1 = new Foto();
		Foto bv2 = new Foto();
		Foto bv3 = new Foto();
		Foto bv4 = new Foto();
		Foto bv5 = new Foto();
		
		fotos.add(bv1);
		fotos.add(bv2);
		fotos.add(bv3);
		fotos.add(bv4);
		fotos.add(bv5);
		// /
		// /
		// / Wanneer we daadwerkelijk gaan testen moeten we hier de gegevens
		// invullen zoals ze in de database staan
		// / Zo kunnen we deze 2 objecten vergelijken en zo de werking van de
		// controller testen
		// /
		// / Een lijst van 3-4 objecten volstaat

		return fotos;
	}
}
