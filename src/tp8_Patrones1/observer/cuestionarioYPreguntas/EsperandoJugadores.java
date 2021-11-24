package tp8_Patrones1.observer.cuestionarioYPreguntas;

public class EsperandoJugadores extends EstadoDelJuego {

	public EsperandoJugadores(Servidor servidor) {
		super(servidor);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void nuevoParticipante(IJugador jugador) throws Exception {
		if( this.servidor.getJugadores().size() < 5 ) {
			servidor.nuevoParticipante(jugador);
			servidor.participanteConPuntajeInicial(jugador);
		}
		else {
			throw new Exception("El cupo ya esta lleno. Solo 5 jugadores");
		}
	}
	
	@Override
	protected void iniciar() {
		this.servidor.setEstado(new EnJuego(this.getServidor()));
		this.servidor.notificarParticipantesComienzoDeJuego();
	}

}
