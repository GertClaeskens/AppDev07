package finah_desktop;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class LeeftijdsCategorieDAO {
	public static ArrayList<LeeftijdsCategorie> GetLeeftijdsCategorieen(){
		// Exception Handling nog nakijken

		Gson gson = new GsonBuilder().serializeNulls().create();
		BufferedReader rd=null;
		try {
			rd = SharedDAO.HaalGegevens("http://localhost:1695/LeeftijdsCategorie/Overzicht");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Type collectionType = new TypeToken<Collection<LeeftijdsCategorie>>() {
		}.getType();
		ArrayList<LeeftijdsCategorie> leeftijdscategorieen = gson.fromJson(rd, collectionType);

		return leeftijdscategorieen;
	}
	public static LeeftijdsCategorie GetLeeftijdsCategorie(int id){
		// Exception Handling nog nakijken
		//Nog opzoeken hoe in dit geval de pathologieen kunnen worden uitgelezen
		Gson gson = new GsonBuilder().serializeNulls().create();
		BufferedReader rd=null;
		try {
			rd = SharedDAO.HaalGegevens("http://localhost:1695/LeeftijdsCategorie/" + id);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LeeftijdsCategorie leeftijdsCategorie = gson.fromJson(rd, LeeftijdsCategorie.class);
		return leeftijdsCategorie;
	}
}
