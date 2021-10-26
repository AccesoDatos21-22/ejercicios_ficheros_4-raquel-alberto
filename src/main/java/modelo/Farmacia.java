package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.MedicamentoDAO;

public class Farmacia implements MedicamentoDAO {
	
	private List<Medicamento> medicamentos = new ArrayList<Medicamento>();
	
	Scanner sc = new Scanner(System.in);

	/**
	 * Constructor de la farmacia
	 */
	public Farmacia() {

	}

	@Override
	public boolean guardar(Medicamento medicamento) {
		medicamentos.add(medicamento);
		return false;
	}

	@Override
	public boolean borrar(Medicamento medicamento) {
		medicamentos.remove(medicamento);
		return false;
	}


	@Override
	public Medicamento buscar(int codigo) {
		
		for (Medicamento medicamento : medicamentos) {
			if (medicamento.getCod() == codigo) {
				return medicamento;
			}
		}
		
		return null;
	}

	@Override
	public boolean actualizar(Medicamento medicamento) {
		
		System.out.println("Introduce el nuevo precio del medicamento " + medicamento.getNombre() + "(formato ejemplo: 7.9)");
		medicamento.setPrecio(Double.parseDouble(sc.nextLine()));
		
		System.out.println("Datos del medicamento con el precio actualizado: ");
		guardar(medicamento);
		return false;
	}
	
	public List<Medicamento> leermedicamentos(){
		
		return medicamentos;
		
	}
}
