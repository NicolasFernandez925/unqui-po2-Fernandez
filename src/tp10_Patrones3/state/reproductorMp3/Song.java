package tp10_Patrones3.state.reproductorMp3;

public class Song {
	
	private String nombre;
	
	public Song(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public void play() {
		System.out.println("La canción " + this.getNombre() + " en Reproducción.");
	}

	public void stop() {
		System.out.println("Canción " + this.getNombre() + " en Stop. Seleccione una canción.");
	}

	public void pause() {
		System.out.println("La canción " + this.getNombre() + " en Pausa.");
	}
	
	public String getNombre() {
		return nombre;
	}

}
