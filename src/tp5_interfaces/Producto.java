package tp5_interfaces;

public abstract class Producto implements IPagable {
	
	protected double precio;
	protected int stock;

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getPrecio() {
		return precio;
	}

	public int getStock() {
		return stock;
	}
	
	public void setStock(int stock) {
		this.stock = stock; 
	}

	abstract public double montoAPagar();
    
	public void decrementarStock() {	
			this.stock -= 1;	
	}

	@Override
	public void registrar() throws Exception  {
		if(this.stock < 1) {
			throw new Exception("No se puede registrar el " + this.toString() + "porque no hay mas stock.");
		}
		this.decrementarStock();
	}
		
}
