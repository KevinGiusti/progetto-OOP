package it.univpm.progetto.studenti.ticketmaster.scanner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Classe che scannerizza in lettura il file APIKey.txt contenente la chiave dell'API inserita dall'utente
 * 
 * @author RoccoAnzivino
 */
public class APIKeyScanner {

	/**
	 * Metodo che restituisce una stringa che contiene la chiave dell'API inserita dall'utente
	 * 
	 * @return key Stringa contenente la chiave dell'API
	 */
	public static String getKey() {
		
		String key = new String();
		
		try {
			
			Scanner fileAPIKey = new Scanner(new BufferedReader(new FileReader("resources/APIKey.txt")));
			
			while (fileAPIKey.hasNext())
				key = fileAPIKey.nextLine();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return key;
		
	}
	
}
