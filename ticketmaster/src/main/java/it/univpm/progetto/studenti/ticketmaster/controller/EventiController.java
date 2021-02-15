package it.univpm.progetto.studenti.ticketmaster.controller;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Vector;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.progetto.studenti.ticketmaster.api.ChiamataEventi;
import it.univpm.progetto.studenti.ticketmaster.exception.EventiException;
import it.univpm.progetto.studenti.ticketmaster.filters.GeneriFilter;
import it.univpm.progetto.studenti.ticketmaster.filters.MinMaxAverageFilter;
import it.univpm.progetto.studenti.ticketmaster.filters.StatiFilter;
import it.univpm.progetto.studenti.ticketmaster.model.Eventi;
import it.univpm.progetto.studenti.ticketmaster.model.EventiBody;
import it.univpm.progetto.studenti.ticketmaster.scanner.GeneriScanner;
import it.univpm.progetto.studenti.ticketmaster.scanner.StatiScanner;
import it.univpm.progetto.studenti.ticketmaster.stats.DatesStatistics;
import it.univpm.progetto.studenti.ticketmaster.stats.MinMaxAverage;

/**
 * Controller della rotta eventi che ritorna una serie di eventi filtrati
 * 
 * @author RoccoAnzivino
 * @author KevinGiusti
 */
@RestController
public class EventiController {

	/**
	 *  Variabile che descrive la chiave del responso nelle eccezioni
	 */
	private static String key;

	/** 
	 * Variabile che descrive il valore delle chiavi del responso nelle eccezioni
	 */
	private static String value;

	/**
	 * Variabile che descrive il responso ottenuto a partire dal body fornito dall'utente
	 */
	private static JSONObject responso;

	/**
	 * Variabile che immagazzina il vettore stati dell'oggetto EventiBody
	 */
	private static Vector<String> statiPaesi;

	/**
	 * Variabile che immagazzina il vettore generi dell'oggetto EventiBody
	 */
	private static Vector<String> generi;

	/**
	 * Variabile che immagazzina il vettore periodo dell'oggetto EventiBody
	 */
	private static Vector<String> periodo;

	/**
	 * Variabile che immagazzina il vettore statiVect dell'oggetto StatiScanner
	 */
	private static Vector<String> statiScanner;

	/**
	 * Variabile che immagazzina il vettore generiVect dell'oggetto GeneriScanner
	 */
	private static Vector<String> generiScanner;

	/**
	 * Variabile che contiene le coppie di chiave/valore che descrivono
	 * il numero totale di eventi per ogni stato inserito nel body
	 */
	private static LinkedHashMap<String, Integer> contatoreEventiPerStati;

	/**
	 * Variabile che contiene le coppie di chiave/valore che descrivono
	 * il numero totale di eventi per ogni genere inserito nel body
	 */
	private static LinkedHashMap<String, Integer> contatoreEventiPerGeneri;

	/**
	 * Variabile che contiene l'informazione relativa allo stato, presa dal vettore statiPaesi
	 */
	private static Vector<String> stati;

	/**
	 * Variabile che contiene l'informazione relativa ai paesi, presa dal vettore statiPaesi
	 */
	private static Vector<String> paesi;

	/**
	 * Variabile che contiene tutti gli stati dell'Australia con l'aggiunta del codice nazionale
	 */
	private static Vector<String> australia;

	/**
	 * Variabile che contiene tutti gli stati della Nuova Zelanda con l'aggiunta del codice nazionale
	 */
	private static Vector<String> newZealand;

	/**
	 * Variabile che contiene i vettori di eventi relativi a ogni chiamata per ogni paese (max 2 nel nostro caso)
	 */
	private static Vector<Vector<Eventi>> chiamateEv;

	/**
	 * Variabile che contiene gli eventi che sono stati filtrati tramite gli stati inseriti nel body dall'utente
	 */
	private static Vector<Eventi> eventiFiltratiPerStati;

