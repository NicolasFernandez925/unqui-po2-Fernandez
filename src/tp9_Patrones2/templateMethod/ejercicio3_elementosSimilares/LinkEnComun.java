package tp9_Patrones2.templateMethod.ejercicio3_elementosSimilares;

public class LinkEnComun extends Filtro {

	@Override
	protected Boolean tieneSimiletud(WikipediaPage pagina, WikipediaPage otraPagina) {
		return pagina.getLinks().stream().anyMatch(link -> otraPagina.getLinks().contains(link));
	}

}
