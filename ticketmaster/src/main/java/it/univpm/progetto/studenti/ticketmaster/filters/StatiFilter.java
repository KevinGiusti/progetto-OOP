package it.univpm.progetto.studenti.ticketmaster.filters;

import java.util.Vector;

import it.univpm.progetto.studenti.ticketmaster.model.Eventi;

/**
 * 
 * Classe che effettua un filtro sugli stati
 * 
 * @author RoccoAnzivino
 *
 */
public class StatiFilter {

	/**
	 * 
	 * Metodo che filtra per stati gli eventi
	 * 
	 * @param stato Definisce lo stato utilizzato per filtrare gli eventi
	 * @param eventiDaFiltrare Tutti gli eventi sottoposti al filtro
	 * @return eventiFiltrati Lista degli eventi dopo il filtraggio
	 * @see it.univpm.progetto.studenti.ticketmaster.model.Eventi
	 */
	public static Vector<Eventi> filterByState(String stato, Vector<Eventi> eventiDaFiltrare) {
		
		Vector<Eventi> eventiFiltrati = new Vector<Eventi>();
		
		for (Eventi eventiTemp : eventiDaFiltrare) {
			
			if(stato.equals(eventiTemp.getStato()))
				eventiFiltrati.add(eventiTemp);
			
		}
		
		return eventiFiltrati;
		
	}
	
}
