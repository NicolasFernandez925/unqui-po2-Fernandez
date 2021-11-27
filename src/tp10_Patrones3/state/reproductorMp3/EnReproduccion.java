package tp10_Patrones3.state.reproductorMp3;

public class EnReproduccion implements EstadoDeReproduccion {
	
	private static EnReproduccion instance;
	
	public EnReproduccion() {
		super();
	}
	
	public static EnReproduccion getInstance() {		 
		 if (instance == null) {		 
			 instance = new EnReproduccion();
		 }
		 return instance;
	}
		
	@Override
	public void play(ReproductorMP3 reproductor, Song cancion) throws Exception {
		throw new Exception("No se puede dar Play a una canción ya en reproducción.");	
	}
	
	@Override
	public void pause(ReproductorMP3 reproductor, Song cancion) {
		cancion.pause();
		reproductor.cambiarEstado(EnPausa.getInstance());
		
	}

	@Override
	public void stop(ReproductorMP3 reproductor, Song cancion) {
		cancion.pause();
		reproductor.cambiarEstado(EnSeleccionDeCancion.getInstance());		
	}	
}
