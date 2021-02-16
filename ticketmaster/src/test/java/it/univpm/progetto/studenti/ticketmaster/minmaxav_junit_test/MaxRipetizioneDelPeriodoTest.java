package it.univpm.progetto.studenti.ticketmaster.minmaxav_junit_test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import it.univpm.progetto.studenti.ticketmaster.filters.MinMaxAverageFilter;

class MaxRipetizioneDelPeriodoTest {

	/**
	 * Metodo per testing del metodo maxRipetizioneDelPeriodo, relativo al controllo del valore
	 * del primo elemento dell'array di interi 'output', che controlla se maxRipetizioneDelPeriodo
	 * fornisce il numero di ripetizioni corretto del periodo considerato
	 * @see it.univpm.progetto.studenti.ticketmaster.filters.MinMaxAverageFilter
	 * @see it.univpm.progetto.studenti.ticketmaster.filters.MinMaxAverageFilter#maxRipetizioneDelPeriodo(long,LocalDate, LocalDate)
	 */
	@Test
	void maxRipetizioneDelPeriodoTest() {
		
		MinMaxAverageFilter test = new MinMaxAverageFilter();
		
		long periodoLength = 90;
		
		LocalDate dataIniziale = LocalDate.of(2021,02,01);
		
		LocalDate dataFinale = LocalDate.of(2021,05,02);
		
		 int[] maxRipPoss = {4};
		
		 int[] output = test.maxRipetizioneDelPeriodo(periodoLength, dataFinale, dataIniziale);
		 
		 assertEquals(maxRipPoss[0], output[0]);
		
	}

}