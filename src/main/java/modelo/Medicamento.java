package modelo;

public class Medicamento {
	
	public final static float IVA = 0.04f;
	
	private int cod; // 4 bytes
	private String nombre; // tamaño 30, 60 bytes
	private double precio; // 8 bytes
	private int stock; // 4 bytes
	private int stockMaximo; // 4 bytes
	private int stockMinimo; // 4 bytes
	private int codProveedor; // 4 bytes
	


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public int getCod() {
		return cod;
	}


	public void setCod(int cod) {
		this.cod = cod;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	public int getStockMaximo() {
		return stockMaximo;
	}


	public void setStockMaximo(int stockMaximo) {
		this.stockMaximo = stockMaximo;
	}


	public int getStockMinimo() {
		return stockMinimo;
	}


	public void setStockMinimo(int stockMinimo) {
		this.stockMinimo = stockMinimo;
	}


	public int getCodProveedor() {
		return codProveedor;
	}


	public void setCodProveedor(int codProveedor) {
		this.codProveedor = codProveedor;
	}


	public static float getIva() {
		return IVA;
	}
	

	public Medicamento() {
		super();
	}


	public Medicamento(int cod, String nombre, double precio, int stock, int codProveedor) {
		super();
		this.cod = cod;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
		this.codProveedor = codProveedor;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Medicamento that = (Medicamento) o;
		return cod == that.cod;
	}


	@Override
	public String toString() {
		return "Código: " + cod + "\n" + "Nombre: " + nombre + "\n" + "Precio: " + precio + "\n" 
	+ "Stock: "+ stock + "\n" +  "Código de proveedor: " + codProveedor;
	}

}
