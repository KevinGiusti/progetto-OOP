package it.univpm.progetto.studenti.ticketmaster.scanner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Vector;

/**
 * 
 * Classe che scannerizza in lettura il file Generi.csv contenente i generi
 * 
 * @author RoccoAnzivino
 *
 */
public class GeneriScanner {

	/**
	 * 
	 * Metodo che restituisce un vettore di stringhe costituito dai generi letti dal file
	 * 
	 * @return generiVect Vettore di stringhe contenenti i generi del file
	 */
	public static Vector<String> getGeneri() {
		
		Vector<String> generiVect = new Vector<String>();
		
		try {
			
			Scanner fileGeneri = new Scanner(new BufferedReader(new FileReader("resources/Generi.csv")));
			
			while (fileGeneri.hasNext())
				generiVect.add(fileGeneri.nextLine());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return generiVect;
		
	}
	
}
