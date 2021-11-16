package model;

public class Config {
	private String HOST;
	private String PORT;
	private String NAME;
	private String USER;	
	private String PASS;
	
	
	
	public Config() {
		HOST = "";
		PORT = "";
		NAME = "";
		USER = "";
		PASS = "";
	}
	public Config(String HOST, String PORT, String NAME, String USER, String PASS) {
		setHOST(HOST);
		setPORT(PORT);
		setNAME(NAME);
		setUSER(USER);
		setPASS(PASS);
	}
	public String getHOST() {
		return HOST;
	}
	public void setHOST(String hOST) {
		HOST = hOST;
	}
	public String getPORT() {
		return PORT;
	}
	public void setPORT(String pORT) {
		PORT = pORT;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getUSER() {
		return USER;
	}
	public void setUSER(String uSER) {
		USER = uSER;
	}
	public String getPASS() {
		return PASS;
	}
	public void setPASS(String pASS) {
		PASS = pASS;
	}
	
	
	@Override
	public String toString() {
		
		String sResultado;
		
		sResultado="HOST:" + HOST;
		sResultado+="\nPORT:" + PORT;
		sResultado+="\nNAME:" + NAME;
		sResultado+="\nUSER:" + USER;
		sResultado+="\nPASS:" + PASS;
		
		
		return sResultado;
	}
	
	
	
}
