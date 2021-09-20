package tp3_introAJava1.counter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class Counter {

	private Collection<Integer> numeros = new ArrayList<Integer>();
	
	public int cantidadDePares() {
		return numeros.stream().filter(n -> (n % 2) == 0).collect(Collectors.toList()).size();    		
	}
	
	public int cantidadDeImpares() {
		return numeros.stream().filter(n -> (n % 2) != 0).collect(Collectors.toList()).size();    		
	}
	
	public int cantidadDeMultiplosDe(Integer numero) {
		return numeros.stream().filter(n -> (n % numero) == 0).collect(Collectors.toList()).size();    		
	}
	
	public void addNumber(Integer numero) {
		numeros.add(numero);	
	}
	
	
	public int multiplos(int x, int y) {
		int numMultiploMasGrande = -1;
		for(Integer i = 0; i <= 1000; i++) {
			if( i % x == 0 && i % y == 0 ) {
				numMultiploMasGrande = i;
			}
		}
		return numMultiploMasGrande;
	}
		
}
