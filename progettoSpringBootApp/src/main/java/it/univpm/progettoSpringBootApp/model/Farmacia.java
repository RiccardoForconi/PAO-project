package it.univpm.progettoSpringBootApp.model;

public class Farmacia {
	//Attributi della classe
	
		/**
		 * parametro che rappresenta il codice identificativo
		 * della farmacia
		 */
		private String codId;
		/**
		 * parametro che rappresenta il codice assegnato dalla ASL
		 * alla farmacia
		 */
		private String codASL;
		/**
		 * parametro che l'indirizzo della farmacia
		 */
		private String indirizzo;
		/**
		 * parametro che rappresenta il nome della farmacia
		 */
		private String descrizione;
		/**
		 * parametro che rappresenta la partita IVA della 
		 * farmacia
		 */
		private String partitaIVA;
		/**
		 * parametro che rappresenta il cap della città dove
		 * si trova la farmacia
		 */
		private String cap;
		/**
		 * parametro che rappresenta il codice del comune secondo
		 * l'ISTAT
		 */
		private String codcomuneIstat;
		/**
		 * parametro che rappresenta il comune della farmacia
		 */
		private String descrizioneCom;
		/**
		 * parametro che rappresenta l'eventuale frazione della 
		 * farmacia
		 */
		private String frazione;
		/**
		 * parametro che rappresenta il codice della provincia
		 * secondo l'ISTAT
		 */
		private String codprovIstat;
		/**
		 * parametro che rappresenta la sigla della provincia
		 * dove si trova la farmacia
		 */
		private String siglaProvincia;
		/**
		 * parametro che rappresenta la provincia della farmacia
		 */
		private String descrizioneProv;
		/**
		 * parametro che rappresenta la data di fine validità 
		 * della farmacia
		 */
		private String datafineval;
		/**
		 * parametro che rappresenta la tipologia della farmacia
		 */
		private String descrizioneTipologia;
		/**
		 * parametro che rappresenta il codice relativo
		 * alla tipologia della farmacia
		 */
		private String codiceTipologia;
		/**
		 * parametro che rappresenta la latitudine della farmacia
		 */
		private String latitudine;
		/**
		 * parametro che rappresentala longitudine della farmacia
		 */
		private String longitudine;
		
		/**
		 * Costruttore di default
		 */
		public Farmacia() {
		}
			
		
		/**
		 * Costruttore che va costruire una farmacia passandogli 
		 * i parametri relativi ai propri campi
		 */
		public Farmacia(String codId, String codASL, String indirizzo, String descrizione, String partitaIVA, String cap,
				String codcomuneIstat, String descrizioneCom, String frazione, String codprovIstat, String siglaProvincia,
				String descrizioneProv, String datafineval, String descrizioneTipologia, String codiceTipologia,
				String latitudine, String longitudine) {
			
			this.codId = codId;
			this.codASL = codASL;
			this.indirizzo = indirizzo;
			this.descrizione = descrizione;
			this.partitaIVA = partitaIVA;
			this.cap = cap;
			this.codcomuneIstat = codcomuneIstat;
			this.descrizioneCom = descrizioneCom;
			this.frazione = frazione;
			this.codprovIstat = codprovIstat;
			this.siglaProvincia = siglaProvincia;
			this.descrizioneProv = descrizioneProv;
			this.datafineval = datafineval;
			this.descrizioneTipologia = descrizioneTipologia;
			this.codiceTipologia = codiceTipologia;
			this.latitudine = latitudine;
			this.longitudine = longitudine;
		}

	    

		/**
		 * Metodo toString che ritorna una stringa relativa alle 
		 * info della farmacia in esame
		 * @return stringa con informazioni
		 */
		 public String toString() {
			return   "Codice identificativo farmacia" + codId +"\n"  
					+"\nCodice ASL=" + codASL + "\nIndirizzo=" + indirizzo + "\nDescrizione Farmacia="
					+ descrizione + "\nPartita IVA=" + partitaIVA + "\nCAP=" + cap + "\nCodice comune Istat=" + codcomuneIstat
					+ "\nDescrizione comune=" + descrizioneCom + "\nFrazione=" + frazione + "\nCodice provincia Istat=" + codprovIstat
					+ "\nSigla Provincia=" + siglaProvincia + "\nDescrizione Provincia=" + descrizioneProv + "\nData fine validita'="
					+ datafineval + "\nDescrizione Tipologia=" + descrizioneTipologia + "\nCodice Tipologia="
					+ codiceTipologia + "\nLatitudine=" + latitudine + "\nLongitudine=" + longitudine; 
		 }   

		/**
		 * metodi set e get della farmacia
		 */
		public String getCodId() {
			return codId;
		}




		public void setCodId(String codId) {
			this.codId = codId;
		}




		public String getCodASL() {
			return codASL;
		}




		public void setCodASL(String codASL) {
			this.codASL = codASL;
		}




		public String getIndirizzo() {
			return indirizzo;
		}




		public void setIndirizzo(String indirizzo) {
			this.indirizzo = indirizzo;
		}




		public String getDescrizione() {
			return descrizione;
		}




		public void setDescrizione(String descrizione) {
			this.descrizione = descrizione;
		}




		public String getPartitaIVA() {
			return partitaIVA;
		}




		public void setPartitaIVA(String partitaIVA) {
			this.partitaIVA = partitaIVA;
		}




		public String getCap() {
			return cap;
		}




		public void setCap(String cap) {
			this.cap = cap;
		}




		public String getCodcomuneIstat() {
			return codcomuneIstat;
		}




		public void setCodcomuneIstat(String codcomuneIstat) {
			this.codcomuneIstat = codcomuneIstat;
		}




		public String getDescrizioneCom() {
			return descrizioneCom;
		}




		public void setDescrizioneCom(String descrizioneCom) {
			this.descrizioneCom = descrizioneCom;
		}




		public String getFrazione() {
			return frazione;
		}




		public void setFrazione(String frazione) {
			this.frazione = frazione;
		}




		public String getCodprovIstat() {
			return codprovIstat;
		}




		public void setCodprovIstat(String codprovIstat) {
			this.codprovIstat = codprovIstat;
		}




		public String getSiglaProvincia() {
			return siglaProvincia;
		}




		public void setSiglaProvincia(String siglaProvincia) {
			this.siglaProvincia = siglaProvincia;
		}




		public String getDescrizioneProv() {
			return descrizioneProv;
		}




		public void setDescrizioneProv(String descrizioneProv) {
			this.descrizioneProv = descrizioneProv;
		}




		public String getDatafineval() {
			return datafineval;
		}




		public void setDatafineval(String datafineval) {
			this.datafineval = datafineval;
		}




		public String getDescrizioneTipologia() {
			return descrizioneTipologia;
		}




		public void setDescrizioneTipologia(String descrizioneTipologia) {
			this.descrizioneTipologia = descrizioneTipologia;
		}




		public String getCodiceTipologia() {
			return codiceTipologia;
		}




		public void setCodiceTipologia(String codiceTipologia) {
			this.codiceTipologia = codiceTipologia;
		}




		public String getLatitudine() {
			return latitudine;
		}




		public void setLatitudine(String latitudine) {
			this.latitudine = latitudine;
		}




		public String getLongitudine() {
			return longitudine;
		}




		public void setLongitudine(String longitudine) {
			this.longitudine = longitudine;
		}
}