	/**
	 * Variabile che contiene le coppie chiave/valore che descrivono le informazioni
	 * relative alle statistiche minimo, massimo e media mensili
	 */
	private static LinkedHashMap<String, MinMaxAverage> minMaxAverage;

	/**
	 * Variabile che contiene le coppie chiave/valore che descrivono le informazioni
	 * relative alle statistiche minimo, massimo e media filtrate
	 * per un periodo personalizzato inserito dall'utente nel body
	 */
	private static LinkedHashMap<String, MinMaxAverage> minMaxAverageFilter;

	/**
	 * Variabile che contiene gli eventi per ogni stato inserito nel body dall'utente,
	 * da cui poi viene generato il contatore contatoreEventiPerStati
	 */
	private static Vector<Eventi> evFiltratiPerStato;

	/**
	 * Oggetto della classe MinMaxAverage, il cui stato descrive le statistiche mensili minimo, massimo e media 
	 */
	private static MinMaxAverage mMA;

	/**
	 * Array di numeri interi che contiene le informazioni preliminari
	 * dalle quali attingono le statistiche minimo, massimo e media
	 */
	private static int[] numberArray;
	
	/**
	 * Variabile che contiene gli eventi che sono stati filtrati tramite i generi
	 * inseriti nel body dall'utente a partire dagli eventi filtrati per stati
	 */
	private static Vector<Eventi> eventiFiltratiPerGeneri;
	
	/**
	 * Variabile che contiene gli eventi per ogni genere inserito nel body dall'utente,
	 * da cui poi viene generato il contatore contatoreEventiPerGeneri
	 */
	private static Vector<Eventi> evFiltratiPerGenere;
	
	/**
	 * Metodo associato alla rotta post /eventi, che è in grado di generare
	 * filtri e statistiche in base al body fornito dall'utente
	 * 
	 * @param eB Oggetto della classe EventiBody
	 * @return responso
	 */
	@SuppressWarnings("unchecked")
	@PostMapping("/eventi")
	public JSONObject eventi(@RequestBody EventiBody eB) {

		responso = new JSONObject();
		generi = eB.getGeneri();
		periodo = eB.getPeriodo();
		statiScanner = StatiScanner.getStati();
		generiScanner = GeneriScanner.getGeneri();
		contatoreEventiPerStati = new LinkedHashMap<String, Integer>();
		contatoreEventiPerGeneri = new LinkedHashMap<String, Integer>();
		stati = new Vector<String>();
		paesi = new Vector<String>();
		australia = new Vector<String>();
		newZealand = new Vector<String>();
		chiamateEv = new Vector<Vector<Eventi>>();
		eventiFiltratiPerStati = new Vector<Eventi>();
		minMaxAverage = new LinkedHashMap<String, MinMaxAverage>();
		minMaxAverageFilter = new LinkedHashMap<String, MinMaxAverage>();
		eventiFiltratiPerGeneri = new Vector<Eventi>();
		
		try {

			controlloStatiEventiBody(eB);

			popolatoreStati();

			controlloSpazioECaseSensitivePerStati();

			controlloSpazioESlashECaseSensitivePerGeneri();
			
			validatorePeriodi();
						
			popolatorePaesi();

			popolatoreAustralia();
			
			popolatoreNewZealand();
			
			algoritmoChiamataEventi();
			
			filtroStati();
			
			controlloFiltroStatistichePeriodiche();
			
			controlloFiltroStati();

			if (generi.isEmpty()) {

				controlloGeneriEventiBody();

				return responso;

			}

			filtroGeneri();
			
			controlloFiltroGeneri();

			responso.put("numero totale eventi", contatoreEventiPerStati);
			
			responso.put("numero eventi per il genere", contatoreEventiPerGeneri);
			
			if (periodo.isEmpty())
				responso.put("statistiche mensili di eventi", minMaxAverage);
			else {
				responso.put("statistiche periodiche di eventi", minMaxAverageFilter);
			}
				
			
			responso.put("eventi", eventiFiltratiPerGeneri);

		} catch (EventiException e) {
			responso = e.generaJSON(key, value);
		}

		return responso;

	}

