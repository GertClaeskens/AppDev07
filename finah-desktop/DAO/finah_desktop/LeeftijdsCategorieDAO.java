package finah_desktop;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;

import org.apache.http.client.ClientProtocolException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class LeeftijdsCategorieDAO {
	public Collection<LeeftijdsCategorie> GetLeeftijdsCategorieen()
			throws ClientProtocolException, IOException {
		// Exception Handling nog nakijken

		Gson gson = new GsonBuilder().serializeNulls().create();
		BufferedReader rd = SharedDAO.HaalGegevens("http://localhost:1695/LeeftijdsCategorie/Overzicht");
		Type collectionType = new TypeToken<Collection<LeeftijdsCategorie>>() {
		}.getType();
		Collection<LeeftijdsCategorie> leeftijdscategorieen = gson.fromJson(rd, collectionType);

		return leeftijdscategorieen;
	}
	public LeeftijdsCategorie GetLeeftijdsCategorie(int id)
			throws ClientProtocolException, IOException {
		// Exception Handling nog nakijken
		//Nog opzoeken hoe in dit geval de pathologieen kunnen worden uitgelezen
		Gson gson = new GsonBuilder().serializeNulls().create();
		BufferedReader rd = SharedDAO.HaalGegevens("http://localhost:1695/LeeftijdsCategorie/" + id);
		LeeftijdsCategorie leeftijdsCategorie = gson.fromJson(rd, LeeftijdsCategorie.class);
		return leeftijdsCategorie;
	}
}
