package tp7_tdd;

import java.util.List;
import java.util.stream.Collectors;

public class JugadaInicial {
	
	private tipoDeJuego tipoJugada;

	public tipoDeJuego getTipoJugada() {
		return tipoJugada;
	}

	public void setTipoJugada(tipoDeJuego tipoJugada) {
		this.tipoJugada = tipoJugada;
	}
	
	public boolean esPoker(List<Carta> mano) {
		return mano.stream().anyMatch(carta -> this.hayPoker(carta, mano));
	}
	
	public boolean hayPoker(Carta carta, List<Carta> mano) {

		return mano.stream().filter(carta2 -> carta.getValor().equals(carta2.getValor())).collect(Collectors.toList()).size() == 4;
	}
	public boolean esColor(List<Carta> mano) {
		return mano.stream().anyMatch(carta -> this.hayColor(carta, mano));
	}
	
	public boolean hayColor(Carta carta, List<Carta> mano) {

		return mano.stream().filter(carta2 -> carta.getPalo().equals(carta2.getPalo())).collect(Collectors.toList()).size() == 5;
	}
	
	public boolean esTrio(List<Carta> mano) {
		return mano.stream().anyMatch(carta -> this.hayTrio(carta, mano));
		
	}

	public boolean hayTrio(Carta carta, List<Carta> mano) {
		return mano.stream().filter(carta2 -> carta.getValor().equals(carta2.getValor())).collect(Collectors.toList()).size() == 3;
	}

	public tipoDeJuego mejorJugada(List<Carta> cartas) {
		if(this.esPoker(cartas)) {
			setTipoJugada(tipoDeJuego.Poker);
		}
		else if(this.esColor(cartas)) {
			setTipoJugada(tipoDeJuego.Color);
		}
		else if(this.esTrio(cartas)) {
			setTipoJugada(tipoDeJuego.Trio);
		}else {
			setTipoJugada(tipoDeJuego.Nada);
		}	
		return this.getTipoJugada();		
	}
}
