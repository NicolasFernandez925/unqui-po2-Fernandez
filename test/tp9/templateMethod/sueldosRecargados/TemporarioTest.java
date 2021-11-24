package tp9.templateMethod.sueldosRecargados;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp9_Patrones2.templateMethod.ejercicio2_SueldosRecargados.Planta;
import tp9_Patrones2.templateMethod.ejercicio2_SueldosRecargados.Temporario;

class TemporarioTest {
	
	Temporario temporario;
	Boolean estaCasado;
	Boolean tieneHijos;
	int horasQueTrabajo;
	
	@BeforeEach
	void setUp() throws Exception {
		estaCasado = true;
		horasQueTrabajo = 10;
		tieneHijos = true;
		temporario = new Temporario(estaCasado, tieneHijos, horasQueTrabajo);
	}
	
	@Test
	void testSueldoBrutoDeUnEmpleadoPasanteQueEstaCasadoYTieneHijos() {
		assertEquals(temporario.sueldoBruto(), 1150);
	}
	
	@Test
	void testSueldoBrutoDeUnEmpleadoPasanteQueNoEstaCasadoYTieneHijos() {
		temporario.setEstaCasado(false);
		assertEquals(temporario.sueldoBruto(), 1150);
	}
	
	@Test
	void testSueldoBrutoDeUnEmpleadoPasanteQueEstaCasadoYNoTieneHijos() {
		temporario.setTieneHijos(false);
		assertEquals(temporario.sueldoBruto(), 1150);
	}
	
	@Test
	void testSueldoBrutoDeUnEmpleadoPasanteQueNoEstaCasadoYNoTieneHijos() {
		temporario.setTieneHijos(false);
		temporario.setEstaCasado(false);
		assertEquals(temporario.sueldoBruto(), 1050);
	}

	

}
