package it.univpm.progettoSpringBootApp.controller;

import org.json.simple.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.progettoSpringBootApp.model.Helloworld;
import it.univpm.progettoSpringBootApp.service.ServiceImpl;
import it.univpm.progettoSpringBootApp.service.Servizio;





@RestController
public class Controller {
	@Autowired
	Servizio servizio;
	
	@GetMapping("/hello")
	public Helloworld metodo1(@RequestParam (name="param1", defaultValue="world") String param1) {
		return  new Helloworld ("Marco", param1);
	}

	@GetMapping("/dati")
	public JSONArray metodo2() {
		return servizio.getFarmacie();
	}
	
	
}
