package finah_desktop;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public abstract class AandoeningDAO {

	public static ArrayList<Aandoening> GetAandoeningen() {
		// Exception Handling nog nakijken

		Gson gson = new GsonBuilder().serializeNulls().create();
		// url WEB :
		// http://finahbackend1920.azurewebsites.net/Aandoening/Overzicht");
		BufferedReader rd = null;
		try {
			rd = SharedDAO
					.HaalGegevens("http://localhost:1695/Aandoening/Overzicht");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Type collectionType = new TypeToken<Collection<Aandoening>>() {
		}.getType();
		ArrayList<Aandoening> aandoeningen = gson.fromJson(rd, collectionType);
		System.out.println(aandoeningen.size());
		return aandoeningen;
	}

	public static Aandoening GetAandoening(int id) {
		// Exception Handling nog nakijken

		Gson gson = new GsonBuilder().serializeNulls().create();

		BufferedReader rd=null;
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
}
