package finah_desktop_fx.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import finah_desktop_fx.model.GeluidsFragment;
public class GeluidsFragmentDAO {
	public static ArrayList<GeluidsFragment> GetGeluidsFragmenten() {
		Type collectionType = new TypeToken<Collection<GeluidsFragment>>() {
		}.getType();
		try {
			return SharedDAO.HaalGegevens(
					"http://finahbackend1920.azurewebsites.net/GeluidsFragment/Overzicht",
					collectionType);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static GeluidsFragment GetGeluidsFragment(int id) {
		Gson gson = new GsonBuilder().serializeNulls().create();
		BufferedReader rd = null;
		try {
			rd = SharedDAO
					.HaalGegevens("http://finahbackend1920.azurewebsites.net/GeluidsFragment/" + id);
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (rd != null) {
			GeluidsFragment geluidsFragment = gson.fromJson(rd,
					GeluidsFragment.class);

			return geluidsFragment;
		}
		return null;
	}

}
