package finah_desktop;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class GeluidsFragmentDAO {
	public static ArrayList<GeluidsFragment> GetGeluidsFragmenten(){
		// Exception Handling nog nakijken

		Gson gson = new GsonBuilder().serializeNulls().create();
		BufferedReader rd=null;
		try {
			rd = SharedDAO
					.HaalGegevens("http://localhost:1695/GeluidsFragment/Overzicht");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Type collectionType = new TypeToken<Collection<GeluidsFragment>>() {
		}.getType();
		ArrayList<GeluidsFragment> geluidsFragmenten = gson.fromJson(rd,
				collectionType);

		return geluidsFragmenten;
	}

	public static GeluidsFragment GetGeluidsFragment(int id){
		// Exception Handling nog nakijken
		// Nog opzoeken hoe in dit geval de pathologieen kunnen worden
		// uitgelezen
		Gson gson = new GsonBuilder().serializeNulls().create();
		BufferedReader rd=null;
		try {
			rd = SharedDAO
					.HaalGegevens("http://localhost:1695/GeluidsFragment/" + id);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (rd != null) {
			GeluidsFragment geluidsFragment = gson.fromJson(rd, GeluidsFragment.class);

			return geluidsFragment;
		}
		return null;
	}

}
