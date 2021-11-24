package tp9.templateMethod.elementosSimilares;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp9_Patrones2.templateMethod.ejercicio3_elementosSimilares.PropiedadEnComun;
import tp9_Patrones2.templateMethod.ejercicio3_elementosSimilares.WikipediaPage;

class PropiedadEnComunTest {

	PropiedadEnComun propiedadEnComunSUT;
	
	Map<String, WikipediaPage> infoBoxWiki1;
	Map<String, WikipediaPage> infoBoxWiki2;
	Map<String, WikipediaPage> infoBoxWiki3;
	
	List<WikipediaPage> paginas;
	
	WikipediaPage wikiPageMock1;
	WikipediaPage wikiPageMock2;
	WikipediaPage wikiPageMock3;
	
	@BeforeEach
	void setUp() throws Exception {
		
		propiedadEnComunSUT = new PropiedadEnComun();
		
		wikiPageMock1 = mock(WikipediaPage.class);
		wikiPageMock2 = mock(WikipediaPage.class);
		wikiPageMock3 = mock(WikipediaPage.class);
		
		infoBoxWiki1 = new HashMap<String, WikipediaPage>();
		infoBoxWiki2 = new HashMap<String, WikipediaPage>();
		infoBoxWiki3 = new HashMap<String, WikipediaPage>();
		
		infoBoxWiki1.put("Adios", wikiPageMock1);
		infoBoxWiki2.put("Chau", wikiPageMock2);
		infoBoxWiki3.put("Adios", wikiPageMock2);
		
		paginas = new ArrayList<WikipediaPage>();
		
		paginas.add(wikiPageMock2);
		paginas.add(wikiPageMock3);
	}

	@Test
	void testWikiPageMock1TienePropiedadEnComunConWikiPageMock3() {
				
		when(wikiPageMock1.getInfobox()).thenReturn(infoBoxWiki1);
		when(wikiPageMock2.getInfobox()).thenReturn(infoBoxWiki2);
		when(wikiPageMock3.getInfobox()).thenReturn(infoBoxWiki3);
			
		assertEquals(propiedadEnComunSUT.getSimilarPages(wikiPageMock1, paginas).size(), 1);
		
	}
	
}
