package dbms;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.*;

import model.Config;

public class DBOracle {
	
	private static File fchConfig =new File("config.cfg");
	
	private static Connection conn;
	private static Config dbProperties=new Config("10.192.120.60","1521","ORCL","BERMUDEZ","medac2021");
	
	public static void desconectar() throws SQLException {
		conn.close();
	}
	
	public static boolean tryConnection() {
		boolean Conectado=false;  
	try {
		conectar();
		desconectar();
		Conectado=true;
	} catch (Exception e) {
		Conectado=false;
	}
	return Conectado;
		
	}
	
	public static Connection getConn() {
		return conn;
	}
	public static void writeConfig() {
		
		try {
		
			RandomAccessFile fchConfigAll=new RandomAccessFile(fchConfig.getAbsolutePath(),"rw");
			
			String sTExto=dbProperties.toString();
			
		fchConfigAll.writeBytes(sTExto);
		fchConfigAll.close();
								
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	/*public static void readConfig() {
		
		try {
			
			
			RandomAccessFile fchConfigAll=new RandomAccessFile(fchConfig.getAbsolutePath(),"r");
			byte[] bFichero=new byte[(int) fchConfig.length()];
			
			fchConfigAll.rea
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}*/
	public static void conectar() throws Exception {
		
		
		String dbURL="jdbc:oracle:thin:@"+dbProperties.getHOST()+":"+dbProperties.getPORT()+":"+dbProperties.getNAME();
		
		//cargar el Driver en memoria 
		
		Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
		
		//Establecemos la conexion
		
		conn=DriverManager.getConnection(dbURL,dbProperties.getUSER(),dbProperties.getPASS());
		
		
	}
	
	
}
