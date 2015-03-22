package finah_desktop;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;

import org.apache.http.client.ClientProtocolException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class BevragingDAO {
	public Collection<Bevraging> GetBevragings()
			throws ClientProtocolException, IOException {
		// Exception Handling nog nakijken

		Gson gson = new GsonBuilder().serializeNulls().create();
		BufferedReader rd = SharedDAO.HaalGegevens("http://localhost:1695/Bevraging/Overzicht");
		Type collectionType = new TypeToken<Collection<Bevraging>>() {
		}.getType();
		Collection<Bevraging> bevragings = gson.fromJson(rd, collectionType);

		return bevragings;
	}
	public Bevraging GetBevraging(int id)
			throws ClientProtocolException, IOException {
		// Exception Handling nog nakijken
		//Nog opzoeken hoe in dit geval de pathologieen kunnen worden uitgelezen
		Gson gson = new GsonBuilder().serializeNulls().create();
		BufferedReader rd = SharedDAO.HaalGegevens("http://localhost:1695/Bevraging/" +id);

		Bevraging bevraging = gson.fromJson(rd, Bevraging.class);

		return bevraging;
	}
}

