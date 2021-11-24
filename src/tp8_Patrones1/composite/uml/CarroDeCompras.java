package tp8_Patrones1.composite.uml;

import java.util.ArrayList;
import java.util.List;

public class CarroDeCompras {

	private List<Producto> productos;
	
	public CarroDeCompras() {
		this.productos = new ArrayList<Producto>();
	}
	
	public List<Producto> getElements(){
		return this.productos;
	}
	
	public int totalRounded() {
		return (int) Math.round(this.total());
	}
	
	public double total() {
		return productos.stream().mapToDouble(p -> p.getPrice()).sum();
	}
}
