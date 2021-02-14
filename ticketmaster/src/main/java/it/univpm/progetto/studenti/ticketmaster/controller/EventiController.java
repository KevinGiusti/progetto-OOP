package it.univpm.progetto.studenti.ticketmaster.controller;

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
 */
@RestController
public class EventiController {

	/**
	 *  
	 */
	private static String key;

	/**
	 * 
	 */
	private static String value;

	/**
	 * 
	 */
	private static JSONObject responso;

	/**
	 * 
	 */
	private static Vector<String> statiPaesi;

	/**
	 * 
	 */
	private static Vector<String> generi;

	/**
	 * 
	 */
	private static Vector<String> periodo;

	/**
	 * 
	 */
	private static Vector<String> statiScanner;

	/**
	 * 
	 */
	private static Vector<String> generiScanner;

	/**
	 * 
	 */
	private static LinkedHashMap<String, Integer> contatoreEventiPerStati;

	/**
	 * 
	 */
	private static LinkedHashMap<String, Integer> contatoreEventiPerGeneri;

	/**
	 * 
	 */
	private static Vector<String> stati;
	
	/**
	 * 
	 */
	private static Vector<String> paesi;
	
	/**
	 * 
	 */
	private static Vector<String> australia;
	
	/**
	 * 
	 */
	private static Vector<String> newZealand;
	
	/**
	 * 
	 */
	private static Vector<Vector<Eventi>> chiamateEv;
	
	/**
	 * 
	 */
	private static Vector<Eventi> eventiFiltratiPerStati;
	
	/**
	 * 
	 */
	private static LinkedHashMap<String, MinMaxAverage> minMaxAverage;
	
	/**
	 * 
	 */
	private static LinkedHashMap<String, MinMaxAverage> minMaxAverageFilter;
	
	/**
	 * 
	 */
	private static Vector<Eventi> evFiltratiPerStato;
	
	/**
	 * 
	 */
	private static MinMaxAverage mMA;
	
	/**
	 * 
	 */
	private static int[] numberArray;
	
	/**
	 * 
	 * 
	 * @param eB
	 * @return
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
		
		
		try {
			
			controlloStatiEventiBody(eB);
			
			popolatoreStati();
			
			controlloSpazioECaseSensitivePerStati();

			controlloSpazioESlashECaseSensitivePerGeneri();
			
			popolatorePaesi();
			
			popolatoreAustralia();
			
			popolatoreNewZealand();
			
			algoritmoChiamataEventi();
			
			filtroStati();


			
			
			

			

			if (eventiFiltratiPerStati.isEmpty()) {
				key = "Attenzione";
				value = "Non ci sono eventi disponibili";
				throw new EventiException();
			}

			if (generi.isEmpty()) {

				HashSet<String> generiHash = new HashSet<String>();

				for (Eventi e : eventiFiltratiPerStati)
					generiHash.add(e.getGenere());
				
				for (String g : generiHash) {
					
					int cont = GeneriFilter.filterByGenre(g, eventiFiltratiPerStati).size();
					contatoreEventiPerGeneri.put(g, cont);
					
				}

				responso.put("numero totale eventi", contatoreEventiPerStati);
				responso.put("numero eventi per il genere", contatoreEventiPerGeneri);
				if(periodo.isEmpty())
					responso.put("statistiche mensili di eventi", minMaxAverage);
				else
					responso.put("statistiche periodiche di eventi", minMaxAverageFilter);
				responso.put("eventi", eventiFiltratiPerStati);
				return responso;
			}

			Vector<Eventi> eventiFiltratiPerGeneri = new Vector<Eventi>();

			for (int i = 0; i < generi.size(); i++) {

				String g = generi.elementAt(i);
				Vector<Eventi> evFiltrati = GeneriFilter.filterByGenre(g, eventiFiltratiPerStati);
				eventiFiltratiPerGeneri.addAll(evFiltrati);
				contatoreEventiPerGeneri.put(generi.elementAt(i), evFiltrati.size());

			}

			if (eventiFiltratiPerGeneri.isEmpty()) {
				key = "Attenzione";
				value = "Non ci sono eventi disponibili";
				throw new EventiException();
			}

			responso.put("numero totale eventi", contatoreEventiPerStati);
			responso.put("numero eventi per il genere", contatoreEventiPerGeneri);
			if(periodo.isEmpty())
				responso.put("statistiche mensili di eventi", minMaxAverage);
			else
				responso.put("statistiche periodiche di eventi", minMaxAverageFilter);
			responso.put("eventi", eventiFiltratiPerGeneri);
			
		}catch(

	EventiException e)
	{
		responso = e.generaJSON(key, value);
	}

	return responso;
	
	}

	/**
	 * Metodo ausiliario che effettua un controllo sul vettore di stati dell'oggetto
	 * eB, vedendo se è vuoto
	 * 
	 * @param eB Oggetto della classe EventiBody
	 * @throws EventiException
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
	 * @throws EventiException
	 */
	private static void popolatoreStati() throws EventiException {

		for (int i = 0; i < statiPaesi.size(); i++) {

			String s = statiPaesi.elementAt(i);

			controlloVirgolaPerStati(s);

			stati.add(s.substring(0, s.indexOf(",")));

		}

	}

