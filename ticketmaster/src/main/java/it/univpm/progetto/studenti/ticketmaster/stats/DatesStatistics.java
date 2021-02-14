package it.univpm.progetto.studenti.ticketmaster.stats;

import java.time.LocalDate;
import java.util.Vector;

import it.univpm.progetto.studenti.ticketmaster.model.Eventi;

/**
 * Classe che consente di determinare il numero totale di 
 * eventi che si svolgono in uno specifico mese
 *
 * @author KevinGiusti
 */
public class DatesStatistics {

	/**
	 * Metodo che consente di determinare il numero totale di 
	 * eventi relativi ad uno specifico stato 
	 * che si svolgono in uno specifico mese
	 * 
	 * @param listaEventi Vettore di oggetti della classe Eventi necessario contenente 
	 * gli eventi dello stato considerato
	 * 
	 * @return monthsEvents Array di interi contenente, in ciascuna posizione, 
	 * il numero degli eventi svolti nello stato considerato relativamente ad uno specifico mese
	 * ad esempio, gennaio è in posizione 0, febbraio in posizione 1, ecc...
	 */
	public int[] numeroEventi(Vector<Eventi> listaEventi) {
		
		int[] monthsEvents= new int[12];
		
		for(int i= 0; i<listaEventi.size(); i++) {
			
			Eventi eventoProv= new Eventi();
			eventoProv= listaEventi.get(i);
			LocalDate mese1= eventoProv.getData(); 

			for(int j= 1; j<=12; j++) {
				
				LocalDate mese2= mese1.withMonth(j);
				
				if(mese1.equals(mese2)) {
					
					int pre_counter= j-1;
					monthsEvents[pre_counter]+=1;
				
				}
				else {
					
					int pre_counter= j-1;
					monthsEvents[pre_counter]+=0;
				
				}
				
				int accumulatore= j+1;
				mese2.plusMonths(accumulatore);
				
			}
		
		}
		
		return monthsEvents;

	}
	
}
