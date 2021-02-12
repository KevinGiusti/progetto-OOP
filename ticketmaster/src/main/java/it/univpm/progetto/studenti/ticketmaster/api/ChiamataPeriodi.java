package it.univpm.progetto.studenti.ticketmaster.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Vector;

import it.univpm.progetto.studenti.ticketmaster.model.Eventi;
import it.univpm.progetto.studenti.ticketmaster.parser.PeriodiParser;


public class ChiamataPeriodi {
	
	/**
	 * 
	 * Metodo static che effettua la chiamata alla rotta eventi 
	 * e passa il json al metodo parse della classe EventiParser
	 * 
	 * @param paese Organizza gli eventi presi dalla chiamata in base al paese
	 * @return listaEventi Vettore di Eventi ritornato dal metodo parse della classe EventiParser
	 * 
	 */
	public static Vector<Eventi> chiamataPeriodi(LocalDate data1, LocalDate data2) {
		
		//LocalDate[] dueDate = new LocalDate[2];
		Vector<Eventi> listaEventi = new Vector<Eventi>();
		
		try {
			System.out.println("innnnnnnnnnnnnnnnnnnnnnnn");
			URL url = new URL("http://localhost:8080/eventi");
			
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String json = input.readLine();
			PeriodiParser periodiParser = new PeriodiParser();
			listaEventi = periodiParser.parse(json);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listaEventi;
	}
}
