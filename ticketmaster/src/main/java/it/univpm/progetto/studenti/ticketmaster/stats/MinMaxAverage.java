package it.univpm.progetto.studenti.ticketmaster.stats;

import java.text.DecimalFormat;

/**
 * Classe che consente di svolgere la statistica relativa alla 
 * determinazione di massimo, minimo e media degli eventi in base
 * ai mesi in cui gli eventi stessi sono tenuti
 *
 * @author KevinGiusti
 */
public class MinMaxAverage {
	
	/**
	 * Variabile che contiene la statistica mensile, nella quale figura il minimo numero di eventi
	 */
	private int minimo;
	
	/**
	 * Variabile che contiene la statistica mensile, nella quale figura il massimo numero di eventi
	 */
	private int massimo;
	
	/**
	 * Variabile che contiene la statistica mensile, nella quale figura la media degli eventi
	 */
	private double media;
	
	/**
	 * Costruttore di default
	 */
	public MinMaxAverage() {}
	
	/**
	 * Metodo che consente di ordinare l'array contenente il numero di
	 * eventi di uno stato svoltisi in un determinato mese, disponendoli
	 * dal più piccolo al più grande
	 * 
	 * @param numEventi Array da ordinare in modo crescente che contiene, in ogni posizione, 
	 * il numero degli eventi svoltisi in uno stato relativi ad un determinato mese
	 * 
	 * @return numEventi Array ordinato
	 */
	public int[] sortSelectedEvents(int[] numEventi) {
		
		int n = numEventi.length; 
		
        int temp = 0;  
        
         for(int i = 0; i < n; i++){  
        	 
        	 for(int j = 1; j < (n - i); j++){  
        		 
        		 if(numEventi[j - 1] > numEventi[j]){ 
        			 
                     temp = numEventi[j - 1];  
                     numEventi[j - 1] = numEventi[j];  
                     numEventi[j] = temp;  
                 
        		 }  
             
        	 }  
        
         }
         
         return numEventi;
	
	}
	
	/**
	 * Metodo che consente di determinare il minimo numero di eventi
	 * svoltisi un un determinato mese in uno specifico stato
	 * 
	 * @param numEventi Array ordinato in modo crescente
	 */
	public void minimoNumeroEventiMese(int[] numEventi) {
		this.minimo = numEventi[0];
	}
	
	/**
	 * Metodo che consente di determinare il massimo numero di eventi
	 * svoltisi un un determinato mese in uno specifico stato
	 * 
	 * @param numEventi Array ordinato in modo crescente
	 */
	public void massimoNumeroEventiMese(int[] numEventi) {
		int maxLength = numEventi.length-1;
		this.massimo = numEventi[maxLength];
	}
	
	/**
	 * Metodo che consente di determinare la media del numero di eventi
	 * svoltisi un un determinato mese in uno specifico stato
	 * 
	 * @param numEventi Array ordinato in modo crescente
	 */
	public void mediaNumeroEventiMese(int[] numEventi) {
		
		int[] accumulatore = new int[1];
		
		for(int i = 0; i < numEventi.length; i++)
			accumulatore[0] += numEventi[i];
		
		int lunghezzaArray = numEventi.length;
		
		this.media = Double.parseDouble(new DecimalFormat("##.##").format((double)accumulatore[0] 
										/ (double)lunghezzaArray).replace(",", "."));
	
	}

	/**
	 * Getter dell'attributo minimo
	 * 
	 * @return minimo
	 */
	public int getMinimo() {
		return minimo;
	}

	/**
	 * Getter dell'attributo massimo
	 * 
	 * @return massimo
	 */
	public int getMassimo() {
		return massimo;
	}

	/**
	 * Getter dell'attributo media
	 * 
	 * @return media
	 */
	public double getMedia() {
		return media;
	}

}