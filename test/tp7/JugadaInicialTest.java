package tp7;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp7_tdd.Carta;
import tp7_tdd.JugadaInicial;
import tp7_tdd.Palo;
import tp7_tdd.Valor;
import tp7_tdd.tipoDeJuego;

class JugadaInicialTest {

	JugadaInicial jugadaInicial;
	Carta carta;
	Carta carta1;
	Carta carta2;
	
	@BeforeEach
	void setUp() throws Exception {
		carta = mock(Carta.class); // DOC	
		carta1 = mock(Carta.class); // DOC	
		carta2 = mock(Carta.class); // DOC	
		
		jugadaInicial = new JugadaInicial(); // SUT

	}
	
	// TEST JUEGO COLOR

	@Test
	void testCuandoHayColorDadaUnaListaDeCartas() {
		List<Carta> cartasColor = Arrays.asList(carta, carta, carta, carta, carta);
		// Setup
		when(carta.getPalo()).thenReturn(Palo.Diamante);
		when(carta.getValor()).thenReturn(Valor.As);
			
		// Exercise
		Boolean esColor = jugadaInicial.esColor(cartasColor);
		
		// Verify
		assertTrue(esColor);
		verify(carta, atLeast(1)).getPalo();
	
	}
	
	@Test
	void testDeLaMejorJugadaEsColorDadaUnaListaDeCartas() {
		List<Carta> cartasColor = Arrays.asList(carta, carta, carta, carta, carta);
		
		// Setup
		when(carta.getPalo()).thenReturn(Palo.Diamante);	
		
		when(carta.getValor()).thenReturn(Valor.Cuatro);
		
		// Exercise
		tipoDeJuego mejorJugada = jugadaInicial.mejorJugada(cartasColor);
			
		// Verify
		assertEquals(mejorJugada, tipoDeJuego.Color);
	
	}
	
	// TEST JUEGO POKER
	
	@Test
	void testCuandoHayPokerDadaUnaListaDeCartas() {
		
		List<Carta> cartasPoker = Arrays.asList(carta1, carta1, carta1, carta1, carta2);

		// Setup
		when(carta1.getValor()).thenReturn(Valor.As);
		when(carta2.getValor()).thenReturn(Valor.Reina);
		
		//Exercise
		Boolean esPoker = jugadaInicial.esPoker(cartasPoker);
		
		// Verify
		assertTrue(esPoker);
		verify(carta1, atLeast(1)).getValor();
	
	}
	
	@Test
	void testDeLaMejorJugadaEsPokerDadaUnaListaDeCartas() {
		
		List<Carta> cartasPoker = Arrays.asList(carta1, carta1, carta1, carta1, carta2);

		// Setup
		when(carta1.getValor()).thenReturn(Valor.As);
		when(carta2.getValor()).thenReturn(Valor.Reina);
		
		//Exercise
		tipoDeJuego mejorJugada = jugadaInicial.mejorJugada(cartasPoker);
			
		// Verify
		assertEquals(mejorJugada, tipoDeJuego.Poker);
	
	}
	
	// TEST JUEGO TRIO
	
	@Test
	void testCuandoHayTrioDadaUnaListaDeCartas() {
		
		List<Carta> cartasTrio = Arrays.asList(carta1, carta1, carta1, carta2, carta2);
			
		// Setup
		when(carta1.getValor()).thenReturn(Valor.Rey);
		when(carta2.getValor()).thenReturn(Valor.Reina);
		
		// Exercise
		Boolean esTrio = jugadaInicial.esTrio(cartasTrio);
			
		// Verify
		assertTrue(esTrio);
		verify(carta1, atLeast(1)).getValor();
	
	}
	
	@Test
	void testDeLaMejorJugadaEsTrioDadaUnaListaDeCartas() {
		
		List<Carta> cartasTrio = Arrays.asList(carta1, carta1, carta1, carta2, carta2);
		
		// Setup
		when(carta1.getValor()).thenReturn(Valor.Rey);
		when(carta2.getValor()).thenReturn(Valor.Reina);
		
		
		when(carta1.getPalo()).thenReturn(Palo.Diamante);
		when(carta2.getPalo()).thenReturn(Palo.Pica);
		
		// Exercise
		tipoDeJuego mejorJugada = jugadaInicial.mejorJugada(cartasTrio);
			
		// Verify
		assertEquals(mejorJugada, tipoDeJuego.Trio);
	
	}

}
