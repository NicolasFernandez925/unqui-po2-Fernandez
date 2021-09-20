package tp3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp3_introAJava1.multiOperador.MultiOperador;

class testMultiplicador {

	private MultiOperador multiOperador;

	@BeforeEach
	public void setUp() throws Exception {
		multiOperador= new MultiOperador();
		multiOperador.addNumber(1);
		multiOperador.addNumber(3);
		multiOperador.addNumber(5);

	}
	
	@Test
	void sumar() {
		int amount = multiOperador.sumar(multiOperador.getNumeros());	
		assertEquals(amount, 9);
	}
	
	@Test
	void restar() {
		int amount = multiOperador.restar(multiOperador.getNumeros());	
		assertEquals(amount, -9);
	}
	
	@Test
	void multiplicar() {
		int amount = multiOperador.multiplicar(multiOperador.getNumeros());	
		assertEquals(amount, 15);
	}

}
