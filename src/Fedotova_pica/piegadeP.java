package Fedotova_pica;

public class piegadeP extends pasutijums{
	
	private String vards, adrese, telNr;
	
	public piegadeP(String picasNos, String dzerNos, boolean siers, String merce,
					double cena, String d, int nr, boolean piegad, String vards, String adrese, String telNr) {
		super(picasNos, dzerNos, siers, merce, cena, d, nr, piegad);
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
	
	public String getTelNr() {
		return telNr;
	}

	public void setTelNr(String telNr) {
		this.telNr = telNr;
	}
	
	public String izvadit() {
	    return "Nr.: "+getNr() + "  Laiks: "+metodes.Laiks() +
		     "\nPica: " +getPicasNos()+ " " + getD()+" cm"+
		     "\nPapild. siers: "+ (isSiers()? "ir" : "nav") +
		     "\nMērce: "+getMerce()+
		     "\nDzeriens: " +getDzerNos()+
		     "\nCena: "+getCena()+
	         "\nAdrese: "+getAdrese()+
	         "\nPasūtītājs: "+getVards()+
	         "\nTel.: "+getTelNr()+
	         "\nCena: "+getCena()+"\n";
	  }

}

