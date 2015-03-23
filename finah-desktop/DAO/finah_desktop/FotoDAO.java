package finah_desktop;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;

import org.apache.http.client.ClientProtocolException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class FotoDAO {
	public static Collection<Foto> GetFotos()
			throws ClientProtocolException, IOException {
		// Exception Handling nog nakijken

		Gson gson = new GsonBuilder().serializeNulls().create();
		BufferedReader rd = SharedDAO.HaalGegevens("http://localhost:1695/Foto/Overzicht");
		Type collectionType = new TypeToken<Collection<Foto>>() {
		}.getType();
		Collection<Foto> fotos = gson.fromJson(rd, collectionType);

		return fotos;
	}
	public static Foto GetFoto(int id)
			throws ClientProtocolException, IOException {
		// Exception Handling nog nakijken
		//Nog opzoeken hoe in dit geval de pathologieen kunnen worden uitgelezen
		Gson gson = new GsonBuilder().serializeNulls().create();
		BufferedReader rd = SharedDAO.HaalGegevens("http://localhost:1695/Foto/" +id);

		Foto foto = gson.fromJson(rd, Foto.class);

		return foto;
	}
}
