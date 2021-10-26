package dao;

import java.io.RandomAccessFile;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import modelo.Medicamento;

public class MedicamentoAleatorio implements MedicamentoDAO {
	
	Scanner sc = new Scanner(System.in);

	public final static int TAM_NOMBRE = 30;
	public final static int TAM_REGISTRO = 88;
	
	public static final String FICHERO = "farmacia.bin";
	
	
	
	@Override
	public boolean guardar(Medicamento medicamento) {
		try (RandomAccessFile farmacia = new RandomAccessFile(FICHERO, "rw")){
			farmacia.seek(medicamento.getCod() * TAM_REGISTRO);
			StringBuilder nombre = new StringBuilder(medicamento.getNombre());
			nombre.setLength(TAM_NOMBRE);
			farmacia.writeChars(nombre.toString());
			farmacia.writeDouble(medicamento.getPrecio());
			farmacia.writeInt(medicamento.getCod());
			farmacia.writeInt(medicamento.getStock());
			farmacia.writeInt(medicamento.getStockMaximo());
			farmacia.writeInt(medicamento.getStockMinimo());
			farmacia.writeInt(medicamento.getCodProveedor());
			
			
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}
	

	@Override
	public Medicamento buscar(int codigo) {
	
		int posicion = (codigo) * TAM_REGISTRO;
		char letra;
		double precio = 0;
		int stock = 0, stockMaximo = 0, stockMinimo = 0, codProveedor = 0, cod = 0;
		String nombre = "";
		
		Medicamento medicamento = new Medicamento();
		
		try (RandomAccessFile farmacia = new RandomAccessFile(FICHERO, "r")) {
			
			if (posicion < farmacia.length()) {
				//posiciono el puntero
				farmacia.seek(posicion);
				
				for (int i = 0; i < TAM_NOMBRE; i++) {
					letra = farmacia.readChar();
					nombre += letra != 0 ? letra : ' ';

				}
				
				precio = farmacia.readDouble();
				cod = farmacia.readInt();
				stock = farmacia.readInt();
				stockMaximo = farmacia.readInt();
				stockMinimo = farmacia.readInt();
				codProveedor = farmacia.readInt();	
	
			
			medicamento = new Medicamento(nombre, precio, codigo, stock, stockMaximo, stockMinimo, codProveedor);
			
			} 
		
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return medicamento;
	}
	

	@Override
	public boolean actualizar(Medicamento medicamento) {
		
		try {
			System.out.println("Introduce el nuevo precio del medicamento " + medicamento.getNombre() + "(formato ejemplo: 7.9)");
			medicamento.setPrecio(Double.parseDouble(sc.nextLine()));
			
			System.out.println("Datos del medicamento con el precio actualizado: ");
			guardar(medicamento);
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
		return true;
	}

	@Override
	public boolean borrar(Medicamento medicamento) {
		
		try (RandomAccessFile farmacia = new RandomAccessFile(FICHERO, "rw")){
			int posicion = medicamento.getCod() * TAM_REGISTRO;
			farmacia.seek(posicion);
			
			for (int i = posicion-1; i < (posicion + TAM_REGISTRO) ; i++) {
				farmacia.write(0);
			}
			
			
			
		} catch (Exception e) {
			return false;
		}
		
	
		
		return true;
	}

}
