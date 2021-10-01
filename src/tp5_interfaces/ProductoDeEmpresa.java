package tp5_interfaces;

public class ProductoDeEmpresa extends Producto {

	public ProductoDeEmpresa(double precio, int stock) {
		
		this.setStock(stock);
		this.setPrecio(precio);
		
	}

	@Override
	public double montoAPagar() {
		return this.getPrecio();
	}

}
