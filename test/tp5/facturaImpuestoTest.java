package tp5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp5_interfaces.Agencia;
import tp5_interfaces.FacturaImpuesto;
import tp5_interfaces.FacturaServicio;

class facturaImpuestoTest {

	FacturaImpuesto liderar,telecentro;
	Agencia agenciaEdesur;

	@BeforeEach
	void setUp() throws Exception {
		agenciaEdesur = new Agencia("Edesur");
		telecentro = new FacturaImpuesto(50, agenciaEdesur);
		liderar = new FacturaImpuesto(200, agenciaEdesur);	
	}

	@Test
	void montoDelImpuesto() {
		assertEquals(liderar.montoAPagar(), 200);
		assertEquals(telecentro.montoAPagar(), 50);
	}
	
	@Test
	void tasaDeServicios() {
		assertEquals(liderar.montoAPagar(), 200);
		assertEquals(telecentro.montoAPagar(), 50);
	}
}
