package finah_desktop_fx.dao;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import finah_desktop_fx.model.Bevraging;

public class BevragingDAO {
	public static ArrayList<Bevraging> GetBevragingen() {

		Type collectionType = new TypeToken<Collection<Bevraging>>() {
		}.getType();
		try {
			return SharedDAO
					.HaalGegevens("http://finahbackend1920.azurewebsites.net/Bevraging/Overzicht",collectionType);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Bevraging GetBevraging(String id) {
		Gson gson = new GsonBuilder().serializeNulls().create();
		BufferedReader rd = null;
		try {
			rd = SharedDAO
					.HaalGegevens("http://finahbackend1920.azurewebsites.net/Bevraging/" + id);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (rd != null) {
			Bevraging bevraging = gson.fromJson(rd, Bevraging.class);
			return bevraging;
		}
		return null;
	}
}
