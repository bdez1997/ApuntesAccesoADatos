package controller;

import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class CtrlXML {
	private static Document docXML;

	public static ArrayList<String> sacarTablas() {

		ArrayList<String> lstTablas = new ArrayList<String>();

		try {
			// Conexionn a BBDD
			dbms.DBOracle.conectar();

			// Ejecutamos orden SQL
			Statement myOrder = dbms.DBOracle.getConn().createStatement();
			String sql = "select table_name from user_tables order by table_name";
			myOrder.execute(sql);

			ResultSet resultado = myOrder.getResultSet();

			while (resultado.next()) {

				lstTablas.add(resultado.getString(1));

			}

			dbms.DBOracle.desconectar();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lstTablas;

	}

	public static void AddList(ArrayList<String> lstTablas) {

		try {
			// Conexionn a BBDD
			dbms.DBOracle.conectar();

			// Ejecutamos orden SQL
			Statement myOrder = dbms.DBOracle.getConn().createStatement();

			for (int i = 1; i <= sacarTablas().size(); i++) {
				docXML = DocumentBuilderFactory.newInstance().newDocumentBuilder().getDOMImplementation()
						.createDocument(null, lstTablas.get(i-1), null);

				String sql = "SELECT * FROM " + lstTablas.get(i-1);
				myOrder.execute(sql);

				ResultSet resultado = myOrder.getResultSet();
				ResultSetMetaData info = resultado.getMetaData();

				int numCampos = info.getColumnCount();
				while (resultado.next()) {
					for (int j = 1; j < numCampos; j++) {

						Element item = docXML.createElement(sacarTablas().get(i-1));

						Element tagName;
						Node tagValue;

						tagName = docXML.createElement(info.getColumnLabel(j));
						tagValue = docXML.createTextNode(resultado.getString(j));
						tagName.appendChild(tagValue);
						item.appendChild(tagName);

						Node nRaiz = docXML.getFirstChild().appendChild(item);
					}
				}
				try {

					Transformer tr = TransformerFactory.newInstance().newTransformer();
					tr.setOutputProperty(OutputKeys.INDENT, "yes");
					tr.setOutputProperty(OutputKeys.METHOD, "xml");
					tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
					tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

					// enviar el DOM al fichero
					tr.transform(new DOMSource(docXML), new StreamResult(new FileOutputStream(sacarTablas().get(i-1)+".xml")));

				} catch (Exception e) {
					System.err.println("He petado en el addList");
				}

			}

			dbms.DBOracle.desconectar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * String[] sShowDataColumn = new String[numCampos]; while (resultado.next()) {
	 * 
	 * for (int i = 1; i <= numCampos; i++) { sShowDataColumn[i - 1] =
	 * resultado.getString(i); }
	 * 
	 * tableQuery.addRow(sShowDataColumn);
	 * 
	 * } view.FrmPrincipal.tableEjercicio.setModel(tableQuery);
	 */

}
