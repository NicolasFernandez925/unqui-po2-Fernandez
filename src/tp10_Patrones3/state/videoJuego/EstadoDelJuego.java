package tp10_Patrones3.state.videoJuego;

public interface EstadoDelJuego {
	String inicio(MaquinaDeVideoJuego maquina);
	String ingresarFicha(int ficha,MaquinaDeVideoJuego maquina);
}
