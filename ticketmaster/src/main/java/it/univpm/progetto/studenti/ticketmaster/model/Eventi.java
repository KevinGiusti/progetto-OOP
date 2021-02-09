package it.univpm.progetto.studenti.ticketmaster.model;

public class Eventi {

	private String nome;
	private String id;
	private String url;
	private String stato;
	private String paese;
	
	public Eventi(String n, String i, String u, String s, String p) {
		this.nome = n;
		this.id = i;
		this.url = u;
		this.stato = s;
		this.paese = p;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getPaese() {
		return paese;
	}

	public void setPaese(String paese) {
		this.paese = paese;
	}
	
}
