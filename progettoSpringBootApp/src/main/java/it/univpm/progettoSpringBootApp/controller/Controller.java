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
	public JSONArray getDati() {
		return servizio.getFarmacie();
	}

	@RequestMapping(value = "/datiCond", method = RequestMethod.DELETE)
	public void deleteFarmacia(@RequestBody JSONObject filter)
	{
		servizio.deleteFarmaciaConditional(filter);
	}
	
	@RequestMapping(value = "/datiLog", method = RequestMethod.DELETE)
	public void deleteFarmacia1(@RequestBody JSONObject filter)
	{
		servizio.deleteFarmaciaLogical(filter);
	}
	
	@GetMapping("/metadati")
	public JSONArray getMetadati() {
		return servizio.getMetadata();
	}
	
	@GetMapping("/stats")
	public JSONObject getStatsSimple(@RequestParam(name="campo")String campo) {
		return servizio.getStats(campo);
	}
	
	@RequestMapping(value = "/statsFiltered", method = RequestMethod.GET)
	public JSONObject getStats(@RequestBody JSONObject filter) {
		return servizio.getStats(filter);
	}
	
	@RequestMapping(value = "/dati", method = RequestMethod.POST)
	public JSONArray getFarmacieCond(@RequestBody JSONObject filter) {
		return servizio.getFarmacieConditional(filter);
	}
	
	@RequestMapping(value = "/dati1", method = RequestMethod.POST)
	public JSONArray getFarmacieLog(@RequestBody JSONObject filter) {
		return servizio.getFarmacieLogical(filter);
	}
}
