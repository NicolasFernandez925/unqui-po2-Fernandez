package tp8_Patrones1.observer.encuentroDeportivos;

import java.util.ArrayList;

public class AppMovil implements IListener {
	
	private ArrayList<IInteres> intereses;	
	private ArrayList<String> resultadosDePartidos;

	public AppMovil() {
		super();
		this.intereses = new ArrayList<IInteres>();
		this.resultadosDePartidos = new ArrayList<String>();
	}

	@Override
	public void update(Partido partido) {
		resultadosDePartidos.add(partido.getResultado());	
	}

	@Override
	public Boolean estaInterasado(Partido partido) {
		return intereses.stream().anyMatch(e -> e.estaInteresado(partido));
	}
	
	public ArrayList<IInteres> getIntereses() {
		return intereses;
	}

	public ArrayList<String> getResultadosDePartidos() {
		return resultadosDePartidos;
	}



}
