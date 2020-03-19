package it.univpm.progettoSpringBootApp.model;

/**
     * Classe metadati che definisce i metadati relativi alle 
     * classi Farmacia
     */
public class metadati {
	/**
     * nome che rappresenta il nominativo all'interno del dataset
     */
	private String sourceField;
	/**
     * nome che rappresenta il nominativo della variabile nel programma
     */
	private String aliases;
	/**
     * nome che rappresenta il tipo della variabile
     */
	private String tipo;
	
	/**
     * Costruttore che prende i dati e li inserisce in un oggetto
     * metadati
     * @param s: stringa inserita in sourceField
     * @param t: stringa inserita in tipo
     * @param a: stringa inserita in aliases
     */
	public metadati(String s, String t, String a) {
		this.sourceField = s;
		this.tipo = t;
		this.aliases =a;
	}

}
