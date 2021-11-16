package model;

public class Ciudad {
	private String sNombre;
	public String sCapital;
	private String code_ine;
	private int iTempMax;
	private int iTempMin;
	
	
	
	public Ciudad() {
		super();
		this.sNombre ="";
		this.iTempMax =0;
		this.iTempMin =0;
	}

	public Ciudad(String sCaptital,String code_ine,String sNombre,int iTempMax,int iTempMin) {
		setsCapital(sCaptital);
		setCode_ine(code_ine);
		setsNombre(sNombre);
		setiTempMax(iTempMax);
		setiTempMin(iTempMin);
		
	}
	
	
	public String getCode_ine() {
		return code_ine;
	}

	public void setCode_ine(String code_ine) {
		this.code_ine = code_ine;
	}

	public String getsCapital() {
		return sCapital;
	}

	public void setsCapital(String sCapital) {
		this.sCapital = sCapital;
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
		return "Ciudad [sNombre=" + sNombre + ", sCapital=" + sCapital + ", iTempMax=" + iTempMax + ", iTempMin="
				+ iTempMin + "]";
	}
	
	
}
