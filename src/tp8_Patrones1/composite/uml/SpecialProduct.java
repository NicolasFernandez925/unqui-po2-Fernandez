package tp8_Patrones1.composite.uml;

public class SpecialProduct extends Producto {

	public SpecialProduct(String name, double price) {
		super(name, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getPrice() {
		return this.price;
	}
}
