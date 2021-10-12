package tp7_tdd.juegos;

import java.util.List;

import tp7_tdd.Carta;
import tp7_tdd.JugadaInicial;
import tp7_tdd.tipoDeJuego;

public class Nada extends JugadaInicial {

	public Nada() {
		this.setTipoJugada(tipoDeJuego.Nada);
	}
	
	@Override
	public tipoDeJuego mejorJugada(List<Carta> cartas) {
		return this.getTipoJugada();	
	}
}
