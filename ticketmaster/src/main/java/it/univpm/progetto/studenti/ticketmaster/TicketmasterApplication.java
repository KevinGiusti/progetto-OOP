package it.univpm.progetto.studenti.ticketmaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * Classe che avvia SpringBoot e il relativo web service sulla porta 8080
 * 
 * @author RoccoAnzivino
 *
 */
@SpringBootApplication
public class TicketmasterApplication {

	/**
	 * 
	 * Metodo main
	 * 
	 * @param args Parametro del metodo main
	 */
	public static void main(String[] args) {
		SpringApplication.run(TicketmasterApplication.class, args);
	}

}
