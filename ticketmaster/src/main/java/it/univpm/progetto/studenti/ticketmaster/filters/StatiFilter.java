package it.univpm.progetto.studenti.ticketmaster.filters;

import java.util.Vector;

import it.univpm.progetto.studenti.ticketmaster.model.Eventi;

public class StatiFilter {

	public static Vector<Eventi> filterByState(String stato, Vector<Eventi> eventiDaFiltrare) {
		
		Vector<Eventi> eventiFiltrati = new Vector<Eventi>();
		
		for (Eventi eventiTemp : eventiDaFiltrare) {
			
			if(stato.equals(eventiTemp.getStato()))
				eventiFiltrati.add(eventiTemp);
			
		}
		
		return eventiFiltrati;
		
	}
	
}
