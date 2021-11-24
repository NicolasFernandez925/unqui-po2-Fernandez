package tp9_Patrones2.templateMethod.ejercicio3_elementosSimilares;

public class MismaLetraInicial extends Filtro {

	@Override
	protected Boolean tieneSimiletud(WikipediaPage pagina, WikipediaPage otraPagina) {
		char letraInicialPage1 = pagina.getTitle().charAt(0);
		char letraInicialPage2 = otraPagina.getTitle().charAt(0);
		return letraInicialPage1 == letraInicialPage2;
	}

}