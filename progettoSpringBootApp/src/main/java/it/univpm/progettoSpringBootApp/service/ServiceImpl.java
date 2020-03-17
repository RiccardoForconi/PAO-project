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
	
	public boolean deleteFarmacia(JSONObject filter) {
		boolean trov = false;
		Gson g = new Gson();
		String str = new String();
		ArrayList<String> listaChiavi = new ArrayList<String>(filter.keySet());
		String str1 = (String) filter.get(listaChiavi.get(0)); 
		JSONParser parser = new JSONParser();
		JSONObject farm1 = new JSONObject();
		for(Farmacia farm : datas)
		{
			str = g.toJson(farm);
			try {
					farm1 = (JSONObject) parser.parse(str);
			}
			catch(ParseException e)
			{}
			str = (String) farm1.get(listaChiavi.get(0));
			//implementando un vettore di metadati poi basterà scorrerlo
			if(str1.equals(str)) {
				trov = true;
				datas.remove(farm);
			}
		}
		return trov;
	}
	
	public JSONArray getMetadata(){
		Gson g = new Gson();
		String str = new String();
		JSONParser parser = new JSONParser();
		JSONObject farm1 = new JSONObject();
		JSONObject stampa1 = new JSONObject();
		sourcefield app1= new sourcefield();
		JSONArray array = new JSONArray();
		Farmacia farm2 = datas.get(1);
		str = g.toJson(farm2);
		try {
			farm1 = (JSONObject) parser.parse(str);
		}
		catch(ParseException e)
		{}
		ArrayList<String> listaChiavi = new ArrayList<String>(farm1.keySet());
		metadati[] stampa = new metadati[17];
	    for(int i=0 ;i<17;i++) {
	    	stampa[i] = new metadati(app1.sourceFields[i], "String", listaChiavi.get(i));
	    	str = g.toJson(stampa[i]);
			try {
					stampa1 = (JSONObject) parser.parse(str);
			}
			catch(ParseException e)
			{}
			array.add(stampa1);
	    }
	    return array;
	}
	
	public JSONObject getStats(JSONObject filter)  {
		ArrayList<String> listaChiavi = new ArrayList<String>(filter.keySet());
		String str = new String();
		Gson g = new Gson();
		JSONObject farm1 = new JSONObject();
		JSONParser parser = new JSONParser();
		double somma = 0,avg=0, max = 0, min = 0;
		boolean primo = false;
		for(Farmacia farm : datas)
		{
			str = g.toJson(farm);
			try {
					farm1 = (JSONObject) parser.parse(str);
			}
			catch(ParseException e)
			{}	
			str = (String) farm1.get(listaChiavi.get(0));
			double filtro = Double.parseDouble(str);
			somma+=filtro;
			if(primo == false)
			{
				primo = true;
				max = filtro;
				min = filtro;
			}
			else {
				if(filtro > max)
					max = filtro;
				if(filtro < min)
					min = filtro;
			}
		}
		avg = somma / datas.size();
		double somma1 =0;
		for(Farmacia farm : datas)
		{
			str = g.toJson(farm);
			try {
					farm1 = (JSONObject) parser.parse(str);
			}
			catch(ParseException e)
			{}	
			str = (String) farm1.get(listaChiavi.get(0));
			double filtro = Double.parseDouble(str);
			somma1+= Math.pow(filtro - avg, 2);
		}
		double devstd = Math.pow((somma1 / datas.size()), 1/2);
		String statistiche = "{\"media\":"+ "\"" + Double.toString(avg)+ "\"" + ", \"sum\":" + "\"" + Double.toString(somma)+ "\"" + ", \"min\":" + "\"" + Double.toString(min)+ "\"" + ", \"max\":" + "\"" + Double.toString(max)+ "\"" + ", \"Deviazione Standard\":" + "\"" + Double.toString(devstd)+ "\"" + "}";
		JSONParser parser1 = new JSONParser();
		JSONObject json= new JSONObject();
		try {
			 json = (JSONObject) parser1.parse(statistiche);
	        }
	    catch(ParseException e)
	    {}	
		System.out.println(json);
		return json;
	}
	
	public JSONArray getFarmacieConditional(JSONObject filter) {
		Gson g = new Gson();
		String str = new String();
		JSONArray arr = new JSONArray();
		JSONParser parser = new JSONParser();
		JSONObject farm1 = new JSONObject();
		Object str1 = new Object();
		ArrayList<String> listaChiavi = new ArrayList<String>(filter.keySet());
		System.out.println(listaChiavi);
		str1= filter.get(listaChiavi.get(0));
		String prova = g.toJson(str1);
		try {
				farm1 = (JSONObject) parser.parse(prova);
	    }
	    catch(ParseException e)
	    {}	
		ArrayList<String> filter1 = new ArrayList<String>(farm1.keySet());
		System.out.println(filter1);
		int numero = Integer.parseInt((String) farm1.get(filter1.get(0)));                                
		 if(filter1.get(0).equals("$gt")) {
			for(Farmacia farm:datas)
			{
				//Farmacia to String
				str = g.toJson(farm);
				//creo JSONObject
				try {
						farm1 = (JSONObject) parser.parse(str);
				}
				catch(ParseException e)
				{}
				
	 			str = (String) farm1.get(listaChiavi.get(0));
	     		int numero1 = Integer.parseInt(str);
				if(numero1 > numero) {
					arr.add(farm1);
				}
			}
		 }
		 if(filter1.get(0).equals("$lt")) {
				for(Farmacia farm:datas)
				{
					//Farmacia to String
					str = g.toJson(farm);
					//creo JSONObject
					try {
							farm1 = (JSONObject) parser.parse(str);
					}
					catch(ParseException e)
					{}
					
		 			str = (String) farm1.get(listaChiavi.get(0));
		     		double numero1 = Double.parseDouble(str);
					if(numero1 < numero) {
						arr.add(farm1);
					}
				}
			}
		return arr;	
	}
	
	public JSONArray getFarmacieLogical(JSONObject filter) {
		Gson g = new Gson();
		String str = new String();
		JSONArray arr = new JSONArray();
		JSONParser parser = new JSONParser();
		JSONArray farm1 = new JSONArray();
		JSONObject farm3 = new JSONObject();
		JSONObject farm2 = new JSONObject();
		Object str1 = new Object();
		ArrayList<String> listaChiavi = new ArrayList<String>(filter.keySet());
		System.out.println("listaChiavi:" + listaChiavi);
		str1= filter.get(listaChiavi.get(0));
		System.out.println("str1:" + str1);
		String prova = g.toJson(str1);
		System.out.println("prova:" + prova);
		try {
				farm1 = (JSONArray) parser.parse(prova);
		}
		catch(ParseException e)
		{}
		System.out.println("farm1:" + farm1);
		farm3 = (JSONObject) farm1.get(0);
		JSONObject farm4 = (JSONObject) farm1.get(1);
		System.out.println("farm3:" + farm3 + "\nfarm4:" + farm4);
		ArrayList<String> nomeParametro1 = new ArrayList<String>(farm3.keySet());
		ArrayList<String> nomeParametro2 = new ArrayList<String>(farm4.keySet());
		System.out.println("nomeParametro1:" + nomeParametro1 + "nomeParametro2:" + nomeParametro2);
		//ArrayList<String> nomeParametri = new ArrayList<String>(farm3.keySet());
		//System.out.println("nomeParametri:" + nomeParametri);
		//System.out.println("farm3:" + farm3.get(nomeParametro1.get(0)) + "\nfarm4:" + farm4.get(nomeParametro2.get(0)));
		String paramFarm3 = (String) farm3.get(nomeParametro1.get(0));
		String paramFarm4 = (String) farm4.get(nomeParametro2.get(0));
		if(listaChiavi.get(0).equals("$and"))
		{
			for(Farmacia farm:datas)
			{
					//Farmacia to String
					str = g.toJson(farm);
					//creo JSONObject
					try {
							farm2 = (JSONObject) parser.parse(str);
					}
					catch(ParseException e)
					{}
					if(paramFarm3.compareTo((String) farm2.get(nomeParametro1.get(0))) == 0 && 
							paramFarm4.compareTo((String) farm2.get(nomeParametro2.get(0))) == 0)
						arr.add(farm2);
			}
		}
		else if(listaChiavi.get(0).equals("$or")) {
			for(Farmacia farm:datas)
			{
					//Farmacia to String
					str = g.toJson(farm);
					//creo JSONObject
					try {
							farm2 = (JSONObject) parser.parse(str);
					}
					catch(ParseException e)
					{}
					if(paramFarm3.compareTo( (String) farm2.get(nomeParametro1.get(0))) == 0 || 
							paramFarm4.compareTo( (String) farm2.get(nomeParametro2.get(0))) == 0)
						arr.add(farm2);
			}
		}
		System.out.println("Stampo arr:" + arr);
		return arr;
		
	}	
}	


