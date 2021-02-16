package it.univpm.progetto.studenti.ticketmaster.controller;

import java.util.Vector;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.progetto.studenti.ticketmaster.scanner.GeneriScanner;
import it.univpm.progetto.studenti.ticketmaster.scanner.StatiScanner;

/**
 * Classe che contiene due rotte get /stati e /generi che restituiscono
 * valori sui file scannerizzati in StatiScanner e GeneriScanner
 * 
 * @author RoccoAnzivino
 */
@RestController
public class DatiController {

	/**
	 * Metodo contenente la rotta get /stati
	 * 
	 * @return StatiScanner.getStati()
	 */
	@GetMapping("/stati")
	public Vector<String> stati() {
		return StatiScanner.getStati();	
	}

	/**
	 * Metodo contenente la rotta get /generi
	 * 
	 * @return GeneriScanner.getGeneri()
	 */
	@GetMapping("/generi")
	public Vector<String> generi() {
		return GeneriScanner.getGeneri();
	}
	
}
