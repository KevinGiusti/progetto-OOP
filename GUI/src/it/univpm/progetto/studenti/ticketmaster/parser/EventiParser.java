package it.univpm.progetto.studenti.ticketmaster.parser;

import java.util.Set;
import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EventiParser {
	
	private Vector<String> stati = new Vector<String>();
	private Vector<Long> numEventi = new Vector<Long>();
	private Vector<String> generi = new Vector<String>();
	private Vector<Long> numGeneri = new Vector<Long>();
	private Vector<Long> minimi = new Vector<Long>();
	private Vector<Long> massimi = new Vector<Long>();
	private Vector<Double> medie = new Vector<Double>();
	private Vector<String> nomi = new Vector<String>();
	private Vector<String> urls = new Vector<String>();
	private Vector<String> citta = new Vector<String>();
	private Vector<String> statiEv = new Vector<String>();
	private Vector<String> paesi = new Vector<String>();
	private Vector<String> date = new Vector<String>();
	private Vector<String> ore = new Vector<String>();
	private Vector<String> generiEv = new Vector<String>();
	private Vector<String> sottoGeneri = new Vector<String>();
	
	public void parse(String chiamata) {
		
		try {
			
			JSONParser parser = new JSONParser();
			
			JSONObject jO = (JSONObject) parser.parse(chiamata);
			
			JSONObject numTotEv = (JSONObject) jO.get("numero totale eventi");
			
				@SuppressWarnings("unchecked")
				Set<String> keysNumEv = numTotEv.keySet();
				for(String s : keysNumEv) {
					stati.add(s);
					numEventi.add((Long) numTotEv.get(s));
				}
				
			JSONObject numEvPerGen = (JSONObject) jO.get("numero eventi per il genere");
			
				@SuppressWarnings("unchecked")
				Set<String> keysNumGen = numEvPerGen.keySet();
				for(String g : keysNumGen) {
					generi.add(g);
					numGeneri.add((Long) numEvPerGen.get(g));
				}
			
			JSONObject statPerEv = (JSONObject) jO.get("statistiche periodiche di eventi");
			
			for (int i = 0; i < stati.size(); i++) {
				
					JSONObject statTemp = (JSONObject) statPerEv.get(stati.elementAt(i));
					minimi.add((Long) statTemp.get("minimo"));
					massimi.add((Long) statTemp.get("massimo"));
					medie.add((Double) statTemp.get("media"));
				
			}
			
			JSONArray eV = (JSONArray) jO.get("eventi");
			
			for (int i = 0; i < eV.size(); i++) {
				
				JSONObject eVTemp = (JSONObject) eV.get(i);
				nomi.add((String) eVTemp.get("nome"));
				urls.add((String) eVTemp.get("url"));
				citta.add((String) eVTemp.get("citta"));
				statiEv.add((String) eVTemp.get("stato"));
				paesi.add((String) eVTemp.get("paese"));
				date.add((String) eVTemp.get("data"));
				ore.add((String) eVTemp.get("ora"));
				generiEv.add((String) eVTemp.get("genere"));
				sottoGeneri.add((String) eVTemp.get("sottoGenere"));
				
			}
		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}

	public String toString(String chiamata) {
		
		parse(chiamata);
		
		String finale = "";
		
		String numTotEv = "Numero totale di eventi:\n";
		
		for(int i = 0; i < stati.size(); i++) {
			numTotEv += "\n   -" + stati.elementAt(i) + ": " + numEventi.elementAt(i);
		}
		
		String numTotGen = "\nNumero eventi per il genere:\n";
		
		for(int i = 0; i < generi.size(); i++) {
			numTotGen += "\n   -" + generi.elementAt(i) + ": " + numGeneri.elementAt(i);
		}
		
		String stats = "\nStatistiche periodiche per gli eventi:\n";
		
		for(int i = 0; i < stati.size(); i++) {
			stats += "\n   -" + stati.elementAt(i) +
					 ":\n      •" + "Minimo: " + minimi.elementAt(i) +
					 "\n      •" + "Massimo: " + massimi.elementAt(i) +
					 "\n      •" + "Media: " + medie.elementAt(i);
		}
		
		String eventi = "\nEventi:\n";
				
		for(int i = 0; i < nomi.size(); i++) {
			eventi += "\n   -" + (i + 1) + "° Evento:\n" +
					  "\n      •" + "Nome: " + nomi.elementAt(i) +
					  "\n      •" + "URL: " + urls.elementAt(i) +
					  "\n      •" + "Citta': " + citta.elementAt(i) +
					  "\n      •" + "Stato: " + statiEv.elementAt(i) +
					  "\n      •" + "Paese: " + paesi.elementAt(i) +
					  "\n      •" + "Data: " + date.elementAt(i) +
					  "\n      •" + "Ora: " + ore.elementAt(i) +
					  "\n      •" + "Genere: " + generiEv.elementAt(i) +
					  "\n      •" + "Sotto genere: " + sottoGeneri.elementAt(i) + "\n";
		}
		
		finale += numTotEv + "\n\n" + numTotGen + "\n\n" + stats + "\n\n" + eventi;
		
		return finale;
		
	}
	
}