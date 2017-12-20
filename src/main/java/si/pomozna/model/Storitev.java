package si.pomozna.model;

import java.util.Date;

public class Storitev {
	
	private long id;
	
	private Date cas_od;
	
	private Date cas_do;
	
	private Lokacija lokacija;
	
	public Storitev(long id, Date cas_od, Date cas_do) {
		this.id = id;
		this.cas_od = cas_od;
		this.cas_do = cas_do;
	}
	
	public Storitev(long id, Lokacija lokacija) {
		this.id = id;
		this.lokacija = lokacija;
	}
	
	public Storitev() {}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public Date getCas_od() {
		return cas_od;
	}
	
	public void setCas_od(Date cas_od) {
		this.cas_od = cas_od;
	}
	
	public Date getCas_do() {
		return cas_do;
	}
	
	public void setCas_do(Date cas_do) {
		this.cas_do = cas_do;
	}
	
	public Lokacija getLokacija() {
		return lokacija;
	}
	
	public void setLokacija(Lokacija lokacija) {
		this.lokacija = lokacija;
	}
}
