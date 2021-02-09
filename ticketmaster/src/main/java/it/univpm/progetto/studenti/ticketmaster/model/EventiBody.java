package it.univpm.progetto.studenti.ticketmaster.model;

import java.util.Vector;

public class EventiBody {

	private Vector<String> stati;
	
	public EventiBody() {
	}
	
	public EventiBody(Vector<String> sP) {
		this.stati = sP;
	}

	public Vector<String> getStati() {
		return stati;
	}

	public void setStati(Vector<String> sP) {
		this.stati = sP;
	}
	
}
