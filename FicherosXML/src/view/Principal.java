package view;

import java.util.ArrayList;

import controller.GestionFchXml;
import model.Jugador;

public class Principal {

	public static void main(String[] args) {
		String fileName="archivos/datos.xml";
		
		GestionFchXml fchXML = new GestionFchXml(fileName);
		ArrayList<Jugador>jJugadores=fchXML.getJugadores();
		
		fchXML.addJugador(new Jugador(7,"Ramon","Pernia","Pelota",1750));
		fchXML.saveData();
		fchXML.mostrarDocumento();
		//jJugadores.forEach(e->System.out.println(e));		leer list de xml
		
		

	}
}
