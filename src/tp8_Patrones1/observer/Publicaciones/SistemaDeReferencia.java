package tp8_Patrones1.observer.Publicaciones;

import java.util.ArrayList;
import java.util.List;

public class SistemaDeReferencia implements ISubject {
	
	List<IInvestigador> investigadores;
	List<Articulo> articulo;
	
	public SistemaDeReferencia() {
		this.investigadores = new ArrayList<IInvestigador>();
		this.articulo = new ArrayList<Articulo>();
	}
	
	public void agregarArticulo(Articulo a) {
		this.articulo.add(a);
		this.notificar(a);
	}

	@Override
	public void suscribir(IInvestigador i) {
		this.investigadores.add(i);
		
	}
	
	public int cantidadSuscriptores() {
		return investigadores.size();
	}

	@Override
	public void desuscribir(IInvestigador i) {
		this.investigadores.remove(i);	
	}

	@Override
	public void notificar(Articulo a) {
		this.investigadores.forEach(investigador -> {
			if(investigador.estaInteresadaEn(a)) {
				investigador.avisarPorArticulo(a);
			}
		});
		
	}

}
