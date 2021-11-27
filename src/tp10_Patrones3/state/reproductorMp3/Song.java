package tp10_Patrones3.state.reproductorMp3;

public class Song {
	
	private String nombre;
	
	public Song(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public void play() {
		System.out.println("La canci�n " + this.getNombre() + " en Reproducci�n.");
	}

	public void stop() {
		System.out.println("Canci�n " + this.getNombre() + " en Stop. Seleccione una canci�n.");
	}

	public void pause() {
		System.out.println("La canci�n " + this.getNombre() + " en Pausa.");
	}
	
	public String getNombre() {
		return nombre;
	}

}
