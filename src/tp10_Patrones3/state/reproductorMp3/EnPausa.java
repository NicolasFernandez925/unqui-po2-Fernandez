package tp10_Patrones3.state.reproductorMp3;

public class EnPausa implements EstadoDeReproduccion {
	
	private static EnPausa instance;
	
	public EnPausa() {
		super();
	}

	public static EnPausa getInstance() {		 
		 if (instance == null) {		 
			 instance = new EnPausa();
		 }
		 return instance;
	}

	@Override
	public void play(ReproductorMP3 reproductor, Song cancion) {
		cancion.play();
		reproductor.cambiarEstado(EnReproduccion.getInstance());	
	}
	
	@Override
	public void pause(ReproductorMP3 reproductor, Song cancion) {
		cancion.play();
		reproductor.cambiarEstado(EnReproduccion.getInstance());	
	}

	@Override
	public void stop(ReproductorMP3 reproductor, Song cancion) {
		reproductor.cambiarEstado(EnSeleccionDeCancion.getInstance());		
	}

}
