package it.univpm.progetto.studenti.ticketmaster.model;

/**
 * 
 * Classe che definisce gli eventi 
 * 
 * @author RoccoAnzivino
 *
 */
public class Eventi {

	/**
	 * 
	 * Variabile che descrive il nome dell'evento
	 * 
	 */
	private String nome;
	
	/**
	 * 
	 * Variabile che descrive l'id dell'evento
	 * 
	 */
	private String id;
	
	/**
	 * 
	 * Variabile che descrive l'url dell'evento
	 * 
	 */
	private String url;
	
	/**
	 * 
	 * Variabile che descrive lo stato in cui si terrà l'evento
	 * 
	 */
	private String stato;
	
	/**
	 * 
	 * Variabile che descrive il paese in cui si terrà l'evento
	 * 
	 */
	private String paese;
	
	/**
	 * 
	 * Costruttore utile a inizializzare gli eventi
	 * 
	 * @param n Assegna il nome all'evento
	 * @param i Assegna l'id all'evento
	 * @param u Assegna l'url all'evento
	 * @param s Assegna lo stato all'evento
	 * @param p Assegna il paese all'evento
	 */
	public Eventi(String n, String i, String u, String s, String p) {
		this.nome = n;
		this.id = i;
		this.url = u;
		this.stato = s;
		this.paese = p;
	}

	/**
	 * 
	 * Getter della variabile nome
	 * 
	 * @return nome 
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * 
	 * Setter della variabile nome
	 * 
	 * @param nome Parametro del setter
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * 
	 * Getter della variabile id
	 * 
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * 
	 * Setter della variabile id
	 * 
	 * @param id Parametro del setter
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 
	 * Getter della variabile url
	 * 
	 * @return url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * 
	 * Setter della variabile url
	 * 
	 * @param url Parametro del setter
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 
	 * Getter della variabile stato
	 * 
	 * @return stato
	 */
	public String getStato() {
		return stato;
	}

	/**
	 * 
	 * Setter della variabile stato
	 * 
	 * @param stato Parametro del setter
	 */
	public void setStato(String stato) {
		this.stato = stato;
	}

	/**
	 * 
	 * Getter della variabile paese
	 * 
	 * @return paese
	 */
	public String getPaese() {
		return paese;
	}

	/**
	 * 
	 * Setter della variabile paese
	 * 
	 * @param paese Parametro del setter
	 */
	public void setPaese(String paese) {
		this.paese = paese;
	}
	
}
