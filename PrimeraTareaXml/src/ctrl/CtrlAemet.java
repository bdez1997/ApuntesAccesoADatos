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
	private static Document docXML;

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

	public ArrayList<Ciudad> getCiudad(String sNombreProvincia) {

		int iTempMax = 0, iTempMin = 0;
		String sNombreCiudad = null;
		XPath xPath = XPathFactory.newInstance().newXPath();
		String sExpression = "/root/ccaa/provincia";
		ArrayList<Ciudad> newCity = new ArrayList<Ciudad>();
		try {
			NodeList nodeList = (NodeList) xPath.compile(sExpression).evaluate(docXML, XPathConstants.NODESET);

			for (int i = 0; i < nodeList.getLength(); i++) {
				Node nNode = nodeList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElemento = (Element) nNode;
					if (eElemento.getAttribute("nombre").equalsIgnoreCase(sNombreProvincia)) {
						NodeList nodeCiudades = eElemento.getElementsByTagName("ciudad");
						for (int j = 0; j < nodeCiudades.getLength(); j++) {
							sNombreCiudad = eElemento.getAttribute("nombre");
							iTempMax = Integer
									.parseInt(eElemento.getElementsByTagName("tmax").item(0).getTextContent());
							iTempMin = Integer
									.parseInt(eElemento.getElementsByTagName("tmin").item(0).getTextContent());
						}
					}
				}
				newCity.add(new Ciudad(sNombreCiudad, iTempMax, iTempMin));
			}
		} catch (XPathExpressionException e) {
			System.err.println("Error aplicando la expresión");
		}
		return newCity;
	}

	public ArrayList<Provincia> getProvincia(String sNombreComunidades) {
		String sNombreProvincia = "";
		ArrayList<Provincia> newProvincia = new ArrayList<Provincia>();
		ArrayList<Ciudad> Cities = new ArrayList<Ciudad>();

		XPath xPath = XPathFactory.newInstance().newXPath();
		String sExpression = "/root/ccaa/provincia";

		try {
			NodeList nodeList = (NodeList) xPath.compile(sExpression).evaluate(docXML, XPathConstants.NODESET);

			for (int i = 0; i < nodeList.getLength(); i++) {
				Node nNode = nodeList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElemento = (Element) nNode;
					if(eElemento.getAttribute("nombre").equalsIgnoreCase(sNombreComunidades)) {
						NodeList nodeProvincia=eElemento.getElementsByTagName("provincia");
						for (int j = 0; j <nodeProvincia.getLength(); j++) {
							sNombreProvincia = eElemento.getAttribute("nombre");
							Cities = getCiudad(eElemento.getAttribute("nombre"));
						}
					}
				}
				newProvincia.add(new Provincia(sNombreProvincia, Cities));
			}

		} catch (XPathExpressionException e) {
			System.err.println("Error aplicando la expresión");
		}

		return newProvincia;

	}

	public ArrayList<Comunidades> getComunidades() {

		String sNombreComunidades = "";
		ArrayList<Comunidades> newComunidades = new ArrayList<Comunidades>();
		ArrayList<Provincia> provincias = new ArrayList<Provincia>();

		XPath xPath = XPathFactory.newInstance().newXPath();
		String sExpression = "/root/ccaa";

		try {
			NodeList nodeList = (NodeList) xPath.compile(sExpression).evaluate(docXML, XPathConstants.NODESET);

			for (int i = 0; i < nodeList.getLength(); i++) {
				Node nNode = nodeList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElemento = (Element) nNode;
					sNombreComunidades = eElemento.getAttribute("nombre");
					provincias = getProvincia();

				}
				newComunidades.add(new Comunidades(sNombreComunidades, provincias));
			}

		} catch (XPathExpressionException e) {
			System.err.println("Error aplicando la expresión");
		}

		return newComunidades;

	}
}
