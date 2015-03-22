package finah_desktop;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;

import org.apache.http.client.ClientProtocolException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class AanvraagDAO {
	public Collection<Aanvraag> GetAanvragen() throws ClientProtocolException,
			IOException {
		// Exception Handling nog nakijken

		Gson gson = new GsonBuilder().serializeNulls().create();
		BufferedReader rd = SharedDAO
				.HaalGegevens("http://localhost:1695/Aanvraag/Overzicht");
		Type collectionType = new TypeToken<Collection<Aanvraag>>() {
		}.getType();
		Collection<Aanvraag> aanvragen = gson.fromJson(rd, collectionType);

		return aanvragen;
	}

	public Aanvraag GetAanvraag(int id) throws ClientProtocolException,
			IOException {
		// Exception Handling nog nakijken
		// Nog opzoeken hoe in dit geval de pathologieen kunnen worden
		// uitgelezen
		Gson gson = new GsonBuilder().serializeNulls().create();

		BufferedReader rd = SharedDAO
				.HaalGegevens("http://localhost:1695/Aanvraag/Overzicht");

		Aanvraag aanvraag = gson.fromJson(rd, Aanvraag.class);

		return aanvraag;
	}
}