	/**
	 * Metodo ausiliario che effettua un controllo sulla virgola per le stringhe del vettore stati
	 * 
	 * @param s Stringa del vettore stati da controllare
	 * @throws EventiException
	 */
	private static void controlloVirgolaPerStati(String s) throws EventiException {

		if (!s.contains(",")) {

			key = "Errore";
			value = "Il formato consentito nel vettore 'stati' è il seguente: 'Stato, Paese'";
			throw new EventiException();

		}

	}

	/**
	 * Metodo ausiliario che effettua un doppio controllo sullo spazio
	 * e sul Case Sensitive delle stringhe del vettore stati
	 * 
	 * @throws EventiException 
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
	 * @param i Iterazione del ciclo for utilizzato per scorrere gli elementi del vettore stati
	 * @throws EventiException
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
			value = "Forse volevi inserire " + suggerimenti + " nell'elemento " + (i + 1)
					+ " del vettore stati";
			throw new EventiException();

		}
		
	}
	
	/**
	 * Metodo ausiliario che effettua un triplo controllo sullo spazio, sullo slash
	 * e sul Case Sensitive delle stringhe del vettore generi
	 * 
	 * @throws EventiException 
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
	 * @param i Iterazione del ciclo for utilizzato per scorrere gli elementi del vettore stati
	 * @throws EventiException
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
			value = "Forse volevi inserire " + suggerimenti + " nell'elemento " + (i + 1)
					+ " del vettore generi";
			throw new EventiException();

		}
		
	}
	
	/**
	 * Metodo ausiliario che popola il vettore paesi
	 * 
	 * @throws EventiException
	 */
	private static void popolatorePaesi() throws EventiException {
		
		for (int i = 0; i < statiPaesi.size(); i++) {

			String p = statiPaesi.elementAt(i);
			paesi.add(p.substring(p.length() - 2, p.length()));

			controlloVirgolaPerPaesi(i);

		}

	}
	
	/**
	 * Metodo ausiliario che effettua un controllo sulla virgola per le stringhe del vettore paesi
	 * 
	 * @param i Iteratore del ciclo for che scorre le stringhe del vettore statiPaesi
	 * @throws EventiException
	 */
	private static void controlloVirgolaPerPaesi(int i) throws EventiException {
		
		if (paesi.elementAt(i).contains(",")) {
			
			key = "Errore";
			value = "Il formato consentito nel vettore 'stati' è il seguente: 'Stato, Paese'";
			throw new EventiException();
		
		}
		
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
	 * Metodo ausiliario che effettua l'algoritmo utile per la chiamata alla rotta events dell'API di ticketmaster.
	 * L'algoritmo evita di ripetere chiamate inutili, effettuandole in base ai paesi (2 nel nostro caso)
	 * e copiando la chiamata nelle successive ripetizioni per paesi uguali
	 * 
	 * @throws EventiException
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
			
			if(!periodo.isEmpty())
				filtroStatistichePeriodiche(mMA, numberArray, i);
			
			
		}
		
	}
	
	/**
	 * Metodo ausiliario che effettua le statistiche minimo, massimo e media in un periodo di default di 30 giorni
	 * 
	 * @param dS Oggetto della classe DatesStatistics
	 * @param i Iteratore del ciclo for che scorre gli oggetti del vettore chiamateEv
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
	 * Metodo ausiliario che effettua un filtro sulle statistiche minimo, massimo e media, 
	 * al fine di produrre queste statistiche in un periodo di tempo personalizzato
	 * 
	 * @param mMA
	 * @param numberArray
	 * @param i
	 */
	private static void filtroStatistichePeriodiche(MinMaxAverage mMA, int[] numberArray, int i) {
		
			MinMaxAverageFilter mma= new MinMaxAverageFilter();
			
			int[] numArray= mma.minMaxAverageFilterFunction(evFiltratiPerStato, periodo);
			
			numberArray = numArray;
			
			mMA.sortSelectedEvents(numberArray);
			
			mMA.minimoNumeroEventiMese(numberArray);
			mMA.massimoNumeroEventiMese(numberArray);
			mMA.mediaNumeroEventiMese(numberArray);
			
			minMaxAverageFilter.put("in " + stati.elementAt(i), mMA);
		
	}
	
	
	
}