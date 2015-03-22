package finah_desktop;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;

import org.apache.http.client.ClientProtocolException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class VraagDAO {
	public Collection<Vraag> GetVragen()
			throws ClientProtocolException, IOException {
		// Exception Handling nog nakijken

		Gson gson = new GsonBuilder().serializeNulls().create();
		BufferedReader rd = SharedDAO
				.HaalGegevens("http://localhost:1695/Vragen/Overzicht");
		Type collectionType = new TypeToken<Collection<Vraag>>() {
		}.getType();
		Collection<Vraag> vragen = gson.fromJson(rd, collectionType);

		return vragen;
	}

	public Vraag GetVraag(int id) throws ClientProtocolException,
			IOException {
		// Exception Handling nog nakijken
		// Nog opzoeken hoe in dit geval de vraagen kunnen worden
		// uitgelezen
		Gson gson = new GsonBuilder().serializeNulls().create();
		BufferedReader rd = SharedDAO
				.HaalGegevens("http://localhost:1695/Vragen/" + id);

		Vraag vraag = gson.fromJson(rd, Vraag.class);

		return vraag;
	}
}
