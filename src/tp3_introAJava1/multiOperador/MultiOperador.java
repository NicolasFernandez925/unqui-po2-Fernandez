package tp3_introAJava1.multiOperador;

import java.util.ArrayList;
import java.util.List;

public class MultiOperador {
	
	private List<Integer> numeros = new ArrayList<Integer>();
	
	public void addNumber(int numero) {
		numeros.add(numero);
	}
	public List<Integer> getNumeros() {
		return numeros;
	}
	
	public int sumar(List<Integer> numeros) {
		return numeros.stream().reduce(0, (a,b) -> a + b);
	}
	
	public int restar(List<Integer> numeros) {
		return numeros.stream().reduce(0, (a,b) -> a - b);
	}
	
	public int multiplicar(List<Integer> numeros) {
		return numeros.stream().reduce(1, (a,b) -> a * b);
	}
}
