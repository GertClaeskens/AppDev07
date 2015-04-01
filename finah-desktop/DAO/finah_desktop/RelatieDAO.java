package finah_desktop;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class RelatieDAO {
	public static ArrayList<Relatie> GetRelaties(){
		// TODO Exception Handling nog nakijken

		Type collectionType = new TypeToken<Collection<Relatie>>() {
		}.getType();
		try {
			return SharedDAO
					.HaalGegevens("http://localhost:1695/Relatie/Overzicht",collectionType);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static Relatie GetRelatie(int id){
		// TODO Exception Handling nog nakijken

		Gson gson = new GsonBuilder().serializeNulls().create();
		BufferedReader rd=null;
		try {
			rd = SharedDAO
					.HaalGegevens("http://localhost:1695/Relatie/" + id);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Relatie relatie = gson.fromJson(rd, Relatie.class);

		return relatie;
	}
}
