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
		
		for (Comunidades ca:fchXML.getInfo()) {
			System.out.println("CCAA: "+ca.getsNombre());
			for(Provincia prov:ca.getlstProvincia()) {
				System.out.println("\tProvincia: "+prov.getsNombre());
				for (Ciudad city : prov.getlstCiudades()) {
					System.out.println("\t\tCiudad: "+city.getsNombre()+" ["+city.getiTempMax()+", "+city.getiTempMin()+" ]");
				}
			}
		}		
	}
}
