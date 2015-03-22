package finah_desktop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.Collection;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class AandoeningDAO {

	public Collection<Aandoening> GetAandoeningen()
			throws ClientProtocolException, IOException {
		// Exception Handling nog nakijken

		Gson gson = new GsonBuilder().serializeNulls().create();
		// url WEB :
		// http://finahbackend1920.azurewebsites.net/Aandoening/Overzicht");
		BufferedReader rd = SharedDAO
				.HaalGegevens("http://localhost:1695/Aandoening/Overzicht");
		Type collectionType = new TypeToken<Collection<Aandoening>>() {
		}.getType();
		Collection<Aandoening> aandoeningen = gson.fromJson(rd, collectionType);

		return aandoeningen;
	}

	public Aandoening GetAandoening(int id) throws ClientProtocolException,
			IOException {
		// Exception Handling nog nakijken
		// Nog opzoeken hoe in dit geval de pathologieen kunnen worden
		// uitgelezen
		Gson gson = new GsonBuilder().serializeNulls().create();
		// HttpGet request = new
		// HttpGet("http://finahbackend1920.azurewebsites.net/Aandoening/" +id);
		BufferedReader rd = SharedDAO
				.HaalGegevens("http://localhost:1695/Aandoening/" + id);

		Aandoening aandoening = gson.fromJson(rd, Aandoening.class);

		return aandoening;
	}
}
