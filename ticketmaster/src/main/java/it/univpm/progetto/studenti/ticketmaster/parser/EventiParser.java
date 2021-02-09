package it.univpm.progetto.studenti.ticketmaster.parser;

import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import it.univpm.progetto.studenti.ticketmaster.model.Eventi;

/**
 * 
 * Classe che analizza il codice json della chiamata alla rotta events dell'API di ticketmaster
 * 
 * @author RoccoAnzivino
 *
 */
public class EventiParser {

	/**
	 * 
	 * Vettore di Eventi nel quale vengono inseriti gli eventi creati
	 * a partire dal json e poi viene restituito alla classe ChiamataEventi
	 *
	 */
	private Vector<Eventi> listaEventi;
	
	/**
	 * 
	 * Metodo che analizza il json della chiamata events e restituisce un vettore di eventi
	 * 
	 * @param chiamata Fornisce il codice json che viene analizzato dal metodo
	 * @return listaEventi Vettore di Eventi contenente gli eventi creati, poi restituito
	 * @see it.univpm.progetto.studenti.ticketmaster.model.Eventi
	 * @see it.univpm.progetto.studenti.ticketmaster.api
	 */
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
