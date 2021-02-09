package it.univpm.progetto.studenti.ticketmaster.parser;

import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import it.univpm.progetto.studenti.ticketmaster.model.Eventi;

public class EventiParser {

	private Vector<Eventi> listaEventi;
	
	public Vector<Eventi> parse(String chiamata) {
		
		listaEventi = new Vector<Eventi>();
		
		try {
			
			JSONParser parser = new JSONParser();
			JSONObject jO = (JSONObject) parser.parse(chiamata);
			JSONObject embedded1 = (JSONObject) jO.get("_embedded");
			JSONArray events = (JSONArray) embedded1.get("events");
			for (int i = 0; i < events.size(); i++) {
				JSONObject eventoTemp = (JSONObject) events.get(i);
				String name = (String) eventoTemp.get("name");
				String id = (String) eventoTemp.get("id");
				String url = (String) eventoTemp.get("url");
				JSONObject embedded2 = (JSONObject) eventoTemp.get("_embedded");
				JSONArray venues = (JSONArray) embedded2.get("venues");
				JSONObject venuesTemp = (JSONObject) venues.get(0);
				JSONObject state = (JSONObject) venuesTemp.get("state");
				String stateName = (String) state.get("name");
				JSONObject country = (JSONObject) venuesTemp.get("country");
				String countryName = (String) country.get("name");
				Eventi e = new Eventi(name, id, url, stateName, countryName);
				listaEventi.add(e);
			}
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return listaEventi;
		
	}
	
}
