
import org.junit.*;

import dao.MedicamentoAleatorio;
import modelo.Medicamento;

public class Pruebas {

	private MedicamentoAleatorio med = new MedicamentoAleatorio();
	private Medicamento medicamento = new Medicamento("Ibuprofeno", 2.00, 1, 23, 25, 10, 546);
	private String FICHERO = "farmacia.bin";
   

	@Test
	public void testGuardar() {
		Assert.assertTrue(med.guardar(medicamento));
	}

	
	@Test
	public void testBuscar() {
		Assert.assertEquals(medicamento, med.buscar(1));
	}
	
	
	@Test
	public void testActualizar() {
		Assert.assertTrue(med.actualizar(medicamento));
	}
	
	
	@Test
	public void testBorrar() {
		Assert.assertTrue(med.borrar(medicamento));
	}
	
}
