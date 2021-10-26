package modelo;

public class Medicamento {
	
	
	/*
	 * 
	Una farmacia necesitar guardar su stock en un fichero al que pueda acceder rápidamente , 
	se desea crear un programa para la gestión de un fichero aleatorio que pueda imprimir este fichero y añadir nuevos registros
	Completar la clase JavaBean Medicamento que guardará los atributos de tipo código que será un código  secuencial que 
	comienza en uno. Nombre de tipo String y con máximo 50 caracteres, precio double, stock de tipo int y cod_proveedor de tipo int 
	que también serán secuenciales referenciando a una foreign key de proveedores.  Se tendrá en cuenta un IVA del 4%. El método equals() 
	comparará solo por código. El método toString() debe imprimir  el medicamento con la siguiente estructura de ejemplo:

	Codigo: 2
	Nombre: ASPIRINA (500 MG 20 COMPRIMIDOS )                 
	Precio: 4.65€
	Stock: 10
	Proveedor: 1

	 */
	
	
	//Atributos
	public final static float IVA = 0.04f;
	
	private String nombre; // tama�o 30, 60 bytes
	private double precio; // 8 bytes
	private int cod; // 4 bytes
	private static int cont=0;
	private int stock; // 4 bytes
	private int stockMaximo; // 4 bytes
	private int stockMinimo; // 4 bytes
	private int codProveedor; // 4 bytes
	
	
	//Constructor
	public Medicamento(String nombre, double precio, int stock, int stockMaximo, int stockMinimo,
			int codProveedor) {
		super();
		cont++;
		this.nombre = nombre;
		this.precio = precio;
		this.cod = cont;
		this.stock = stock;
		this.stockMaximo = stockMaximo;
		this.stockMinimo = stockMinimo;
		this.codProveedor = codProveedor;
	}

	public Medicamento(String nombre, double precio, int cod, int stock, int stockMaximo, int stockMinimo,
			int codProveedor) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.cod = cod;
		this.stock = stock;
		this.stockMaximo = stockMaximo;
		this.stockMinimo = stockMinimo;
		this.codProveedor = codProveedor;
	}

	public Medicamento() {
		
	}
	
	//Getters y Setters
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
	
	//equals codigo
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medicamento other = (Medicamento) obj;
		if (cod != other.cod)
			return false;
		return true;
	}

	//toString
	
	@Override
	public String toString() {
		
		return "Codigo: " + cod + "\n" +
				"Nombre: " + nombre + "\n" +
				"Precio: " + precio + "\n" +
				"Stock: " + stock + "\n" +
				"Proveedor: " + codProveedor + "\n";
	}

	
	

}
