package finah_desktop;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;

import org.apache.http.client.ClientProtocolException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class GeluidsFragmentDAO {
	public Collection<GeluidsFragment> GetGeluidsFragmenten()
			throws ClientProtocolException, IOException {
		// Exception Handling nog nakijken

		Gson gson = new GsonBuilder().serializeNulls().create();
		BufferedReader rd = SharedDAO
				.HaalGegevens("http://localhost:1695/GeluidsFragment/Overzicht");
		Type collectionType = new TypeToken<Collection<GeluidsFragment>>() {
		}.getType();
		Collection<GeluidsFragment> geluidsFragmenten = gson.fromJson(rd,
				collectionType);

		return geluidsFragmenten;
	}

	public GeluidsFragment GetGeluidsFragment(int id)
			throws ClientProtocolException, IOException {
		// Exception Handling nog nakijken
		// Nog opzoeken hoe in dit geval de pathologieen kunnen worden
		// uitgelezen
		Gson gson = new GsonBuilder().serializeNulls().create();
		BufferedReader rd = SharedDAO
				.HaalGegevens("http://localhost:1695/GeluidsFragment/" + id);

		GeluidsFragment geluidsFragment = gson.fromJson(rd,
				GeluidsFragment.class);

		return geluidsFragment;
	}

}
