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
			JSONObject embedded = (JSONObject) jO.get("_embedded");
			JSONArray events = (JSONArray) embedded.get("events");
			for (int i = 0; i < events.size(); i++) {
				JSONObject x = (JSONObject) events.get(i);
				String name = (String) x.get("name");
				String type = (String) x.get("type");
				String id = (String) x.get("id");
				String url = (String) x.get("url");
				Eventi e = new Eventi(name, type, id, url);
				listaEventi.add(e);
			}
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return listaEventi;
		
	}
	
}