	/**
	 * Metodo ausiliario che effettua un controllo sul vettore di stati dell'oggetto
	 * eB, vedendo se è vuoto
	 * 
	 * @param eB Oggetto della classe EventiBody
	 * @throws EventiException Questo metodo lancia l'eccezione EventiException
	 */
	private static void controlloStatiEventiBody(EventiBody eB) throws EventiException {

		if (!eB.getStati().isEmpty())
			statiPaesi = eB.getStati();
		else {
			key = "Attenzione";
			value = "Non è stato specificato nessuno stato. Lista stati: " + statiScanner;
			throw new EventiException();
		}

	}

	/**
	 * Metodo ausiliario che popola il vettore stati
	 * 
	 * @throws EventiException Questo metodo lancia l'eccezione EventiException
	 */
	private static void popolatoreStati() throws EventiException {

		for (int i = 0; i < statiPaesi.size(); i++) {

			String s = statiPaesi.elementAt(i);

			controlloVirgolaPerStati(s);

			stati.add(s.substring(0, s.indexOf(",")));

		}

	}

	/**
	 * Metodo ausiliario che effettua un controllo sulla virgola per le stringhe del
	 * vettore stati
	 * 
	 * @param s Stringa del vettore stati da controllare
	 * @throws EventiException Questo metodo lancia l'eccezione EventiException
	 */
	private static void controlloVirgolaPerStati(String s) throws EventiException {

		if (!s.contains(",")) {

			key = "Errore";
			value = "Il formato consentito nel vettore 'stati' è il seguente: 'Stato, Paese'";
			throw new EventiException();

		}

	}

	/**
	 * Metodo ausiliario che effettua un doppio controllo sullo spazio e sul Case
	 * Sensitive delle stringhe del vettore stati
	 * 
	 * @throws EventiException Questo metodo lancia l'eccezione EventiException
	 */
	private static void controlloSpazioECaseSensitivePerStati() throws EventiException {

		for (int i = 0; i < stati.size(); i++) {

			String temp = stati.elementAt(i);
			String s = null;

			if (!temp.contains(" ")) {

				s = temp.substring(0, 1).toUpperCase() + temp.substring(1, temp.length()).toLowerCase();
				stati.set(i, s);

			} else {

				String t = temp.substring(0, 1).toUpperCase() + temp.substring(1, temp.length()).toLowerCase();
				char[] cArr = t.toCharArray(); // Trasforma la stringa in array di char

				for (int j = 0; j < cArr.length; j++) {

					char c = cArr[j];
					if (c == ' ' && j != cArr.length - 1)
						cArr[j + 1] = Character.toUpperCase(cArr[j + 1]);

				}

				s = new String(cArr);
				stati.set(i, s);

			}

			generatoreSuggerimentiPerStati(s, i);

		}

	}

	/**
	 * Metodo che genera i suggerimenti per il vettore stati
	 * 
	 * @param s Stringa del vettore stati da analizzare
	 * @param i Iterazione del ciclo for utilizzato per scorrere gli elementi del
	 *          vettore stati
	 * @throws EventiException Questo metodo lancia l'eccezione EventiException
	 */
	private static void generatoreSuggerimentiPerStati(String s, int i) throws EventiException {

		if (!statiScanner.contains(s)) {

			Vector<String> suggerimenti = new Vector<String>();

			for (String sugg : statiScanner) {

				if (sugg.charAt(0) == s.charAt(0))
					suggerimenti.add(sugg);

			}

			if (suggerimenti.isEmpty()) {

				key = "Attenzione";
				value = "Nessuno stato inizia per " + s.charAt(0) + ". Lista stati: " + statiScanner;
				throw new EventiException();

			}

			key = "Suggerimento";
			value = "Forse volevi inserire " + suggerimenti + " nell'elemento " + (i + 1) + " del vettore stati";
			throw new EventiException();

		}

	}

