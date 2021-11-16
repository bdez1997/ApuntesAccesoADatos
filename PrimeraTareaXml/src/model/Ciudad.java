package model;

public class Ciudad {
	private String sNombre;
	private int iTempMax;
	private int iTempMin;
	
	
	
	public Ciudad() {
		super();
		this.sNombre ="";
		this.iTempMax =0;
		this.iTempMin =0;
	}

	public Ciudad(String sNombre,int iTempMax,int iTempMin) {
		
		setsNombre(sNombre);
		setiTempMax(iTempMax);
		setiTempMin(iTempMin);
		
	}
	
	public String getsNombre() {
		return sNombre;
	}
	public void setsNombre(String sNombre) {
		this.sNombre = sNombre;
	}
	public int getiTempMax() {
		return iTempMax;
	}
	public void setiTempMax(int iTempMax) {
		this.iTempMax = iTempMax;
	}
	public int getiTempMin() {
		return iTempMin;
	}
	public void setiTempMin(int iTempMin) {
		this.iTempMin = iTempMin;
	}
	@Override
	public String toString() {
		return "Ciudad [sNombre=" + sNombre + ", iTempMax=" + iTempMax + ", iTempMin=" + iTempMin + "]";
	}
	
	
	
	
}
