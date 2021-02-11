package it.univpm.progetto.studenti.ticketmaster.datestats;

import java.time.LocalDate;
import java.util.Vector;

import it.univpm.progetto.studenti.ticketmaster.model.Eventi;

public class DatesStatistics {

	public int[] numeroEventi(Vector<Eventi> listaEventi) {
		
		int[] monthsEvents= new int[12];
		
		for(int i= 0; i<listaEventi.size(); i++) {
			
			Eventi eventoProv= new Eventi();
			eventoProv= listaEventi.get(i);
			//System.out.println("numero tot eventi "+listaEventi.size());
			//System.out.println(eventoProv.getNome());
			LocalDate mese1= eventoProv.getData(); 
			//System.out.println(mese1);

			for(int j= 1; j<=12; j++) {
				LocalDate mese2= mese1.withMonth(j);
				//System.out.println(mese2);
				
				if(mese1.equals(mese2)) {
					//numeroEventiMese+=1;
					//System.out.println(numeroEventiMese);	
					//System.out.println("iterazione "+i);
					int pre_counter= j-1;
					//System.out.println("valore pre_counter "+pre_counter);
					monthsEvents[pre_counter]+=1;
				}
				else {
					//numeroEventiMese=0;
					int pre_counter= j-1;
					monthsEvents[pre_counter]+=0;
					//System.out.println(numeroEventiMese);
					//System.out.println("iterazione "+i);
				}
				
				int accumulatore= j+1;
				mese2.plusMonths(accumulatore);
				
			}
		}
		
		/*System.out.println("gen "+monthsEvents[0]);
		System.out.println("feb "+monthsEvents[1]);
		System.out.println("mar "+monthsEvents[2]);
		System.out.println("apr "+monthsEvents[3]);
		System.out.println("mag "+monthsEvents[4]);
		System.out.println("giu "+monthsEvents[5]);
		System.out.println("lug "+monthsEvents[6]);
		System.out.println("apr "+monthsEvents[7]);
		System.out.println("set "+monthsEvents[8]);
		System.out.println("ott "+monthsEvents[9]);
		System.out.println("nov "+monthsEvents[10]);
		System.out.println("dic "+monthsEvents[11]);*/
		
		return monthsEvents;

	}
	
}
