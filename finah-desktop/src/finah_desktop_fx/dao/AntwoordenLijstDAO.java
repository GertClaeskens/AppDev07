package finah_desktop_fx.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import finah_desktop_fx.model.AntwoordenLijst;

public abstract class AntwoordenLijstDAO {
	public static AntwoordenLijst GetAntwoordenLijst(String id) {
		// Exception Handling nog nakijken

		Gson gson = new GsonBuilder().serializeNulls().create();

		BufferedReader rd = null;
		try {
			rd = SharedDAO.HaalGegevens("http://finahbackend1920.azurewebsites.net/AntwoordenLijst/"
					+ id);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		AntwoordenLijst antwoordenLijst = gson.fromJson(rd, AntwoordenLijst.class);

		return antwoordenLijst;
	}

	public static ArrayList<AntwoordenLijst> GetAntwoordenLijsten() {
		// Exception Handling nog nakijken

		Type collectionType = new TypeToken<Collection<AntwoordenLijst>>() {
		}.getType();
		//ArrayList<AntwoordenLijst> antwoordenLijsten = null;
		try {
			return SharedDAO.HaalGegevens("http://finahbackend1920.azurewebsites.net/AntwoordenLijst/Overzicht",
					collectionType);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
