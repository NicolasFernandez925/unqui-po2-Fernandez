package tp8_Patrones1.observer.encuentroDeportivos;

import java.util.ArrayList;

public class Contrincantes implements IInteres {
	
	private ArrayList<String> contrincantes;
	
	public Contrincantes() {
		super();
		this.contrincantes = new ArrayList<String>();
	}

	@Override
	public Boolean estaInteresado(Partido partido) {
		return contrincantes.stream().anyMatch(c -> partido.jugoContraContrincante(c));
	}
	
	public ArrayList<String> getContrincantes() {
		return contrincantes;
	}

	public void setContrincantes(ArrayList<String> contrincantes) {
		this.contrincantes = contrincantes;
	}

}
