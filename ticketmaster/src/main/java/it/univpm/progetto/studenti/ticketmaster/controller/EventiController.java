package it.univpm.progetto.studenti.ticketmaster.controller;

import java.util.Vector;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.progetto.studenti.ticketmaster.api.ChiamataEventi;
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

	@SuppressWarnings("unchecked")
	@PostMapping("/eventi")
	public JSONObject eventi(@RequestBody EventiBody eB) {

		JSONObject responso = new JSONObject();
		Vector<String> statiPaesi = eB.getStati();
		Vector<String> stati = new Vector<String>();
		
		for (int i = 0; i < statiPaesi.size(); i++) {
			
			String s = statiPaesi.elementAt(i);
			stati.add(s.substring(0, s.indexOf(",")));
		
		}

		Vector<String> statiScanner = StatiScanner.getStati();
		
		for (int i = 0; i<stati.size(); i++) {
			
			String s = stati.elementAt(i);
			
			if (!statiScanner.contains(s)) {
				
				Vector<String> suggerimenti = new Vector<String>();
				
				for (String sugg : statiScanner) {
					
					if (sugg.charAt(0) == s.charAt(0))
						suggerimenti.add(sugg);
				
				}

				responso.put("Suggerimento", "Forse volevi inserire " + suggerimenti + " nell'elemento " + (i+1) + " del vettore stati");
				
				return responso;

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
				responso.put("Errore", "Lo stato " + p + " non è disponibile");
				return responso;
			}

		}

		Vector<Eventi> eventiFiltratiPerStati = new Vector<Eventi>();

		for (int i = 0; i < chiamateEv.size(); i++) {

			Vector<Eventi> evTemp = chiamateEv.elementAt(i);
			eventiFiltratiPerStati.addAll(StatiFilter.filterByState(stati.elementAt(i), evTemp));

		}

		responso.put("eventi", eventiFiltratiPerStati);

		return responso;

	}

}