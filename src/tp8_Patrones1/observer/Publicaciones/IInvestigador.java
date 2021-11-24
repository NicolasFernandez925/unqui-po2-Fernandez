package tp8_Patrones1.observer.Publicaciones;

public interface IInvestigador {
	boolean estaInteresadaEn(Articulo articulo);
	void avisarPorArticulo(Articulo articulo);
}
