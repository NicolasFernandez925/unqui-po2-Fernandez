package tp10_Patrones3.state.reproductorMp3;

public interface EstadoDeReproduccion {
	
	public void pause(ReproductorMP3 reproductor, Song cancion) throws Exception;
	public void stop(ReproductorMP3 reproductor, Song cancion) throws Exception;
	public void play(ReproductorMP3 reproductor, Song cancion) throws Exception;
	
}
