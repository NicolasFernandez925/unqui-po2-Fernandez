package tp7.caso1;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp7_tdd.caso1.Carta;
import tp7_tdd.caso1.Jugada;
import tp7_tdd.caso1.Palo;
import tp7_tdd.caso1.PokerStatus;
import tp7_tdd.caso1.Valor;
import tp7_tdd.caso1.tipoDeJuego;
import tp7_tdd.caso1.juegos.Poker;

class pokerStatusTest {
	
	PokerStatus pokerStars;
	Poker poker;
	Carta carta1;
	Carta carta2;
	Carta carta3;
	Carta carta4;
	Carta carta5;
	Jugada jugada1;
	Jugada jugada2;
	List<Carta> cartasJugador1;
	List<Carta> cartasJugador2;

	@BeforeEach
	void setUp() throws Exception {
		
		pokerStars = new PokerStatus(); // SUT
		
		carta1 = mock(Carta.class); // DOC
		carta2 = mock(Carta.class); // DOC
		carta3 = mock(Carta.class); // DOC
		carta4 = mock(Carta.class); // DOC
		carta5 = mock(Carta.class); // DOC
		
		jugada1 = mock(Jugada.class); // DOC
		jugada2 = mock(Jugada.class); // DOC
		
		poker = mock(Poker.class); // DOC		
		
	}

	@Test
	void testVerificarJugadaQueGanaConPokerATodasLasDemas() {
			
		// Setup
		when(carta1.getValor()).thenReturn(Valor.As);
		when(carta2.getValor()).thenReturn(Valor.Reina);
				
		// Exercise
		tipoDeJuego verificarJuegoGanador = pokerStars.verificar(carta1, carta1, carta1, carta1, carta2);
		
		// Verify
		assertEquals(verificarJuegoGanador, tipoDeJuego.Poker);
		
	}
	
	@Test
	void testVerificarLaJugadaQueColorLeGanaATrio() {
			
		// Setup
		when(carta1.getPalo()).thenReturn(Palo.Diamante);
		when(carta2.getPalo()).thenReturn(Palo.Diamante);
		when(carta3.getPalo()).thenReturn(Palo.Diamante);
		when(carta4.getPalo()).thenReturn(Palo.Diamante);
		when(carta5.getPalo()).thenReturn(Palo.Diamante);
		
		when(carta1.getValor()).thenReturn(Valor.As);
		when(carta2.getValor()).thenReturn(Valor.Seis);
		when(carta3.getValor()).thenReturn(Valor.Siete);
		when(carta4.getValor()).thenReturn(Valor.Reina);
		when(carta5.getValor()).thenReturn(Valor.Rey);
				
		// Exercise
		tipoDeJuego verificarJuegoGanador = pokerStars.verificar(carta1, carta2, carta3, carta4, carta5);
		
		// Verify
		assertEquals(verificarJuegoGanador, tipoDeJuego.Color);
		
	}

	
	@Test
	void testVerificarLaJugadaDeTrio() {
			
		// Setup
		when(carta1.getPalo()).thenReturn(Palo.Diamante);
		when(carta2.getPalo()).thenReturn(Palo.Trebol);
		when(carta3.getPalo()).thenReturn(Palo.Trebol);
		when(carta4.getPalo()).thenReturn(Palo.Pica);
		when(carta5.getPalo()).thenReturn(Palo.Corazon);
		
		when(carta1.getValor()).thenReturn(Valor.As);
		when(carta2.getValor()).thenReturn(Valor.As);
		when(carta3.getValor()).thenReturn(Valor.Siete);
		when(carta4.getValor()).thenReturn(Valor.As);
		when(carta5.getValor()).thenReturn(Valor.Rey);
				
		// Exercise
		tipoDeJuego verificarJuegoGanador = pokerStars.verificar(carta1, carta2, carta3, carta4, carta5);
		
		// Verify
		assertEquals(verificarJuegoGanador, tipoDeJuego.Trio);
		
	}
	
	
	@Test
	void testVerificarLaJugadaQueNoTieneNingunJuego() {
			
		// Setup
		when(carta1.getPalo()).thenReturn(Palo.Diamante);
		when(carta2.getPalo()).thenReturn(Palo.Pica);
		when(carta3.getPalo()).thenReturn(Palo.Trebol);
		when(carta4.getPalo()).thenReturn(Palo.Corazon);
		when(carta5.getPalo()).thenReturn(Palo.Diamante);
		
		when(carta1.getValor()).thenReturn(Valor.As);
		when(carta2.getValor()).thenReturn(Valor.Seis);
		when(carta3.getValor()).thenReturn(Valor.Siete);
		when(carta4.getValor()).thenReturn(Valor.Reina);
		when(carta5.getValor()).thenReturn(Valor.Rey);
				
		// Exercise
		tipoDeJuego verificarJuegoGanador = pokerStars.verificar(carta1, carta2, carta3, carta4, carta5);
		
		// Verify
		assertEquals(verificarJuegoGanador, tipoDeJuego.Nada);
		
	}
	
