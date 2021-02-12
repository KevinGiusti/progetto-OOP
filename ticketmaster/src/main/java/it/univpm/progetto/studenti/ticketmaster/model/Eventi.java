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
	
	
	
	/**
	 * 
	 * Variabile che descrive il genere dell'evento
	 * 
	 */
	private String genere;
	
	/**
	 * 
	 * Variabile che descrive il sotto genere dell'evento
	 * 
	 */
	private String sottoGenere;
	
	
	//Builder Method SECTION
	
	/**
	 * 
	 * Costruttore di default utile a inizializzare gli eventi
	 * 
	 */
	 
	/**
	 * 
	 * Variabile che descrive il primo anno/mese/giorno del periodo personalizzato
	 * 
	 */
	 private LocalDate data1; 
	 
	 /**
		 * 
		 * Variabile che descrive il secondo anno/mese/giorno del periodo personalizzato
		 * 
		 */
	private LocalDate data2;
	 
	public Eventi() {}	
	
	/**
	 * 
	 * Costruttore utile a inizializzare gli eventi
	 * 
	 * @param n Assegna il nome all'evento
	 * @param u Assegna l'url all'evento
	 * @param s Assegna lo stato all'evento
	 * @param p Assegna il paese all'evento
	 * @param d Assegna la data all'evento
	 * 
	 */
	
	//String n, String u, String s, String p, LocalDate d, String g, String sG
	public Eventi(String n, String u, String s, String p, LocalDate d, String g, String sG) {
		this.nome = n;
		this.url = u;
		this.stato = s;
		this.paese = p;
		this.data= d;
		this.genere = g;
		this.sottoGenere = sG;
	}
	
	/**
	 * 
	 * Costruttore utile a inizializzare gli eventi
	 * 
	 * @param n Assegna il nome all'evento
	 * @param u Assegna l'url all'evento
	 * @param s Assegna lo stato all'evento
	 * @param p Assegna il paese all'evento
	 * @param d Assegna la data all'evento
	 * 
	 */
	
	/*//String n, String u, String s, String p, LocalDate d, String g, String sG
	public Eventi(String n, String u, String s, String p, LocalDate d, String g, String sG, LocalDate d1, LocalDate d2) {
		this.nome = n;
		this.url = u;
		this.stato = s;
		this.paese = p;
		this.data= d;
		this.genere = g;
		this.sottoGenere = sG;
		this.data1= d1;
		this.data2= d2;
	}*/
	
	//String n, String u, String s, String p, LocalDate d, String g, String sG
		public Eventi(LocalDate d1, LocalDate d2) {
			this.data1= d1;
			this.data2= d2;
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
	public void setData(LocalDate localDate) {
		this.data = localDate;
	}

	/**
	 * @return the genere
	 */
	public String getGenere() {
		return genere;
	}

	/**
	 * @param genere the genere to set
	 */
	public void setGenere(String genere) {
		this.genere = genere;
	}

	/**
	 * @return the sottoGenere
	 */
	public String getSottoGenere() {
		return sottoGenere;
	}

	/**
	 * @param sottoGenere the sottoGenere to set
	 */
	public void setSottoGenere(String sottoGenere) {
		this.sottoGenere = sottoGenere;
	}
	
	/**
	 * 
	 * Getter dell'attributo data1
	 * 
	 * @return data1
	 */
	public LocalDate getData1() {
		return data1;
	}
	
	/**
	 * 
	 * Setter dell'attributo data1
	 * 
	 * @param date1 Parametro del setter
	 */
	public void setData1(LocalDate date1) {
		this.data1 = date1;
	}
	
	/**
	 * 
	 * Getter dell'attributo data2
	 * 
	 * @return data2
	 */
	public LocalDate getData2() {
		return data2;
	}
	
	/**
	 * 
	 * Setter dell'attributo data2
	 * 
	 * @param date2 Parametro del setter
	 */
	public void setData2(LocalDate date2) {
		this.data2 = date2;
	}

}
