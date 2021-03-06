package dao;

import modelo.Farmacia;
import modelo.Medicamento;

public class FarmaciaXSTREAM implements FarmaciaDAO{
	
final static String rutaFarmacia ="xml/FarmaciaXTREAM.xml"; // localizacion del fichero XML
	final static String rutaMedicamento =""; // localizacion del fichero XML

	@Override
	public Farmacia leer() {
		Farmacia farmacia = new Farmacia();
		try {
			Class<?>[] classes = new Class[] { Farmacia.class, Medicamento.class };

			XStream xstream = new XStream();
			//XStream.setupDefaultSecurity(xstream);
			//xstream.allowTypes(classes);

			xstream.alias("Farmacia", Farmacia.class);
			xstream.alias("Medicamento", Medicamento.class);
			xstream.addImplicitCollection(Farmacia.class, "Farmacia");

			farmacia = (Farmacia) xstream
					.fromXML(new FileInputStream(rutaFarmacia));

			for(Medicamento medd: farmacia.leerTodos()) {
				System.out.println(medd+"\n");
			}
			return farmacia;
		} catch (FileNotFoundException e) {
			System.err.println("Error: " + e);
		}
		return null;
	}

	@Override
	public boolean guardar(Farmacia farmacia) {
		try {

			System.out.println("Comienza el proceso de creación del fichero a XML...");
			XStream xstream = new XStream();

			long time = System.currentTimeMillis();
			System.out.println("Inicio: " + new Date(time));

			// cambiar de nombre a las etiquetas XML
			xstream.alias("Medicamento", Medicamento.class);
			xstream.alias("Farmacia", Farmacia.class);

			// quitar etiqueta lista (Atributo de la clase ListaEmpleados)
			xstream.addImplicitCollection(Empresa.class, "Farmacia");
			// Insertar los objetos en XML
			xstream.toXML(farmacia, new FileOutputStream(rutaFarmacia));
			System.out.println("Creado fichero XML....");
			return true;
			
		} catch (IOException e) {
			System.err.println("Error: " + e);
		}
		return false;
	}


	public Medicamento leerMedicamento() {
		
		return null;
	}

	public void guardarMedicamento(Medicamento medicamento) {
	}

	
}
