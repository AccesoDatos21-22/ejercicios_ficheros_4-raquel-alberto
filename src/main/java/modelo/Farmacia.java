package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.MedicamentoDAO;

public class Farmacia implements MedicamentoDAO {
	private List<Medicamento> medicamentos;
	
	/**
	 * Constructor de la farmacia
	 */
		
	public Farmacia() {
		medicamentos=new ArrayList<>();
	}
	
	@Override
	public boolean guardar(Medicamento medicamento) {
		return medicamentos.add(medicamento);
	}

	@Override
	public boolean borrar(Medicamento medicamento) {
		return medicamentos.remove(medicamento);
	}


	@Override
	public Medicamento buscar(int codigo) {
		for (Medicamento medicamento : medicamentos) {
			if (medicamento.getCod()==codigo) {
				return medicamento;
			}
		}
		return null;
	}
	
	

	@Override
	public boolean actualizar(Medicamento medicamento) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce el precio nuevo del medicamento");
		medicamento.setPrecio(sc.nextDouble());
		
		System.out.println("Medicamento actualizado: ");
		guardar(medicamento);
		
		sc.close();
		
		return false;
	}

	@Override
	public List<Medicamento> leerTodos() {
		return medicamentos;
	}
	
	
	
	
}
