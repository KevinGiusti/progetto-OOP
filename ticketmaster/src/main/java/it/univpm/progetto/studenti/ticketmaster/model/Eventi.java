package it.univpm.progetto.studenti.ticketmaster.model;

import java.time.LocalDate;

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
	
	
	
	//LocalDate Attributes SECTION
	
	/**
	 * 
	 * Variabile che descrive anno/mese/giorno dell'evento
	 * 
	 */
	private LocalDate data;
	
	
	//Builder Method SECTION
	
	/**
	 * 
	 * Costruttore di default utile a inizializzare gli eventi
	 * 
	 */
	public Eventi() {}	
	
	/**
	 * 
	 * Costruttore utile a inizializzare gli eventi
	 * 
	 * @param n Assegna il nome all'evento
	 * @param i Assegna l'id all'evento
	 * @param u Assegna l'url all'evento
	 * @param s Assegna lo stato all'evento
	 * @param p Assegna il paese all'evento
	 * @param localDate Assegna la data all'evento
	 * @param localTime Assegna l'ora all'evento
	 */
	
	//String n, String i, String u, String s, String p, LocalDate localDate, LocalTime localTime, LocalDate localDateTime
	public Eventi(String n, String i, String u, String s, String p, LocalDate data) {
		this.nome = n;
		this.id = i;
		this.url = u;
		this.stato = s;
		this.paese = p;
		this.data= data;
	}

	/**
	 * 
	 * Getter dell'attributo nome
	 * 
	 * @return nome 
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * 
	 * Setter dell'attributo nome
	 * 
	 * @param nome Parametro del setter
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * 
	 * Getter dell'attributo id
	 * 
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * 
	 * Setter dell'attributo id
	 * 
	 * @param id Parametro del setter
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 
	 * Getter dell'attributo url
	 * 
	 * @return url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * 
	 * Setter dell'attributo url
	 * 
	 * @param url Parametro del setter
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 
	 * Getter dell'attributo stato
	 * 
	 * @return stato
	 */
	public String getStato() {
		return stato;
	}

	/**
	 * 
	 * Setter dell'attributo stato
	 * 
	 * @param stato Parametro del setter
	 */
	public void setStato(String stato) {
		this.stato = stato;
	}

	/**
	 * 
	 * Getter dell'attributo paese
	 * 
	 * @return paese
	 */
	public String getPaese() {
		return paese;
	}

	/**
	 * 
	 * Setter dell'attributo paese
	 * 
	 * @param paese Parametro del setter
	 */
	public void setPaese(String paese) {
		this.paese = paese;
	}
	
	/**
	 * 
	 * Getter dell'attributo localDate
	 * 
	 * @return localDate
	 */
	public LocalDate getData() {
		return data;
	}
	
	/**
	 * 
	 * Setter dell'attributo localDate
	 * 
	 * @param localDate Parametro del setter
	 */
	public void setLocalDate(LocalDate localDate) {
		this.data = localDate;
	}
}
