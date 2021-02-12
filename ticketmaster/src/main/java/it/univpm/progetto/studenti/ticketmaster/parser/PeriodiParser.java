package it.univpm.progetto.studenti.ticketmaster.parser;

import java.time.LocalDate;
import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import it.univpm.progetto.studenti.ticketmaster.model.Eventi;

public class PeriodiParser {

	/**
	 * 
	 * Array di date nel quale vengono inserite le date create
	 * a partire dalla Rotta /eventi JSON e poi viene restituito alla classe ChiamataPeriodi
	 *
	 */
	//private LocalDate[] periodi= new LocalDate[2];
	private Vector<Eventi> periodi;
	
	/**
	 * 
	 * Metodo che analizza il json della chiamata events e restituisce un vettore di eventi
	 * 
	 * @param chiamata Fornisce il codice json che viene analizzato dal metodo
	 * @return periodi Array di date contenente le date ottenut
	 */
	public Vector<Eventi> parse(String chiamata) {
		
		periodi= new Vector<Eventi>();
		try {
			
		
			JSONParser parser = new JSONParser();
			JSONObject jO = (JSONObject) parser.parse(chiamata);
			JSONArray periodoPersonalizzato = (JSONArray) jO.get("periodoPersonalizzato");
			
			
				JSONObject eventoTemp1 = (JSONObject) periodoPersonalizzato.get(0);
				String data1= (String) eventoTemp1.get("data1");
				LocalDate dataConv1= dateConverter(data1);
				
				JSONObject eventoTemp2 = (JSONObject) periodoPersonalizzato.get(1);
				String data2= (String) eventoTemp2.get("data2");
				LocalDate dataConv2= dateConverter(data2);
				
				Eventi ev= new Eventi(dataConv1, dataConv2);
				periodi.add(ev);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return periodi;
	}
	
	/**
	 * 
	 * Metodo che converte una Stringa che contiene informazioni circa 
	 * la data dell'evento considerato in un oggetto di tipo LocalDate
	 * 
	 * @param date Stringa che contiene il valore "yyyy-mm-dd" dal Json
	 * @return locD oggetto della classe LocalDate
	 */
	public LocalDate dateConverter(String date) {
		
		LocalDate locD= LocalDate.parse(date);
		return locD;
	}
}
