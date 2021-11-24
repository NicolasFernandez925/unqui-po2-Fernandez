package tp10_Patrones3.state.reproductorMp3;

public class ReproductorMP3 {
	
	private Song cancion;
	private EstadoDeReproduccion estadoActual;
		
	public ReproductorMP3(Song cancion) {
		super();
		this.cancion = cancion;
		this.estadoActual = new EnSeleccionDeCancion();
	}
	
	public void reproducirCancion() throws Exception {
		this.getEstado().play(this, this.getCancion());
	}
	
	public void detenerCancion() throws Exception {
		this.getEstado().stop(this, this.getCancion());
	}
	
	public void pausarCancion() throws Exception {
		this.getEstado().pause(this, this.getCancion());
	}
	
	public Song getCancion() {
		return cancion;
	}
	public void cambiarCancion(Song cancion) {
		this.cancion = cancion;
	}
		
	public EstadoDeReproduccion getEstado() {
		return estadoActual;
	}
	public void cambiarEstado(EstadoDeReproduccion estadoDeReproduccion) {
		this.estadoActual = estadoDeReproduccion;
	}

}
