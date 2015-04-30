package finah_desktop_fx.dao;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

import javafx.collections.ObservableList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import finah_desktop_fx.model.Foto;

public class FotoDAO {
	public static ArrayList<Foto> GetFotos(){
		// Exception Handling nog nakijken

		Type collectionType = new TypeToken<Collection<Foto>>() {
		}.getType();
		try {
			return SharedDAO.HaalGegevens("http://localhost:1695/Foto/Overzicht",collectionType);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	public static Foto GetFoto(int id) {
		// Exception Handling nog nakijken
		//Nog opzoeken hoe in dit geval de pathologieen kunnen worden uitgelezen
		Gson gson = new GsonBuilder().serializeNulls().create();
		BufferedReader rd=null;
		try {
			rd = SharedDAO.HaalGegevens("http://localhost:1695/Foto/" +id);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (rd != null) {
			Foto foto = gson.fromJson(rd, Foto.class);

			return foto;
		}
		return null;
	}
	
}
