package tp8_Patrones1.observer.encuentroDeportivos;

import java.util.ArrayList;

public class Partido {

	private String deporte;
	private ArrayList<String> contrincantes;
	private String resultado;
	
	public Partido(String deporte, ArrayList<String> contrincantes, String resultado) {
		super();
		this.deporte = deporte;
		this.contrincantes = contrincantes;
		this.resultado = resultado;
	}
		
	public String getDeporte() {
		return deporte;
	}
	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}
	public ArrayList<String> getContrincantes() {
		return contrincantes;
	}
	public void setContrincantes(ArrayList<String> contrincantes) {
		this.contrincantes = contrincantes;
	}
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public Boolean jugoContraContrincante(String contrincante2) {		
		return this.getContrincantes().contains(contrincante2);
	}

	
	
}
