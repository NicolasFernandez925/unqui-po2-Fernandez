package tp10_Patrones3.state.reproductorMp3;

import java.time.LocalTime;

public class Song {
	
	private String nombre;
	private LocalTime duracion;
		
	public Song(String nombre, LocalTime duracion) {
		super();
		this.nombre = nombre;
		this.duracion = duracion;
	}
	
	public void play() {}

	public void stop() {}

	public void pause() {}
	
	public String getNombre() {
		return nombre;
	}
	public LocalTime getDuracion() {
		return duracion;
	}
}