	/**
	 * Metodo ausiliario che effettua un triplo controllo sullo spazio, sullo slash
	 * e sul Case Sensitive delle stringhe del vettore generi
	 * 
	 * @throws EventiException Questo metodo lancia l'eccezione EventiException
	 */
	private static void controlloSpazioESlashECaseSensitivePerGeneri() throws EventiException {

		for (int i = 0; i < generi.size(); i++) {

			String temp = generi.elementAt(i);
			String g = null;

			if (!(temp.contains(" ") || temp.contains("/"))) {

				g = temp.substring(0, 1).toUpperCase() + temp.substring(1, temp.length()).toLowerCase();
				generi.set(i, g);

			} else {

				String t = temp.substring(0, 1).toUpperCase() + temp.substring(1, temp.length()).toLowerCase();
				char[] cArr = t.toCharArray(); // Trasforma la stringa in array di char

				for (int j = 0; j < cArr.length; j++) {

					char c = cArr[j];

					if ((c == ' ' || c == '/') && j != cArr.length - 1)
						cArr[j + 1] = Character.toUpperCase(cArr[j + 1]);

				}

				g = new String(cArr);
				generi.set(i, g);

			}

			generatoreSuggerimentiPerGeneri(g, i);

		}

	}

	/**
	 * Metodo che genera i suggerimenti per il vettore generi
	 * 
	 * @param g Stringa del vettore generi da analizzare
	 * @param i Iterazione del ciclo for utilizzato per scorrere gli elementi del
	 *          vettore stati
	 * @throws EventiException Questo metodo lancia l'eccezione EventiException
	 */
	private static void generatoreSuggerimentiPerGeneri(String g, int i) throws EventiException {

		if (!generiScanner.contains(generi.elementAt(i))) {

			Vector<String> suggerimenti = new Vector<String>();

			for (String sugg : generiScanner) {

				if (sugg.charAt(0) == g.charAt(0))
					suggerimenti.add(sugg);

			}

			if (suggerimenti.isEmpty()) {

				key = "Attenzione";
				value = "Nessun genere inizia per " + g.charAt(0) + ". Lista generi: " + generiScanner;
				throw new EventiException();

			}

			key = "Suggerimento";
			value = "Forse volevi inserire " + suggerimenti + " nell'elemento " + (i + 1) + " del vettore generi";
			throw new EventiException();

		}

	}

	/**
	 * Metodo ausiliario che popola il vettore paesi
	 * 
	 * @throws EventiException Questo metodo lancia l'eccezione EventiException
	 */
	private static void popolatorePaesi() throws EventiException {

		for (int i = 0; i < statiPaesi.size(); i++) {

			String p = statiPaesi.elementAt(i);
			paesi.add(p.substring(p.length() - 2, p.length()));

			controlloVirgolaPerPaesi(i);

		}

	}

	/**
	 * Metodo ausiliario che effettua un controllo sulla virgola per le stringhe del
	 * vettore paesi
	 * 
	 * @param i Iteratore del ciclo for che scorre le stringhe del vettore
	 *          statiPaesi
	 * @throws EventiException Questo metodo lancia l'eccezione EventiException
	 */
	private static void controlloVirgolaPerPaesi(int i) throws EventiException {

		if (paesi.elementAt(i).contains(",")) {

			key = "Errore";
			value = "Il formato consentito nel vettore 'stati' è il seguente: 'Stato, Paese'";
			throw new EventiException();

		}

	}
	
	/**
	 * Metodo ausiliario che effettua un controllo sul mese inserito nel
	 * periodo personalizzato, relativo alle stringhe del vettore periodo,
	 * per accertarsi che vengano inseriti valori accettabili per rappresentare
	 * un mese
	 * 
	 * @throws EventiException Questo metodo lancia l'eccezione EventiException
	 */
	private static void controlloScritturaMese() throws EventiException {

			key = "Errore";
			value = "Il formato consentito per il mese nel vettore 'periodo' è il seguente: da 01 a 12";
			throw new EventiException();

	}
	
