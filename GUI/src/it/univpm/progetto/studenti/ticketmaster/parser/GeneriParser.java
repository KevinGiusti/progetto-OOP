package it.univpm.progetto.studenti.ticketmaster.parser;

import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class GeneriParser {

public static Vector<String> generi(String chiamata) {
		
		Vector<String> generiVect = new Vector<String>();
		
		try {
			
			JSONParser parser = new JSONParser();
			
			JSONArray jA = (JSONArray) parser.parse(chiamata);
			
			for(int i = 0; i < jA.size(); i++)
				generiVect.add((String) jA.get(i));
			
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return generiVect;
		
	}
	
}
