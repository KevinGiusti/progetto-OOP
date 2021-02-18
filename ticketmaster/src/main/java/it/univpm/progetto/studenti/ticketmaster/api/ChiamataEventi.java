package it.univpm.progetto.studenti.ticketmaster.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;

import it.univpm.progetto.studenti.ticketmaster.model.Eventi;
import it.univpm.progetto.studenti.ticketmaster.parser.EventiParser;
import it.univpm.progetto.studenti.ticketmaster.scanner.APIKeyScanner;

/**
 * Classe contenente la chiamata alla rotta events
 * 
 * @author RoccoAnzivino
 */
public class ChiamataEventi {
	
	/**
	 * Metodo static che effettua la chiamata alla rotta events 
	 * e passa il json al metodo parse della classe EventiParser
	 * 
	 * @param paese Organizza gli eventi presi dalla chiamata in base al paese
	 * @return listaEventi Vettore di Eventi ritornato dal metodo parse della classe EventiParser
	 * @see it.univpm.progetto.studenti.ticketmaster.model.Eventi
	 * @see it.univpm.progetto.studenti.ticketmaster.parser.EventiParser
	 */
	public static Vector<Eventi> chiamata(String paese) {
		
		Vector<Eventi> listaEventi = new Vector<Eventi>();
		String key = APIKeyScanner.getKey();
		
		try {
			
			URL url = new URL("https://app.ticketmaster.com/discovery/v2/events.json?countryCode=" 
								+ paese + "&apikey=" + key);
			
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
					
			BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			
			String json = input.readLine();
			
			EventiParser eP = new EventiParser();
			
			listaEventi = eP.parse(json);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return listaEventi;
	
	}

}