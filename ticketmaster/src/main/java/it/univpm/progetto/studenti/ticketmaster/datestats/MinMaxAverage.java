package it.univpm.progetto.studenti.ticketmaster.datestats;

public class MinMaxAverage {
	
	public int[] sortSelectedEvents(int[] numEventi) {
		
		int n = numEventi.length;  
        int temp= 0;  
         for(int i= 0; i<n; i++){  
        	 for(int j=1; j < (n-i); j++){  
        		 if(numEventi[j-1] > numEventi[j]){  
        			 //scambia elementi
                     temp = numEventi[j-1];  
                     numEventi[j-1] = numEventi[j];  
                     numEventi[j] = temp;  
                 }  
             }  
         }
         
         /*for(int i=0; i<numEventi.length; i++) {
        	 System.out.println(numEventi[i]+" ");
        	 }*/
         
         return numEventi;
	}
	
	public int minimoNumeroEventiMese(int[] numEventi) {
		
		int minimo= 0;
		minimo= numEventi[0];
		return minimo;
	}
	
	public int massimoNumeroEventiMese(int[] numEventi) {
		
		int massimo= 0;
		int maxLength= numEventi.length-1;
		massimo= numEventi[maxLength];
		return massimo;
	}
	
	public double mediaNumeroEventiMese(int[] numEventi) {
		
		double media= 0;
		int[] accumulatore= new int[1];
		for(int i= 0; i<numEventi.length; i++) {
			
			accumulatore[0]+= numEventi[i];
		}
		int lunghezzaArray= numEventi.length;
		media= (double)accumulatore[0]/(double)lunghezzaArray;
		return media;
	}
}