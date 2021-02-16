package it.univpm.progetto.univpm.ticketmaster.minmaxaverage_junit_test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.univpm.progetto.studenti.ticketmaster.stats.MinMaxAverage;

/**
 * Classe che effettua un test sul funzionamento del metodo sortSelectedEvents
 * 
 * @author KevinGiusti
 */
public class SortSelectedEventsTest {

	/**
	 * oggetto della classe MinMaxAverage
	 * @see it.univpm.progetto.studenti.ticketmaster.stats.MinMaxAverage
	 */
	private MinMaxAverage test;
	
	/**
	 * array di interi da passare come parametro al metodo 'sortSelectedEvents'
	 * @see it.univpm.progetto.studenti.ticketmaster.stats.MinMaxAverage
	 * @see it.univpm.progetto.studenti.ticketmaster.stats.MinMaxAverage#sortSelectedEvents()
	 */
	private int[] numEventi = {0, 3, 2, 1, 4, 5, 9, 7, 8, 6, 2, 0};
	
	/**
	 * array di interi che rappresenta il risultato corretto ottenuto invocando
	 * il metodo 'sortSelectedEvents' sull'array di interi 'numEventi'
	 * @see it.univpm.progetto.studenti.ticketmaster.stats.MinMaxAverage#sortSelectedEvents()
	 * @see #numEventi
	 */
	private int[] alreadySorted = {0, 0, 1, 2, 2, 3, 4, 5, 6, 7, 8, 9};
	
	/**
	 * array di interi che rappresenta il risultato ottenuto invocando
	 * il metodo 'sortSelectedEvents' sull'array di interi 'numEventi', da confrontare
	 * con 'alreadySorted'
	 * @see it.univpm.progetto.studenti.ticketmaster.stats.MinMaxAverage#sortSelectedEvents()
	 * @see #numEventi
	 * @see #alreadySorted
	 */
	private int[] output;
	
	/**
	 * metodo che inizializza ogni attributo dichiarato nella classe
	 * di test 'SortSelectedEventsTest'
	 * è il primo metodo ad essereeseguito prima di ogni test
	 */
	@BeforeEach
	public void setUp() {
		
		test = new MinMaxAverage();
		
		output = test.sortSelectedEvents(numEventi);
	}
	
	/**
	 * metodo eseguito al fine di ogni test per liberare risorse
	 */
	@AfterEach
	public void tearDown() {}
	
	/**
	 * Metodo per testing del metodo sortSelectedEvents che controlla
	 * se il sorting di un array di interi venga svolto nel modo corretto
	 * @see it.univpm.progetto.studenti.ticketmaster.stats.MinMaxAverage
	 * @see it.univpm.progetto.studenti.ticketmaster.stats.MinMaxAverage#sortSelectedEvents(int[])
	 */
	@Test
	void sortSelectedEventsTest() {
		
		for(int i = 0; i < 12; i++) {
			Assertions.assertEquals(alreadySorted[i], output[i]);
		}
		
	}

}
