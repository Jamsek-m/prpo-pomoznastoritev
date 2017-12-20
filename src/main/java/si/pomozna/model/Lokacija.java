package si.pomozna.model;

public class Lokacija {
	
	private String geoSirina;
	
	private String geoDolzina;
	
	private double radij;
	
	public Lokacija(String geoSirina, String geoDolzina, double radij) {
		this.geoSirina = geoSirina;
		this.geoDolzina = geoDolzina;
		this.radij = radij;
	}
	
	public Lokacija() {}
	
	public String getGeoSirina() {
		return geoSirina;
	}
	
	public void setGeoSirina(String geoSirina) {
		this.geoSirina = geoSirina;
	}
	
	public String getGeoDolzina() {
		return geoDolzina;
	}
	
	public void setGeoDolzina(String geoDolzina) {
		this.geoDolzina = geoDolzina;
	}
	
	public double getRadij() {
		return radij;
	}
	
	public void setRadij(double radij) {
		this.radij = radij;
	}
}
