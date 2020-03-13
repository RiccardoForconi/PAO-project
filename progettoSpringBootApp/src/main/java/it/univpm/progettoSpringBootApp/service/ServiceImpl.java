package it.univpm.progettoSpringBootApp.service;
import java.util.ArrayList;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import it.univpm.progettoSpringBootApp.utilities.*;
import it.univpm.progettoSpringBootApp.model.*;


@Service
public class ServiceImpl implements Servizio{
	//numero di farmacie nel file = 1736
	private static ArrayList<Farmacia> datas =new ArrayList<Farmacia>(1736);

	public ServiceImpl() {
		try {
		     Connection connect = new Connection();
		     connect.startConnection();
		     Parsing parser=new Parsing(connect.getData());
		     parser.createJSON();
		     CreaStruct struct = new CreaStruct();
	   	     struct.read();
	   	     datas = struct.getDati();
/* 
		     CreaStruct dati=new CreaStruct();
		     dati.read();
*/
		}catch(Exception e) {
			System.out.println("Si è verificato un errore");
		}
	}

	public JSONArray getFarmacie(){
		//classe per trasformazione string -> JSONObject
		System.out.println("sono qui 5");
		Gson g = new Gson();
		String str = new String();
		JSONArray arr = new JSONArray();
		JSONParser parser = new JSONParser();
		JSONObject obj = new JSONObject();
		for(Farmacia farm:datas)
		{
			//Farmacia to String
			str = g.toJson(farm);
			//creo JSONObject
			try {
					obj = (JSONObject) parser.parse(str);
			}
			catch(ParseException e)
			{}
			//aggiungo oggetto a JSONArray
			arr.add(obj);
		}
		//ritorniamo JSONArray
		return arr;
		
	}
/*
	public JSONArray getMetadata(){
		
	}
	
	//all'interno di find è presente una farmacia
	public JSONArray getFarmacie(String find){
		
	}
	
	public void deleteFarmacia(Integer id) {
		
	}
*/
}	
	


