package tp8_Patrones1.observer.encuentroDeportivos;

public interface IListener {
	
	public void update(Partido partido);
	public Boolean estaInterasado(Partido partido);
	
}
