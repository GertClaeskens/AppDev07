package finah_desktop_fx.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import finah_desktop_fx.model.Thema;

public class ThemaDAO {
	public static ArrayList<Thema> GetThemas(){
		// TODO Exception Handling nog nakijken

		Type collectionType = new TypeToken<Collection<Thema>>() {
		}.getType();
		try {
			return SharedDAO
					.HaalGegevens("http://localhost:1695/Thema/Overzicht",collectionType);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static Thema GetThema(int id){
		// TODO Exception Handling nog nakijken

		Gson gson = new GsonBuilder().serializeNulls().create();
		BufferedReader rd=null;
		try {
			rd = SharedDAO
					.HaalGegevens("http://localhost:1695/Thema/" + id);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Thema relatie = gson.fromJson(rd, Thema.class);

		return relatie;
	}
}

