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

public class ChiamataEventi {
	
	public static Vector<Eventi> chiamata(String stato) {
		
		Vector<Eventi> listaEventi = new Vector<Eventi>();
		
		try {
			
			URL url = new URL("https://app.ticketmaster.com/discovery/v2/events.json?countryCode=" + stato + "&apikey=GYG4nHiptHvMOEacUHSlhyHIYwA3zrI4");
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