package tp8_Patrones1.observer.cuestionarioYPreguntas;

import java.util.ArrayList;
import java.util.List;

public class Jugador implements IJugador {
	
	private String nombre;
	private List<Pregunta> preguntas;
	
	public Jugador(String nombre) {
		this.preguntas = new ArrayList<Pregunta>();
		this.nombre = nombre;
	}
	
	@Override
	public void preguntaRespondida(IJugador jugador, String nombrePregunta) {
		System.out.println("El jugador " + jugador.nombreJugador() +" ha respondido la pregunta " + nombrePregunta + " de forma correcta.");
		
	}

	@Override
	public void preguntaIncorrecta(Pregunta pregunta) {
		System.out.println("La respuesta a la pregunta " + pregunta.getNombre() + " es incorrecta");
		
	}

	@Override
	public void preguntaCorrecta(Pregunta pregunta) {
		System.out.println("La respuesta de la pregunta " + pregunta.getNombre() + " es correcta ");
		
	}

	@Override
	public void finDeLaPartida(String nombreJugador) {
		this.setPreguntas(new ArrayList<Pregunta>());
		System.out.println("Finalizo la partida. Gano: " + nombreJugador);
		
	}
	
	public void setPreguntas( ArrayList<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}
	
	public List<Pregunta> getPreguntas() {
		return this.preguntas;
	}

	@Override
	public void inicioDePartida(List<Pregunta> preguntas) {
		this.getPreguntas().addAll(preguntas);
		System.out.println("La partida ha comenzado.");
		
	}

	@Override
	public String nombreJugador() {
		return this.nombre;
		
	}

}
