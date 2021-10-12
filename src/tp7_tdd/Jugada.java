package tp7_tdd.caso1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Jugada {
	
	private List<Carta> cartas;
	
	public Jugada(Carta carta1, Carta carta2, Carta carta3, Carta carta4, Carta carta5) {
		this.cartas = Arrays.asList(carta1, carta2, carta3, carta4, carta5);
	}
	
	public List<Carta> getCartas(){
		return this.cartas;
	}
	
	public void agregarCarta(Carta carta) {
		this.cartas.add(carta);
	}
	
	/**
	 *  La carta de mayor valor en este caso es el mas chico en sentido ordinal ( De Izq a Der ).
	 *  los Enum arrancan en la posicion 0.
	 */ 
	public Carta mejorCarta() {
		return this.getCartas().stream().min(Comparator.comparing(Carta::getValor)).get();
	}
}
