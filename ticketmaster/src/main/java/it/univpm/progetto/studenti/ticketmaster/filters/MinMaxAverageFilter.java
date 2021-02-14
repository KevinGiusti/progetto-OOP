package it.univpm.progetto.studenti.ticketmaster.filters;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Vector;
import it.univpm.progetto.studenti.ticketmaster.model.Eventi;

/**
 * Classe che consente di determinare il numero totale di eventi svolti in uno
 * stato relativamente ad uno specifico periodo di tempo inserito dall'user
 *
 * @author KevinGiusti
 */
public class MinMaxAverageFilter {

	/**
	 * Metodo
	 * 
	 * @param listaEventi
	 * @param datePeriodo
	 * @return
	 */
	public int[] minMaxAverageFilterFunction(Vector<Eventi> listaEventi, Vector<String> datePeriodo) {

		int[] numeroEventi = null;
		
		LocalDate dataIniziale = dateConverter(datePeriodo.elementAt(0));
		
		LocalDate dataFinale = dateConverter(datePeriodo.elementAt(1));
		
		int annoLimite = 0;

		long periodo = ChronoUnit.DAYS.between(dataIniziale, dataFinale);
		long[] periodiAdder = new long[1];
		periodiAdder[0] = 0;

		Eventi eventoScelto = new Eventi();
		int[] massimaRipetizionePossibileDelPeriodo = new int[1];
		massimaRipetizionePossibileDelPeriodo[0] = 1;

		for (int i = 0; i < listaEventi.size(); i++) {

			eventoScelto = listaEventi.get(i);
			LocalDate dataEvento = eventoScelto.getData();
			annoLimite = dataEvento.getYear();

			periodiAdder[0] += periodo;
			
			if (periodiAdder[0] < 728) {
				
				LocalDate dataAggiornata = dataIniziale.plusDays(periodiAdder[0]);
				LocalDate dataLimite = LocalDate.of(annoLimite, Month.DECEMBER, 31);

					if (dataAggiornata.isBefore(dataLimite)) {
						massimaRipetizionePossibileDelPeriodo[0] += 1;
					} else
						massimaRipetizionePossibileDelPeriodo[0] += 0;
				
			}
			
		}

		periodiAdder[0] = 0;

		numeroEventi = new int[massimaRipetizionePossibileDelPeriodo[0]];
			
		for (int j = 0; j < massimaRipetizionePossibileDelPeriodo[0]; j++) {

			LocalDate dataAggiornataIniz = dataIniziale.plusDays(periodiAdder[0]);
			LocalDate dataAggiornataFin = dataFinale.plusDays(periodiAdder[0]);

			for (int i = 0; i < listaEventi.size(); i++) {

				eventoScelto = listaEventi.get(i);
				LocalDate dataEvento = eventoScelto.getData();
					
				if ((dataEvento.isAfter(dataAggiornataIniz)) && (dataEvento.isBefore(dataAggiornataFin))) {
						numeroEventi[j] += 1;
					} else {
						numeroEventi[j] += 0;
					}
				
			}

			periodiAdder[0] += periodo;

			
		}
			
		return numeroEventi;
	
	}

	/**
	 * Metodo che converte una Stringa che contiene informazioni circa 
	 * la data dell'evento considerato in un oggetto di tipo LocalDate
	 * 
	 * @param date Stringa che contiene il valore "yyyy-mm-dd" dal Json
	 * @return locD Oggetto della classe LocalDate
	 */
	public static LocalDate dateConverter(String date) {

		LocalDate locD = LocalDate.parse((CharSequence) date);
		
		return locD;
	
	}

}