	@Test
	void testJugador1ConPokerLeGanaAlJugador2ConTrio() {
		
		cartasJugador1 = Arrays.asList(carta1, carta1, carta1, carta1, carta2);
		cartasJugador2 = Arrays.asList(carta3, carta3, carta3, carta4, carta4);
		
		// Setup
		when(carta1.getValor()).thenReturn(Valor.As);
		when(carta2.getValor()).thenReturn(Valor.Reina);	
		when(carta3.getValor()).thenReturn(Valor.As);
		when(carta4.getValor()).thenReturn(Valor.Reina);
		
		when(carta1.getPalo()).thenReturn(Palo.Diamante);
		when(carta2.getPalo()).thenReturn(Palo.Diamante);	
		when(carta3.getPalo()).thenReturn(Palo.Trebol);
		when(carta4.getPalo()).thenReturn(Palo.Pica);	
		
		when(jugada1.getCartas()).thenReturn(cartasJugador1);
		when(jugada2.getCartas()).thenReturn(cartasJugador2);
				
		// Exercise
		Jugada verificarJuegoGanador = pokerStars.leGana(jugada1, jugada2);
		
		// Verify
		assertEquals(verificarJuegoGanador, jugada1);
	}
	
	
	@Test
	void testJugador2ConColorLeGanaAlJugador1ConTrio() {
		
		cartasJugador1 = Arrays.asList(carta1, carta1, carta1, carta4, carta2);
		cartasJugador2 = Arrays.asList(carta3, carta3, carta3, carta3, carta3);
		
		// Setup
		when(carta1.getValor()).thenReturn(Valor.As);
		when(carta2.getValor()).thenReturn(Valor.Reina);	
		when(carta3.getValor()).thenReturn(Valor.As);
		when(carta4.getValor()).thenReturn(Valor.Reina);
		
		when(carta1.getPalo()).thenReturn(Palo.Diamante);
		when(carta2.getPalo()).thenReturn(Palo.Diamante);	
		when(carta3.getPalo()).thenReturn(Palo.Trebol);
		when(carta4.getPalo()).thenReturn(Palo.Pica);	
		
		when(jugada1.getCartas()).thenReturn(cartasJugador1);
		when(jugada2.getCartas()).thenReturn(cartasJugador2);
				
		// Exercise
		Jugada verificarJuegoGanador = pokerStars.leGana(jugada1, jugada2);
		
		// Verify
		assertEquals(verificarJuegoGanador, jugada2);
	}
	
