package tp10_Patrones3.state.reproductorMp3;

public class EnPausa implements EstadoDeReproduccion {

	public EnPausa() {
		super();
	}

	@Override
	public void play(ReproductorMP3 reproductor, Song cancion) {
		cancion.play();
		reproductor.cambiarEstado(new EnReproduccion());	
	}
	
	@Override
	public void pause(ReproductorMP3 reproductor, Song cancion) {
		cancion.play();
		reproductor.cambiarEstado(new EnReproduccion());	
	}

	@Override
	public void stop(ReproductorMP3 reproductor, Song cancion) {
		cancion.stop();
		reproductor.cambiarEstado(new EnSeleccionDeCancion());		
	}

}
