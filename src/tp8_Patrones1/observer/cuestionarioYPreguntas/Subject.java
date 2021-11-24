package tp8_Patrones1.observer.cuestionarioYPreguntas;

public interface Subject {
	
	public void sacarJugador(IJugador jugadoor);

	public void  nuevoParticipante(IJugador jugador);

	public void  notificarPreguntaCorrecta(IJugador Jugador,Pregunta pregunta);

	public void  notificarPreguntaCorrectaATodos(IJugador Jugador,  Pregunta pregunta);

	public void  notificarATodosElGanador(IJugador jugador);
	
	public void notificarParticipantesComienzoDeJuego();

	public void notificarRespuestIncorrecta(IJugador jugador, Pregunta pregunta);
}
