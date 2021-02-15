package it.univpm.progetto.studenti.ticketmaster.datesstatistics_junit_test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Vector;

import org.junit.jupiter.api.Test;

import it.univpm.progetto.studenti.ticketmaster.model.Eventi;
import it.univpm.progetto.studenti.ticketmaster.stats.DatesStatistics;

class DatesStatisticsTest {

	@Test
	void datesStatisticsTest() {
		
		DatesStatistics test = new DatesStatistics();
		
		LocalDate dataEv1 = LocalDate.of(2021,05,03);
		
		LocalDate dataEv2 = LocalDate.of(2021,10,26);
		
		Eventi evento1 = new Eventi("Backstreet Boys", "http://resale.ticketmaster.com.au/Resale/Tickets/2797641", "Melbourne", "Victoria", "Australia", dataEv1,  "19:30:00", "Pop", "Pop Rock");
		
		Eventi evento2 = new Eventi("Steel Panther", "http://resale.ticketmaster.com.au/Resale/Tickets/2973428", "Melbourne", "Victoria", "Australia", dataEv2,  "19:30:00", "Rock", "Hard Rock");
		
		Vector<Eventi> listaEventi = new Vector<Eventi>();
		
		listaEventi.add(0, evento1);
		listaEventi.add(1, evento2);
		
		int [] numeroEventi = {0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0};
		
		int[] output = test.numeroEventi(listaEventi);

		for(int i = 0; i < 12; i++) {
			assertEquals(numeroEventi[i], output[i]);
		}
	
	}
	
	@Test
	void datesStatisticsTestNotNull() {
		
		LocalDate dataEv1 = LocalDate.of(2021,05,03);
		
		LocalDate dataEv2 = LocalDate.of(2021,10,26);
		
		Eventi evento1 = new Eventi("Backstreet Boys", "http://resale.ticketmaster.com.au/Resale/Tickets/2797641", "Melbourne", "Victoria", "Australia", dataEv1,  "19:30:00", "Pop", "Pop Rock");
		
		Eventi evento2 = new Eventi("Steel Panther", "http://resale.ticketmaster.com.au/Resale/Tickets/2973428", "Melbourne", "Victoria", "Australia", dataEv2,  "19:30:00", "Rock", "Hard Rock");
		
		Vector<Eventi> listaEventi = new Vector<Eventi>();
		
		listaEventi.add(0, evento1);
		listaEventi.add(1, evento2);
		
		assertNotNull(listaEventi.elementAt(0));
	
	}

}