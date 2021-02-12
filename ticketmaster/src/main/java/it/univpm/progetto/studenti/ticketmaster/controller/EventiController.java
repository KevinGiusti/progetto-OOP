package it.univpm.progetto.studenti.ticketmaster.controller;

import java.util.Vector;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.progetto.studenti.ticketmaster.api.ChiamataEventi;
import it.univpm.progetto.studenti.ticketmaster.datestats.DatesStatistics;
import it.univpm.progetto.studenti.ticketmaster.datestats.MinMaxAverage;
import it.univpm.progetto.studenti.ticketmaster.exception.EventiException;
import it.univpm.progetto.studenti.ticketmaster.filters.GeneriFilter;
import it.univpm.progetto.studenti.ticketmaster.filters.StatiFilter;
import it.univpm.progetto.studenti.ticketmaster.model.Eventi;
import it.univpm.progetto.studenti.ticketmaster.model.EventiBody;
import it.univpm.progetto.studenti.ticketmaster.scanner.StatiScanner;

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

		JSONObject responso = new JSONObject();
		Vector<String> statiPaesi = null;
		Vector<String> statiScanner = StatiScanner.getStati();
		Vector<String> generi = eB.getGeneri();
		
		System.out.println(generi);

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
				stati.add(s.substring(0, s.indexOf(",")));
			}

			for (int i = 0; i < stati.size(); i++) {

				String s = stati.elementAt(i);

				if (!statiScanner.contains(s)) {

					Vector<String> suggerimenti = new Vector<String>();

					for (String sugg : statiScanner) {

						if (sugg.charAt(0) == s.charAt(0))
							suggerimenti.add(sugg);

					}

					key = "Suggerimento";
					value = "Forse volevi inserire " + suggerimenti + " nell'elemento " + (i + 1)
							+ " del vettore stati";
					
					throw new EventiException();

				}

			}

			Vector<String> paesi = new Vector<String>();

			for (int i = 0; i < statiPaesi.size(); i++) {

				String p = statiPaesi.elementAt(i);
				paesi.add(p.substring(p.length() - 2, p.length()));

			}

			Vector<Vector<Eventi>> chiamateEv = new Vector<Vector<Eventi>>();

			for (int i = 0; i < paesi.size(); i++) {

				String p = paesi.elementAt(i);

				if (p.equals("AU") || p.equals("NZ")) {

					Vector<String> subPaesi = new Vector<String>();

					for (int h = 0; h < i; h++) {
						String subP = paesi.elementAt(h);
						subPaesi.add(subP);
					}

					if (!subPaesi.contains(p)) {

						chiamateEv.add(ChiamataEventi.chiamata(p));
//					System.out.println("Cristo");
					} else
						chiamateEv.add(chiamateEv.elementAt(subPaesi.indexOf(p)));

				} else {
					key = "Errore";
					value = "Lo stato " + p + " non è disponibile";
					throw new EventiException();
				}

			}

			Vector<Eventi> eventiFiltratiPerStati = new Vector<Eventi>();

			for (int i = 0; i < chiamateEv.size(); i++) {

				Vector<Eventi> evTemp = chiamateEv.elementAt(i);
				eventiFiltratiPerStati.addAll(StatiFilter.filterByState(stati.elementAt(i), evTemp));

			}

			if(eventiFiltratiPerStati.isEmpty()) {
				key = "Attenzione";
				value = "Non ci sono eventi disponibili";
				throw new EventiException();
			}
			
			Vector<Eventi> eventiFiltratiPerGeneri = new Vector<Eventi>();
			
			for (int i = 0; i < generi.size(); i++) {

				String g = generi.elementAt(i);
				eventiFiltratiPerGeneri.addAll(GeneriFilter.filterByGenre(g, eventiFiltratiPerStati));

			}

			
			responso.put("eventi", eventiFiltratiPerGeneri);

			/**
			 * oggetto per il calcolo eventi per ciascun mese
			 *
			 */
			DatesStatistics sc = new DatesStatistics();
			int[] numberArray = sc.numeroEventi(eventiFiltratiPerStati);

			/**
			 * oggetto per l'ordinamento del numero eventi in ciascun mese
			 *
			 */
			MinMaxAverage minMaxAverage = new MinMaxAverage();
			minMaxAverage.sortSelectedEvents(numberArray);

			/**
			 * attributo che indica il valore minimo richiesto dalla statistica
			 *
			 */
			int numMinEventiMese = minMaxAverage.minimoNumeroEventiMese(numberArray);
			// System.out.println(numMinEventiMese);

			/**
			 * attributo che indica il valore massimo richiesto dalla statistica
			 *
			 */
			int numMaxEventiMese = minMaxAverage.massimoNumeroEventiMese(numberArray);
			// System.out.println(numMaxEventiMese);

			/**
			 * attributo che indica la media dei valori richiesto dalla statistica
			 *
			 */
			double mediaEventiMese = minMaxAverage.mediaNumeroEventiMese(numberArray);
			// System.out.println(mediaEventiMese);

		} catch (EventiException e) {
			responso = e.generaJSON(key, value);
		}
		return responso;
	}
}