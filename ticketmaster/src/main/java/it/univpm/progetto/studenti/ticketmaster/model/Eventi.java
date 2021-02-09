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
	
	
	
	//LocalDate Attributes SECTION
	
	/**
	 * 
	 * Variabile che descrive anno/mese/giorno dell'evento
	 * 
	 */
	private LocalDate localDate;
	
	/**
	 * 
	 * Variabile che descrive ora/minuto/secondo di inizio dell'evento
	 * 
	 */
	private LocalDate localTime;
	
	/**
	 * 
	 * Variabile che descrive:
	 * anno/giorno/mese/ora/minuto/secondo di inizio dell'evento
	 */
	private LocalDate localdateTime;
	
	//Builder Method SECTION
	
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
	public Eventi(String n, String i, String u, String s, String p, LocalDate localDate, LocalDate LocalTime, LocalDate dateTime) {
		this.nome = n;
		this.id = i;
		this.url = u;
		this.stato = s;
		this.paese = p;
		this.localDate= localDate;
		this.localTime= localTime;
		this.dateTime= dateTime;
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
	public LocalDate getLocalDate() {
		return localDate;
	}
	
	/**
	 * 
	 * Setter dell'attributo localDate
	 * 
	 * @param localDate Parametro del setter
	 */
	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}
	
	/**
	 * 
	 * Getter dell'attributo localTime
	 * 
	 * @return localTime
	 */
	public LocalTime getLocalTime() {
		return localTime;
	}
	
	/**
	 * 
	 * Setter dell'attributo localTime
	 * 
	 * @param localTime Parametro del setter
	 */
	public void setLocalTime(LocalTime localTime) {
		this.localTime = localTime;
	}
	
	/**
	 * 
	 * Getter dell'attributo dateTime
	 * 
	 * @return dateTime
	 */
	public LocalDate getDateTime() {
		return dateTime;
	}
	
	/**
	 * 
	 * Setter dell'attributo dateTime
	 * 
	 * @param dateTime Parametro del setter
	 */
	public void setDateTime(LocalDate dateTime) {
		this.dateTime = dateTime;
	}
	
}
