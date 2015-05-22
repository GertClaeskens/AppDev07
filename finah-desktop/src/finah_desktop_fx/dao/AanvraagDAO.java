package finah_desktop_fx.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import finah_desktop_fx.model.Aanvraag;



public class AanvraagDAO {
	public static ArrayList<Aanvraag> GetAanvragen() {
		Type collectionType = new TypeToken<Collection<Aanvraag>>() {
		}.getType();

		try {
			return SharedDAO.HaalGegevens(
					"http://finahbackend1920.azurewebsites.net/Aanvraag/Overzicht", collectionType);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static Aanvraag GetAanvraag(int id) {
		Gson gson = new GsonBuilder().serializeNulls().create();

		BufferedReader rd = null;
		try {
			rd = SharedDAO.HaalGegevens("http://finahbackend1920.azurewebsites.net/Aanvraag/" + id);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (rd != null) {
			Aanvraag aanvraag = gson.fromJson(rd, Aanvraag.class);

			return aanvraag;
		}
		return null;
	}
}
