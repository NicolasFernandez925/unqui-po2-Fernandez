package tp10_Patrones3.state.reproductorMp3;

public class EnSeleccionDeCancion implements EstadoDeReproduccion {
	
	public EnSeleccionDeCancion() {
		super();
	}

	@Override
	public void play(ReproductorMP3 reproductor, Song cancion) {
		cancion.play();
		reproductor.cambiarEstado(new EnReproduccion());			
	}

	@Override
	public void pause(ReproductorMP3 reproductor, Song cancion) throws Exception {
		throw new Exception("No se puede pausar una cancion que aún no fue seleccionada.");	
	}

	@Override
	public void stop(ReproductorMP3 reproductor, Song cancion) throws Exception {
		throw new Exception("No se puede poner Stop una cancion que aún no fue seleccionada.");	
	}
	
}
