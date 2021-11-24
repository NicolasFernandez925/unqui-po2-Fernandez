package tp8_Patrones1.observer.cuestionarioYPreguntas;

public class EnJuego extends EstadoDelJuego {
	
	public EnJuego(Servidor servidor) {
		super(servidor);
	}
	
	@Override
	public void recibirRespuesta(Pregunta pregunta, String respuesta, IJugador jugador) throws Exception {
		
		if(servidor.esRespuestaCorrecta(pregunta, respuesta)) {
			//Notifico solamente al jugador la respuesta correcta
			this.servidor.notificarPreguntaCorrecta(jugador, pregunta);
			//Notifico solamente a todos los jugadores la respuesta correcta
			this.servidor.notificarPreguntaCorrectaATodos(jugador, pregunta);
			// computo los puntos al jugador que respondio correcto
			this.servidor.computarRespuestCorrecta(pregunta, jugador);
		}
		else {
			this.servidor.notificarRespuestIncorrecta(jugador, pregunta);
		}
	} 

	@Override
	public void finDelJuego(IJugador jugador) {
		this.servidor.setEstado(new EsperandoJugadores(this.getServidor()));
		this.servidor.notificarATodosElGanador(jugador);
	}
}
