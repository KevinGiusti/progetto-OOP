package it.univpm.progetto.studenti.ticketmaster.minmaxav_junit_test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import org.junit.jupiter.api.Test;

import it.univpm.progetto.studenti.ticketmaster.filters.MinMaxAverageFilter;

class dateConverterTest {
	
	/**
	 * Metodo per testing del metodo dateConverter(), relativo al controllo della stringa
	 * inserita nel convertitore , che, fornita una stringa rappresentante una data ed un oggetto
	 * LocalDate che rappresenta la medesima data, controlla se il risultato della conversione
	 * sia pari all'oggetto LocalDate
	 * @see it.univpm.progetto.studenti.ticketmaster.filters.MinMaxAverageFilter
	 * @see it.univpm.progetto.studenti.ticketmaster.filters.MinMaxAverageFilter#dateConverter(String)
	 */
	@Test
	void testDateConverter() {
		
		MinMaxAverageFilter test = new MinMaxAverageFilter();
		
		String dataInizialePeriodoPersonalizzato = "2021-01-01";
		
		LocalDate localDatePeriodoPers = LocalDate.of(2021,01,01);
		
		LocalDate output = test.dateConverter(dataInizialePeriodoPersonalizzato);
		
		assertEquals(localDatePeriodoPers, output);
		
	}

	/**
	 * Metodo per testing del metodo dateConverter(), relativo al controllo della stringa
	 * inserita nel convertitore , che, fornita una stringa rappresentante una data errata, generi
	 * un'eccezione di tipo DateTimeParseException
	 */
	@Test
	void testDateConverterException() {
		
		MinMaxAverageFilter test = new MinMaxAverageFilter();
		
		String dataInizialePeriodoPersonalizzato = "2021-78-01";
		
		assertThrows(DateTimeParseException.class, ()->test.dateConverter(dataInizialePeriodoPersonalizzato));
		
	}

}