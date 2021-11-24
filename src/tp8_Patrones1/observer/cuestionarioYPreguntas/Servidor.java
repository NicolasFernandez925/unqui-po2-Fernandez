package tp8_Patrones1.observer.cuestionarioYPreguntas;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Servidor implements Subject {
	
	private Set<IJugador> jugadores;
	private Map<IJugador, Integer> JugadoresYSusPuntos;
	private Cuestionario cuestionario;
	private EstadoDelJuego estado;
	
	public Servidor(Cuestionario cuestionario) {
		this.cuestionario = cuestionario;
		this.JugadoresYSusPuntos = new HashMap<IJugador, Integer>();
		this.jugadores = new HashSet<IJugador>();
		this.estado = new EsperandoJugadores(this);
	}
	
	public Set<IJugador> getJugadores() {
		return this.jugadores;
	}
	
	public void setEstado(EstadoDelJuego estadoNuevo) {
		this.estado = estadoNuevo;
	}
	
	
	public void verificarRespuesta(Pregunta pregunta, String respuesta, IJugador jugador) throws Exception {
		this.estado.recibirRespuesta(pregunta, respuesta, jugador);
		
	}
	
	public boolean esRespuestaCorrecta(Pregunta pregunta, String respuesta) {
		return pregunta.getRespuesta() == respuesta;
	}
	
	public void computarRespuestCorrecta(Pregunta Pregunta, IJugador jugador) throws Exception {
		this.sumarPuntos(jugador);	
		if(this.esGanador(jugador)) {
			this.anunciarFinDelJuego(jugador);
		}
	}
	
	public void iniciar() throws Exception {
		this.estado.iniciar();
	}
	
	public void anunciarFinDelJuego(IJugador jugador) throws Exception  {
		this.estado.finDelJuego(jugador);
	}
	
	private boolean esGanador(IJugador jugador) {
		return this.JugadoresYSusPuntos.get(jugador) == cuestionario.cantidadDePreguntas();
	}
	
	private void sumarPuntos(IJugador jugador) {
		int puntajeJugador = this.JugadoresYSusPuntos.get(jugador) + 1;
		this.JugadoresYSusPuntos.put(jugador, puntajeJugador);

	}

	@Override
	public void sacarJugador(IJugador jugador) {
		this.jugadores.remove(jugador);
		
	}
	
	public void participanteConPuntajeInicial(IJugador jugador) {
		this.JugadoresYSusPuntos.put(jugador, 0);
	}
	
	@Override
	public void nuevoParticipante(IJugador jugador) {
		this.jugadores.add(jugador);
		
	}

	@Override
	public void notificarPreguntaCorrecta(IJugador jugador, Pregunta pregunta) {
		jugador.preguntaCorrecta(pregunta);
		
	}

	@Override
	public void notificarPreguntaCorrectaATodos(IJugador jugador, Pregunta pregunta) {
		this.jugadores.stream().forEach( j -> j.preguntaRespondida(jugador, pregunta.getNombre()));
		
	}

	@Override
	public void notificarRespuestIncorrecta(IJugador jugador, Pregunta pregunta) {
		jugador.preguntaIncorrecta(pregunta);
		
	}

	@Override
	public void notificarATodosElGanador(IJugador jugador) {
		this.jugadores.stream().forEach(j -> j.finDeLaPartida(jugador.nombreJugador()));
		
	}

	@Override
	public void notificarParticipantesComienzoDeJuego(){
		List<Pregunta> preguntas = this.cuestionario.getPreguntas();	
		this.jugadores.stream().forEach(j -> j.inicioDePartida(preguntas));		
	}
	
}
