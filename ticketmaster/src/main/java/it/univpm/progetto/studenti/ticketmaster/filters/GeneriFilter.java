package it.univpm.progetto.studenti.ticketmaster.filters;

import java.util.Vector;

import it.univpm.progetto.studenti.ticketmaster.model.Eventi;

/**
 * Classe che effettua un filtro sui generi
 * 
 * @author Kejvin
 */
public class GeneriFilter {

	/**s
	 * Metodo che filtra per generi gli eventi
	 * 
	 * @param genere Definisce il genere utilizzato per filtrare gli eventi
	 * @param eventiDaFiltrare Tutti gli eventi sottoposti al filtro
	 * @return eventiFiltrati Lista degli eventi dopo il filtraggio
	 * @see it.univpm.progetto.studenti.ticketmaster.model.Eventi
	 */
	public static Vector<Eventi> filterByGenre(String genere, Vector<Eventi> eventiDaFiltrare) {
		
		Vector<Eventi> eventiFiltrati = new Vector<Eventi>();
		
		for (Eventi eventiTemp : eventiDaFiltrare) {
			
			if(genere.equals(eventiTemp.getGenere()))
				eventiFiltrati.add(eventiTemp);
			
		}
		
		return eventiFiltrati;
		
	}
	
}