package EjemploDOM;


import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class EjemploDOM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File fichero = new File("ejemplo.xml");
		
		leerXMLDOM(fichero);

	}
	
	private static void leerXMLDOM(File fichero) {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		
		DocumentBuilder dBuilder;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
		
			Document doc = dBuilder.parse(fichero);
			
			doc.getDocumentElement().normalize();
			
			Node n = null;
			
			NodeList nList = doc.getElementsByTagName("coche");
			System.out.println("Número de coches: " + nList.getLength());
			
			for (int i=0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);
			}
		} catch (SAXException | IOException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
