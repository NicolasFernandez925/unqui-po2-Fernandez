package tp8_Patrones1.observer.encuentroDeportivos;

import java.util.ArrayList;

public class Servidor implements IListener {
	
	private ArrayList<Partido> partidosDeInteres;
	private ArrayList<String> intereses;
	
	public Servidor() {
		super();
		this.partidosDeInteres = new ArrayList<Partido>();
		this.intereses = new ArrayList<String>();
	}
	
	@Override
	public void update(Partido partido) {
		this.getPartidosDeInteres().add(partido);
	}

	@Override
	public Boolean estaInterasado(Partido partido) {
		return intereses.contains(partido.getDeporte());	
	}
	
	public ArrayList<Partido> getPartidosDeInteres() {
		return partidosDeInteres;
	}

	public ArrayList<String> getIntereses() {
		return intereses;
	}

	public void setIntereses(ArrayList<String> intereses) {
		this.intereses = intereses;
	}
}
