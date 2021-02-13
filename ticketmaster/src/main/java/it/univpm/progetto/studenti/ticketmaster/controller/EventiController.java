package it.univpm.progetto.studenti.ticketmaster.controller;

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
 * 
 * Controller della rotta eventi che ritorna una serie di eventi filtrati
 * 
 * @author RoccoAnzivino
 *
 */
@RestController
public class EventiController {

	private String key;
	private String value;

	@SuppressWarnings("unchecked")
	@PostMapping("/eventi")
	public JSONObject eventi(@RequestBody EventiBody eB) {
//		long init = System.currentTimeMillis();
		JSONObject responso = new JSONObject();
		Vector<String> statiPaesi = null;
		Vector<String> generi = eB.getGeneri();
		Vector<String> periodo = eB.getPeriodo();
		Vector<String> statiScanner = StatiScanner.getStati();
		Vector<String> generiScanner = GeneriScanner.getGeneri();
		LinkedHashMap<String, Integer> contatoreEventiPerStati = new LinkedHashMap<String, Integer>();
		
		try {

			if (!eB.getStati().isEmpty())
				statiPaesi = eB.getStati();
			else {
				key = "Attenzione";
				value = "Non è stato specificato nessuno stato. Lista stati: " + statiScanner;
				throw new EventiException();
			}

			Vector<String> stati = new Vector<String>();

			for (int i = 0; i < statiPaesi.size(); i++) {

				String s = statiPaesi.elementAt(i);

				if (!s.contains(",")) {
					key = "Errore";
					value = "Il formato consentito nel vettore 'stati' è il seguente: 'Stato, Paese'";
					throw new EventiException();
				}

				stati.add(s.substring(0, s.indexOf(",")));

			}

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

			for (int i = 0; i < generi.size(); i++) {

				String temp = generi.elementAt(i);

				String g = temp.substring(0, 1).toUpperCase() + temp.substring(1, temp.length()).toLowerCase();

				generi.set(i, g);

				if (!generiScanner.contains(g)) {

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

			Vector<String> paesi = new Vector<String>();

			for (int i = 0; i < statiPaesi.size(); i++) {

				String p = statiPaesi.elementAt(i);
				paesi.add(p.substring(p.length() - 2, p.length()));

				if (paesi.elementAt(i).contains(",")) {
					key = "Errore";
					value = "Il formato consentito nel vettore 'stati' è il seguente: 'Stato, Paese'";
					throw new EventiException();
				}

			}

//			long init = System.currentTimeMillis();
			
			Vector<String> australia = new Vector<String>();
			australia.addAll(statiScanner);
			australia.remove(australia.size() - 1);
			australia.add("AU");

			Vector<String> newZealand = new Vector<String>();
			newZealand.add(statiScanner.elementAt(statiScanner.size() - 1));
			newZealand.add("NZ");

			Vector<Vector<Eventi>> chiamateEv = new Vector<Vector<Eventi>>();

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

//			long fin = System.currentTimeMillis();
//			
//			System.out.println(fin - init);
			Vector<Eventi> eventiFiltratiPerStati = new Vector<Eventi>();
			LinkedHashMap<String, MinMaxAverage> minMaxAverage = new LinkedHashMap<String, MinMaxAverage>();
			
			for (int i = 0; i < chiamateEv.size(); i++) {

				Vector<Eventi> evTemp = chiamateEv.elementAt(i);
				Vector<Eventi> evFiltrati = StatiFilter.filterByState(stati.elementAt(i), evTemp);
				eventiFiltratiPerStati.addAll(evFiltrati);
				contatoreEventiPerStati.put("in " + stati.elementAt(i), evFiltrati.size());
				// oggetto per il calcolo eventi per ciascun mese
				DatesStatistics sc = new DatesStatistics();
				MinMaxAverage mMA = new MinMaxAverage();
				int[] numberArray = sc.numeroEventi(evFiltrati);
				mMA.sortSelectedEvents(numberArray);
				mMA.minimoNumeroEventiMese(numberArray);
				mMA.massimoNumeroEventiMese(numberArray);
				mMA.mediaNumeroEventiMese(numberArray);
				minMaxAverage.put("in " + stati.elementAt(i), mMA);
				for(int n : numberArray)
					System.out.println(n);
				// oggetto per l'ordinamento del numero eventi in ciascun mese
//				minMaxAverage.elementAt(i).sortSelectedEvents(numberArray);
//				responso.put("numero minimo mensile di eventi in ogni stato", minMaxAverage.elementAt(i).minimoNumeroEventiMese(numberArray));
//				responso.put("numero massimo mensile di eventi in ogni stato", minMaxAverage.elementAt(i).massimoNumeroEventiMese(numberArray));
//				responso.put("numero medio mensile di eventi in ogni stato", minMaxAverage.elementAt(i).mediaNumeroEventiMese(numberArray));
			}
			
			if (eventiFiltratiPerStati.isEmpty()) {
				key = "Attenzione";
				value = "Non ci sono eventi disponibili";
				throw new EventiException();
			}	
	
			if (generi.isEmpty()) {
//				responso.put("numero totale di eventi", eventiFiltratiPerStati.size());
				responso.put("numero totale eventi", contatoreEventiPerStati);
				responso.put("eventi", eventiFiltratiPerStati);
				return responso;
			}
			
			Vector<Eventi> eventiFiltratiPerGeneri = new Vector<Eventi>();

			for (int i = 0; i < generi.size(); i++) {

				String g = generi.elementAt(i);
				eventiFiltratiPerGeneri.addAll(GeneriFilter.filterByGenre(g, eventiFiltratiPerStati));

			}
			
			if (eventiFiltratiPerGeneri.isEmpty()) {
				key = "Attenzione";
				value = "Non ci sono eventi disponibili";
				throw new EventiException();
			}
			
			responso.put("numero totale eventi", contatoreEventiPerStati);
			responso.put("statistiche mensili di eventi", minMaxAverage);
			responso.put("eventi", eventiFiltratiPerGeneri);

		} catch (EventiException e) {
			responso = e.generaJSON(key, value);
		}

		return responso;
	}
}