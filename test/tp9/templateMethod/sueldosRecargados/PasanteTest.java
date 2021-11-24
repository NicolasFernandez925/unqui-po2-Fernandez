package tp9.templateMethod.sueldosRecargados;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp9_Patrones2.templateMethod.ejercicio2_SueldosRecargados.Pasante;

class PasanteTest {
	
	Pasante pasante;
	double precioPorHora;
	int horasTrabajadas;

	@BeforeEach
	void setUp() throws Exception {
		
		precioPorHora = 20.0;
		horasTrabajadas = 5;
		pasante = new Pasante(precioPorHora, horasTrabajadas);
	}
	
	@Test
	void testSueldoBrutoDeUnEmpleadoPasante() {
		assertEquals(pasante.sueldoBruto(), 100);
	}

	@Test
	void testGetPrecioPorHora() {
		assertEquals(pasante.getPrecioPorHora(), precioPorHora);
	}
	
	@Test
	void testGetCantidadDeHoras() {
		assertEquals(pasante.getHorasTrabajadas(), horasTrabajadas);
	}

}
