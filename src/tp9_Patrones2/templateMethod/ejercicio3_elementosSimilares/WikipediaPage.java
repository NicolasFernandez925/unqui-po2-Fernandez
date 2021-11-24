package tp9_Patrones2.templateMethod.ejercicio3_elementosSimilares;

import java.util.List;
import java.util.Map;

public interface WikipediaPage {

	public String getTitle(); /*retorna el t�tulo de la p�gina.*/
	public List<WikipediaPage> getLinks(); /*retorna una Lista de las p�ginas de
	Wikipedia con las que se conecta.*/
	public Map<String, WikipediaPage> getInfobox(); /*retorna un Map con un valor en
	texto y la pagina que describe ese valor que aparecen en los infobox de la
	p�gina de Wikipedia.*/
	
}
