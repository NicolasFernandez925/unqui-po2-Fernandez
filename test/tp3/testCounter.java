package tp3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp3_introAJava1.counter.Counter;

class testCounter {
	
	private Counter counter;

	@BeforeEach
	public void setUp() throws Exception {
		counter = new Counter();
		counter.addNumber(1);
		counter.addNumber(3);
		counter.addNumber(5);
		counter.addNumber(7);
		counter.addNumber(9);
		counter.addNumber(1);
		counter.addNumber(1);
		counter.addNumber(1);
		counter.addNumber(1);
		counter.addNumber(4);
	}
	
	@Test
	public void cantidadDeImpares() {
		int amount = counter.cantidadDeImpares();	
		assertEquals(amount, 9);
	}
	
	@Test
	public void cantidadDePares() {
		int amount = counter.cantidadDePares();	
		assertEquals(amount, 1);
	}
	
	@Test
	public void cantidadMultiplosDeXNumero() {
		int amount = counter.cantidadDeMultiplosDe(3);	
		assertEquals(amount, 2);
	}

	@Test
	public void multiplos() {
		int amount = counter.multiplos(3, 2);	
		assertEquals(amount, 996);
	}

}
