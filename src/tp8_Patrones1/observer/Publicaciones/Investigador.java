package tp8_Patrones1.observer.Publicaciones;

import java.util.ArrayList;
import java.util.List;

public class Investigador implements IInvestigador {
	
	List<String> intereses;
	
	public Investigador() {
		this.intereses = new ArrayList<String>();
	}

	@Override
	public boolean estaInteresadaEn(Articulo articulo) {
		return this.intereses.stream().anyMatch( i -> articulo.datosBibliograficos().contains(i));		
	}

	@Override
	public void avisarPorArticulo(Articulo articulo) {
		System.out.println("El articulo de interes es: " + articulo.titulo + "Genero: " + articulo.getTipo());
		
	}
	
	public void agregarInteres(String interes) {
		this.intereses.add(interes);
	}
	
	public void borrarInteres(String interes) {
		this.intereses.remove(interes);
	}

}
