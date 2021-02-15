package it.univpm.progetto.studenti.ticketmaster.minmaxav_junit_test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import org.junit.jupiter.api.Test;

import it.univpm.progetto.studenti.ticketmaster.filters.MinMaxAverageFilter;

class dateConverterTest {
	
	@Test
	void testDateConverter() {
		
		MinMaxAverageFilter test = new MinMaxAverageFilter();
		
		String dataInizialePeriodoPersonalizzato = "2021-01-01";
		
		LocalDate localDatePeriodoPers = LocalDate.of(2021,01,01);
		
		LocalDate output = test.dateConverter(dataInizialePeriodoPersonalizzato);
		
		assertEquals(localDatePeriodoPers, output);
		
	}

	@Test
	void testDateConverterException() {
		
		MinMaxAverageFilter test = new MinMaxAverageFilter();
		
		String dataInizialePeriodoPersonalizzato = "2021-78-01";
		
		assertThrows(DateTimeParseException.class, ()->test.dateConverter(dataInizialePeriodoPersonalizzato));
		
	}

}