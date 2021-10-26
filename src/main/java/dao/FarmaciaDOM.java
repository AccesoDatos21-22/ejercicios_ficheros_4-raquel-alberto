package dao;

import java.io.File;
import java.nio.file.Path;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

import modelo.Farmacia;
import modelo.Medicamento;

public class FarmaciaDOM{

	
	//Completar la clase FarmaciaDOM para guardar y leer la información de un fichero XML
	
	/**
	 * Lee los medicamentos de la farmacia de un fichero xml
	 * mediante DOM
	 * @param farmacia
	 * @return
	 */
	
	private static final String DOM_XML = "xml/FarmaciaDOM.xml";
	
	public boolean leer(Path farmaciaXML) {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		DocumentBuilder builder;
		
		try {
			
			builder = factory.newDocumentBuilder();
			
			Document documento = builder.parse(new File (DOM_XML));
			documento.getDocumentElement().normalize();
					
			// Obtenemos la lista de nodos con nombre empleado de todo el documento
				NodeList medicamentos = documento.getElementsByTagName("Medicamento");
				for (int i = 0; i < medicamentos.getLength(); i++) {
						Node med = medicamentos.item(i); // obtener un nodo
						if (med.getNodeType() == Node.ELEMENT_NODE) {
							Element elemento = (Element) med; // tipo de nodo
							System.out.println("Nombre: " + getNodo("nombre", elemento));
							System.out.println("Precio: " + getNodo("precio", elemento));
							System.out.println("Codigo: " + getNodo("cod", elemento));
							System.out.println("Stock: " + getNodo("stock", elemento));
							System.out.println("Stock Maximo: " + getNodo("stockmax", elemento));
							System.out.println("Stock Minimo: " + getNodo("stockmin", elemento));
							System.out.println("Codigo proveedor: " + getNodo("codprov", elemento));
							
							}
						}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
		
	}
	
	private String getNodo(String etiqueta, Element med) {
		// TODO Auto-generated method stub
		NodeList nodo = med.getElementsByTagName(etiqueta).item(0).getChildNodes();
		Node valornodo = nodo.item(0);
		return valornodo.getNodeValue(); //devuelve el valor del nodo
	}
	

	/**
	 * Guarda los medicamentos de la farmacia en un fichero XML 
	 * mediamente DOM
	 * @param farmacia
	 * @return
	 */
	public boolean guardar(Farmacia farmacia) {
		
		try {
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

			DocumentBuilder builder = factory.newDocumentBuilder();

			DOMImplementation implementation = builder.getDOMImplementation();

			Document documento = implementation.createDocument(null, "Medicamentos", null);
			documento.setXmlVersion("1.0"); // asignamos la version de nuestro XML
			
			List<Medicamento> medicamentos = farmacia.leermedicamentos();
			
			
			for (int i = 0; i < medicamentos.size() ; i++) {
				Element raiz = documento.createElement("medicamento");

				documento.getDocumentElement().appendChild(raiz);

				CrearElemento("Nombre", medicamentos.get(i).getNombre(), raiz, documento);
				CrearElemento("Precio", String.valueOf(medicamentos.get(i).getPrecio()), raiz, documento);
				CrearElemento("Codigo", String.valueOf(medicamentos.get(i).getCod()), raiz, documento);
				CrearElemento("Stock", String.valueOf(medicamentos.get(i).getStock()), raiz, documento);
				CrearElemento("StockMaximo", String.valueOf(medicamentos.get(i).getStockMaximo()), raiz, documento);
				CrearElemento("StockMinimo", String.valueOf(medicamentos.get(i).getStockMinimo()), raiz, documento);
				CrearElemento("CodigoProveedor", String.valueOf(medicamentos.get(i).getCodProveedor()), raiz, documento);
				
				
			}
			
			Source source = new DOMSource(documento);
			// Creamos el resultado en el fichero Empleados.xml
			Result result = new StreamResult(new java.io.File(DOM_XML));
			// Obtenemos un TransformerFactory
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			// Le damos formato y realizamos la transformación del documento a fichero
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.METHOD, "xml");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			transformer.transform(source, result);
			// Mostramos el documento por pantalla especificando el canal de salida el
			// System.out
			Result console = new StreamResult(System.out);

			transformer.transform(source, console);

			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}

	private void CrearElemento(String datomedicamento, String valor, Element raiz, Document documento) {
		// TODO Auto-generated method stub
		Element med = documento.createElement(datomedicamento);
		Text text = documento.createTextNode(valor);
		raiz.appendChild(med);
		med.appendChild(text);
	}


}
