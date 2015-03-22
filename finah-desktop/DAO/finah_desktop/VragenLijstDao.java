package finah_desktop;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;

import org.apache.http.client.ClientProtocolException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class VragenLijstDao {
	public Collection<VragenLijst> GetVragenLijsten()
			throws ClientProtocolException, IOException {
		// Exception Handling nog nakijken

		Gson gson = new GsonBuilder().serializeNulls().create();
		BufferedReader rd = SharedDAO
				.HaalGegevens("http://localhost:1695/VragenLijst/Overzicht");
		Type collectionType = new TypeToken<Collection<VragenLijst>>() {
		}.getType();
		Collection<VragenLijst> vragenlijsten = gson.fromJson(rd, collectionType);

		return vragenlijsten;
	}

	public VragenLijst GetVragenLijst(int id) throws ClientProtocolException, IOException {
		// Exception Handling nog nakijken
		// Nog opzoeken hoe in dit geval de vragenlijstenlijsten kunnen worden
		// uitgelezen
		Gson gson = new GsonBuilder().serializeNulls().create();
		BufferedReader rd = SharedDAO
				.HaalGegevens("http://localhost:1695/VragenLijst/" + id);

		VragenLijst vragenlijst = gson.fromJson(rd, VragenLijst.class);

		return vragenlijst;
	}
}
