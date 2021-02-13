package it.univpm.progetto.studenti.ticketmaster.stats;

import java.util.Vector;

import it.univpm.progetto.studenti.ticketmaster.model.Eventi;

public class NumTotEventi {
	
	
	public static Vector<Integer> statsNumTotEventi (Vector<Eventi> ev, Vector<String> stati) {
		
		//Vector<Eventi> eventiFiltratiPerStati = new Vector<Eventi>();
		//Vector<String> stati = new Vector<String>();
		int accumulatore = 0;
		Vector<Integer> totalePerOgniStato= new Vector<Integer>();
		
		/*for (int i= 0; i< eventiFiltratiPerStati.size(); i++) {
			accumulatore= eventiFiltratiPerStati.elementAt(i).size();
			totalePerOgniStato.add(i, accumulatore);
			
		}*/
		for(int i=0; i<stati.size(); i++) {
			for(int j=0;j<ev.size(); j++) {
				
				//totalePerOgniStato
			}
		}
		
		for(int i=0; i<totalePerOgniStato.size(); i++) {
			System.out.println(totalePerOgniStato.elementAt(i));
		}
		
		return totalePerOgniStato;
	}
}
