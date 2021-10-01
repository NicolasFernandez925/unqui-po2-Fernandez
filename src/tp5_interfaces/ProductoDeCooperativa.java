package tp5_interfaces;

public class ProductoDeCooperativa extends Producto {
	
	private double iva;
	
	public ProductoDeCooperativa(double precio, int stock) {
		this.setIva(0.1);
		this.setPrecio(precio);
		this.setStock(stock);
	}
	
	@Override
	public double montoAPagar() {
		return this.getPrecio() - this.getIva();
	}
	
	public void setIva(double iva) {
		this.iva = iva;
	}
	
	public double getIva() {
		return this.getPrecio() * this.iva;
	}
	
}
