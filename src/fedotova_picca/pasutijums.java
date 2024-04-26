package fedotova_picca;

public class pasutijums {
	private String picasNos, dzerNos, d;
	private boolean siers, pipari;
	private double cena;
	private int nr;

	public pasutijums(String picasNos, String dzerNos, boolean siers, boolean pipari, double cena, String d, int nr) {
		this.picasNos = picasNos;
		this.dzerNos = dzerNos;
		this.pipari = pipari;
		this.siers = siers;
		this.cena = cena;
		this.d = d;
		this.nr = nr;
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

	public String getD() {
		return d;
	}

	public void setD(String d) {
		this.d = d;
	}
	
	public void setNr(int nr) {
		this.nr = nr;
	}

	public double getNr() {
		return nr;
	}

	public String izvadit() {
	    return "Nr.: "+getNr()+
	    	 "\nPica: " +getPicasNos() +
	    	 "\nPicas d: "+getD()+
	    	 "\nPapild. siers: "+ (isSiers()? "ir" : "nav") +
	         "\nPapild. pipari: "+ (isPipari()? "ir" : "nav")+
	         "\nDzeriens: " +getDzerNos()+
	         "\nCena: "+getCena()+"\n";
	  }

}