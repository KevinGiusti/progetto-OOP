package it.univpm.progetto.studenti.ticketmaster.filters;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Vector;
import it.univpm.progetto.studenti.ticketmaster.model.Eventi;

public class MinMaxAverageFilter {

	/**
	 * 
	 * Classe che consente di determinare il numero totale di eventi svolti in uno
	 * stato relativamente ad uno specifico periodo di tempo inserito dall'user
	 *
	 * @author KevinGiusti
	 *
	 */
	public int[] minMaxAverageFilterFunction(Vector<Eventi> listaEventi, Vector<String> datePeriodo) {

		int[] numeroEventi = null;
		
//		System.out.println("dim datePeriodo "+datePeriodo.size());
//		System.out.println("size listaEventi: "+listaEventi.size());
			LocalDate dataIniziale = dateConverter(datePeriodo.elementAt(0));
			LocalDate dataFinale = dateConverter(datePeriodo.elementAt(1));
			int annoLimite = 0;

			long periodo = ChronoUnit.DAYS.between(dataIniziale, dataFinale);
//		System.out.println("days: "+periodo);
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
				// 728 poichè 365*2
				if (periodiAdder[0] < 728) {
					LocalDate dataAggiornata = dataIniziale.plusDays(periodiAdder[0]);
					LocalDate dataLimite = LocalDate.of(annoLimite, Month.DECEMBER, 31);

					if (dataAggiornata.isBefore(dataLimite)) {
						massimaRipetizionePossibileDelPeriodo[0] += 1;
					} else
						massimaRipetizionePossibileDelPeriodo[0] += 0;
				}
			}

//		System.out.println("NUMERO PERIODI: "+massimaRipetizionePossibileDelPeriodo[0]);

			periodiAdder[0] = 0;

			numeroEventi = new int[massimaRipetizionePossibileDelPeriodo[0]];
			for (int j = 0; j < massimaRipetizionePossibileDelPeriodo[0]; j++) {

//			System.out.println("periodiAdder "+periodiAdder[0]);
				LocalDate dataAggiornataIniz = dataIniziale.plusDays(periodiAdder[0]);
//			System.out.println("data aggggg "+ dataAggiornataIniz);
				LocalDate dataAggiornataFin = dataFinale.plusDays(periodiAdder[0]);

				for (int i = 0; i < listaEventi.size(); i++) {

					eventoScelto = listaEventi.get(i);
					LocalDate dataEvento = eventoScelto.getData();
//				System.out.println("data aggggg prima del controllo "+ dataAggiornataIniz);
//				System.out.println("data aggggg prima del controllo "+ dataAggiornataFin);
					if ((dataEvento.isAfter(dataAggiornataIniz)) && (dataEvento.isBefore(dataAggiornataFin))) {
						numeroEventi[j] += 1;
					} else {
						numeroEventi[j] += 0;
					}
				}

				periodiAdder[0] += periodo;

			}
			
//		for(int i= 0; i<numeroEventi.length; i++) {
//			System.out.println("alolala "+numeroEventi[i]);
//		}

		return numeroEventi;
	}

	public LocalDate dateConverter(String date) {

		LocalDate locD = LocalDate.parse((CharSequence) date);
		return locD;
	}
}
