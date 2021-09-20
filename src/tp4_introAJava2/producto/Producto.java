package tp4_introAJava2.producto;

public class Producto {

	private String nombre;
	private double precio;
	private boolean esPrecioCuidado = false;
	
	public Producto(String nombre, double precio) {
		this.nombre = nombre;
		this.precio = precio;
	}
	
	public Producto(String nombre, double precio, boolean esPrecioCuidado) {
		this.nombre = nombre;
		this.precio = precio;
		this.esPrecioCuidado = esPrecioCuidado;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public boolean esPrecioCuidado() {
		return this.esPrecioCuidado;
	}
	
	public double getPrecio() {
		return this.precio;
	}
	public void aumentarPrecio(double precio) {
		this.precio =  this.getPrecio() + precio;
	}
		
}
