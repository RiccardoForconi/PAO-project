package it.univpm.progettoSpringBootApp.controller;

import org.json.simple.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import it.univpm.progettoSpringBootApp.service.*;


/**
 * Questa classe gestisce le richieste REST
 */
@RestController
public class Controller {
	@Autowired
	/**
     * Contiene l'oggetto Servizio che ci aiuta nel finalizzare
     * le operazioni richieste
     */
	Servizio servizio;
	
	/**
     * Percorso che restituisce i dati relativi a tutte le farmacie
     * @return JSONArray che contiene tutte le farmacie con le relative
     * informazioni
     */
	@GetMapping("/dati")
	public JSONArray getDati() {
		return servizio.getFarmacie();
	}
	
	/**
     * Percorso che restituisce i dati relativi a tutte le farmacie
     * che sono state filtrate attraverso un filtro conditional.
     * @return void
     */
	@RequestMapping(value = "/datiCond", method = RequestMethod.DELETE)
	public void deleteFarmacia(@RequestBody JSONObject filter)
	{
		servizio.deleteFarmaciaConditional(filter);
	}
	
	/**
     * Percorso che restituisce i dati relativi a tutte le farmacie
     * che sono state filtrate attraverso un filtro logical.
     * @return void
     */
	@RequestMapping(value = "/datiLog", method = RequestMethod.DELETE)
	public void deleteFarmacia1(@RequestBody JSONObject filter)
	{
		servizio.deleteFarmaciaLogical(filter);
	}
	
	/**
     * Percorso che restituisce i metadati relativi a ogni farmacia
     * @return JSONArray contenente i dati spiegati
     */
	@GetMapping("/metadati")
	public JSONArray getMetadati() {
		return servizio.getMetadata();
	}
	
	/**
     * Percorso che restituisce le statistiche relative a un campo
     * scelto delle farmacie
     * @return JSONObject contenente le statistiche in formato JSON
     */
	@GetMapping("/stats")
	public JSONObject getStatsSimple(@RequestParam(name="campo")String campo) {
		return servizio.getStats(campo);
	}
	
	/**
     * Percorso che restituisce le statistiche relative a un campo
     * scelto delle farmacie filtrate attraverso il filtro conditional
     * @return JSONObject contenente le statistiche in formato JSON
     */
	@RequestMapping(value = "/statsFiltered", method = RequestMethod.GET)
	public JSONObject getStats(@RequestBody JSONObject filter) {
		return servizio.getStats(filter);
	}
	
	/**
     * Percorso che restituisce i dati relativi a tutte le farmacie
     * filtrate attraverso un filtro conditional
     * @return JSONArray che contiene tutte le farmacie filtrate
     */
	@RequestMapping(value = "/dati", method = RequestMethod.POST)
	public JSONArray getFarmacieCond(@RequestBody JSONObject filter) {
		return servizio.getFarmacieConditional(filter);
	}
	
	/**
     * Percorso che restituisce i dati relativi a tutte le farmacie
     * filtrate attraverso un filtro logical
     * @return JSONArray che contiene tutte le farmacie filtrate
     */
	@RequestMapping(value = "/dati1", method = RequestMethod.POST)
	public JSONArray getFarmacieLog(@RequestBody JSONObject filter) {
		return servizio.getFarmacieLogical(filter);
	}
}
