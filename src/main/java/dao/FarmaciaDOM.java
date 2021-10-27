package dao;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

//import jakarta.xml.bind.Element;
import modelo.Farmacia;
import modelo.Medicamento;

public class FarmaciaDOM{

	/**
	 * Lee los medicamentos de la farmacia de un fichero xml
	 * mediante DOM
	 * @param farmacia
	 * @return
	 */
	
	private static final String DOM_XML="xml/Farmaciaa.xml";
	public boolean leer(Path farmaciaXML) {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		DocumentBuilder builder;
		
		try {
			builder = factory.newDocumentBuilder();

			Document document = builder.parse(new File(DOM_XML));
			document.getDocumentElement().normalize();

			// Obtenemos la lista de nodos con nombre empleado de todo el documento
			NodeList farmacia = document.getElementsByTagName("medicamento");

			for (int i = 0; i < farmacia.getLength(); i++) {
				Node farma = farmacia.item(i); // obtener un nodo
				if (farma.getNodeType() == Node.ELEMENT_NODE) {
					Element elemento = (Element) farma; // tipo de nodo
					System.out.println("Nombre: " + getNodo("nombre", elemento));
					System.out.println("Precio: " + getNodo("precio", elemento));
					System.out.println("Código: " + getNodo("cod", elemento));
					System.out.println("Stock: " + getNodo("stock", elemento));
					System.out.println("Stock máximo: " + getNodo("stockmax", elemento));
					System.out.println("Stock mínimo: " + getNodo("stockmin", elemento));
					System.out.println("Código de proveedor: " + getNodo("codprovee", elemento));
				}
			}

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return false;
		
	}
	
	private String getNodo(String etiqueta, Element elemento) {
		NodeList nodo = elemento.getElementsByTagName(etiqueta).item(0).getChildNodes();
		Node valornodo = (Node) nodo.item(0);
		return valornodo.getNodeValue(); // devuelve el valor del nodo
		
		}
	
	/**
	 * Guarda los medicamentos de la farmacia en un fichero XML 
	 * mediamente DOM
	 * @param farmacia
	 * @return
	 */
	public boolean guardar(Farmacia farmacia) {
		return false;
		
	}

}
