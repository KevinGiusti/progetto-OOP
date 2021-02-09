package it.univpm.progetto.studenti.ticketmaster.scanner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Vector;

public class StatiScanner {

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
