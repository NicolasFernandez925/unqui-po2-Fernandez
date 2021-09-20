package tp4.supermercado;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp4_introAJava2.producto.Producto;
import tp4_introAJava2.producto.ProductoPrimeraNecesidad;
import tp4_introAJava2.supermercado.Supermercado;

class supermercadoTest {

	private Producto arroz;
	private Producto detergente;
	private ProductoPrimeraNecesidad alfajor;
	private Supermercado supermercado;
	
	@BeforeEach
	public void setUp() {
		arroz = new Producto("Arroz", 18.9d, true);
		detergente = new Producto("Detergente", 75d);
		supermercado = new Supermercado("Lo de Tito", "Av Zubeldia 801");
		alfajor = new ProductoPrimeraNecesidad("Detergente", 75d,true,0.9);
	}
	
	@Test
	public void testCantidadDeProductos() {
		assertEquals(0, supermercado.getCantidadDeProductos());
		supermercado.agregarProducto(arroz);
		supermercado.agregarProducto(detergente);
		supermercado.agregarProducto(alfajor);
		assertEquals(3, supermercado.getCantidadDeProductos());
	}
	
	@Test
	public void testPrecioTotal() {	
		assertEquals(Double.valueOf(0), supermercado.getPrecioTotal());
		supermercado.agregarProducto(arroz);
		supermercado.agregarProducto(detergente);
		assertEquals(Double.valueOf(93.9), supermercado.getPrecioTotal());
	}

}
