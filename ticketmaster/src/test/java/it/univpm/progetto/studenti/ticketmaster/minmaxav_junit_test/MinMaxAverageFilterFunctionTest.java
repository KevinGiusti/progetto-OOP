package it.univpm.progetto.studenti.ticketmaster.minmaxav_junit_test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Vector;

import org.junit.jupiter.api.Test;

import it.univpm.progetto.studenti.ticketmaster.filters.MinMaxAverageFilter;
import it.univpm.progetto.studenti.ticketmaster.model.Eventi;

/**
 * Classe che effettua un test sul funzionamento del metodo minMaxAverageFilterFunction
 * 
 * @author KevinGiusti
 */
class MinMaxAverageFilterFunctionTest {

	/**
	 * Metodo per testing del metodo minMaxAverageFilterFunction che controlla
	 * se minMaxAverageFilterFunction relativo alla classe MinMaxAverageFilter
	 * assegna, in maniera corretta, ogni evento del vettore listaEventi al relativo periodo, in modo che
	 * ogni elemento dell'array di interi, che può essere inteso come una ripetizione del periodo, 
	 * indichi il numero di eventi svolti in tale ripetizione del periodo.
	 * @see it.univpm.progetto.studenti.ticketmaster.filters.MinMaxAverageFilter
	 * @see it.univpm.progetto.studenti.ticketmaster.filters.MinMaxAverageFilter#minMaxAverageFilterFunction
	 */
	@Test
	void testMinMaxAerageFilterFunction() {
	
		MinMaxAverageFilter test = new MinMaxAverageFilter();
		
		LocalDate dataEv1 = LocalDate.of(2021,05,03);
		
		LocalDate dataEv2 = LocalDate.of(2021,10,26);
		
		Eventi evento1 = new Eventi("Backstreet Boys", "http://resale.ticketmaster.com.au/Resale/Tickets/2797641", "Melbourne", "Victoria", "Australia", dataEv1,  "19:30:00", "Pop", "Pop Rock");
		
		Eventi evento2 = new Eventi("Steel Panther", "http://resale.ticketmaster.com.au/Resale/Tickets/2973428", "Melbourne", "Victoria", "Australia", dataEv2,  "19:30:00", "Rock", "Hard Rock");

		Vector<Eventi> listaEventi = new Vector<Eventi>();
		listaEventi.add(0, evento1);
		listaEventi.add(1, evento2);
		
		int[]  numeroEventi = {0, 0, 1, 0, 0, 1, 0}; 
		
		Vector<String> periodTime = new Vector<String>();
		periodTime.add(0, "2021-01-01");
		periodTime.add(1, "2021-03-01");
		
		int[] output = test.minMaxAverageFilterFunction(listaEventi, periodTime);
		
		for(int i = 0; i < numeroEventi.length; i++) {
			assertEquals(numeroEventi[i], output[i]);
		}
		
	}
	
}