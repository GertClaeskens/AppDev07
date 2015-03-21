package finah_desktop_testfiles;

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

import finah_desktop.*;

public class Uitlezen_WebAPI {

	public static void main(String[] args) throws ClientProtocolException,
			IOException {
		// Code leest de objecten uit de postcode Controller op de Backend
		// Deze controller dient voor test-doeleinden

		Gson gson = new GsonBuilder().serializeNulls().create();
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(
				"http://localhost:1695/Postcode/Overzicht");
		// HttpGet request = new HttpGet("http://finahbackend1920.azurewebsites.net/Postcode/Overzicht");
		HttpResponse response = client.execute(request);
		BufferedReader rd = new BufferedReader(new InputStreamReader(response
				.getEntity().getContent()));
		String line;
		Type collectionType = new TypeToken<Collection<Postcode>>() {
		}.getType();
		Collection<Postcode> pc = gson.fromJson(rd, collectionType);

		if (pc != null) {
			for (Postcode p : pc) {
				System.out.println(p.getId() + ": " + p.getPostnr() + "  "
						+ p.getGemeente());
			}
		}
		System.out.println(rd.readLine());
		while ((line = rd.readLine()) != null) {
			System.out.println(line);
		}

	}

}
