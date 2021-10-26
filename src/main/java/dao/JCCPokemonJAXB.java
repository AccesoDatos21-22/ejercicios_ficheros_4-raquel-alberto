package dao;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import modelo.JCCPokemon;

public class JCCPokemonJAXB implements JCCPokemonDAO {

	private static final String JAXB_XML_FILE = "xml/PokemonJAXB.xml";
	
	/*
	 * Completar los métodos de la clase JCCPokemonJAXB para guardar y leer la información en un fichero XML 
	 */
	
	@Override
	public JCCPokemon leer() {
		
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(JCCPokemon.class);
			
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			Unmarshaller unmarshaller = context.createUnmarshaller();
			
			JCCPokemon pok = (JCCPokemon) unmarshaller.unmarshal(Files.newInputStream(Paths.get(JAXB_XML_FILE)));
			System.out.println("********* Pokemon cargado desde fichero XML***************");
			
			marshaller.marshal(pok, System.out);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public boolean guardar(JCCPokemon pokemones) {
	
		
		long time = System.currentTimeMillis();
		System.out.println("Inicio: " + new Date(time));
		JAXBContext context;
		
		try {
			context = JAXBContext.newInstance(JCCPokemon.class);
			
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			marshaller.marshal(pokemones, System.out);
			
			marshaller.marshal(pokemones, Files.newOutputStream(Paths.get(JAXB_XML_FILE)));
			
			Unmarshaller unmarshaller = context.createUnmarshaller();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
