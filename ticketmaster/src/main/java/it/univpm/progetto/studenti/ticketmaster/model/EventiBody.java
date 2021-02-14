package it.univpm.progetto.studenti.ticketmaster.model;

import java.util.Vector;

/**
 * Classe che descrive il body della chiamata post della rotta eventi
 * 
 * @author RoccoAnzivino
 * @author KevinGiusti
 */
public class EventiBody {

	/**
	 * Attributo che memorizza gli stati inseriti nel body della chiamata
	 */
	private Vector<String> stati;
	
	/**
	 * Attributo che memorizza i generi inseriti nel body della chiamata
	 */
	private Vector<String> generi;
	
	/**
	 * Attributo che memorizza il periodo personalizzato inserito nel body della chiamata
	 */
	private Vector<String> periodo;
	
	/**
	 * Costruttore di default
	 */
	public EventiBody() {}
	
	/**
	 * Costruttore inizializza un oggetto EventiBody
	 * 
	 * @param s Vettore di stringhe da assegnare all'attributo stati
	 * @param g Vettore di Stringhe da assegnare all'attributo generi
	 * @param periodoPersonalizzato Vettore di Stringhe da assegnare all'attributo periodoPersonalizzato
	 */
	public EventiBody(Vector<String> s, Vector<String> g, Vector<String> periodoPersonalizzato) {
		this.stati = s;
		this.generi = g;
		this.periodo = periodoPersonalizzato;
	}

	/**
	 * Getter dell'attributo stati
	 * 
	 * @return stati
	 */
	public Vector<String> getStati() {
		return stati;
	}

	/**
	 * Setter dell'attributo stati
	 * 
	 * @param s Parametro del setter
	 */
	public void setStati(Vector<String> s) {
		this.stati = s;
	}

	/**
	 * Getter dell'attributo generi
	 * 
	 * @return generi
	 */
	public Vector<String> getGeneri() {
		return generi;
	}

	/**
	 * Setter dell'attributo generi
	 * 
	 * @param g Parametro del setter
	 */
	public void setGeneri(Vector<String> g) {
		this.generi = g;
	}
	
	/**
	 * Getter dell'attributo periodo
	 * 
	 * @return periodo
	 */
	public Vector<String> getPeriodo() {
		return periodo;
	}

	/**
	 * Setter dell'attributo periodo
	 * 
	 * @param p Parametro del setter
	 */
	public void setPeriodo(Vector<String> p) {
		this.periodo = p;
	}
	
}
