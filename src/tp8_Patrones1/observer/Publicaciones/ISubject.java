package tp8_Patrones1.observer.Publicaciones;

public interface ISubject {
	
	void suscribir(IInvestigador i);
	void desuscribir(IInvestigador i);
	void notificar(Articulo a);
}
