package tp5.enumerativos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp5_interfaces.practicaEnumerativos.ActividadSemanal;
import tp5_interfaces.practicaEnumerativos.Deporte;
import tp5_interfaces.practicaEnumerativos.DiaDeLaSemana;
import tp5_interfaces.practicaEnumerativos.Municipio;

class municipioTest {

	Municipio muni;
	ActividadSemanal actividadUno;
	ActividadSemanal actividadDos;
	ActividadSemanal actividadTres;
	
	@BeforeEach
	void setUp() throws Exception {
		 muni = new Municipio();
		 actividadUno = new ActividadSemanal(DiaDeLaSemana.SABADO, LocalTime.now(),12,Deporte.FUTBOL);
		 actividadDos = new ActividadSemanal(DiaDeLaSemana.LUNES, LocalTime.now(),13,Deporte.BASKET);
		 actividadTres = new ActividadSemanal(DiaDeLaSemana.DOMINGO, LocalTime.now(),17,Deporte.FUTBOL);	
		 
		 muni.agregarActidad(actividadDos);
		 muni.agregarActidad(actividadTres);
		 muni.agregarActidad(actividadUno);
	}
	
	@Test
	void imprimirTodos() {
		muni.imprimirActividades();
	}

	@Test
	void cantidadDeActividadesDeFutbolTest() {
		assertEquals(muni.actividadesDeFutbol().size(), 2);
	}
	
	@Test
	void cantidadDeportesConUnaComplejidadDadaTest() {
		assertEquals(muni.actividadesConComplejidad(2).size(), 3);
	}
	
	@Test
	void actividadSemanalConMenorCostoDelDeporteDadoTest() {
		assertTrue(muni.actividadSemanalConMenorCostoDelDeporte(Deporte.BASKET) == actividadDos);
		assertFalse(muni.actividadSemanalConMenorCostoDelDeporte(Deporte.BASKET) == actividadTres);
	}
	
	@Test
	void actividadSemanalDeMenorCostoDeCadaDeporte() {
		System.out.println(muni.actividadSemanalDeMenorCostoDeCadaDeporte().toString());
	}

}
