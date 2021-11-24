package tp9.templateMethod.sueldosRecargados;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp9_Patrones2.templateMethod.ejercicio2_SueldosRecargados.Pasante;
import tp9_Patrones2.templateMethod.ejercicio2_SueldosRecargados.Planta;

class PlantaTest {
	
	Planta planta;
	int cantidadHijos;
	

	@BeforeEach
	void setUp() throws Exception {
		cantidadHijos = 5;
		planta = new Planta(cantidadHijos);
	}
	
	@Test
	void testSueldoBrutoDeUnEmpleadoPlanta() {
		assertEquals(planta.sueldoBruto(), 3750);
	}

	@Test
	void testGetCantidadDeHijos() {
		assertEquals(planta.getCantidadHijos(), cantidadHijos);
	}
	
	@Test
	void testGetSueldo() {
		assertEquals(planta.getSueldoBasico(), 3000);
	}
	

	@Test
	void testPlusPorHijo() {
		assertEquals(planta.getPlusPorHijo(), 150);
	}


}
