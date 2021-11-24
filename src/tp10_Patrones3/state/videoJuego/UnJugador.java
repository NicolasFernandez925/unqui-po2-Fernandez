package tp10_Patrones3.state.videoJuego;

public class UnJugador implements EstadoDelJuego {

	@Override
	public String inicio(MaquinaDeVideoJuego maquina) {
		maquina.cambiarEstado(new SinFichas());
		return "La partida para 1 jugador ya esta en juego.";
		
	}

	@Override
	public String ingresarFicha(int ficha, MaquinaDeVideoJuego maquina) {
		return "Error, no se puede volver a iniciar un juego para 1 jugador. Termine su partida luego vuelva a introducir fichas.";	
	}

}
