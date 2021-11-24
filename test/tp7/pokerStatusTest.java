package tp7;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp7_tdd.Carta;
import tp7_tdd.Jugada;
import tp7_tdd.Palo;
import tp7_tdd.PokerStatus;
import tp7_tdd.Valor;
import tp7_tdd.tipoDeJuego;

class pokerStatusTest {
	
	PokerStatus pokerStars;
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
		
		// Setup
		pokerStars = new PokerStatus(); // SUT
		
		carta1 = mock(Carta.class); // DOC
		carta2 = mock(Carta.class); // DOC
		carta3 = mock(Carta.class); // DOC
		carta4 = mock(Carta.class); // DOC
		carta5 = mock(Carta.class); // DOC
		
		jugada1 = mock(Jugada.class); // DOC
		jugada2 = mock(Jugada.class); // DOC		
		
	}

	@Test
	void testVerificarJugadaQueGanaConPokerATodasLasDemas() {
			
		// Configuration exercise
		when(carta1.getValor()).thenReturn(Valor.As);
		when(carta2.getValor()).thenReturn(Valor.Reina);
				
		// Exercise
		tipoDeJuego verificarJuegoGanador = pokerStars.verificar(carta1, carta1, carta1, carta1, carta2);
		
		// Verify
		assertEquals(verificarJuegoGanador, tipoDeJuego.Poker);
		
	}
	
	@Test
	void testVerificarLaJugadaQueColorLeGanaATrio() {
			
		// Configuration exercise
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
			
		// Configuration exercise
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
			
		// Configuration exercise
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
		
		// Configuration exercise
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
		
		// Configuration exercise
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
		
		// Configuration exercise
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
		
		// Configuration exercise
		/*when(carta1.getValor()).thenReturn(Valor.Reina);
		when(carta2.getValor()).thenReturn(Valor.Reina);	
		when(carta3.getValor()).thenReturn(Valor.Rey);
		when(carta4.getValor()).thenReturn(Valor.Reina);*/
		configurationValuesCartas(Valor.Reina, Valor.Rey,Valor.Rey);
		
		/*when(carta1.getPalo()).thenReturn(Palo.Diamante);
		when(carta2.getPalo()).thenReturn(Palo.Diamante);	
		when(carta3.getPalo()).thenReturn(Palo.Trebol);
		when(carta4.getPalo()).thenReturn(Palo.Pica);*/
		configurationPalosCartas(Palo.Diamante, Palo.Diamante,Palo.Trebol,Palo.Pica);
		
		when(jugada1.getCartas()).thenReturn(cartasJugador1);
		when(jugada2.getCartas()).thenReturn(cartasJugador2);
		
		when(jugada1.mejorCarta()).thenReturn(carta1);
		when(jugada2.mejorCarta()).thenReturn(carta3);
				
		// Exercise
		Jugada verificarJuegoGanador = pokerStars.leGana(jugada1, jugada2);
		
		// Verify
		assertEquals(verificarJuegoGanador, jugada2);
	}
	
	public void configurationValuesCartas(Valor v1, Valor v2,Valor v3) {
		when(carta1.getValor()).thenReturn(v1);
		when(carta2.getValor()).thenReturn(v2);
		when(carta3.getValor()).thenReturn(v3);
	}
	
	public void configurationPalosCartas(Palo p1, Palo p2, Palo p3, Palo p4) {
		when(carta1.getPalo()).thenReturn(p1);
		when(carta2.getPalo()).thenReturn(p2);	
		when(carta3.getPalo()).thenReturn(p3);
		when(carta4.getPalo()).thenReturn(p4);
	}

	



}
