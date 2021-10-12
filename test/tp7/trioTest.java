package tp7;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp7_tdd.Carta;
import tp7_tdd.Valor;
import tp7_tdd.tipoDeJuego;
import tp7_tdd.juegos.Trio;

class trioTest {
	
	Trio trio;
	Carta carta1;
	Carta carta2;

	List<Carta> cartas;

	@BeforeEach
	void setUp() throws Exception {
		carta1 = mock(Carta.class); // DOC
		carta2 = mock(Carta.class); // DOC
		trio = new Trio(); // SUT
		cartas = Arrays.asList(carta1, carta1, carta1, carta2, carta2);
	}

	@Test
	void testCuandoHayPokerDadaUnaListaDeCartas() {
			
		// Setup
		when(carta1.getValor()).thenReturn(Valor.Rey);
		when(carta2.getValor()).thenReturn(Valor.Reina);
		
		// Exercise
		Boolean esTrio = trio.esTrio(cartas);
			
		// Verify
		assertTrue(esTrio);
		verify(carta1, atLeast(1)).getValor();
	
	}
	
	@Test
	void testDeLaMejorJugadaDadaUnaListaDeCartas() {
		
		// Setup
		when(carta1.getValor()).thenReturn(Valor.Rey);
		when(carta2.getValor()).thenReturn(Valor.Reina);
		
		// Exercise
		tipoDeJuego mejorJugada = trio.mejorJugada(cartas);
			
		// Verify
		assertEquals(mejorJugada, tipoDeJuego.Trio);
	
	}

}
