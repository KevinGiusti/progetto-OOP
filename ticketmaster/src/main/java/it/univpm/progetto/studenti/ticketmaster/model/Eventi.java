package it.univpm.progetto.studenti.ticketmaster.model;

public class Eventi {

	private String nomeEvento;
	private String tipoEvento;
	private String idEvento;
	private String urlEvento;
	
	public Eventi(String nE, String tE, String iE, String uE) {
		this.nomeEvento = nE;
		this.tipoEvento = tE;
		this.idEvento = iE;
		this.urlEvento = uE;
	}

	public String getNomeEvento() {
		return nomeEvento;
	}

	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}

	public String getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public String getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(String idEvento) {
		this.idEvento = idEvento;
	}

	public String getUrlEvento() {
		return urlEvento;
	}

	public void setUrlEvento(String urlEvento) {
		this.urlEvento = urlEvento;
	}
	
	
	
}