	/**
	 * Metodo ausiliario che effettua un controllo sulle stringhe del vettore periodo
	 * per accertarsi che le date vengano inserite in ordine cronologico 
	 * 
	 * @throws EventiException Questo metodo lancia l'eccezione EventiException
	 */
	private static void controlloOrdineDate() throws EventiException {

			key = "Errore";
			value = "la prima data deve essere minore della seconda data inserita";
			throw new EventiException();

	}
	
	/**
	 * Metodo ausiliario che effettua un controllo sul giorno inserito nel
	 * periodo personalizzato, relativo alle stringhe del vettore periodo,
	 * per accertarsi che vengano inseriti valori accettabili per rappresentare
	 * un giorno
	 * 
	 * @throws EventiException Questo metodo lancia l'eccezione EventiException
	 */
	private static void controlloScritturaGiorno() throws EventiException {

			key = "Errore";
			value = "Il formato consentito per il giorno nel vettore 'periodo' è il seguente: da 01 a 31 a seconda del mese";
			throw new EventiException();

	}
	
	/**
	 * Metodo ausiliario che effettua un controllo sulle stringhe del vettore periodo,
	 * per accertarsi che vengano inseriti numeri per rappresentare
	 * anno, giorno e mese e non lettere
	 * 
	 * @throws EventiException Questo metodo lancia l'eccezione EventiException
	 */
	private static void controlloLettereInPeriodo() throws EventiException {

			key = "Errore";
			value = "le date non possono contenere lettere, ma solo numeri; scrivere la data nel seguente formato: yyyy--mm--dd";
			throw new EventiException();

	}
	
	/**
	 * Metodo ausiliario che effettua un controllo sul trattino, che separa 
	 * anno, mese e giorno del periodo personalizzato, relativo alle stringhe del
	 * vettore periodo
	 * 
	 * @throws EventiException Questo metodo lancia l'eccezione EventiException
	 */
	private static void controlloScritturaPeriodo() throws EventiException {

			key = "Errore";
			value = "Il formato consentito nel vettore 'periodo' è il seguente: 'yyyy-mm-dd'";
			throw new EventiException();

	}
	
	/**
	 * Metodo ausiliario che popola il vettore australia
	 */
	private static void popolatoreAustralia() {

		australia.addAll(statiScanner);
		australia.remove(australia.size() - 1);
		australia.add("AU");

	}

	/**
	 * Metodo ausiliario che popola il vettore newZealand
	 */
	private static void popolatoreNewZealand() {

		newZealand.add(statiScanner.elementAt(statiScanner.size() - 1));
		newZealand.add("NZ");

	}

	/**
	 * Metodo ausiliario che effettua l'algoritmo utile per la chiamata alla rotta
	 * events dell'API di ticketmaster. L'algoritmo evita di ripetere chiamate
	 * inutili, effettuandole in base ai paesi (2 nel nostro caso) e copiando la
	 * chiamata nelle successive ripetizioni per paesi uguali
	 * 
	 * @throws EventiException Questo metodo lancia l'eccezione EventiException
	 */
	private static void algoritmoChiamataEventi() throws EventiException {

		for (int i = 0; i < paesi.size(); i++) {

			String p = paesi.elementAt(i);

			String s = stati.elementAt(i);

			if (p.equals("AU") || p.equals("NZ")) {

				if ((australia.contains(p) && australia.contains(s))
						|| (newZealand.contains(p) && newZealand.contains(s))) {

					Vector<String> subPaesi = new Vector<String>();

					for (int h = 0; h < i; h++) {
						String subP = paesi.elementAt(h);
						subPaesi.add(subP);
					}

					if (!subPaesi.contains(p)) {

						chiamateEv.add(ChiamataEventi.chiamata(p));

					} else
						chiamateEv.add(chiamateEv.elementAt(subPaesi.indexOf(p)));
				} else {
					key = "Errore";
					value = "Lo stato " + s + " non appartiene al paese " + p;
					throw new EventiException();
				}
			} else {
				key = "Errore";
				value = "Lo stato " + p + " non è disponibile";
				throw new EventiException();
			}

		}

	}

