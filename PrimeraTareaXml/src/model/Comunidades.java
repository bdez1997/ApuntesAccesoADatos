package model;

import java.util.ArrayList;

public class Comunidades {
	
	private String sNombre;
	private ArrayList<Provincia>lstProvincia;
	
	public Comunidades(String sNombre, ArrayList<Provincia>lstProvincia) {
		setsNombre(sNombre);
		setlstProvincia(lstProvincia);
	}
	
	public String getsNombre() {
		return sNombre;
	}
	public void setsNombre(String sNombre) {
		this.sNombre = sNombre;
	}
	public ArrayList<Provincia> getlstProvincia() {
		return lstProvincia;
	}
	public void setlstProvincia(ArrayList<Provincia> lstProvincia) {
		this.lstProvincia = lstProvincia;
	}
	
	@Override
	public String toString() {
		return "Comunidades [sNombre=" + sNombre + ", lstProvincia=" + lstProvincia + "]";
	}
	
	
	
	
}
