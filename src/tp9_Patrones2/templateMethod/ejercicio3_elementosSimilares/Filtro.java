package tp9_Patrones2.templateMethod.ejercicio3_elementosSimilares;

import java.util.List;
import java.util.stream.Collectors;


/**
 * Clase abstracta: Filtro
 * Clase concreta: LinkEnComun, MismaLetraInicial, PropiedadEnComun;
 * Template method: getSimilarPages();
 * operaciones primitivas: tieneSimiletud();
 * operaciones concretas: -
 * Hook method no se utilizo
 * */

public abstract class Filtro {
	
	public List<WikipediaPage> getSimilarPages(WikipediaPage page, List<WikipediaPage> wikipedia) {
		return wikipedia.stream().filter(wiki -> this.tieneSimiletud(wiki, page)).collect(Collectors.toList());
	}

	protected abstract Boolean tieneSimiletud(WikipediaPage pagina, WikipediaPage otraPagina);
}