	/**
	 * Metodo ausiliario che effettua un filtro per stati sul vettore chiamateEv
	 */
	private static void filtroStati() {

		for (int i = 0; i < chiamateEv.size(); i++) {

			Vector<Eventi> evTemp = chiamateEv.elementAt(i);
			evFiltratiPerStato = StatiFilter.filterByState(stati.elementAt(i), evTemp);

			eventiFiltratiPerStati.addAll(evFiltratiPerStato);
			
			
			
			contatoreEventiPerStati.put("in " + stati.elementAt(i), evFiltratiPerStato.size());

			DatesStatistics dS = new DatesStatistics();

			statisticheMensili(dS, i);
			
			int dimVectorCounter = 2;
			if (!periodo.isEmpty() && dimVectorCounter == periodo.size())
				filtroStatistichePeriodiche(mMA, numberArray, i);
		}

	}
	
	/**
	 * Metodo ausiliario che effettua le statistiche minimo, massimo e media in un
	 * periodo di default di 30 giorni
	 * 
	 * @param dS Oggetto della classe DatesStatistics
	 * @param i  Iteratore del ciclo for che scorre gli oggetti del vettore
	 *           chiamateEv
	 */
	private static void statisticheMensili(DatesStatistics dS, int i) {

		mMA = new MinMaxAverage();

		numberArray = dS.numeroEventi(evFiltratiPerStato);

		mMA.sortSelectedEvents(numberArray);

		mMA.minimoNumeroEventiMese(numberArray);
		mMA.massimoNumeroEventiMese(numberArray);
		mMA.mediaNumeroEventiMese(numberArray);

		minMaxAverage.put("in " + stati.elementAt(i), mMA);

	}

	/**
	 * Metodo ausiliario che effettua un filtro sulle statistiche minimo, massimo e
	 * media, al fine di produrre queste statistiche in un periodo di tempo
	 * personalizzato
	 * 
	 * @param mMA Oggetto della classe MinMaxAverage, il cui stato descrive
	 * le statistiche mensili minimo, massimo e media
	 * 
	 * @param numberArray Array di numeri interi che contiene le informazioni preliminari
	 * dalle quali attingono le statistiche minimo, massimo e media
	 * 
	 * @param i Iteratore del ciclo for che scorre gli oggetti del vettore
	 *           chiamateEv
	 */
	private static void filtroStatistichePeriodiche(MinMaxAverage mMA, int[] numberArray, int i) {

		MinMaxAverageFilter mma = new MinMaxAverageFilter();

		int[] numArray = mma.minMaxAverageFilterFunction(evFiltratiPerStato, periodo);

		numberArray = numArray;

		mMA.sortSelectedEvents(numberArray);

		mMA.minimoNumeroEventiMese(numberArray);
		mMA.massimoNumeroEventiMese(numberArray);
		mMA.mediaNumeroEventiMese(numberArray);

		minMaxAverageFilter.put("in " + stati.elementAt(i), mMA);

	}
	
	/**
	 * Metodo ausiliario che effettua un controllo sul vettore di stati dell'oggetto
	 * eB, vedendo se è vuoto 
	 * 
	 * @throws EventiException Questo metodo lancia l'eccezione EventiException
	 */
	private static void controlloFiltroStatistichePeriodiche() throws EventiException {
		
		if(!periodo.isEmpty()) {
			int controllerSize = 2;
			if (controllerSize != periodo.size()) {

				key = "Attenzione";
				value = "è possibile inserire solo due date, ovvero la data di inizio e la data di fine";
				throw new EventiException();

			}
			
		}

	}
	
	/**
	 * Metodo ausiliario, per la validazione delle stringhe che compongono il vettore
	 * periodo, che accerta che ciascun mese del periodo personalizzato sia compreso tra 
	 * 01 e 12
	 * 
	 * @throws EventiException Questo metodo lancia l'eccezione EventiException
	 */
	public static void validatoreMese() throws EventiException {
		
		int dimVectorCounter = 2;
		
		if (!periodo.isEmpty() && dimVectorCounter == periodo.size()) {
			
			for(int k = 0; k< 2; k++) {
				
				String data = periodo.elementAt(k);
				
				if(data.length() != 10) {
					controlloScritturaMese();
				}
				
				char firstNumber = data.charAt(5);
				char secondNumber = data.charAt(6);
				
				if( (firstNumber != 0) && (secondNumber == '-') ) {
					controlloScritturaMese();
				}
				else {
					if( !((1<= Integer.parseInt(data.substring(5,7))) && (12>= Integer.parseInt(data.substring(5,7)))) ) {
						controlloScritturaMese();
					}
					
				}
				
			}
			
		}
		
	}
		
