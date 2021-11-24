package tp10.State.videoJuego;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp10_Patrones3.state.videoJuego.DosJugadores;
import tp10_Patrones3.state.videoJuego.EstadoDelJuego;
import tp10_Patrones3.state.videoJuego.MaquinaDeVideoJuego;
import tp10_Patrones3.state.videoJuego.SinFichas;
import tp10_Patrones3.state.videoJuego.UnJugador;

class SinFichasTest {
	
	UnJugador unJugador;
	DosJugadores dosJugadores;
	EstadoDelJuego estadoDelJuego;
	MaquinaDeVideoJuego maquinaDeJuego;

	SinFichas sinficha;
	
	int fichas;

	@BeforeEach
	void setUp() throws Exception {
		
		unJugador = mock(UnJugador.class);
		dosJugadores = mock(DosJugadores.class);
		estadoDelJuego = mock(EstadoDelJuego.class);
		maquinaDeJuego = mock(MaquinaDeVideoJuego.class);
		
		sinficha = new SinFichas();
		
	}

	@Test
	void testInicioDeUnJuegoSinFichas() {
		String msgEsperado = "Para jugar debe introducir alemnos 1 ficha";			
		assertEquals(sinficha.inicio(maquinaDeJuego), msgEsperado);
	}
	
	@Test
	void testSeIniciaUnJuegoPara1Jugador() {
		String msgEsperado = "Se ingreso para 1 Jugador. Listo para iniciar.";
		fichas = 1;
		
		when(maquinaDeJuego.getFichas()).thenReturn(5);
	
		assertEquals(sinficha.ingresarFicha(fichas, maquinaDeJuego), msgEsperado);
		
		verify(maquinaDeJuego).cambiarEstado(any(EstadoDelJuego.class));
		verify(maquinaDeJuego).descontarFicha(fichas);
	}
	
	@Test
	void testSeIniciaUnJuegoPara2Jugadores() {
		String msgEsperado = "Se ingreso para 2 Jugadores. Listo para iniciar.";
		fichas = 2;
		
		when(maquinaDeJuego.getFichas()).thenReturn(5);
			
		assertEquals(sinficha.ingresarFicha(fichas, maquinaDeJuego), msgEsperado);
		
		verify(maquinaDeJuego).cambiarEstado(any(EstadoDelJuego.class));
		verify(maquinaDeJuego).descontarFicha(fichas);
	}
	
	@Test
	void testNoIniciaPorqueLaMaquinaNoTieneFichasSuficientes() {
		String msgEsperado = "La maquina no tiene mas fichas disponibles";
		fichas = 0;
		
		when(maquinaDeJuego.getFichas()).thenReturn(0);
				
		assertEquals(sinficha.ingresarFicha(fichas, maquinaDeJuego), msgEsperado);
		
		verify(maquinaDeJuego, never()).cambiarEstado(any(DosJugadores.class));
		verify(maquinaDeJuego, never()).cambiarEstado(any(UnJugador.class));
	}
	
	@Test
	void testNoIniciaElJuegoPorqueNoSeIngresaronLasFichasValidas() {
		String msgEsperado = "Ingrese: 1 ficha = Un jugador, 2 fichas = Dos jugadores";
		fichas = 5;
		
		when(maquinaDeJuego.getFichas()).thenReturn(10);
				
		assertEquals(sinficha.ingresarFicha(fichas, maquinaDeJuego), msgEsperado);
		
		verify(maquinaDeJuego, never()).cambiarEstado(any(DosJugadores.class));
		verify(maquinaDeJuego, never()).cambiarEstado(any(UnJugador.class));
	}

}
