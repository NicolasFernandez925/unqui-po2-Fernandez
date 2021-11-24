package tp8_Patrones1.observer.cuestionarioYPreguntas;

public abstract class EstadoDelJuego {
	
	protected Servidor servidor;
	
	public EstadoDelJuego(Servidor servidor) {
		this.servidor = servidor;
	}
	
	protected void recibirRespuesta(Pregunta pregunta, String respuesta, IJugador jugador) throws Exception {
		throw new Exception("El juego no empezo.");
	}
	
	protected void nuevoParticipante(IJugador jugador) throws Exception {
		throw new Exception("Juego ya iniciado, no se pueden añadir jugadores.");
	}

	protected void iniciar() throws Exception {
		throw new Exception("Juego ya iniciado.");
	}
	
	protected void finDelJuego(IJugador jugador) throws Exception {
		throw new Exception("El juego todavia no ha comenzado.");
	}
	
	public Servidor getServidor() {
		return this.servidor;
	}

}
