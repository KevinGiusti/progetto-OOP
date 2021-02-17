package it.univpm.progetto.studenti.ticketmaster.parser;

import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class StatiParser {
	
	public static Vector<String> stati(String chiamata) {
		
		Vector<String> statiVect = new Vector<String>();
		
		try {
			
			JSONParser parser = new JSONParser();
			
			JSONArray jA = (JSONArray) parser.parse(chiamata);
			
			for(int i = 0; i < jA.size(); i++)
				statiVect.add((String) jA.get(i));
			
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return statiVect;
		
	}

}