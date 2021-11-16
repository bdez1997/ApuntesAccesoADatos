package controller;

import java.io.FileOutputStream;
import java.io.IOException;

import java.io.OutputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import model.Jugador;

public class GestionFchXml {
	private static Document docXML;
	public void saveData() {
		
		try {
			
			Transformer tr = TransformerFactory.newInstance().newTransformer();
			tr.setOutputProperty(OutputKeys.INDENT, "yes");
			tr.setOutputProperty(OutputKeys.METHOD, "xml");
			tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount","4");
			
			//enviar el DOM al fichero
			tr.transform(new DOMSource(docXML),new StreamResult(new FileOutputStream("nuevosdatos.xml")));
				
			
		} catch (Exception e) {		
			
		}
		
	}
	public void addJugador(Jugador j) {
		Element item = docXML.createElement("jugador");
		item.setAttribute("numero",String.valueOf(j.getiNumero()));
		
		Element tagName;
		Node tagValue;
		
		//<sNombre>
		tagName = docXML.createElement("nombre");
		tagValue=docXML.createTextNode(j.getsNombre());
		tagName.appendChild(tagValue);
		item.appendChild(tagName);
		//<Apellidos>		
		tagName = docXML.createElement("apellidos");
		tagValue=docXML.createTextNode(j.getsApellidos());
		tagName.appendChild(tagValue);
		item.appendChild(tagName);
		//<nick>
		tagName = docXML.createElement("nick");
		tagValue=docXML.createTextNode(j.getsNick());
		tagName.appendChild(tagValue);
		item.appendChild(tagName);
		//<puntos>
		tagName = docXML.createElement("puntos");
		tagValue=docXML.createTextNode(String.valueOf(j.getiPuntos()));
		tagName.appendChild(tagValue);
		item.appendChild(tagName);
		
		Node nRaiz =docXML.getFirstChild().appendChild(item);
		
	}

	public GestionFchXml(String fileName) {
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

	public void mostrarDocumento() {

		XPath xPath = XPathFactory.newInstance().newXPath();
		String sExpression = "/game/jugador";

		try {
			NodeList nodeList = (NodeList) xPath.compile(sExpression).evaluate(docXML, XPathConstants.NODESET);

			for (int i = 0; i < nodeList.getLength(); i++) {
				Node nNode = nodeList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElemento = (Element) nNode;
					System.out.println("Jugador numero: " + eElemento.getAttribute("numero"));
					System.out.println(
							"Nombre de Jugador: " + eElemento.getElementsByTagName("nombre").item(0).getTextContent());
					System.out.println("Apellidos de Jugador: "
							+ eElemento.getElementsByTagName("apellidos").item(0).getTextContent());
					System.out.println(
							"Nick de Jugador: " + eElemento.getElementsByTagName("nick").item(0).getTextContent());
					System.out.println(
							"Nombre de Jugador: " + eElemento.getElementsByTagName("puntos").item(0).getTextContent());
					System.out.println();
				}

			}

		} catch (XPathExpressionException e) {
			System.err.println("Error aplicando la expresión");
		}

	}

	public ArrayList<Jugador> getJugadores(){
		ArrayList<Jugador> jJugadores=new ArrayList<Jugador>();
		int iNumero,iPuntos;
		String sNombre,sApellidos,sNick;
		XPath xPath = XPathFactory.newInstance().newXPath();
		String sExpression = "/game/jugador";

		try {
			NodeList nodeList = (NodeList) xPath.compile(sExpression).evaluate(docXML, XPathConstants.NODESET);

			for (int i = 0; i < nodeList.getLength(); i++) {
				Node nNode = nodeList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {			
					Element eElemento = (Element) nNode;
					
					iNumero=Integer.parseInt(eElemento.getAttribute("numero"));
					sNombre=eElemento.getElementsByTagName("nombre").item(0).getTextContent();
					sApellidos=eElemento.getElementsByTagName("apellidos").item(0).getTextContent();
					sNick=eElemento.getElementsByTagName("nick").item(0).getTextContent();
					iPuntos=Integer.parseInt(eElemento.getElementsByTagName("puntos").item(0).getTextContent());
					
					jJugadores.add(new Jugador(iNumero,sNombre,sApellidos,sNick,iPuntos));
				}

			}

		} catch (XPathExpressionException e) {
			System.err.println("Error aplicando la expresión");
		}
		return jJugadores;
		
	}
}
