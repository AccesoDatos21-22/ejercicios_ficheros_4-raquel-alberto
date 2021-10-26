package modelo;

import java.io.Serializable;

public class Pokemon implements Serializable{

	

	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private int vida;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	
	public Pokemon(String nombre, int vida) {
		super();
		this.nombre = nombre;
		this.vida = vida;
	}
	
	public Pokemon() {
		
	}
	

}
