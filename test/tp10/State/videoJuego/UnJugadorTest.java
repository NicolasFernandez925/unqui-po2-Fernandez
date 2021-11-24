package tp10.State.videoJuego;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp10_Patrones3.state.videoJuego.MaquinaDeVideoJuego;
import tp10_Patrones3.state.videoJuego.UnJugador;

class UnJugadorTest {
	
	MaquinaDeVideoJuego maquina;
	UnJugador unJugador;
	
	String msgEsperado;

	@BeforeEach
	void setUp() throws Exception {
		
		maquina = mock(MaquinaDeVideoJuego.class);
		unJugador = new UnJugador();
	}

	@Test
	void testIniciaUnJuegoQueYaFueIniciado() {	
		msgEsperado  =  "La partida para 1 jugador ya esta en juego.";
		assertEquals(unJugador.inicio(maquina), msgEsperado);
	}
	
	@Test
	void testIngresaFichasAUnJuegoQueYaEstaEnPartida() {	
		msgEsperado  =  "Error, no se puede volver a iniciar un juego para 1 jugador. Termine su partida luego vuelva a introducir fichas.";
		int fichas = 2;	
		assertEquals(unJugador.ingresarFicha(fichas, maquina), msgEsperado);
	}
}
