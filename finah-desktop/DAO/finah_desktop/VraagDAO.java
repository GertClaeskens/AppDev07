package finah_desktop;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class VraagDAO {
	public static ArrayList<Vraag> GetVragen(){
		// Exception Handling nog nakijken

		Gson gson = new GsonBuilder().serializeNulls().create();
		BufferedReader rd=null;
		try {
			rd = SharedDAO
					.HaalGegevens("http://localhost:1695/Vragen/Overzicht");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Type collectionType = new TypeToken<Collection<Vraag>>() {
		}.getType();
		ArrayList<Vraag> vragen = gson.fromJson(rd, collectionType);

		return vragen;
	}

	public static Vraag GetVraag(int id){
		// Exception Handling nog nakijken
		// Nog opzoeken hoe in dit geval de vraagen kunnen worden
		// uitgelezen
		Gson gson = new GsonBuilder().serializeNulls().create();
		BufferedReader rd=null;
		try {
			rd = SharedDAO
					.HaalGegevens("http://localhost:1695/Vragen/" + id);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Vraag vraag = gson.fromJson(rd, Vraag.class);

		return vraag;
	}
}
