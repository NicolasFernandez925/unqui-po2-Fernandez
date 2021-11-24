package tp8_Patrones1.observer.cuestionarioYPreguntas;

import java.util.ArrayList;
import java.util.List;

public class Cuestionario {
	
	private List<Pregunta> preguntas;
	
	public Cuestionario(ArrayList<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}

	public List<Pregunta> getPreguntas() {
		return preguntas;
	}
	
	public int cantidadDePreguntas() {
		return this.getPreguntas().size();
	}
	
	public void agregarPregunta(Pregunta pregunta) {
		 this.preguntas.add(pregunta);
	}
	
	public void borrarPregunta(Pregunta pregunta) {
		 this.preguntas.remove(pregunta);
	}

}
