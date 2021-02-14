package it.univpm.progetto.studenti.ticketmaster.parser;

import java.time.LocalDate;
import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import it.univpm.progetto.studenti.ticketmaster.filters.MinMaxAverageFilter;
import it.univpm.progetto.studenti.ticketmaster.model.Eventi;

/**
 * Classe che analizza il codice json della chiamata alla rotta events dell'API di ticketmaster
 * 
 * @author RoccoAnzivino
 * @author KevinGiusti
 */
public class EventiParser {

	/**
	 * Vettore di Eventi nel quale vengono inseriti gli eventi creati
	 * a partire dal JSON e poi viene restituito alla classe ChiamataEventi
	 */
	private Vector<Eventi> listaEventi;
	
	/**
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
				String url = (String) eventoTemp.get("url");
				
				JSONObject dates = (JSONObject) eventoTemp.get("dates");
				
				JSONObject start = (JSONObject) dates.get("start");
				String localDate = (String) start.get("localDate");
				
				LocalDate locDt = MinMaxAverageFilter.dateConverter(localDate);
				String localTime = (String) start.get("localTime");
				
				JSONArray classifications = (JSONArray) eventoTemp.get("classifications");
				
				JSONObject classificationsTemp = (JSONObject) classifications.get(0);
				
				JSONObject genre = (JSONObject) classificationsTemp.get("genre");
				String nameGenre = (String) genre.get("name");
				
				JSONObject subGenre = (JSONObject) classificationsTemp.get("subGenre");
				String nameSubGenre = (String) subGenre.get("name");
				
				JSONObject embedded2 = (JSONObject) eventoTemp.get("_embedded");
				
				JSONArray venues = (JSONArray) embedded2.get("venues");
				
				JSONObject venuesTemp = (JSONObject) venues.get(0);
				
				JSONObject city = (JSONObject) venuesTemp.get("city");
				String cityName = (String) city.get("name");
				
				JSONObject state = (JSONObject) venuesTemp.get("state");
				String stateName = (String) state.get("name");
				
				JSONObject country = (JSONObject) venuesTemp.get("country");
				String countryName = (String) country.get("name");
				
				Eventi e = new Eventi(name, url, cityName, stateName, countryName, locDt, localTime, 
						nameGenre, nameSubGenre);

				listaEventi.add(e);
			
			}
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return listaEventi;
		
	}

}
