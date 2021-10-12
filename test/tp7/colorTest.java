package tp7;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp7_tdd.caso1.Carta;
import tp7_tdd.caso1.Palo;
import tp7_tdd.caso1.tipoDeJuego;
import tp7_tdd.caso1.juegos.Color;

class colorTest {	
	
	Color color;
	Carta carta;
	List<Carta> cartas;
	
	@BeforeEach
	void setUp() throws Exception {
		carta = mock(Carta.class); // DOC	
		color = new Color(); // SUT
		cartas = Arrays.asList(carta, carta, carta, carta, carta);
	}

	@Test
	void testCuandoHayColorDadaUnaListaDeCartas() {
		
		// Setup
		when(carta.getPalo()).thenReturn(Palo.Diamante);
			
		// Exercise
		Boolean esColor = color.esColor(cartas);
		
		// Verify
		assertTrue(esColor);
		verify(carta, atLeast(1)).getPalo();
	
	}
	
	@Test
	void testDeLaMejorJugadaDadaUnaListaDeCartas() {

		// Setup
		when(carta.getPalo()).thenReturn(Palo.Diamante);	
		
		// Exercise
		tipoDeJuego mejorJugada = color.mejorJugada(cartas);
			
		// Verify
		assertEquals(mejorJugada, tipoDeJuego.Color);
	
	}

}
