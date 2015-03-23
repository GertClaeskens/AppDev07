package finah_desktop;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class BevragingDAO {
	public static ArrayList<Bevraging> GetBevragingen() {
		// Exception Handling nog nakijken

		Gson gson = new GsonBuilder().serializeNulls().create();
		BufferedReader rd = null;
		try {
			rd = SharedDAO
					.HaalGegevens("http://localhost:1695/Bevraging/Overzicht");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Type collectionType = new TypeToken<Collection<Bevraging>>() {
		}.getType();
		ArrayList<Bevraging> bevragingen = gson.fromJson(rd, collectionType);

		return bevragingen;
	}

	public static Bevraging GetBevraging(String id) {
		// Exception Handling nog nakijken
		// Nog opzoeken hoe in dit geval de pathologieen kunnen worden
		// uitgelezen
		Gson gson = new GsonBuilder().serializeNulls().create();
		BufferedReader rd = null;
		try {
			rd = SharedDAO
					.HaalGegevens("http://localhost:1695/Bevraging/" + id);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (rd != null) {
			Bevraging bevraging = gson.fromJson(rd, Bevraging.class);
			return bevraging;

		}

		return null;

	}
}
