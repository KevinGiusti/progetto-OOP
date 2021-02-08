package it.univpm.progetto.studenti.ticketmaster.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;

public class ChiamataEventi {
	
	public static /*Vector<Eventi>*/ void  chiamata(String stato) {
		
		try {
			
			URL url = new URL("https://app.ticketmaster.com/discovery/v2/events.json?countryCode=" + stato + "&apikey=GYG4nHiptHvMOEacUHSlhyHIYwA3zrI4");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String json = input.readLine();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}

}