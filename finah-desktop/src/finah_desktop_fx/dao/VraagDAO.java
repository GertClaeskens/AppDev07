package finah_desktop_fx.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import finah_desktop_fx.model.Vraag;
public class VraagDAO {
	public static ArrayList<Vraag> GetVragen() {
		// Exception Handling nog nakijken

		Type collectionType = new TypeToken<Collection<Vraag>>() {}.getType();
		try {
			return SharedDAO.HaalGegevens(
					"http://finahbackend1920.azurewebsites.net/Vragen/Overzicht", collectionType);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public static Vraag GetVraag(int id) {
		// Exception Handling nog nakijken
		// Nog opzoeken hoe in dit geval de vraagen kunnen worden
		// uitgelezen
		Gson gson = new GsonBuilder().serializeNulls().create();
		BufferedReader rd = null;
		try {
			rd = SharedDAO.HaalGegevens("http://finahbackend1920.azurewebsites.net/Vragen/" + id);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Vraag vraag = gson.fromJson(rd, Vraag.class);

		return vraag;
	}
}
