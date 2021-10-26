package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


@XmlRootElement(name="JCCPokemon")
@XmlType(propOrder = { "pokemones", "fechaLanzamiento", "numCartas" })

public class JCCPokemon implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<Pokemon> pokemones;
	private Date fechaLanzamiento;
	private int numCartas;
	
	//Getters y Setters
	public List<Pokemon> getPokemones() {
		return pokemones;
	}
	public void setPokemones(List<Pokemon> pokemones) {
		this.pokemones = pokemones;
	}
	public Date getFechaLanzamiento() {
		return fechaLanzamiento;
	}
	public void setFechaLanzamiento(Date fechaLanzamiento) {
		this.fechaLanzamiento = fechaLanzamiento;
	}
	public int getNumCartas() {
		return numCartas;
	}
	public void setNumCartas(int numCartas) {
		this.numCartas = numCartas;
	}

	
	//Constructor
	public JCCPokemon(Date fechaLanzamiento, int numCartas) {
		super();
		this.fechaLanzamiento = fechaLanzamiento;
		this.numCartas = numCartas;
	}
	
	public JCCPokemon() {
		
	}
	
}
