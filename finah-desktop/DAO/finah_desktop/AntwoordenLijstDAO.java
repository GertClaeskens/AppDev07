package finah_desktop;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public abstract class AntwoordenLijstDAO {
	public static AntwoordenLijst GetAntwoordenLijst(int id) {
		// Exception Handling nog nakijken

		Gson gson = new GsonBuilder().serializeNulls().create();

		BufferedReader rd = null;
		try {
			rd = SharedDAO.HaalGegevens("http://localhost:1695/AntwoordenLijst/"
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
			return SharedDAO.HaalGegevens("http://localhost:1695/AntwoordenLijst/Overzicht",
					collectionType);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
