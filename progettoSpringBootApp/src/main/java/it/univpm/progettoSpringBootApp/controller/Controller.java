package it.univpm.progettoSpringBootApp.controller;

import org.json.simple.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import it.univpm.progettoSpringBootApp.service.*;




@RestController
public class Controller {
	@Autowired
	Servizio servizio;
	

	@GetMapping("/dati")
	public JSONArray metodo1() {
		return servizio.getFarmacie();
	}

	@RequestMapping(value = "/dati", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteFarmacia(@RequestBody JSONObject filter)
	{
		boolean trov;
		trov = servizio.deleteFarmacia(filter);
		if(trov == false)
			return new ResponseEntity<>("Il prodotto non è stato eliminato", HttpStatus.BAD_REQUEST);
		else
			return new ResponseEntity<>("Il prodotto è stato eliminato", HttpStatus.OK);
	}
	
	@GetMapping("/metadati")
	public JSONArray metodo2() {
		return servizio.getMetadata();
	}
	
	@GetMapping("/stats")
	public JSONObject metodo3(@RequestBody JSONObject filter) {
		return servizio.getStats(filter);
	}
	
	@RequestMapping(value = "/dati", method = RequestMethod.POST)
	public JSONArray metodo4(@RequestBody JSONObject filter) {
		return servizio.getFarmacieConditional(filter);
	}
	
	@RequestMapping(value = "/dati1", method = RequestMethod.POST)
	public JSONArray metodo5(@RequestBody JSONObject filter) {
		return servizio.getFarmacieLogical(filter);
	}
}
