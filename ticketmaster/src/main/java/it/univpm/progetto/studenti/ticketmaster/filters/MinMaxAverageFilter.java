package it.univpm.progetto.studenti.ticketmaster.filters;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Vector;
import it.univpm.progetto.studenti.ticketmaster.model.Eventi;


public class MinMaxAverageFilter {
	
	/**
	 * 
	 * Classe che consente di determinare il numero totale di 
	 * eventi svolti in uno stato relativamente ad
	 * uno specifico periodo di tempo inserito dall'user
	 *
	 * @author KevinGiusti
	 *
	 */ 
	public void minMaxAverageFilterFunction(Vector<Eventi> listaEventi, Vector<String> datePeriodo) {
		
		LocalDate dataIniziale= dateConverter(datePeriodo.elementAt(0));
		LocalDate dataFinale= dateConverter(datePeriodo.elementAt(1));

		long periodo = ChronoUnit.DAYS.between(dataIniziale, dataFinale);
		System.out.println("days: "+periodo);
		
		int[] numeroEventi= new int[1];
		Eventi eventoScelto= new Eventi();
		System.out.println("size listaEventi: "+listaEventi.size());
		for(int i= 0; i<listaEventi.size(); i++) {
			
			eventoScelto= listaEventi.get(i);
			LocalDate dataEvento= eventoScelto.getData();
			if( (dataEvento.isAfter(dataIniziale)) && (dataEvento.isBefore(dataFinale))    ) {
				numeroEventi[0]+=1;
			}
			else
				numeroEventi[0]+=0;
			}
		
		
		System.out.println("numeroEventi "+numeroEventi[0]);
		}
		
		//return monthsEvents;
		
		
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
		
		//return monthsEvents;

	//}
	
	public LocalDate dateConverter(String date) {
		
		LocalDate locD= LocalDate.parse((CharSequence) date);
		return locD;
	
	}
}
		
			


