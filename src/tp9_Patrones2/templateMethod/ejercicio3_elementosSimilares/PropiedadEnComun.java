package tp9_Patrones2.templateMethod.ejercicio3_elementosSimilares;

public class PropiedadEnComun extends Filtro {

	@Override
	protected Boolean tieneSimiletud(WikipediaPage pagina, WikipediaPage otraPagina) {
		return pagina.getInfobox().keySet().stream().anyMatch(k -> otraPagina.getInfobox().keySet().contains(k));
	}

}
