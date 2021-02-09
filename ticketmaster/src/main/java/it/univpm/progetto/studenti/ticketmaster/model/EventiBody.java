package it.univpm.progetto.studenti.ticketmaster.model;

import java.util.Vector;

/**
 * 
 * Classe che descrive il body della chiamata post della rotta eventi
 * 
 * @author RoccoAnzivino
 *
 */
public class EventiBody {

	/**
	 * 
	 * Variabile che memorizza gli stati inseriti nel body della chiamata
	 * 
	 */
	private Vector<String> stati;
	
	/**
	 * 
	 * Costruttore di default
	 * 
	 */
	public EventiBody() {
	}
	
	/**
	 * 
	 * Costruttore inizializza un oggetto EventiBody
	 * 
	 * @param s Vettore di stringhe da assegnare alla variabile stati
	 */
	public EventiBody(Vector<String> s) {
		this.stati = s;
	}

	/**
	 * 
	 * Getter della variabile stati
	 * 
	 * @return stati
	 */
	public Vector<String> getStati() {
		return stati;
	}

	/**
	 * 
	 * Setter della variabile stati
	 * 
	 * @param s Parametro del setter
	 */
	public void setStati(Vector<String> s) {
		this.stati = s;
	}
	
}
