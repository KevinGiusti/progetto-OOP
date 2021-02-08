package it.univpm.progetto.studenti.ticketmaster.controller;

import java.util.Vector;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.progetto.studenti.ticketmaster.api.ChiamataEventi;
import it.univpm.progetto.studenti.ticketmaster.model.Eventi;
import it.univpm.progetto.studenti.ticketmaster.model.EventiBody;

@RestController
public class EventiController {

	@SuppressWarnings("unchecked")
	@PostMapping("/eventi")
	public JSONObject eventi(@RequestBody EventiBody e) {
		JSONObject responso = new JSONObject();
		String stato = e.getStato();
		if (stato.equals("AU") || stato.equals("NZ")) {
			Vector<Eventi> eventi = ChiamataEventi.chiamata(e.getStato());
			responso.put("eventi", eventi);
		}
		else
			responso.put("Errore", "Lo stato inserito non è disponibile");
		
		return responso;
	}

}
