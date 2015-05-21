package finah_desktop_fx.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import finah_desktop_fx.model.AccountsOverzicht;

public abstract class AccountsOverzichtDAO {


	public static ArrayList<AccountsOverzicht> GetAccountsOverzicht() {
		// Exception Handling nog nakijken

		Type collectionType = new TypeToken<Collection<AccountsOverzicht>>() {
		}.getType();

		try {
			return SharedDAO.HaalGegevens(
					"http://finahbackend1920.azurewebsites.net/?????/?????", collectionType);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public static AccountsOverzicht GetAccountsOverzicht(int id) {
		// Exception Handling nog nakijken
		Gson gson = new GsonBuilder().serializeNulls().create();

		BufferedReader rd = null;
		try {
			rd = SharedDAO.HaalGegevens("http://finahbackend1920.azurewebsites.net/?????/" + id);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (rd != null) {
			AccountsOverzicht accountsOverzicht = gson.fromJson(rd, AccountsOverzicht.class);

			return accountsOverzicht;
		}
		return null;
	}
}
