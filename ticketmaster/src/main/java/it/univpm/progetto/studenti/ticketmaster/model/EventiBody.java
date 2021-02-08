package it.univpm.progetto.studenti.ticketmaster.model;

public class EventiBody {

	private String stato;
	
	public EventiBody() {
		
	}
	
	public EventiBody(String s) {
		this.stato = s;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}
	
}
