package ctrl;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import model.Ciudad;
import model.Comunidades;
import model.Provincia;

public class CtrlAemet {
	private Document docXML;

	public CtrlAemet(String fileName) {
		try {
			docXML = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(fileName);
			docXML.getDocumentElement().normalize();

		} catch (SAXException e) {
			System.err.println("Error de sintaxis");
		} catch (ParserConfigurationException e) {
			System.err.println("Error con el parser");
		} catch (IOException e) {
			System.err.println("Error accediendo al fichero");
		}
	}

	public ArrayList<Comunidades> getInfo() {
		
		
		return getComunidades();
	}

	private ArrayList<Comunidades> getComunidades() {

		ArrayList<Comunidades> lstComunidades = new ArrayList<Comunidades>();

		NodeList nodoComunidades = docXML.getElementsByTagName("ccaa");

		for (int i = 0; i < nodoComunidades.getLength(); i++) {
			Element eElemento = (Element) nodoComunidades.item(i);

			String id = eElemento.getAttribute("id");
			String sNombre = eElemento.getAttribute("nombre");
			ArrayList<Provincia> provincias = getProvincias(id);
			lstComunidades.add(new Comunidades(id, sNombre, provincias));

		}
		return lstComunidades;
	}

	private ArrayList<Provincia> getProvincias(String idComunidades) {

		ArrayList<Provincia> lstProvincias = new ArrayList<Provincia>();
		NodeList nodoProvincias = docXML.getElementsByTagName("provincia");

		for (int i = 0; i < nodoProvincias.getLength(); i++) {
			Element eElemento = (Element) nodoProvincias.item(i);

			String ccaa = eElemento.getAttribute("ccaa");

			if (ccaa.equals(idComunidades)) {
				String id = eElemento.getAttribute("id");
				String sNombre = eElemento.getAttribute("nombre");
				ArrayList<Ciudad> ciudades = getCiudades(id);
				lstProvincias.add(new Provincia(ccaa,id, sNombre, ciudades));
			}

		}
		return lstProvincias;
	}

	private ArrayList<Ciudad> getCiudades(String idProvincias) {
		
		ArrayList<Ciudad> lstCiudades = new ArrayList<Ciudad>();

		NodeList nodoCiudades = docXML.getElementsByTagName("ciudad");
		
		for (int i = 0; i < nodoCiudades.getLength(); i++) {
			Element eElemento = (Element) nodoCiudades.item(i);

				String capital = eElemento.getAttribute("capital");		
				String sNombre = eElemento.getAttribute("nombre");
				String code_ine = eElemento.getAttribute("cod_ine");
				int TempMax=Integer.parseInt(eElemento.getElementsByTagName("tmax").item(0).getTextContent());
				int TempMin=Integer.parseInt(eElemento.getElementsByTagName("tmin").item(0).getTextContent());
				if (code_ine.substring(0, 2).equals(idProvincias.substring(0,2))) {
					lstCiudades.add(new Ciudad(capital,code_ine, sNombre, TempMax,TempMin));
				}
			

		}				
		
		return lstCiudades;
	}
}
