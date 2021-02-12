package it.univpm.progetto.studenti.ticketmaster.scanner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Vector;

/**
 * 
 * Classe che scannerizza in lettura il file Stati.csv contenente gli stati
 * 
 * @author RoccoAnzivino
 *
 */
public class StatiScanner {

	/**
	 * 
	 * Metodo che restituisce un vettore di stringhe costituito dagli stati letti dal file
	 * 
	 * @return statiVect Vettore di stringhe contenenti gli stati del file
	 */
	public static Vector<String> getStati() {
		
		Vector<String> statiVect = new Vector<String>();
		
		try {
			
			Scanner fileStati = new Scanner(new BufferedReader(new FileReader("resources/Stati.csv")));
			
			while (fileStati.hasNext())
				statiVect.add(fileStati.nextLine());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return statiVect;
		
	}
	
}