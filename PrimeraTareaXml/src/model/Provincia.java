package model;

import java.util.ArrayList;

public class Provincia {
	
	private String sNombre;
	private ArrayList<Ciudad> lstCiudades;
	
	
	
	public Provincia() {
		
		this.sNombre ="";
		this.lstCiudades = null;
	}
	public Provincia(String sNombre, ArrayList<Ciudad> lstCiudades) {

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
	
	@Override
	public String toString() {
		return "Provincia [sNombre=" + sNombre + ", lstCiudades=" + lstCiudades + "]";
	}
	
}
