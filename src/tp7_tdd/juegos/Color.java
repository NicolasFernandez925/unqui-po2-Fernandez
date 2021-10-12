package tp7_tdd.caso1.juegos;

import java.util.List;
import java.util.stream.Collectors;

import tp7_tdd.caso1.Carta;
import tp7_tdd.caso1.JugadaInicial;
import tp7_tdd.caso1.tipoDeJuego;

public class Color extends JugadaInicial {

	public Color() {
		this.setTipoJugada(tipoDeJuego.Color);
	}
	
	public boolean esColor(List<Carta> mano) {
		return mano.stream().anyMatch(carta -> this.hayColor(carta, mano));
	}
	
	public boolean hayColor(Carta carta, List<Carta> mano) {

		return mano.stream().filter(carta2 -> carta.getPalo().equals(carta2.getPalo())).collect(Collectors.toList()).size() == 5;
	}
	
	@Override
	public tipoDeJuego mejorJugada(List<Carta> cartas) {
		if(!this.esColor(cartas)) {
			this.setTipoJugada(new Trio().mejorJugada(cartas));
		}
	
		return this.getTipoJugada();
		
	}

}
