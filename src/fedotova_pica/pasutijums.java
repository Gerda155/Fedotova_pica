package fedotova_pica;

public class pasutijums {
	private String picasNos, dzerNos;
	private boolean siers, pipari, aktivs;
	private double cena;
	private int d;
	
	public pasutijums(String picasNos, String dzerNos, boolean siers, boolean pipari, double cena, int d, boolean aktivs) {
		this.picasNos = picasNos;
		this.dzerNos = dzerNos;
		pipari = false;
		siers = false;
		this.cena = cena;
		this.d = d;
		this.aktivs = true;
	}
	
	public void setCena(int cena) {
		this.cena = cena;
	}
	
	public double getCena() {
		return cena;
	}

	public String getPicasNos() {
		return picasNos;
	}

	public void setPicasNos(String picasNos) {
		this.picasNos = picasNos;
	}

	public String getDzerNos() {
		return dzerNos;
	}

	public void setDzerNos(String dzerNos) {
		this.dzerNos = dzerNos;
	}

	public boolean isSiers() {
		return siers;
	}

	public void setSiers(boolean siers) {
		this.siers = siers;
	}

	public boolean isPipari() {
		return pipari;
	}

	public void setPipari(boolean pipari) {
		this.pipari = pipari;
	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}
	
	public boolean isAktivs() {
		return aktivs;
	}

	public void setAktivs(boolean aktivs) {
		this.aktivs = aktivs;
	}
	
	public String izvadit() {
	    return "Status: "+(isAktivs()? "aktīvs" : "pabeigts")+
	    	 "\nPica: " +getPicasNos() + 
	    	 "\nPicas d: "+getD()+
	    	 "\nPapild. siers: "+ (isSiers()? "ir" : "nav") + 
	         "\nPapild. pipari: "+ (isPipari()? "ir" : "nav")+
	         "\nDzeriens: " +getDzerNos()+"\n";
	  }

}
