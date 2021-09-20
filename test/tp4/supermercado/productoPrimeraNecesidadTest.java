package tp4.supermercado;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp4_introAJava2.producto.ProductoPrimeraNecesidad;

class productoPrimeraNecesidadTest {

	private ProductoPrimeraNecesidad leche;
	
	@BeforeEach
	public void setUp() {
		leche = new ProductoPrimeraNecesidad("Leche", 8d, false, 0.9);
	}
	
	@Test
	public void testCalcularPrecio() {
		assertEquals(Double.valueOf(7.2), leche.getPrecio());
	}

}