	@Test
	void testJugador1ConPokerLeGanaAlJugador1QueNoTieneNada() {
		
		cartasJugador1 = Arrays.asList(carta1, carta1, carta1, carta1, carta2);
		cartasJugador2 = Arrays.asList(carta3, carta1, carta2, carta4, carta4);
		
		// Setup
		when(carta1.getValor()).thenReturn(Valor.As);
		when(carta2.getValor()).thenReturn(Valor.Reina);	
		when(carta3.getValor()).thenReturn(Valor.As);
		when(carta4.getValor()).thenReturn(Valor.Reina);
		
		when(carta1.getPalo()).thenReturn(Palo.Diamante);
		when(carta2.getPalo()).thenReturn(Palo.Diamante);	
		when(carta3.getPalo()).thenReturn(Palo.Trebol);
		when(carta4.getPalo()).thenReturn(Palo.Pica);	
		
		when(jugada1.getCartas()).thenReturn(cartasJugador1);
		when(jugada2.getCartas()).thenReturn(cartasJugador2);
				
		// Exercise
		Jugada verificarJuegoGanador = pokerStars.leGana(jugada1, jugada2);
		
		// Verify
		assertEquals(verificarJuegoGanador, jugada1);
	}	
	
	@Test
	void testJugador1ConPokerEmpataConJugador2PeroGanaJugador1PorTenerLaCartaMasAltaAs() {
		
		cartasJugador1 = Arrays.asList(carta1, carta1, carta1, carta1, carta2);
		cartasJugador2 = Arrays.asList(carta2, carta2, carta2, carta2, carta1);
		
		// Setup
		when(carta1.getValor()).thenReturn(Valor.As);
		when(carta2.getValor()).thenReturn(Valor.Reina);	
		when(carta3.getValor()).thenReturn(Valor.As);
		when(carta4.getValor()).thenReturn(Valor.Reina);
		
		when(carta1.getPalo()).thenReturn(Palo.Diamante);
		when(carta2.getPalo()).thenReturn(Palo.Pica);	
		when(carta3.getPalo()).thenReturn(Palo.Trebol);
		when(carta4.getPalo()).thenReturn(Palo.Pica);	
		
		when(jugada1.getCartas()).thenReturn(cartasJugador1);
		when(jugada2.getCartas()).thenReturn(cartasJugador2);
		
		when(jugada1.mejorCarta()).thenReturn(carta1);
		when(jugada2.mejorCarta()).thenReturn(carta2);
				
		// Exercise
		Jugada verificarJuegoGanador = pokerStars.leGana(jugada1, jugada2);
		
		// Verify
		assertEquals(verificarJuegoGanador, jugada1);
	}
	
	@Test
	void testJugador2ConColorEmpataConJugador1PeroGanaJugador2PorTenerLaCartaMasAltaRey() {
		
		cartasJugador1 = Arrays.asList(carta1, carta1, carta1, carta1, carta1);
		cartasJugador2 = Arrays.asList(carta3, carta3, carta3, carta3, carta3);
		
		// Setup
		when(carta1.getValor()).thenReturn(Valor.Reina);
		when(carta2.getValor()).thenReturn(Valor.Reina);	
		when(carta3.getValor()).thenReturn(Valor.Rey);
		when(carta4.getValor()).thenReturn(Valor.Reina);
		
		when(carta1.getPalo()).thenReturn(Palo.Diamante);
		when(carta2.getPalo()).thenReturn(Palo.Diamante);	
		when(carta3.getPalo()).thenReturn(Palo.Trebol);
		when(carta4.getPalo()).thenReturn(Palo.Pica);	
		
		when(jugada1.getCartas()).thenReturn(cartasJugador1);
		when(jugada2.getCartas()).thenReturn(cartasJugador2);
		
		when(jugada1.mejorCarta()).thenReturn(carta1);
		when(jugada2.mejorCarta()).thenReturn(carta3);
				
		// Exercise
		Jugada verificarJuegoGanador = pokerStars.leGana(jugada1, jugada2);
		
		// Verify
		assertEquals(verificarJuegoGanador, jugada2);
	}
	



}
