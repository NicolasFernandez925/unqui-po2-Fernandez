package tp7_tdd.juegos;

import java.util.List;
import java.util.stream.Collectors;

import tp7_tdd.Carta;
import tp7_tdd.JugadaInicial;
import tp7_tdd.tipoDeJuego;

public class Trio extends JugadaInicial {
	
	public Trio() {
		this.setTipoJugada(tipoDeJuego.Trio);
	}
	
	public boolean esTrio(List<Carta> mano) {
		return mano.stream().anyMatch(carta -> this.hayTrio(carta, mano));
		
	}

	public boolean hayTrio(Carta carta, List<Carta> mano) {
		return mano.stream().filter(carta2 -> carta.getValor().equals(carta2.getValor())).collect(Collectors.toList()).size() == 3;
	}

	@Override
	public tipoDeJuego mejorJugada(List<Carta> cartas) {
		if(!this.esTrio(cartas)) {
			this.setTipoJugada(new Nada().mejorJugada(cartas));
		}
	
		return this.getTipoJugada();
		
	}
}
