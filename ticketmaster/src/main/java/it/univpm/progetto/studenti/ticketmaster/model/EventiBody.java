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
	 * Attributo che memorizza gli stati inseriti nel body della chiamata
	 * 
	 */
	private Vector<String> stati;
	
	/**
	 * 
	 * 
	 * 
	 */
	private Vector<String> generi;
	
	/**
	 * 
	 * Costruttore di default
	 * 
	 */
	public EventiBody() {}
	
	/**
	 * 
	 * Costruttore inizializza un oggetto EventiBody
	 * 
	 * @param s Vettore di stringhe da assegnare all'attributo stati
	 * 
	 */
	public EventiBody(Vector<String> s, Vector<String> g) {
		this.stati = s;
		this.generi = g;
	}

	/**
	 * 
	 * Getter dell'attributo stati
	 * 
	 * @return stati
	 */
	public Vector<String> getStati() {
		return stati;
	}

	/**
	 * 
	 * Setter dell'attributo stati
	 * 
	 * @param s Parametro del setter
	 */
	public void setStati(Vector<String> s) {
		this.stati = s;
	}

	/**
	 *
	 * 
	 * 
	 * @return the generi
	 */
	public Vector<String> getGeneri() {
		return generi;
	}

	/**
	 * 
	 * 
	 * 
	 * @param generi the generi to set
	 */
	public void setGeneri(Vector<String> g) {
		this.generi = g;
	}

}
