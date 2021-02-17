package it.univpm.progetto.studenti.ticketmaster.minmaxav_junit_test;

import java.time.LocalDate;
import java.util.Vector;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.univpm.progetto.studenti.ticketmaster.filters.MinMaxAverageFilter;
import it.univpm.progetto.studenti.ticketmaster.model.Eventi;

/**
 * Classe che effettua un test sul funzionamento del metodo minMaxAverageFilterFunction
 * 
 * @author KevinGiusti
 */
public class MinMaxAverageFilterFunctionTest {

	/**
	 * oggetto della classe MinMaxAverageFilter
	 * @see it.univpm.progetto.studenti.ticketmaster.filters.MinMaxAverageFilter
	 */
	private MinMaxAverageFilter test;
	
	/**
	 * oggetto della classe LocalDate che indica la data del primo evento
	 * @see #evento1
	 */
	private LocalDate dataEv1;
	
	/**
	 * oggetto della classe LocalDate che indica la data del secondo evento
	 * @see #evento2
	 */
	private LocalDate dataEv2;
	
	/**
	 * oggetto della classe Eventi che indica il primo evento considerato nel test
	 * @see it.univpm.progetto.studenti.ticketmaster.model.Eventi
	 */
	private Eventi evento1;
	
	/**
	 * oggetto della classe Eventi che indica il secondo evento considerato nel test
	 * @see it.univpm.progetto.studenti.ticketmaster.model.Eventi
	 */
	private Eventi evento2;
	
	/**
	 * Vettore di eventi da passare come parametro al metodo 'minMaxAverageFilterFunction'
	 * al fine di eseguire il test
	 * @see it.univpm.progetto.studenti.ticketmaster.model.Eventi
	 * @see it.univpm.progetto.studenti.ticketmaster.filters.MinMaxAverageFilter
	 * @see it.univpm.progetto.studenti.ticketmaster.filters.MinMaxAverageFilter#minMaxAverageFilterFunction(Vector, Vector)
	 */
	private Vector<Eventi> listaEventi;
	
	/**
	 * array di interi che rappresenta il corretto risultato ottenuto 
	 * dall'esecuzione del metodo 'minMaxAverageFilterFunction'
	 * @see it.univpm.progetto.studenti.ticketmaster.filters.MinMaxAverageFilter#minMaxAverageFilterFunction(Vector, Vector)
	 */
	private int[]  numeroEventi = {0, 0, 1, 0, 0, 1, 0}; 
	
	/**
	 * Vettore di stringhe da passare come parametro al metodo 'minMaxAverageFilterFunction'
	 * al fine di eseguire il test
	 * @see it.univpm.progetto.studenti.ticketmaster.model.Eventi
	 * @see it.univpm.progetto.studenti.ticketmaster.filters.MinMaxAverageFilter
	 * @see it.univpm.progetto.studenti.ticketmaster.filters.MinMaxAverageFilter#minMaxAverageFilterFunction(Vector, Vector)
	 */
	private Vector<String> periodTime;
	
	/**
	 * array di interi che il risultato ottenuto dall'esecuzione del metodo 'minMaxAverageFilterFunction'
	 * da confrontare con numeroEventi
	 * @see #numeroEventi
	 * @see it.univpm.progetto.studenti.ticketmaster.filters.MinMaxAverageFilter#minMaxAverageFilterFunction(Vector, Vector)
	 */
	private int[] output;
	
	/**
	 * metodo che inizializza ogni attributo dichiarato nella classe
	 * di test 'MinMaxAverageFilterFunctionTest'
	 * è il primo metodo ad essereeseguito prima di ogni test
	 */
	@BeforeEach
	public void setUp() {
		
		test = new MinMaxAverageFilter();
		
		dataEv1 = LocalDate.of(2021,05,03);
		
		dataEv2 = LocalDate.of(2021,10,26);
		
		evento1 = new Eventi("Backstreet Boys", "http://resale.ticketmaster.com.au/Resale/Tickets/2797641", "Melbourne", "Victoria", "Australia", dataEv1,  "19:30:00", "Pop", "Pop Rock");
		
		evento2 = new Eventi("Steel Panther", "http://resale.ticketmaster.com.au/Resale/Tickets/2973428", "Melbourne", "Victoria", "Australia", dataEv2,  "19:30:00", "Rock", "Hard Rock");
		
		listaEventi = new Vector<Eventi>();
		
		listaEventi.add(0, evento1);
		listaEventi.add(1, evento2);
		
		periodTime = new Vector<String>();
		
		periodTime.add(0, "2021-01-01");
		periodTime.add(1, "2021-03-01");
		
		output = test.minMaxAverageFilterFunction(listaEventi, periodTime);
		
	}
	
	/**
	 * metodo eseguito al fine di ogni test per liberare risorse
	 */
	@AfterEach
	public void tearDown() {}
	
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
	
		for(int i = 0; i < numeroEventi.length; i++) {
			Assertions.assertEquals(numeroEventi[i], output[i]);
		}
		
	}

}