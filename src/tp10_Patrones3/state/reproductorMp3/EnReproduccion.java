package tp10_Patrones3.state.reproductorMp3;

public class EnReproduccion implements EstadoDeReproduccion {

	public EnReproduccion() {
		super();
	}
		
	@Override
	public void play(ReproductorMP3 reproductor, Song cancion) throws Exception {
		throw new Exception("No se puede dar Play una cancion ya en reproducción.");	
	}
	
	@Override
	public void pause(ReproductorMP3 reproductor, Song cancion) {
		cancion.pause();
		reproductor.cambiarEstado(new EnPausa());
		
	}

	@Override
	public void stop(ReproductorMP3 reproductor, Song cancion) {
		cancion.pause();
		reproductor.cambiarEstado(new EnSeleccionDeCancion());		
	}

	
}
