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
	 * Metodo che consente di determinare il numero totale di
	 * eventi relativi ad uno specifico stato che si svolgono in uno specifico mese
	 * 
	 * @param listaEventi listaEventi Vettore di oggetti della classe Eventi necessario contenente
	 * gli eventi dello stato considerato
	 * @param datePeriodo Vettore di stringhe contenente data iniziale e data finale
	 * per il calcolo del periodo personalizzato
	 * @return numeroEventi array contenente, in ogni posizione, il numero degli eventi contenuti
	 * in ogni ripetizione del periodo inserito; ad esempio:
	 * se il periodo e' di 50 giorni, allora l'elemento in posizione 0 dell'array numeroEventi e' il
	 * numero degli eventi nei primi 50 giorni, l'elemento  in posizione 1 dell'array numeroEventi 
	 * e' il numero degli eventi nei secondi 50 giorni dalla data iniziale inserita, ecc..
	 * @see it.univpm.progetto.studenti.ticketmaster.model.Eventi
	 * @see it.univpm.progetto.studenti.ticketmaster.filters.MinMaxAverageFilter#dateConverter(String)
	 * @see it.univpm.progetto.studenti.ticketmaster.filters.MinMaxAverageFilter#maxRipetizioneDelPeriodo(long, LocalDate, LocalDate)
	 * 
	 */
	public int[] minMaxAverageFilterFunction(Vector<Eventi> listaEventi, Vector<String> datePeriodo) {

		int[] numeroEventi = null;
		
		LocalDate dataIniziale = dateConverter(datePeriodo.elementAt(0));
		
		LocalDate dataFinale = dateConverter(datePeriodo.elementAt(1));

		long periodo = ChronoUnit.DAYS.between(dataIniziale, dataFinale);

		Eventi eventoScelto = new Eventi();
		
		int[] maxRipPeriodo= new int[1];
		maxRipPeriodo= maxRipetizioneDelPeriodo(periodo, dataFinale, dataIniziale);
		
		long[] periodiAdder = new long[1];
		periodiAdder[0] = 0;

		numeroEventi = new int[maxRipPeriodo[0]];
			
		for (int j = 0; j < maxRipPeriodo[0]; j++) {

			LocalDate dataAggiornataIniz = dataIniziale.plusDays(periodiAdder[0]);
			LocalDate dataAggiornataFin = dataFinale.plusDays(periodiAdder[0]);

			for (int i = 0; i < listaEventi.size(); i++) {

				eventoScelto = listaEventi.get(i);
				LocalDate dataEvento = eventoScelto.getData();
					
//				if ((dataEvento.isAfter(dataAggiornataIniz)) && (dataEvento.isBefore(dataAggiornataFin))) {
				if ( ( (dataEvento.isAfter(dataAggiornataIniz)) ||  (dataEvento.equals(dataAggiornataIniz)) ) && ( (dataEvento.isBefore(dataAggiornataFin)) || (dataEvento.equals(dataAggiornataFin))) ) {
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
	
	/**
	 * Metodo che calcola il numero massimo di ripetizioni possibili del periodo personalizzato
	 * inserito dall'utente
	 * 
	 * @param periodoLength attributo che indica il periodo di tempo personalizzato in giorni
	 * @param dataFinale oggetto/attributo della classe LocalDate che indica la data finale
	 * del periodo personalizzato
	 * @param dataIniziale oggetto/attributo della classe LocalDate che indica la data iniziale
	 * del periodo personalizzato
	 * @return massimaRipetizionePossibileDelPeriodo array di interi di dimesione 1 che indica il numero di 
	 * volte che il periodo scelto può essere ripetuto, a partire dalla data di inizio personalizzata, fino 
	 * alla fine dell'anno corrente; ad esempio: 
	 * se il periodo è di 50 giorni e la data iniziale è 2021 10 15, allora massimaRipetizionePossibileDelPeriodo
	 * equivale a 2, poiche' (2021 10 15)+50= 2021 12 4 e, ancora, (2021 12 4)+50= 2022 01 23
	 * poiche' siamo entrati nel nuovo anno, non possiamo più sommare il periodo di 50 giorni, dunque 
	 * massimaRipetizionePossibileDelPeriodo = 2
	 */	
	public int[] maxRipetizioneDelPeriodo(long periodoLength, LocalDate dataFinale, LocalDate dataIniziale) {
		
		int[] massimaRipetizionePossibileDelPeriodo = new int[1];
		massimaRipetizionePossibileDelPeriodo[0] = 1;
		
		int annoLimite = dataFinale.getYear();;
		
		long[] periodiAdder = new long[1];
		periodiAdder[0] = 0;
		
		periodiAdder[0] += periodoLength;
			
		for(long k = 0; k<365 ;k++) {
			if (periodiAdder[0] < 364) {	
				LocalDate dataAggiornata = dataIniziale.plusDays(periodiAdder[0]);
				LocalDate dataLimite = LocalDate.of(annoLimite, Month.DECEMBER, 31);

					if (dataAggiornata.isBefore(dataLimite)) {
						massimaRipetizionePossibileDelPeriodo[0] += 1;
					} else
						massimaRipetizionePossibileDelPeriodo[0] += 0;
					
			}
			periodiAdder[0] += periodoLength;
			k = periodiAdder[0];
		}
		
		return massimaRipetizionePossibileDelPeriodo;
	}
}
