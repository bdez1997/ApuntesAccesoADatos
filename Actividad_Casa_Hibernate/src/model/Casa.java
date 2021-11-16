package model;

public class Casa {
	
	private int iId;
	private String sCalle;
	private int iNumber;
	private double doDimension;
	
	
	public Casa() {
		
	}
	
	
	public Casa(String sCalle, int iNumber, double doDimension) {
		
		setsCalle(sCalle);
		setiNumber(iNumber);
		setdoDimension(doDimension);
	}
	
	
	public Casa(int iId, String sCalle, int iNumber, double doDimension) {
		
		setiId(iId);
		setsCalle(sCalle);
		setiNumber(iNumber);
		setdoDimension(doDimension);
	}


	public String getsCalle() {
		return sCalle;
	}
	public void setsCalle(String sCalle) {
		this.sCalle = sCalle;
	}
	public int getiNumber() {
		return iNumber;
	}
	public void setiNumber(int iNumber) {
		this.iNumber = iNumber;
	}
	public double getdoDimension() {
		return doDimension;
	}
	public void setdoDimension(double doDimension) {
		this.doDimension = doDimension;
	}

	public int getiId() {
		return iId;
	}

	public void setiId(int iId) {
		this.iId = iId;
	}


	@Override
	public String toString() {
	
		String sResultado="";
		
		sResultado="iID= "+iId+" ";
		sResultado+="Calle= "+sCalle+" ";
		sResultado+="Number= " + iNumber+" ";
		sResultado+="Dimension= " + doDimension+"\n";
		sResultado+="-------------------------------------";
		
		
		return sResultado;
	}
	
	
	
}
