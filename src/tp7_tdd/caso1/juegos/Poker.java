package tp7_tdd.caso1.juegos;

import java.util.List;
import java.util.stream.Collectors;

import tp7_tdd.caso1.Carta;
import tp7_tdd.caso1.JugadaInicial;
import tp7_tdd.caso1.tipoDeJuego;

public class Poker extends JugadaInicial{

	public Poker() {
		this.setTipoJugada(tipoDeJuego.Poker);
	}
	
	public boolean esPoker(List<Carta> mano) {
		return mano.stream().anyMatch(carta -> this.hayPoker(carta, mano));
	}
	
	public boolean hayPoker(Carta carta, List<Carta> mano) {

		return mano.stream().filter(carta2 -> carta.getValor().equals(carta2.getValor())).collect(Collectors.toList()).size() == 4;
	}

	@Override
	public tipoDeJuego mejorJugada(List<Carta> cartas) {
		if(!this.esPoker(cartas)) {
			setTipoJugada(new Color().mejorJugada(cartas));
		}
		
		return this.getTipoJugada();
		
	}
	
}
