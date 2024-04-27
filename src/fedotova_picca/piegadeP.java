package fedotova_picca;

public class piegadeP extends pasutijums{
	
	private String vards, adrese;
	long telNr;
	
	public piegadeP(String picasNos, String dzerNos, boolean siers,boolean pipari,
					double cena, String d, int nr, String vards, String adrese, long telNr) {
		super(picasNos, dzerNos, siers, pipari, cena, d, nr);
		this.adrese = adrese;
		this.vards = vards;
		this.telNr = telNr;
	}

	public String getVards() {
		return vards;
	}

	public void setVards(String vards) {
		this.vards = vards;
	}
	
	public String getAdrese() {
		return adrese;
	}

	public void setAdrese(String adrese) {
		this.adrese = adrese;
	}
	
	public long getTelNr() {
		return telNr;
	}

	public void setTelNr(long telNr) {
		this.telNr = telNr;
	}
	
	public String izvadit() {
	    return "Nr.: "+getNr() + "  Laiks: "+metodes.Laiks() +
	    	 "\nPica: " +getPicasNos()+ " " + getD()+" cm"+
	    	 "\nPapild. siers: "+ (isSiers()? "ir" : "nav") +
	         "\nPapild. pipari: "+ (isPipari()? "ir" : "nav")+
	         "\nDzeriens: " +getDzerNos()+
	         "\nAdrese: "+getAdrese()+
	         "\nPasūtītājs: "+getVards()+
	         "\nTel.: "+getTelNr()+
	         "\nCena: "+getCena()+"\n";
	  }

}
