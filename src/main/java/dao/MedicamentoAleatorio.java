package dao;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;
import java.util.Scanner;

import modelo.Medicamento;

public class MedicamentoAleatorio implements MedicamentoDAO {
	
	public final static int TAM_NOMBRE = 30;
	public final static int TAM_REGISTRO = 88;
	
	
	
	public static final String fichero = "medicamento.bin";
	

	@Override
	public boolean guardar(Medicamento medicamento) {
		try (RandomAccessFile raf = new RandomAccessFile(fichero, "rw")) { // posiciono en el registro del medicamento a insertar
			
			raf.seek(medicamento.getCod() * TAM_REGISTRO);
			
			StringBuilder nombre = new StringBuilder(medicamento.getNombre());
			
			nombre.setLength(TAM_NOMBRE);
			raf.writeChars(nombre.toString());
			
			raf.writeDouble(medicamento.getPrecio());
			raf.writeInt(medicamento.getCod());
			raf.writeInt(medicamento.getStock());
			raf.writeInt(medicamento.getStockMaximo());
			raf.writeInt(medicamento.getStockMinimo());
			raf.writeInt(medicamento.getCodProveedor());
	
			System.out.println(medicamento.toString());
			
		} catch (IOException exception) {
			return false;
		}
		return false;
	}

	@Override
	public Medicamento buscar(int codigo) {
		
		Medicamento medica = new Medicamento();
		
		int posicion= (codigo) * TAM_REGISTRO;
		int stock=0, cod, codProveedor=0, stockmax=0, stockmin=0;
		double precio=0;
		char letra;
		String nom="";
			
		try (RandomAccessFile raf = new RandomAccessFile(fichero, "r")) {// posiciono en el registro del medicamento a insertar
			
			if (posicion < raf.length()) {
				
				raf.seek(posicion); //Pongo el puntero en el sitio que quiero
				
				for (int i = 0; i < TAM_NOMBRE; i++) {
					
					letra = raf.readChar();

					nom += letra != 0 ? letra : ' ';
				}
				
				precio = raf.readDouble();
				cod= raf.readInt();
				stock = raf.readInt();
				stockmax=raf.readInt();
				stockmin=raf.readInt();
				codProveedor= raf.readInt();
				
				medica= new Medicamento(codigo,nom,precio,stock,codProveedor);
			}

			
		} catch (IOException exception) {
			System.err.println("Error al escribir");
		}
		
		
		return medica;
		
	}

	@Override
	public boolean actualizar(Medicamento medicamento) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce el nuevo código del medicamento");
		medicamento.setCod(sc.nextInt());
		
		System.out.println("Datos actualizados del medicamento");
		guardar(medicamento);
		
		sc.close();
		return false;
	}

	@Override
	public boolean borrar(Medicamento medicamento) {
			
			medicamento.setCod(0);
			medicamento.setNombre("");
			medicamento.setPrecio(0);
			medicamento.setStock(0);
			medicamento.setStockMaximo(0);
			medicamento.setStockMinimo(0);
			medicamento.setCodProveedor(0);
			
			System.out.println("El medicamento ha sido borrado");
			guardar(medicamento);
			

		return false;
	}

	@Override
	public List<Medicamento> leerTodos() {
		// TODO Auto-generated method stub
		return null;
	}


	
	
}
