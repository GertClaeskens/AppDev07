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

		Type collectionType = new TypeToken<Collection<Foto>>() {
		}.getType();
		try {
			return SharedDAO.HaalGegevens("http://finahbackend1920.azurewebsites.net/Foto/Overzicht",collectionType);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	public static Foto GetFoto(int id) {
		Gson gson = new GsonBuilder().serializeNulls().create();
		BufferedReader rd=null;
		try {
			rd = SharedDAO.HaalGegevens("http://finahbackend1920.azurewebsites.net/Foto/" +id);
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (rd != null) {
			Foto foto = gson.fromJson(rd, Foto.class);

			return foto;
		}
		return null;
	}
	
}
