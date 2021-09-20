package tp4.trabajador;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp4_introAJava2.trabajo.Ingreso;
import tp4_introAJava2.trabajo.IngresoPorHorasExtras;
import tp4_introAJava2.trabajo.Trabajador;

class trabajadorTest {

	Trabajador nicolas;
	Ingreso ingreso1;
	Ingreso ingreso2;
	IngresoPorHorasExtras ingreso3;
	
	@BeforeEach
	void setUp() throws Exception {
		nicolas = new Trabajador();
		ingreso1= new Ingreso("concepto1", 1000d);
		ingreso2 = new Ingreso("concepto2", 2000d);
		ingreso3 = new IngresoPorHorasExtras("concepto3", 3000d,5);
		nicolas.addIngreso(ingreso1);
		nicolas.addIngreso(ingreso2);
		nicolas.addIngreso(ingreso3);
	}

	@Test
	void testMontoTotalPersibido() {
		assertEquals(6000d, nicolas.getTotalPersibido());
	}
	
	@Test
	void testMontoImponible() {
		assertEquals(3000d, nicolas.getMontoImponible());
	}
	
	@Test
	void testImpuestoAPagar() {
		assertEquals(60d, nicolas.getImpuestoAPagar());
	}

}
