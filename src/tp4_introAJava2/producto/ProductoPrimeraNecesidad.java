package tp4_introAJava2.producto;

public class ProductoPrimeraNecesidad extends Producto {
	
	private double descuento = 0.9;
	
	public ProductoPrimeraNecesidad(String nombre, double precio,double descuento) {
		super(nombre, precio);
		this.descuento = descuento;
		
	}
	
	public ProductoPrimeraNecesidad(String nombre, double precio, boolean esPrecioCuidado, double descuento) {
		super(nombre, precio, esPrecioCuidado);
		this.descuento = descuento;
		
	}
	
	@Override
	public double getPrecio() {
		return super.getPrecio() * this.descuento;
	}
}
