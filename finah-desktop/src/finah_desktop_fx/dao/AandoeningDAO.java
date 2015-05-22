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
		Gson gson = new GsonBuilder().serializeNulls().create();

		BufferedReader rd = null;
		try {
			rd = SharedDAO.HaalGegevens("http://finahbackend1920.azurewebsites.net/Aandoening/"
					+ id);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Aandoening aandoening = gson.fromJson(rd, Aandoening.class);

		return aandoening;
	}

	public static ArrayList<Aandoening> GetAandoeningen() {

		Type collectionType = new TypeToken<Collection<Aandoening>>() {
		}.getType();
		try {
			return SharedDAO.HaalGegevens("http://finahbackend1920.azurewebsites.net/Aandoening/Overzicht",
					collectionType);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void PasAandoeningAan(Aandoening aandoening){
		
	}
}
