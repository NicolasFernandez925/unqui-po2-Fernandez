package tp7_tdd.caso1;

import java.util.List;

public abstract class JugadaInicial {
	
	protected tipoDeJuego tipoJugada;
	public abstract tipoDeJuego mejorJugada(List<Carta> cartas);

	protected tipoDeJuego getTipoJugada() {
		return tipoJugada;
	}

	protected void setTipoJugada(tipoDeJuego tipoJugada) {
		this.tipoJugada = tipoJugada;
	}
}
