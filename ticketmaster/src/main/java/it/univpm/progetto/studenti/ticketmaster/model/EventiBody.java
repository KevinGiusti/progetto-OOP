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
	
	
	//LocalDate SECTION
	
	/**
	 * 
	 * Attributo che memorizza il periodo personalizzato inserito nel body della chiamata
	 * 
	 */
	private Vector<String> periodo;
	
	
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
	 * @param g Vettore di Stringhe da assegnare all'attributo generi
	 * @param periodoPersonalizzato Vettore di Stringhe da assegnare all'attributo periodoPersonalizzato
	 * 
	 */
	public EventiBody(Vector<String> s, Vector<String> g, Vector<String> periodoPersonalizzato) {
		this.stati = s;
		this.generi = g;
		this.periodo = periodoPersonalizzato;
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
	
	/**
	 *
	 * 
	 * 
	 * @return dataInizialeFiltraggio
	 */
	public Vector<String> getPeriodo() {
		return periodo;
	}

	/**
	 * 
	 * 
	 * 
	 * @param dataIniz Parametro del setter
	 */
	public void setPeriodo(Vector<String> dataPers) {
		this.periodo = dataPers;
	}
}
