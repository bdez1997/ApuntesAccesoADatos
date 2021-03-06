package logic;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.concurrent.Callable;

import model.Dept;

public class LogDept {
	
	
	
	public static void getList() {
		ArrayList<Dept> list = new ArrayList<Dept>();
		
		try {
			//Conexionn a BBDD
			dbms.DBOracle.conectar();
			String sql="SELECT * FROM DEPT";
			
			//Ejecutamos orden SQL
			Statement myOrder =dbms.DBOracle.getConn().createStatement();
			myOrder.execute(sql);
			
			ResultSet resultado = myOrder.getResultSet();
			ResultSetMetaData info=resultado.getMetaData();
						
			
			int numCampos=info.getColumnCount();
			
			for (int i = 1; i <= numCampos; i++) {
				System.out.print(info.getColumnName(i)+" \t");
			}
			System.out.println();
			
			while (resultado.next()){
				
				
				for (int i = 1; i <= numCampos; i++) {
					System.out.print(resultado.getString(i)+" \t");
				}
				System.out.println();
				
				
				/*System.out.print("Nombre: "+resultado.getString("ENAME"));
				System.out.print("Salario: "+resultado.getInt(2));*/
							
			}
			
			dbms.DBOracle.desconectar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void cambiarLoc(String LOC, Integer DEPTNO) throws SQLException {
		String sql ="{ call CAMBIAR_DEPT_LOC (?,?) }";
		
		CallableStatement order =dbms.DBOracle.getConn().prepareCall(sql);
		order.setString(1, LOC);
		order.setInt(2, DEPTNO);
		
		order.execute();
		
	}

	public static int getTotalDeEmpleados(Integer numDept) throws Exception {

		int iTotal=0;
		String sql = "{ ? = call Total_Emps (?) }";
		
		CallableStatement order =dbms.DBOracle.getConn().prepareCall(sql);		
		
		order.registerOutParameter(1, Types.NUMERIC);		
		order.setInt(2, numDept);
		
		order.execute();
		
		order.getInt(1);
		
		return iTotal;
	}

	/*public static ArrayList<Dept> getDepts() throws Exception{
		ArrayList<Dept>listDept=new ArrayList<Dept>();
		int iTotal=0;
		String sql = "{ ? = call GET_DEPTS (?) }";
		
		CallableStatement order =dbms.DBOracle.getConn().prepareCall(sql);		
		
		order.registerOutParameter(1, OracleTypes.CURSOR);		
		
		order.execute();
		ResultSet resultado = (ResultSet)order.getObject(1);
		while(resultado.next()) {
			listDept.add(new Dept());
		}
		
		
		return null;
	}*/
}
