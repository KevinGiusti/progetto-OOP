package it.univpm.progetto.studenti.ticketmaster.controller;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.progetto.studenti.ticketmaster.api.ChiamataEventi;
import it.univpm.progetto.studenti.ticketmaster.model.EventiBody;

@RestController
public class EventiController {

	@PostMapping("/eventi")
	public JSONObject eventi(@RequestBody EventiBody e) {
		return null;
	}
	
}
