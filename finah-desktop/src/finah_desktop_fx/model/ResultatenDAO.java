package finah_desktop_fx.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import finah_desktop_fx.dao.SharedDAO;

public abstract class ResultatenDAO {
	
	public static ArrayList<Resultaat> GetResultaten() {
		// Exception Handling nog nakijken

		Type collectionType = new TypeToken<Collection<Resultaat>>() {
		}.getType();

		try {
			return SharedDAO.HaalGegevens(
					"http://finahbackend1920.azurewebsites.net/Resultaten/Overzicht", collectionType);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public static Resultaat GetResultaat(int id) {
		// Exception Handling nog nakijken
		Gson gson = new GsonBuilder().serializeNulls().create();

		BufferedReader rd = null;
		try {
			rd = SharedDAO.HaalGegevens("http://finahbackend1920.azurewebsites.net/Resultaten/" + id);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (rd != null) {
			Resultaat resultaat = gson.fromJson(rd, Resultaat.class);

			return resultaat;
		}
		return null;
	}

	
}
