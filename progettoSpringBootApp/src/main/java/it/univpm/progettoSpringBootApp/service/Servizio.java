package it.univpm.progettoSpringBootApp.service;

import org.json.simple.*;

/**
* interfaccia relativa ai servizi forniti dall'applicazione
*/
public interface Servizio{
	public abstract JSONArray getMetadata();
	public abstract JSONArray getFarmacie();
	public abstract void deleteFarmaciaSimple(String codiceFarmacia);
	public abstract void deleteFarmaciaConditional(JSONObject filter);
	public abstract void deleteFarmaciaLogical(JSONObject filter);
	public abstract JSONObject getStats(String filter);
	public abstract JSONObject getStats(JSONObject filter);
	public abstract JSONArray getFarmacieConditional(JSONObject filter);
	public abstract JSONArray getFarmacieLogical(JSONObject filter);
}
