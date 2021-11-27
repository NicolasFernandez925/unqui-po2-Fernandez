package tp10_Patrones3.state.reproductorMp3;

public class EnSeleccionDeCancion implements EstadoDeReproduccion {
	
	private static EnSeleccionDeCancion instance;
	
	public EnSeleccionDeCancion() {
		super();
	}

	public static EnSeleccionDeCancion getInstance() {		 
		 if (instance == null) {		 
			 instance = new EnSeleccionDeCancion();
		 }
		 return instance;
	}

	@Override
	public void play(ReproductorMP3 reproductor, Song cancion) {
		cancion.play();
		reproductor.cambiarEstado(EnReproduccion.getInstance());			
	}

	@Override
	public void pause(ReproductorMP3 reproductor, Song cancion) throws Exception {
		throw new Exception("No se puede pausar una canción que aún no fue seleccionada.");	
	}

	@Override
	public void stop(ReproductorMP3 reproductor, Song cancion) throws Exception {
		throw new Exception("No se puede poner Stop una canción que aún no fue seleccionada.");	
	}
	
}
