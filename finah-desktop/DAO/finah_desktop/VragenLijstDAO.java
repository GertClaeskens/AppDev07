package finah_desktop;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class VragenLijstDAO {
	public static ArrayList<VragenLijst> GetVragenLijsten(){
		// Exception Handling nog nakijken

		Gson gson = new GsonBuilder().serializeNulls().create();
		BufferedReader rd=null;
		try {
			rd = SharedDAO
					.HaalGegevens("http://localhost:1695/VragenLijst/Overzicht");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Type collectionType = new TypeToken<Collection<VragenLijst>>() {
		}.getType();
		ArrayList<VragenLijst> vragenlijsten = gson.fromJson(rd, collectionType);

		return vragenlijsten;
	}

	public static VragenLijst GetVragenLijst(int id){
		// Exception Handling nog nakijken
		// Nog opzoeken hoe in dit geval de vragenlijstenlijsten kunnen worden
		// uitgelezen
		Gson gson = new GsonBuilder().serializeNulls().create();
		BufferedReader rd=null;
		try {
			rd = SharedDAO
					.HaalGegevens("http://localhost:1695/VragenLijst/" + id);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		VragenLijst vragenlijst = gson.fromJson(rd, VragenLijst.class);

		return vragenlijst;
	}
}
