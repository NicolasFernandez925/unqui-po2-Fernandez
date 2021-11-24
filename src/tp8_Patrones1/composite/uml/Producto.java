package tp8_Patrones1.composite.uml;

public class Producto {

	protected double price;
	protected String name;
	
	public Producto(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public String getName() {
		return this.name;
	}
}
