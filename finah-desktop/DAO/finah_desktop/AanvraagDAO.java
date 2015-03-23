package finah_desktop;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class AanvraagDAO {
	public static ArrayList<Aanvraag> GetAanvragen() {
		// Exception Handling nog nakijken

		Gson gson = new GsonBuilder().serializeNulls().create();
		BufferedReader rd = null;
		try {
			rd = SharedDAO
					.HaalGegevens("http://localhost:1695/Aanvraag/Overzicht");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Type collectionType = new TypeToken<Collection<Aanvraag>>() {
		}.getType();
		ArrayList<Aanvraag> aanvragen = gson.fromJson(rd, collectionType);

		return aanvragen;
	}

	public static Aanvraag GetAanvraag(int id) {
		// Exception Handling nog nakijken
		// Nog opzoeken hoe in dit geval de pathologieen kunnen worden
		// uitgelezen
		Gson gson = new GsonBuilder().serializeNulls().create();

		BufferedReader rd = null;
		try {
			rd = SharedDAO.HaalGegevens("http://localhost:1695/Aanvraag/" + id);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (rd != null) {
			Aanvraag aanvraag = gson.fromJson(rd, Aanvraag.class);

			return aanvraag;
		}
		return null;
	}
}
