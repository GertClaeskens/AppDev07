package finah_desktop_fx.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import finah_desktop_fx.model.Pathologie;
public class PathologieDAO {
	public static ArrayList<Pathologie> GetPathologieen(){
		// Exception Handling nog nakijken

		Type collectionType = new TypeToken<Collection<Pathologie>>() {
		}.getType();
		try {
			return SharedDAO
					.HaalGegevens("http://finahbackend1920.azurewebsites.net/Pathologie/Overzicht",collectionType);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static Pathologie GetPathologie(int id){
		// Exception Handling nog nakijken
		// Nog opzoeken hoe in dit geval de pathologieen kunnen worden
		// uitgelezen
		Gson gson = new GsonBuilder().serializeNulls().create();
		BufferedReader rd=null;
		try {
			rd = SharedDAO
					.HaalGegevens("http://finahbackend1920.azurewebsites.net/Pathologie/" + id);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Pathologie pathologie = gson.fromJson(rd, Pathologie.class);

		return pathologie;
	}
}
