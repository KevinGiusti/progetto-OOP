package it.univpm.progetto.studenti.ticketmaster.minmaxav_junit_test;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.univpm.progetto.studenti.ticketmaster.filters.MinMaxAverageFilter;

/**
 * Classe che effettua un test sul funzionamento del metodo maxRipetizioneDelPeriodo
 * 
 * @author KevinGiusti
 */
public class MaxRipetizioneDelPeriodoTest {
	
	/**
	 * oggetto della classe MinMaxAverageFilter
	 * @see it.univpm.progetto.studenti.ticketmaster.filters.MinMaxAverageFilter
	 */
	private MinMaxAverageFilter test;
	
	/**
	 * attributo che indica la lunghezza del periodo personalizzato
	 */
	private long periodoLength;
	
	/**
	 * oggetto della classe LocalDate che indica la data iniziale
	 */
	private LocalDate dataIniziale;
	
	/**
	 * oggetto della classe LocalDate che indica la data finale
	 */
	private LocalDate dataFinale;
	
	/**
	 * array di interi che rappresenta il risultato corretto atteso dal metodo maxRipetizioneDelPeriodo
	 * @see it.univpm.progetto.studenti.ticketmaster.filters.MinMaxAverageFilter#maxRipetizioneDelPeriodo(long, LocalDate, LocalDate)
	 */
	private int[] maxRipPoss = {4};
	
	/**
	 * array di interi che rappresenta il risultato dal metodo maxRipetizioneDelPeriodo, da confrontare con maxRipPoss
	 * @see it.univpm.progetto.studenti.ticketmaster.filters.MinMaxAverageFilter#maxRipetizioneDelPeriodo(long, LocalDate, LocalDate)
	 * @see #maxRipPoss
	 */
	private int[] output;
	
	/**
	 * metodo che inizializza ogni attributo dichiarato nella classe
	 * di test 'MaxRipetizioneDelPeriodoTest'
	 * è il primo metodo ad essereeseguito prima di ogni test
	 */
	@BeforeEach
	public void setUp() {
		
		test = new MinMaxAverageFilter();
		
		periodoLength = 90;
		
		dataIniziale = LocalDate.of(2021,02,01);
		
		dataFinale = LocalDate.of(2021,05,02);
		
		output = test.maxRipetizioneDelPeriodo(periodoLength, dataFinale, dataIniziale);
	}
	
	/**
	 * metodo eseguito al fine di ogni test per liberare risorse
	 */
	@AfterEach
	public void TearDown() {}
	
	/**
	 * Metodo per testing del metodo maxRipetizioneDelPeriodo, relativo al controllo del valore
	 * del primo elemento dell'array di interi 'output', che controlla se maxRipetizioneDelPeriodo
	 * fornisce il numero di ripetizioni corretto del periodo considerato
	 * @see it.univpm.progetto.studenti.ticketmaster.filters.MinMaxAverageFilter
	 * @see it.univpm.progetto.studenti.ticketmaster.filters.MinMaxAverageFilter#maxRipetizioneDelPeriodo(long,LocalDate, LocalDate)
	 */
	@Test
	void maxRipetizioneDelPeriodoTest() {
		
		 Assertions.assertEquals(maxRipPoss[0], output[0]);
		
	}

}