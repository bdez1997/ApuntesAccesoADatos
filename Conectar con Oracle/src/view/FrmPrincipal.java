package view;

public class FrmPrincipal {

	public static void inicio() {
	
		//dbms.DBOracle.writeConfig();
		//probarConexion();
		//cambiarDept();
		 try {
			 logic.LogDept.getList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

	

	private static void cambiarDept() {
		controller.ctrlDept.mostrarSql();
		String localidad ="MAD";
		Integer deptno=10;
		controller.ctrlDept.nuevaLoc(localidad, deptno);
	}

	private static void probarConexion() {
		try {
			if (dbms.DBOracle.tryConnection()) {
				System.out.println("Conectando....");
				dbms.DBOracle.conectar();
				System.out.println("Conexi?n con ?xito!!!!");								
			}
			dbms.DBOracle.desconectar();
			System.out.println("Conexi?n cerrada");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