	/**
	 * Metodo ausiliario, per la validazione delle stringhe che compongono il vettore
	 * periodo, che accerta che ciascun giorno del periodo personalizzato sia compreso tra 
	 * 1 e 31, oppure tra 1 e 30, oppure tra 1 e 28 a seconda del mese relativo 
	 * al giorno considerato
	 * 
	 * @throws EventiException Questo metodo lancia l'eccezione EventiException
	 */
	public static void validatoreGiorno() throws EventiException {
		
		int dimVectorCounter = 2;
		
		if (!periodo.isEmpty() && dimVectorCounter == periodo.size()) {
			
			for(int k = 0; k < 2; k++) {
				
				String data = periodo.elementAt(k);
				
				Vector<Character> d1= new Vector<Character>();
				
				for(int i = 0; i < data.length(); i++) {
					
					d1.add(i, data.charAt(i));
				}
				
				if(data.length() != 10) {
					controlloScritturaGiorno();
				}
				
				int giornoInserito = Integer.parseInt(data.substring(8,10));
				
				if( !( (1<= Integer.parseInt(data.substring(8,10))) && (31>= Integer.parseInt(data.substring(8,10))) ) ) {
					controlloScritturaGiorno();
				}
				else {
					
					int meseIniziale = Integer.parseInt(data.substring(5,7));
					
					int[] mesi30giorni = {4, 6, 9, 11};
					int febbraio = 2;
					
					for(int i = 0; i<mesi30giorni.length; i++) {
						if( (meseIniziale == mesi30giorni[i]) && (giornoInserito == 31) ) {
							
							controlloScritturaGiorno();
						}
					}
					
					if( (meseIniziale == febbraio) && (giornoInserito > 28) ) {
						controlloScritturaGiorno();
					}
					
				}
				
			}
			
		}
		
	}	
	
	/**
	 * Metodo ausiliario, per la validazione delle stringhe che compongono il vettore
	 * periodo, che accerta che ciascuna data del periodo personalizzato venga espressa 
	 * solo con numeri e mai con lettere
	 *
	 * 
	 * @throws EventiException Questo metodo lancia l'eccezione EventiException
	 */
	private static void controlloreLettereInPeriodo() throws EventiException {
		
		int dimVectorCounter = 2;
		
		if (!periodo.isEmpty() && dimVectorCounter == periodo.size()) {
			
			for(int k = 0; k < 2; k++) {
				
				String data = periodo.elementAt(k);
				
				for(int i = 0; i< data.length(); i++) {
					
					if( !( (Character.isDigit(data.charAt(i))) || (data.charAt(i)=='-') ) ) {
						
						controlloLettereInPeriodo();
					}
					
				}

			}
			
		}
		
	}
	
	/**
	 * Metodo ausiliario, relativo alle stringhe che compongono il vettore
	 * periodo, che accerta che le date inserire siano disposte in ordine cronologico
	 *
	 * 
	 * @throws EventiException Questo metodo lancia l'eccezione EventiException
	 */
	private static void controlloreOrdineDate() throws EventiException {
		
		int dimVectorCounter = 2;
		
		if (!periodo.isEmpty() && dimVectorCounter == periodo.size()) {
			
			LocalDate data1 = MinMaxAverageFilter.dateConverter(periodo.elementAt(0));
			LocalDate data2 = MinMaxAverageFilter.dateConverter(periodo.elementAt(1));
			
			if(data1.isAfter(data2)) {
				controlloOrdineDate();
			}
			
		}

	}
	
