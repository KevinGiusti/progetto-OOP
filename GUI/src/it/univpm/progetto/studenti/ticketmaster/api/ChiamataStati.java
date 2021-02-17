package it.univpm.progetto.studenti.ticketmaster.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;

import it.univpm.progetto.studenti.ticketmaster.parser.StatiParser;

public class ChiamataStati {

	public static Vector<String> chiamata() {

		Vector<String> stati = new Vector<String>();

		try {

			URL url = new URL("http://localhost:8080/stati");

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			String json = input.readLine();

			stati = StatiParser.stati(json);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return stati;

	}

}