package it.univpm.progetto.studenti.ticketmaster.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;

import it.univpm.progetto.studenti.ticketmaster.parser.EventiParser;
import it.univpm.progetto.studenti.ticketmaster.parser.StatiParser;

public class ChiamataEventi {

	public static /*String*/ void chiamata(Vector<String> stati, Vector<String> paesi, Vector<String> generi,
			Vector<String> periodo) {

		String parametriStati = "";
		String parametriPaesi = "";
		String parametriGeneri = "";
		String parametriPeriodo = "";

		for (int i = 0; i < stati.size(); i++) {
			String stato = stati.elementAt(i);
			if (i != stati.size() - 1)
				parametriStati += stato + ", ";
			else
				parametriStati += stato;
		}
		
		for (int i = 0; i < paesi.size(); i++) {
			String paese = paesi.elementAt(i);
			if (i != paesi.size() - 1)
				parametriPaesi += paese + ", ";
			else
				parametriPaesi += paese;
		}
		
		for (int i = 0; i < generi.size(); i++) {
			String genere = generi.elementAt(i);
			if (i != generi.size() - 1)
				parametriGeneri += genere + ", ";
			else
				parametriGeneri += genere;
		}
		
		System.out.println(parametriStati);
		System.out.println(parametriPaesi);
		System.out.println(parametriGeneri);
//		
//		for (int i = 0; i < stati.size(); i++) {
//			String stato = stati.elementAt(i);
//			if (!stato.equals(stati.lastElement()))
//				parametriStati += stati.elementAt(i) + ", ";
//			else
//				parametriStati += stati.elementAt(i);
//		}
//
//		String responso = new String();
//
//		try {
//
//			URL url = new URL("http://localhost:8080/eventi?");
//
//			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//
//			BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//
//			String json = input.readLine();
//
//			EventiParser eP = new EventiParser();
//
//			responso = eP.toString(json);
//
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		return responso;

	}

}
