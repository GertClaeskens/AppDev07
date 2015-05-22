package finah_desktop_fx.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import finah_desktop_fx.model.LeeftijdsCategorie;
public class LeeftijdsCategorieDAO {
	public static ArrayList<LeeftijdsCategorie> GetLeeftijdsCategorieen() {

		Type collectionType = new TypeToken<Collection<LeeftijdsCategorie>>() {
		}.getType();
		try {
			return SharedDAO.HaalGegevens(
					"http://finahbackend1920.azurewebsites.net/LeeftijdsCategorie/Overzicht",
					collectionType);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static LeeftijdsCategorie GetLeeftijdsCategorie(int id) {
		Gson gson = new GsonBuilder().serializeNulls().create();
		BufferedReader rd = null;
		try {
			rd = SharedDAO
					.HaalGegevens("http://finahbackend1920.azurewebsites.net/LeeftijdsCategorie/"
							+ id);
		} catch (IOException e) {
			e.printStackTrace();
		}
		LeeftijdsCategorie leeftijdsCategorie = gson.fromJson(rd,
				LeeftijdsCategorie.class);
		return leeftijdsCategorie;
	}
}
