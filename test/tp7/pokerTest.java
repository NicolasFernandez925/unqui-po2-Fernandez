package tp7;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp7_tdd.caso1.Carta;
import tp7_tdd.caso1.Valor;
import tp7_tdd.caso1.tipoDeJuego;
import tp7_tdd.caso1.juegos.Poker;

class pokerTest {
	
	Poker poker;
	Carta carta1;
	Carta carta2;
	List<Carta> cartas;

	@BeforeEach
	void setUp() throws Exception {
		carta1 = mock(Carta.class); // DOC
		carta2 = mock(Carta.class); // DOC
		poker = new Poker(); // SUT
		cartas = Arrays.asList(carta1, carta1, carta1, carta1, carta2);	
	}

	@Test
	void testCuandoHayPokerDadaUnaListaDeCartas() {

		// Setup
		when(carta1.getValor()).thenReturn(Valor.As);
		when(carta2.getValor()).thenReturn(Valor.Reina);
		
		//Exercise
		Boolean esPoker = poker.esPoker(cartas);
		
		// Verify
		assertTrue(esPoker);
		verify(carta1, atLeast(1)).getValor();
	
	}
	
	@Test
	void testDeLaMejorJugadaDadaUnaListaDeCartas() {

		// Setup
		when(carta1.getValor()).thenReturn(Valor.As);
		when(carta2.getValor()).thenReturn(Valor.Reina);
		
		//Exercise
		tipoDeJuego mejorJugada = poker.mejorJugada(cartas);
			
		// Verify
		assertEquals(mejorJugada, tipoDeJuego.Poker);
	
	}
}
