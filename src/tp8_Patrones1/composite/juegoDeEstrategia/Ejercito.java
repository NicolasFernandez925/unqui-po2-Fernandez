package tp8_Patrones1.composite.juegoDeEstrategia;

import java.util.ArrayList;

public class Ejercito implements IPersonaje {
	
	private ArrayList<IPersonaje> personajes;
	
	public Ejercito() {
		personajes = new ArrayList<IPersonaje>();
	}

	@Override
	public void caminar() {
		this.personajes.stream().forEach(p -> p.caminar());
		
	}
	
	public void agregar(IPersonaje personaje) {
		personajes.add(personaje);
	}
	
	public void borrar(IPersonaje personaje) {
		personajes.remove(personaje);
	}

}
