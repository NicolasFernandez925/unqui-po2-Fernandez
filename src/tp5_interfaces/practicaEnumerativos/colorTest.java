package tp5_interfaces.practicaEnumerativos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.Test;

class colorTest {

	@Test
	void testSiguienteColorDeAmarilloEsMiel() {
		assertTrue(Color.AMARILLO.proximoColorMaduracion() == Color.MIEL);
	}
	
	@Test
	void testSiguienteColorDeMielEsRojo() {
		assertTrue(Color.MIEL.proximoColorMaduracion() == Color.ROJO);
	}
	
	@Test
	void testSiguienteColorDeGrisEsAmarillo() {
		assertTrue(Color.GRIS.proximoColorMaduracion() == Color.AMARILLO);
	}
	
	@Test
	void testDeNivelDeRiesgo() {
		assertTrue(Color.ROJO.getNivelDeRiesto() == 4);
		assertFalse(Color.ROJO.getNivelDeRiesto() == 10);
	}

}
