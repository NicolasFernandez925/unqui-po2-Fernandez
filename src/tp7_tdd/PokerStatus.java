package tp7_tdd.caso1;

import java.util.Arrays;
import java.util.List;

import tp7_tdd.caso1.juegos.Poker;

public class PokerStatus {
	
	private JugadaInicial jugadaInicial;
	
	public PokerStatus() {
		jugadaInicial = new Poker();
	}
	
	public tipoDeJuego verificar(Carta carta1, Carta carta2, Carta carta3, Carta carta4, Carta carta5) {
		List<Carta> cartas = Arrays.asList(carta1, carta2, carta3, carta4, carta5);	
		return jugadaInicial.mejorJugada(cartas);
	}
	
	public Jugada leGana(Jugada jugada1, Jugada jugada2) {	
		tipoDeJuego jugadaJugador1 = this.verificar(jugada1.getCartas().get(0),jugada1.getCartas().get(1),jugada1.getCartas().get(2),jugada1.getCartas().get(3),jugada1.getCartas().get(4));
		tipoDeJuego jugadaJugador2 = this.verificar(jugada2.getCartas().get(0),jugada2.getCartas().get(1),jugada2.getCartas().get(2),jugada2.getCartas().get(3),jugada2.getCartas().get(4));
		Jugada ganador;
		
		/**
		 * Compruebo con el ordinal del Enum para saber cual es menor. 
		 * El mayor es de Izq a Der
		 * El nro ordinal arranca en 0
		 * Poker,Color,Trio,Nada
		 *   0     1     2    3
		 */
		
		if(jugadaJugador1.ordinal() < jugadaJugador2.ordinal()) {
			ganador = jugada1;
		}
		else if(jugadaJugador2.ordinal() < jugadaJugador1.ordinal()) {
			ganador = jugada2;
		}
		else {
			ganador = this.desempatar(jugada1, jugada2);
		}
			
		return ganador;
	}
	
	private Jugada desempatar(Jugada jugada1, Jugada jugada2) {
		/**
		 * Compruebo la carta con mayor valor
		 * El nro ordinal arranca en 0. El mayor es de Izq a Der
		 * As, Rey, Reina, Jack, Diez...
		 *  0   1     2      3     4
		 */
		Carta carta1 = jugada1.mejorCarta();
		Carta carta2 = jugada2.mejorCarta();
		return carta1.getValor().ordinal() < carta2.getValor().ordinal() ? jugada1 : jugada2;
	}

}
