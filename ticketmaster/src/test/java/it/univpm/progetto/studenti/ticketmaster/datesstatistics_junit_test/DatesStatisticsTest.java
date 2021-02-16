package it.univpm.progetto.studenti.ticketmaster.datesstatistics_junit_test;

import java.time.LocalDate;
import java.util.Vector;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.univpm.progetto.studenti.ticketmaster.model.Eventi;
import it.univpm.progetto.studenti.ticketmaster.stats.DatesStatistics;

/**
 * Classe che effettua un test sul funzionamento del metodo numeroEventi
 * 
 * @author KevinGiusti
 */
public class DatesStatisticsTest {
	
	/**
	 * oggetto della classe DatesStatistics
	 * @see it.univpm.progetto.studenti.ticketmaster.stats.DatesStatistics
	 */
	private DatesStatistics test;
	
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
	 * Vettore di eventi da passare come parametro al metodo 'numeroEventi'
	 * al fine di eseguire il test
	 * @see it.univpm.progetto.studenti.ticketmaster.model.Eventi
	 * @see it.univpm.progetto.studenti.ticketmaster.stats.DatesStatistics
	 * @see it.univpm.progetto.studenti.ticketmaster.stats.DatesStatistics#numeroEventi(Vector)
	 */
	private Vector<Eventi> listaEventi;
	
	/**
	 * Array di interi che rappresenta la soluzione corretta che deve essere 
	 * ottenuta dall'esecuzione del metodo 'numeroEventi'
	 * @see it.univpm.progetto.studenti.ticketmaster.stats.DatesStatistics#numeroEventi(Vector)
	 */
	private int [] numeroEventi = {0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0};
	
	/**
	 * Array di interi ottenuto dall'esecuzione del metodo 'numeroEventi'
	 * @see it.univpm.progetto.studenti.ticketmaster.stats.DatesStatistics#numeroEventi(Vector)
	 */
	private int[] output;
	
	/**
	 * metodo che inizializza ogni attributo dichiarato nella classe
	 * di test 'DatesStatisticsTest'
	 * è il primo metodo ad essereeseguito prima di ogni test
	 */
	@BeforeEach
	public void setup() {
		
		test = new DatesStatistics();
		
		dataEv1 = LocalDate.of(2021,05,03);
		
		dataEv2 = LocalDate.of(2021,10,26);
		
		evento1 = new Eventi("Backstreet Boys", "http://resale.ticketmaster.com.au/Resale/Tickets/2797641", "Melbourne", "Victoria", "Australia", dataEv1,  "19:30:00", "Pop", "Pop Rock");
		
		evento2 = new Eventi("Steel Panther", "http://resale.ticketmaster.com.au/Resale/Tickets/2973428", "Melbourne", "Victoria", "Australia", dataEv2,  "19:30:00", "Rock", "Hard Rock");
		
		listaEventi = new Vector<Eventi>();
		
		listaEventi.add(0, evento1);
		listaEventi.add(1, evento2);
		
		output = test.numeroEventi(listaEventi);
	}
	
	/**
	 * metodo eseguito al fine di ogni test per liberare risorse
	 */
	@AfterEach
	public void TearDown() {}
	
	/**
	 * Metodo per testing del metodo numeroEventi() che controlla se l'array di interi preso come parametro
	 * dalla funzione numeroEventi della classe DatesStatistics assegna, in maniera
	 * corretta, ogni evento del vettore listaEventi al relativo mese, in modo che
	 * ogni elemento dell'array di interi, che può essere inteso come un mese, 
	 * indichi il numero di eventi svolti in tale mese.
	 * @see it.univpm.progetto.studenti.ticketmaster.stats.DatesStatistics
	 * @see it.univpm.progetto.studenti.ticketmaster.stats.DatesStatistics#numeroEventi
	 */
	@Test
	void datesStatisticsTest() {
		
		for(int i = 0; i < 12; i++) {
			Assertions.assertEquals(numeroEventi[i], output[i]);
		}
	
	}
	
	/**
	 * Metodo per testing del che controlla se il vettore
	 * contenente gli eventi non sia sia vuoto in modo da poter eseguire correttamete
	 * il metodo numeroEventi()
	 * @see it.univpm.progetto.studenti.ticketmaster.stats.DatesStatistics
	 */
	@Test
	void datesStatisticsTestNotNull() {
		
		Assertions.assertNotNull(listaEventi.elementAt(0));
	
	}

}