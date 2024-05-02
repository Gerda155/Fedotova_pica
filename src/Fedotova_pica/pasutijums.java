package Fedotova_pica;

public class pasutijums {
	private String picasNos, dzerNos, d, merce;
	private boolean siers, piegad;
	private double cena;
	private int nr;

	public pasutijums(String picasNos, String dzerNos, boolean siers, String merce, double cena, String d, int nr, boolean piegad) {
		this.picasNos = picasNos;
		this.dzerNos = dzerNos;
		this.merce = merce;
		this.siers = siers;
		this.cena = cena;
		this.d = d;
		this.nr = nr;
		this.piegad = piegad;
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

	public String getMerce() {
		return merce;
	}

	public void setMerce(String merce) {
		this.merce = merce;
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

	public boolean isPiegad() {
		return piegad;
	}

	public void setPiegad(boolean piegad) {
		this.piegad = piegad;
	}
	
	public String izvadit() {
	    return "Nr.: "+getNr() + "  Laiks: "+metodes.Laiks() +
	    	 "\nPica: " +getPicasNos()+ " " + getD()+" cm"+
	    	 "\nPapild. siers: "+ (isSiers()? "ir" : "nav") +
	         "\nMērce: "+getMerce()+
	         "\nDzeriens: " +getDzerNos()+
	         "\nCena: "+getCena()+"\n";
	  }

}
