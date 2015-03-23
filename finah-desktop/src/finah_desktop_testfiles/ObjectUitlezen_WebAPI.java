package finah_desktop_testfiles;

import java.io.BufferedReader;
import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import finah_desktop.Aanvraag;
import finah_desktop.SharedDAO;

public class ObjectUitlezen_WebAPI {

	public static void main(String[] args) throws ClientProtocolException,
			IOException {
		// Code leest de objecten uit de postcode Controller op de Backend
		// Deze controller dient voor test-doeleinden
		//Vraag p;
		Gson gson = new GsonBuilder().serializeNulls().create();
//		HttpClient client = new DefaultHttpClient();
//		HttpGet request = new HttpGet("http://localhost:1695/Aandoening/1");
//		// HttpGet request = new
//		// HttpGet("http://finahbackend1920.azurewebsites.net/Aandoening/" +id);
//		HttpResponse response = client.execute(request);
//		BufferedReader rd = new BufferedReader(new InputStreamReader(response
//				.getEntity().getContent()));
		//Type collectionType = new TypeToken<Aandoening>() {}.getType();
		BufferedReader rd = SharedDAO.HaalGegevens("http://localhost:1695/Aanvraag/1");
		String line = rd.readLine();
		System.out.println(line);
		Aanvraag p = gson.fromJson(line, Aanvraag.class);
		System.out.println(p.getId());// + ": " + p.getOmschrijving());
		
		System.out.println(p.toString());
//		for (int i = 0; i < p.getBijhorende_pathologie().size(); i++) {
//			System.out.println(p.getId() + ": " + p.getOmschrijving() + "  ");
//					//+ p.getBijhorende_pathologie().get(i).getId() + " "
//					//+ p.getBijhorende_pathologie().get(i).getNaam());
//		}

	}

}
