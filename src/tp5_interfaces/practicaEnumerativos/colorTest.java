package tp5_interfaces.practicaEnumerativos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.Test;

class colorTest {

	private ActividadSemanal actividad;
	@Test
	void pruebaDeMaduracion() {
		assertTrue(Color.AMARILLO.proximoColorMaduracion() == Color.valueOf("GRIS"));
	}
	
	@Test
	void nivelDeRiesgo() {
		//actividad = new ActividadSemanal(DiaDeLaSemana.JUEVES, LocalTime.now(),3,Deporte.FUTBOL);
		//System.out.println(actividad.toString() + LocalTime.now());

		assertTrue(Color.ROJO.getNivelDeRiesto() == 4);
		assertFalse(Color.ROJO.getNivelDeRiesto() == 10);
	}

}