	/**
	 * Metodo ausiliario, per la validazione delle stringhe che compongono il vettore
	 * periodo, che accerta che ciascuna data del periodo personalizzato venga espressa 
	 * separando anno, mese e giorno mediante un trattino e che svolge tutti i controlli
	 * sulle date ante descritti richiamando i metodi validatoreMese(),
	 * validatoreGiorno() e controlloreLettereInPeriodo()
	 *
	 * 
	 * @throws EventiException Questo metodo lancia l'eccezione EventiException
	 */
	private static void validatorePeriodi() throws EventiException {
		
		int dimVectorCounter = 2;
		
		if (!periodo.isEmpty() && dimVectorCounter == periodo.size()) {
			
			for(int k = 0; k < 2; k++) {
				
				String data = periodo.elementAt(k);
				
				if(data.length() != 10) {
					controlloScritturaPeriodo();

				}
				
				Vector<Character> dataVector = new Vector<Character>();
				
				for(int i = 0; i < data.length(); i++) {
					
					dataVector.add(i, data.charAt(i));
				}
				
				if( (dataVector.elementAt(4) != '-') || (dataVector.elementAt(7) != '-') ) {
					controlloScritturaPeriodo();
				}
				
				controlloreLettereInPeriodo();
				
				validatoreMese();
				
				validatoreGiorno();
				
				controlloreOrdineDate();
				
			}
			
		}

	}
	
	/**
	 * Metodo ausiliario che effettua un controllo nel caso in cui non ci fossero
	 * eventi disponibili dopo il filtro per stati
	 * 
	 * @throws EventiException Questo metodo lancia l'eccezione EventiException
	 */
	private static void controlloFiltroStati() throws EventiException {

		if (eventiFiltratiPerStati.isEmpty()) {

			key = "Attenzione";
			value = "Non ci sono eventi disponibili";
			throw new EventiException();

		}

	}

	/**
	 * Metodo ausiliario che effettua un controllo sul vettore di generi
	 * dell'oggetto eB, vedendo se è vuoto e ritornando un responso alternativo
	 */
	@SuppressWarnings("unchecked")
	private static void controlloGeneriEventiBody() {

		HashSet<String> generiHash = new HashSet<String>();

		for (Eventi e : eventiFiltratiPerStati)
			generiHash.add(e.getGenere());

		for (String g : generiHash) {

			int cont = GeneriFilter.filterByGenre(g, eventiFiltratiPerStati).size();
			contatoreEventiPerGeneri.put(g, cont);

		}

		responso.put("numero totale eventi", contatoreEventiPerStati);

		responso.put("numero eventi per il genere", contatoreEventiPerGeneri);

		if (periodo.isEmpty())
			responso.put("statistiche mensili di eventi", minMaxAverage);
		else
			responso.put("statistiche periodiche di eventi", minMaxAverageFilter);

		responso.put("eventi", eventiFiltratiPerStati);

	}

	/**
	 * Metodo ausiliario che effettua un filtro per generi sul vettore eventiFiltratiPerStati 
	 */
	private static void filtroGeneri() {
		
		for (int i = 0; i < generi.size(); i++) {

			String g = generi.elementAt(i);
			evFiltratiPerGenere = GeneriFilter.filterByGenre(g, eventiFiltratiPerStati);
			
			eventiFiltratiPerGeneri.addAll(evFiltratiPerGenere);
			
			contatoreEventiPerGeneri.put(generi.elementAt(i), evFiltratiPerGenere.size());

		}
		
	}
	
	/**
	 * Metodo ausiliario che effettua un controllo nel caso in cui non ci fossero
	 * eventi disponibili dopo il filtro per generi
	 * 
	 * @throws EventiException Questo metodo lancia l'eccezione EventiException
	 */
	private static void controlloFiltroGeneri() throws EventiException {
		
		if (eventiFiltratiPerGeneri.isEmpty()) {
			
			key = "Attenzione";
			value = "Non ci sono eventi disponibili";
			throw new EventiException();
		
		}
		
	}
	
}