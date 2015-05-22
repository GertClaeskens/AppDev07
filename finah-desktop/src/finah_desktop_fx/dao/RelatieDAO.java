package finah_desktop_fx.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import finah_desktop_fx.model.Relatie;
public class RelatieDAO {
	public static ArrayList<Relatie> GetRelaties(){

		Type collectionType = new TypeToken<Collection<Relatie>>() {
		}.getType();
		try {
			return SharedDAO
					.HaalGegevens("http://finahbackend1920.azurewebsites.net/Relatie/Overzicht",collectionType);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Relatie GetRelatie(int id){

		Gson gson = new GsonBuilder().serializeNulls().create();
		BufferedReader rd=null;
		try {
			rd = SharedDAO
					.HaalGegevens("http://finahbackend1920.azurewebsites.net/Relatie/" + id);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Relatie relatie = gson.fromJson(rd, Relatie.class);

		return relatie;
	}
}
