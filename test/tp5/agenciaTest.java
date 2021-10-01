package tp5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp5_interfaces.Agencia;
import tp5_interfaces.Caja;
import tp5_interfaces.FacturaImpuesto;
import tp5_interfaces.FacturaServicio;
import tp5_interfaces.ProductoDeCooperativa;
import tp5_interfaces.ProductoDeEmpresa;

class agenciaTest {

	Caja caja;
	Agencia agenciaEdesur;
	FacturaServicio luz;
	FacturaImpuesto arba;
	
	@BeforeEach
	void setUp() throws Exception {
		
		agenciaEdesur = new Agencia("Edesur");
		caja = new Caja();
		luz = new FacturaServicio(10,5, agenciaEdesur);
		arba = new FacturaImpuesto(500, agenciaEdesur);
		 
		caja.registrarPagable(luz);
		caja.registrarPagable(arba);
	}

	@Test
	void cantidadDeFacturasRegistradasEnLaAgencia() {
		assertEquals(agenciaEdesur.getCantidad(),2);
	}

}
