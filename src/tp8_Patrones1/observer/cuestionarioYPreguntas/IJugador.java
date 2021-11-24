package tp8_Patrones1.observer.cuestionarioYPreguntas;

import java.util.List;

public interface IJugador {
	
	public void preguntaRespondida(IJugador jugador, String nombreJugador);

	public void preguntaIncorrecta(Pregunta pregunta);

	public void preguntaCorrecta(Pregunta pregunta);

	public void finDeLaPartida(String nombreJugador);

	public void inicioDePartida(List<Pregunta> preguntas);

	public String nombreJugador();

}
