package tp8_Patrones1.observer.cuestionarioYPreguntas;

public class Pregunta {
	
	private String nombre;
	private String respuesta;
	
	public Pregunta(String nombre, String respuesta) {
		this.nombre = nombre;
		this.respuesta = respuesta;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
}
