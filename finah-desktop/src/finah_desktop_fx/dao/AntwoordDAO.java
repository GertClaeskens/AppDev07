package finah_desktop_fx.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import finah_desktop_fx.model.Antwoord;

public abstract class AntwoordDAO {
	public static Antwoord GetAntwoord(int id) {
		// Exception Handling nog nakijken

		Gson gson = new GsonBuilder().serializeNulls().create();

		BufferedReader rd = null;
		try {
			rd = SharedDAO.HaalGegevens("http://finahbackend1920.azurewebsites.net/Antwoord/"
					+ id);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Antwoord antwoord = gson.fromJson(rd, Antwoord.class);

		return antwoord;
	}

	public static ArrayList<Antwoord> GetAntwoorden() {
		// Exception Handling nog nakijken

		Type collectionType = new TypeToken<Collection<Antwoord>>() {
		}.getType();
		//ArrayList<Antwoord> antwoorden = null;
		try {
			return SharedDAO.HaalGegevens("http://finahbackend1920.azurewebsites.net/Antwoord/Overzicht",
					collectionType);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
