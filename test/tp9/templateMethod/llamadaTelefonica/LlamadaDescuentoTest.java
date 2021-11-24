package tp9.templateMethod.llamadaTelefonica;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp9_Patrones2.templateMethod.ejercicio4_llamadasTelefonica.LlamadaDescuento;


class LlamadaDescuentoTest {

	LlamadaDescuento llamadaTel;
	int tiempo;
	int horaDelDia;

	@BeforeEach
	void setUp() throws Exception {
		tiempo = 10;
		horaDelDia = 12;
		llamadaTel =new LlamadaDescuento(tiempo, horaDelDia);
	}

	@Test
	void testCostoFinalConHoraPico() {
		assertEquals(llamadaTel.costoFinal(), 95f);
	}
}
