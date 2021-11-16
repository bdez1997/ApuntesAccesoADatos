package model;

import java.util.ArrayList;

public class Provincia {
	
	private String sNombre;
	private String ccaa;
	private String id;
	private ArrayList<Ciudad> lstCiudades;
	
	
	
	public Provincia() {
		
		this.sNombre ="";
		this.lstCiudades = null;
	}
	public Provincia(String ccaa,String id,String sNombre, ArrayList<Ciudad> lstCiudades) {
		
		setCcaa(ccaa);
		setId(id);
		setsNombre(sNombre);
		setlstCiudades(lstCiudades);
	}
	public String getsNombre() {
		return sNombre;
	}
	public void setsNombre(String sNombre) {
		this.sNombre = sNombre;
	}
	public ArrayList<Ciudad> getlstCiudades() {
		return lstCiudades;
	}
	public void setlstCiudades(ArrayList<Ciudad> lstCiudades) {
		this.lstCiudades = lstCiudades;
	}
	public String getCcaa() {
		return ccaa;
	}
	public void setCcaa(String ccaa) {
		this.ccaa = ccaa;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Provincia [sNombre=" + sNombre + ", ccaa=" + ccaa + ", id=" + id + ", lstCiudades=" + lstCiudades + "]";
	}
	
	
	
}
