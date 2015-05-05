package finah_desktop_fx.model;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class Aandoening extends SuperklasseAandoeningPathologie implements
		JsonSerializer<Aandoening>, JsonDeserializer<Aandoening> {

	// PropertyValueType getName()
	// void setName(PropertyValueType value)
	// PropertyType nameProperty()
	private List<Pathologie> Patologieen;

	public List<Pathologie> getBijhorende_pathologie() {
		return Patologieen;
	}

	public void voegPathologieToe(Pathologie pat) {
		Patologieen.add(pat);

	}

	public Aandoening(int id, String omschrijving) {
		this.Id = id;
		this.Omschrijving = omschrijving;
	}

	public void voegPathologieLijstToe(ArrayList<Pathologie> patlijst) {
		Patologieen = patlijst;
	}

	public void setBijhorende_pathologie(List<Pathologie> bijhorende_pathologie) {
		this.Patologieen = bijhorende_pathologie;
	}

	public Aandoening() {
		Patologieen = new ArrayList<Pathologie>();
	}

	@Override
	public String toString() {
		return this.getOmschrijving();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + this.getId();
		result = prime
				* result
				+ ((this.getOmschrijving() == null) ? 0 : this
						.getOmschrijving().hashCode());
		result = prime * result
				+ ((Patologieen == null) ? 0 : Patologieen.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aandoening other = (Aandoening) obj;
		if (this.getId() != other.getId())
			return false;
		if (this.getOmschrijving() == null) {
			if (other.getOmschrijving() != null)
				return false;
		} else if (!this.getOmschrijving().equals(other.getOmschrijving()))
			return false;
		if (Patologieen == null) {
			if (other.Patologieen != null)
				return false;
		} else if (!Patologieen.equals(other.Patologieen))
			return false;
		return true;
	}

	@Override
	public JsonElement serialize(Aandoening aand, Type arg1,
			JsonSerializationContext arg2) {
		JsonObject object = new JsonObject();
		int id = aand.getId();
		String omschrijving = aand.getOmschrijving();
		object.addProperty("Id", id);
		object.addProperty("Omschrijving", omschrijving);
		// we create the json object for the dog and send it back to the
		// Gson serializer
		return object;
	}

	@Override
	public Aandoening deserialize(JsonElement json, Type typeOfT,
			JsonDeserializationContext context) throws JsonParseException {
		int id = json.getAsJsonObject().get("id").getAsInt();
		String omschrijving = json.getAsJsonObject().get("omschrijving")
				.getAsString();
		Aandoening a = new Aandoening();
		a.setId(id);
		a.setOmschrijving(omschrijving);

		return a;
	}

	// public Aandoening(String naam) {
	// super(naam);
	// }
	// public Aandoening(String naam,Pathologie patholog) {
	// super(naam);
	// }
}
