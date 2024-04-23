package fedotova_pica;

public class pasutijums {
	private String picasNos, dzerNos;
	private boolean siers, pipari;
	private double cena;
	
	public pasutijums(String picasNos, String dzerNos, boolean siers, boolean pipari, double cena) {
		this.setPicasNos(picasNos);
		this.setDzerNos(dzerNos);
		this.setPipari(pipari);
		this.setSiers(siers);
		this.cena = cena;
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

}
