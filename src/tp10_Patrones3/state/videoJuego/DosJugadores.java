package tp10_Patrones3.state.videoJuego;

public class DosJugadores implements EstadoDelJuego {

	@Override
	public String inicio(MaquinaDeVideoJuego maquina) {
		maquina.cambiarEstado(new SinFichas());
		return "La partida para 2 jugadores ya esta en juego.";
		
	}

	@Override
	public String ingresarFicha(int ficha, MaquinaDeVideoJuego maquina) {
		return "Error, no se puede volver a iniciar un juego. Termine su partida luego vuelva a introducir fichas.";		
	}
}
