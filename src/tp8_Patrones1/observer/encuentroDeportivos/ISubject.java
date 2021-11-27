package tp8_Patrones1.observer.encuentroDeportivos;

public interface ISubject {
	
	public void suscribir(IListener listener);
	public void desuscribir(IListener listener);
	public void notificar(Partido partido);
}
