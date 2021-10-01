package tp5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp5_interfaces.Agencia;
import tp5_interfaces.FacturaImpuesto;
import tp5_interfaces.FacturaServicio;

class facturaServicioTest {
	
	FacturaServicio luz, arba;
	Agencia agenciaEdesur;

	@BeforeEach
	void setUp() throws Exception {
		agenciaEdesur = new Agencia("Edesur");
		luz = new FacturaServicio(10, 5, agenciaEdesur);
		arba = new FacturaServicio(500, 5, agenciaEdesur);	
	}

	@Test
	void montoDelServicio() {
		assertEquals(luz.montoAPagar(), 50);
		assertEquals(arba.montoAPagar(), 2500);
	}

}
