package tp7_tdd.caso1.juegos;

import java.util.List;

import tp7_tdd.caso1.Carta;
import tp7_tdd.caso1.JugadaInicial;
import tp7_tdd.caso1.tipoDeJuego;

public class Nada extends JugadaInicial {

	public Nada() {
		this.setTipoJugada(tipoDeJuego.Nada);
	}
	
	@Override
	public tipoDeJuego mejorJugada(List<Carta> cartas) {
		return this.getTipoJugada();	
	}
}
