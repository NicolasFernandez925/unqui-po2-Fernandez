package tp8_Patrones1.observer.encuentroDeportivos;

import java.util.ArrayList;

public class GestorDePartidos implements ISubject {
	
	private ArrayList<Partido> partidos = new ArrayList<Partido>();
	private ArrayList<IListener> suscriptores = new ArrayList<IListener>();
	
	public void agregarPartido(Partido partido) {
		this.partidos.add(partido);
		this.notificar(partido);
	}

	@Override
	public void suscribir(IListener suscriptor) {
		this.suscriptores.add(suscriptor);		
	}

	@Override
	public void desuscribir(IListener suscriptor) {
		if(suscriptores.contains(suscriptor)) {
			suscriptores.remove(suscriptor);
		}		
	}

	@Override
	public void notificar(Partido partido) {
		for (IListener suscriptor : suscriptores) {
			if(suscriptor.estaInterasado(partido)) {
				suscriptor.update(partido);
			}
		}
		
	}

}
