package fedotova_pica;

public class pasutijums {
	private String picasNos, dzerNos;
	private boolean siers, pipari;
	private double cena;
	private int d;
	
	public pasutijums(String picasNos, String dzerNos, boolean siers, boolean pipari, double cena, int d) {
		this.picasNos = picasNos;
		this.dzerNos = dzerNos;
		this.pipari = pipari;
		this.siers = siers;
		this.cena = cena;
		this.d = d;
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

}
