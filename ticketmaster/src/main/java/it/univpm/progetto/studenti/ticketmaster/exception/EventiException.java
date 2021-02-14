package it.univpm.progetto.studenti.ticketmaster.exception;

import org.json.simple.JSONObject;

/**
 * Classe che descrive le eccezioni presenti nell'intero progetto
 * 
 * @author RoccoAnzivino
 */
public class EventiException extends Exception {

	/**
	 * Variabile funzionale alla classe Exception
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore di default che attinge al costruttore della classe Exception
	 */
	public EventiException() {
		super();
	}
	
	/**
	 * Metodo che assegna al responso dell'eccezione una nuova coppia di chiave/valore,
	 * la quale definisce il responso alternativo
	 * 
	 * @param key Descrive la chiave del responso nelle eccezioni
	 * @param value Descrive il valore delle chiavi del responso nelle eccezioni
	 * @return responso 
	 */
	@SuppressWarnings("unchecked")
	public JSONObject generaJSON(String key, String value) {
		
		JSONObject responso = new JSONObject();
		
		responso.put(key, value);
		
		return responso;
		
	}
	
}