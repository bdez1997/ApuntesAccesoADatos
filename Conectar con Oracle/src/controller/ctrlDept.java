package controller;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

import model.Dept;

public class ctrlDept {
	
	public static void mostrarSql() {
		
		ArrayList<Dept> listDept=new ArrayList<Dept>();
		try {
			//listDept = logic.LogDept.getList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (Dept dept : listDept) {
			System.out.println(dept);
		}
	}
	
	public static void listadoDepts() {
		
		try {
			//ArrayList<Dept> listadoDepts=logic.LogDept.getDepts();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
				
	public static void nuevaLoc(String localidad,Integer deptno) {
		
		try {
			logic.LogDept.cambiarLoc(localidad, deptno);
			System.out.println("Se ha cambiado corectamente");
		} catch (Exception e) {
			System.err.println("Oju ompare "+e.toString());
		}
	}
	public static void totalEmps(Integer numDept) {
		
		try {
			int total=logic.LogDept.getTotalDeEmpleados(numDept);
			System.out.println();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}
}
