package finah_desktop;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;

import org.apache.http.client.ClientProtocolException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class PathologieDAO {
	public Collection<Pathologie> GetPathologieen()
			throws ClientProtocolException, IOException {
		// Exception Handling nog nakijken

		Gson gson = new GsonBuilder().serializeNulls().create();
		BufferedReader rd = SharedDAO
				.HaalGegevens("http://localhost:1695/Pathologie/Overzicht");
		Type collectionType = new TypeToken<Collection<Pathologie>>() {
		}.getType();
		Collection<Pathologie> pathologieen = gson.fromJson(rd, collectionType);

		return pathologieen;
	}

	public Pathologie GetPathologie(int id) throws ClientProtocolException,
			IOException {
		// Exception Handling nog nakijken
		// Nog opzoeken hoe in dit geval de pathologieen kunnen worden
		// uitgelezen
		Gson gson = new GsonBuilder().serializeNulls().create();
		BufferedReader rd = SharedDAO
				.HaalGegevens("http://localhost:1695/Pathologie/" + id);

		Pathologie pathologie = gson.fromJson(rd, Pathologie.class);

		return pathologie;
	}
}
