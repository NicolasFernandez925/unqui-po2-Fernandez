package tp7;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import tp7_tdd.caso1.Carta;
import tp7_tdd.caso1.Jugada;
import tp7_tdd.caso1.Valor;

class jugadaTest {
	
	Jugada jugada;
	Carta carta1;
	Carta carta2;
	Carta carta3;
	Carta carta4;
	Carta carta5;
	

	@BeforeEach
	void setUp() throws Exception {
		
		//Setup	
		carta1 = mock(Carta.class); // DOC
		carta2 = mock(Carta.class); // DOC
		carta3 = mock(Carta.class); // DOC
		carta4 = mock(Carta.class); // DOC
		carta5 = mock(Carta.class);	// DOC	
			
		jugada = new Jugada(carta1,carta2,carta3,carta4,carta5); // SUT
	}

	@Test
	void testCantidadDeCartasEnLaMano() {
		
		@SuppressWarnings("unchecked")
		ArrayList<Carta> cartas = mock(ArrayList.class);
		
		// Exercise
		cartas.add(carta1);
		cartas.add(carta2);
		cartas.add(carta3);
		cartas.add(carta4);
		cartas.add(carta5);
		
		// Verify	
		InOrder ordenCartas = inOrder(cartas);
		
		ordenCartas.verify(cartas).add(carta1);
		ordenCartas.verify(cartas).add(carta2);
		ordenCartas.verify(cartas).add(carta3);
		ordenCartas.verify(cartas).add(carta4);
		ordenCartas.verify(cartas).add(carta5);
		
		assertEquals(jugada.getCartas().size(), 5);
	
	}
	
	@Test
	void testCartaConMayorValor() {
		
		// Exercise
		when(carta1.getValor()).thenReturn(Valor.As);
		when(carta2.getValor()).thenReturn(Valor.Rey);
		when(carta3.getValor()).thenReturn(Valor.Siete);
		when(carta4.getValor()).thenReturn(Valor.Cinco);
		when(carta5.getValor()).thenReturn(Valor.Cuatro);
		
		// Verify
		assertEquals(jugada.mejorCarta(), carta1);
		
	}

}
