package it.univpm.progetto.studenti.ticketmaster.minmaxav_junit_test;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.univpm.progetto.studenti.ticketmaster.filters.MinMaxAverageFilter;

/**
 * Classe che effettua un test sul funzionamento del metodo dateConverter
 * 
 * @author KevinGiusti
 */
public class dateConverterTest {
	
	/**
	 * Stringa che indica la data di inizio del periodo personalizzato su cui eseguire i test
	 */
	private String dataInizialePeriodoPersonalizzato;
	
	/**
	 * Stringa che indica la data di inizio errata del periodo personalizzato
	 * su cui eseguire i test assertThrows
	 */
	private String dataErrata;
	
	/**
	 * oggetto/attributo della classe Localdate che rappresenta il risultato corretto del test
	 */
	private LocalDate localDatePeriodoPers;
	
	/**
	 * oggetto/attributo della classe Localdate che rappresenta il risultato ottenuto dal
	 * test che dovrà essere confrontato con localDatePeriodoPers
	 * @see #localDatePeriodoPers
	 */
	private LocalDate output;
	
	/**
	 * metodo che inizializza ogni attributo dichiarato nella classe
	 * di test 'dateConverterTest'
	 * è il primo metodo ad essereeseguito prima di ogni test
	 */
	@BeforeEach
	public void setUp() {
		
		dataInizialePeriodoPersonalizzato = "2021-01-01";
		
		dataErrata = "2021-59-01";
		
		localDatePeriodoPers = LocalDate.of(2021,01,01);
		
		output = MinMaxAverageFilter.dateConverter(dataInizialePeriodoPersonalizzato);
	}
	
	/**
	 * metodo eseguito al fine di ogni test per liberare risorse
	 */
	@AfterEach
	public void TearDown() {}
	
	/**
	 * Metodo per testing del metodo dateConverter(), relativo al controllo della stringa
	 * inserita nel convertitore , che, fornita una stringa rappresentante una data ed un oggetto
	 * LocalDate che rappresenta la medesima data, controlla se il risultato della conversione
	 * sia pari all'oggetto LocalDate
	 * @see it.univpm.progetto.studenti.ticketmaster.filters.MinMaxAverageFilter
	 * @see it.univpm.progetto.studenti.ticketmaster.filters.MinMaxAverageFilter#dateConverter(String)
	 */
	@Test
	public void testDateConverter() {
		Assertions.assertEquals(localDatePeriodoPers, output);
	}

	/**
	 * Metodo per testing del metodo dateConverter(), relativo al controllo della stringa
	 * inserita nel convertitore , che, fornita una stringa rappresentante una data errata, generi
	 * un'eccezione di tipo DateTimeParseException
	 */
	@Test
	public void testDateConverterException() {
		Assertions.assertThrows(DateTimeParseException.class, ()->MinMaxAverageFilter.dateConverter(dataErrata));
	}

}