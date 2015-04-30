package finah_desktop_fx.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import finah_desktop_fx.model.Aandoening;

public abstract class AandoeningDAO {

	public static Aandoening GetAandoening(int id) {
		// Exception Handling nog nakijken

		Gson gson = new GsonBuilder().serializeNulls().create();

		BufferedReader rd = null;
		try {
			rd = SharedDAO.HaalGegevens("http://localhost:1695/Aandoening/"
					+ id);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Aandoening aandoening = gson.fromJson(rd, Aandoening.class);

		return aandoening;
	}

	public static ArrayList<Aandoening> GetAandoeningen() {
		// Exception Handling nog nakijken

		Type collectionType = new TypeToken<Collection<Aandoening>>() {
		}.getType();
		//ArrayList<Aandoening> aandoeningen = null;
		try {
			return SharedDAO.HaalGegevens("http://localhost:1695/Aandoening/Overzicht",
					collectionType);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
