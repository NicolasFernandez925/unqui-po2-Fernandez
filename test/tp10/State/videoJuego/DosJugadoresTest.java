package tp10.State.videoJuego;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp10_Patrones3.state.videoJuego.DosJugadores;
import tp10_Patrones3.state.videoJuego.MaquinaDeVideoJuego;

class DosJugadoresTest {

	MaquinaDeVideoJuego maquina;
	DosJugadores dosJugadores;
	
	String msgEsperado;

	@BeforeEach
	void setUp() throws Exception {
		
		maquina = mock(MaquinaDeVideoJuego.class);
		dosJugadores = new DosJugadores();
	}

	@Test
	void testIniciaUnJuegoQueYaFueIniciado() {	
		msgEsperado  = "La partida para 2 jugadores ya esta en juego.";
		assertEquals(dosJugadores.inicio(maquina), msgEsperado);
	}
	
	@Test
	void testIngresaFichasAUnJuegoQueYaEstaEnPartida() {	
		msgEsperado  = "Error, no se puede volver a iniciar un juego. Termine su partida luego vuelva a introducir fichas.";		
		int fichas = 2;	
		assertEquals(dosJugadores.ingresarFicha(fichas, maquina), msgEsperado);
	}

}
