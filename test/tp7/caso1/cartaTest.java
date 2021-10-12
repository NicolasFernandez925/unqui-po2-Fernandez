package tp7.caso1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp7_tdd.caso1.Carta;
import tp7_tdd.caso1.Palo;
import tp7_tdd.caso1.Valor;

class cartaTest {
	
	Carta carta1;
	Carta carta2;

	@BeforeEach
	void setUp() throws Exception {
		carta1 = new Carta(Valor.As, Palo.Diamante);
		carta2 = new Carta(Valor.Reina, Palo.Diamante);
	}

	@Test
	void testValorDeCarta1EsMayorQueValorDeCarta2() {
		assertTrue(carta1.mayorValor(carta2));
	}
	
	@Test
	void testPaloDeCarta1EsIgualAlPaloDeCarta2() {
		assertTrue(carta1.mayorValor(carta2));
	}

}
