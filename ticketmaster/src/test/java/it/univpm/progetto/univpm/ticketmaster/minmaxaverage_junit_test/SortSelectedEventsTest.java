package it.univpm.progetto.univpm.ticketmaster.minmaxaverage_junit_test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.univpm.progetto.studenti.ticketmaster.stats.MinMaxAverage;

/**
 * Classe che effettua un test sul funzionamento del metodo sortSelectedEvents
 * 
 * @author KevinGiusti
 */
class SortSelectedEventsTest {

	/**
	 * Metodo per testing del metodo sortSelectedEvents che controlla
	 * se il sorting di un array di interi venga svolto nel modo corretto
	 * @see it.univpm.progetto.studenti.ticketmaster.stats.MinMaxAverage
	 * @see it.univpm.progetto.studenti.ticketmaster.stats.MinMaxAverage#sortSelectedEvents(int[])
	 */
	@Test
	void sortSelectedEventsTest() {
		
		MinMaxAverage test = new MinMaxAverage();
		
		int[] numEventi = {0, 3, 2, 1, 4, 5, 9, 7, 8, 6, 2, 0};
		
		int[] alreadySorted = {0, 0, 1, 2, 2, 3, 4, 5, 6, 7, 8, 9};
		
		int[] output = test.sortSelectedEvents(numEventi);
		
		for(int i = 0; i < 12; i++) {
			assertEquals(alreadySorted[i], output[i]);
		}
		
	}

}
