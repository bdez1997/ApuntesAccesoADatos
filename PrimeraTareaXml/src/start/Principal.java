package start;

import java.io.File;

import ctrl.CtrlAemet;
import model.Ciudad;
import model.Comunidades;
import model.Provincia;

public class Principal {
	public static File fileName=new File("PB.xml"); 
	  
	public static void main(String[] args) {
		
		CtrlAemet fchXML = new CtrlAemet("PB.xml");
		
		for (Comunidades ca:fchXML.getComunidades()) {
			System.out.println("CCAA: "+ca.getsNombre());
			for(Provincia prov:ca.getlstProvincia()) {
				System.out.println("Provincia: "+prov.getsNombre());
				for (Ciudad city : prov.getlstCiudades()) {
					System.out.println("Ciudad: "+city.getsNombre());
				}
			}
		}		
	}
}
