package it.univpm.progettoSpringBootApp.model;

public class sourcefield {
	/**
     * vettore di stringhe contenente i nominativi delle variabili
     * all'interno del dataset
     */
	public String[] sourceFields = new String[17];
	
	/**
     * Costruttore che costruisce un oggetto sourcefield standard
     */
	public sourcefield() {
		this.sourceFields[0]="CODICE TIPOLOGIA";
		this.sourceFields[1]="INDIRIZZO";
		this.sourceFields[2]="CODICE COMUNE ISTAT";
		this.sourceFields[3]="DESCRIZIONE PROVINCIA";
		this.sourceFields[4]="FRAZIONE";
		this.sourceFields[5]="DESCRIZIONE COMUNE";
		this.sourceFields[6]="CODICE PROVINCIA ISTAT";
		this.sourceFields[7]="DESCRIZIONE FARMACIA";
		this.sourceFields[8]="DESCRIZIONE TIPOLOGIA";
		this.sourceFields[9]="CAP";
		this.sourceFields[10]="CODICE IDENTIFICATIVO FARMACIA";
		this.sourceFields[11]="PARTITA IVA";
		this.sourceFields[12]="LATITUDINE";
		this.sourceFields[13]="COD FARMACIA ASSEGNATO DA ASL";
		this.sourceFields[14]="DATA FINE VALIDITA";
		this.sourceFields[15]="SIGLA PROVINCIA";
		this.sourceFields[16]="LONGITUDINE";
		
	}

}
