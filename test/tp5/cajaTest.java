package tp5;
import tp5_interfaces.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class cajaTest {

	Caja caja;
	Agencia agenciaEdesur;
	Producto leche;
	Producto tomate;
	ProductoDeCooperativa carne;
	FacturaServicio luz;
	FacturaImpuesto arba;
	
	@BeforeEach
	void setUp() throws Exception {
		
		agenciaEdesur = new Agencia("Edesur");
		caja = new Caja();	
		leche = new ProductoDeEmpresa(50.0,10);
		tomate = new ProductoDeCooperativa(20.0,5);
		carne = new ProductoDeCooperativa(130.0,5);
		luz = new FacturaServicio(10,5, agenciaEdesur);
		arba = new FacturaImpuesto(500, agenciaEdesur);
		
		caja.registrarPagable(leche);
		caja.registrarPagable(tomate);
		caja.registrarPagable(carne);
		caja.registrarPagable(luz);
		caja.registrarPagable(arba);
		
	}
	
	@Test
	void pruebaMontoTotalIPagables() {
		assertEquals(caja.montoTotalAPagar(),735.d);
	}
	
	@Test
	void cantidadDeIPagablesEnLaCaja() {
		assertEquals(caja.getCantidadPagables(), 5);
	}
	
	@Test
	void stockCajaConProductosLuegoDeRegistrar() {
		assertEquals(leche.getStock(),9);
		assertEquals(tomate.getStock(),4);
		assertEquals(carne.getStock(),4);
	}
	
}


