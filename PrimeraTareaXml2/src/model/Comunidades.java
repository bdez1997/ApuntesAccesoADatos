package model;

import java.util.ArrayList;

public class Comunidades {
	
	private String sNombre;
	private String sId;
	private ArrayList<Provincia>lstProvincia;
	
	public Comunidades(String sId,String sNombre, ArrayList<Provincia>lstProvincia) {
		setsId(sId);
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
	
	public String getsId() {
		return sId;
	}

	public void setsId(String sId) {
		this.sId = sId;
	}

	@Override
	public String toString() {
		return "Comunidades [sNombre=" + sNombre + ", sId=" + sId + ", lstProvincia=" + lstProvincia + "]";
	}
	
	
	
	
}
