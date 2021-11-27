package tp8_Patrones1.observer.encuentroDeportivos;

public class Deporte implements IInteres {
	
	private String deporte;

	public Deporte(String deporte) {
		super();
		this.deporte = deporte;
	}

	@Override
	public Boolean estaInteresado(Partido partido) {
			return deporte == partido.getDeporte();
	}
	
	public String getDeportes() {
		return deporte;
	}

	public void setDeportes(String deporte) {
		this.deporte = deporte;
	}


}
