package it.univpm.progetto.studenti.ticketmaster.exception;

import org.json.simple.JSONObject;

public class EventiException extends Exception {

	private static final long serialVersionUID = 1L;

	public EventiException() {
		super();
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject generaJSON(String key, String value) {
		
		JSONObject responso = new JSONObject();
		
		responso.put(key, value);
		
		return responso;
		
	}
	
}