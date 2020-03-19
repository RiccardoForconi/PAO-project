package it.univpm.progettoSpringBootApp.utilities;

import java.io.*;
import java.net.*;

/**
* Implementazione della classe Connection che ci permette una 
* connessione all'URL relativo al dataset
*/
public class Connection {
		/**
		* parametro contenente l'indirizzo del dataset da scaricare
		*/
		private final String url = "https://www.dati.gov.it/api/3/action/package_show?id=024e7240-aa66-4c49-9c78-d8ad85836180";
		
		/**
		* parametro contenente tutto ciò che si trova all'interno del
		* dataset
		*/
		private String data;
		
		/**
		* Costruttore di default
		*/
		public Connection() {
			data="";
		}
		
		/**
		* parametro che passa il contenuto del dataset.
		*/
		public String getData() {
			
			return data; 
		}
		
		/**
		* Il metodo startConnection istaura una connessione e va a memorizzare il contenuto del dataset
		* nella stringa data
		*/
		public void startConnection() {
			
			try {
				URLConnection openConnection = new URL(url).openConnection();
				openConnection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
				InputStream in = openConnection.getInputStream();
				
				 String line = "";
				 try {
				   InputStreamReader inR = new InputStreamReader( in );
				   BufferedReader buf = new BufferedReader( inR );
				  
				   while ( ( line = buf.readLine() ) != null ) {
					   data+= line;
				   }
				 } finally {
				   in.close();
				 }
			} catch (MalformedURLException e) {
				// Implementare la gestione dell'eccezione
			    System.out.println("Errore nell'Url");
			    //startConnection();
			} catch (IOException e) {
				//Implemenatare...
				System.out.println("Errore in connection");
			}
		   }

}
