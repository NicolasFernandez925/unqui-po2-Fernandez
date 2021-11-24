package tp10.State.videoJuego;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp10_Patrones3.state.videoJuego.MaquinaDeVideoJuego;
import tp10_Patrones3.state.videoJuego.SinFichas;

class MaquinaDeVideoJuegoTest {
	
	MaquinaDeVideoJuego maquina;
	SinFichas sinFicha;
	int cantidadFichas;
	
	@BeforeEach
	void setUp() throws Exception {
		cantidadFichas = 2;
		sinFicha = mock(SinFichas.class);
		maquina = new MaquinaDeVideoJuego(cantidadFichas);
	}

	@Test
	void testAlIniciarLaMaquinaTieneElEstadoSinFichas() {
		assertEquals(maquina.getEstadoJuego().getClass(), sinFicha.getClass());
	}
	
	@Test
	void testAlIniciarElJuegoEnUnaMaquinaSinFichasDevuelveElMsgQueIngreseLasFichas() {
		String msgEsperado = "Para jugar debe introducir alemnos 1 ficha";
		
		when(sinFicha.inicio(maquina)).thenReturn(msgEsperado);
		
		assertEquals(maquina.iniciar(), msgEsperado);
	}
	
	@Test
	void testAlIngresar2FichaEnLaMaquinaPuedeJugarEnModoDe2Jugador() {
		String msgEsperado ="Se ingreso para 2 Jugadores. Listo para iniciar.";
		
		when(sinFicha.ingresarFicha(cantidadFichas, maquina)).thenReturn(msgEsperado);
	
		assertEquals(maquina.ingresarFichas(cantidadFichas), msgEsperado);
	}
	
	@Test
	void testAlIngresar1FichaEnLaMaquinaPuedeJugarEnModoDe1Jugador() {
		String msgEsperado ="Se ingreso para 1 Jugador. Listo para iniciar.";
		cantidadFichas = 1;
		
		when(sinFicha.ingresarFicha(cantidadFichas, maquina)).thenReturn(msgEsperado);
		
		assertEquals(maquina.ingresarFichas(cantidadFichas), msgEsperado);	
	}
	
	@Test
	void testElJugadorIngresaUnaCantidadDeFichasNoValida() {
		String msgEsperado ="Ingrese: 1 ficha = Un jugador, 2 fichas = Dos jugadores";
		int fichasNoValidaEnLaMaquina = 5;
		
		when(sinFicha.ingresarFicha(fichasNoValidaEnLaMaquina, maquina)).thenReturn(msgEsperado);
		
		assertEquals(maquina.ingresarFichas(fichasNoValidaEnLaMaquina), msgEsperado);	
	}
	
	
	@Test
	void testDescontarFichas() {
		int cantidadFichasADescontar = 1;
		maquina.descontarFicha(cantidadFichasADescontar);
		assertEquals(maquina.getFichas(), 1);
		
	}

}
