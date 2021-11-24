package tp10_Patrones3.state.videoJuego;

public class SinFichas implements EstadoDelJuego {

	@Override
	public String inicio(MaquinaDeVideoJuego maquina) {
		return "Para jugar debe introducir alemnos 1 ficha";
		
	}

	@Override
	public String ingresarFicha(int ficha, MaquinaDeVideoJuego maquina) {
		
		String msg = "La maquina no tiene mas fichas disponibles";
		
		if(maquina.getFichas() > 0) {
			if(ficha == 1) {
				msg = "Se ingreso para 1 Jugador. Listo para iniciar.";
				maquina.descontarFicha(1);
				maquina.cambiarEstado(new UnJugador());
			}
			else if (ficha == 2) {
				msg = "Se ingreso para 2 Jugadores. Listo para iniciar.";
				maquina.descontarFicha(2);
				maquina.cambiarEstado(new DosJugadores());
			} 
			else {
				msg = "Ingrese: 1 ficha = Un jugador, 2 fichas = Dos jugadores";
			}
		}
		
		return msg;	
	}

}
