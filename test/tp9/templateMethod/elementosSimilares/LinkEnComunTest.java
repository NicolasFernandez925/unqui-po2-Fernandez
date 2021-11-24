package tp9.templateMethod.elementosSimilares;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp9_Patrones2.templateMethod.ejercicio3_elementosSimilares.LinkEnComun;
import tp9_Patrones2.templateMethod.ejercicio3_elementosSimilares.WikipediaPage;

class LinkEnComunTest {
	
	LinkEnComun linkEnComunSut;
	
	WikipediaPage wikiPageMock1;
	WikipediaPage wikiPageMock2;
	
	WikipediaPage wikiPageMock3;
	WikipediaPage wikiPageMock4;

	@BeforeEach
	void setUp() throws Exception {
		
		linkEnComunSut = new LinkEnComun();
		
		wikiPageMock1 = mock(WikipediaPage.class);
		wikiPageMock2 = mock(WikipediaPage.class);

	}

	@Test
	void testTieneLinkEnComunWikiPageMock1ConLaListaDeLinks2() {
		
		List<WikipediaPage> links1 = new ArrayList<WikipediaPage>();
		List<WikipediaPage> links2 = new ArrayList<WikipediaPage>();
		
		links1.add(wikiPageMock1);
		links1.add(wikiPageMock2);
		
		links2.add(wikiPageMock1);
		
		when(wikiPageMock1.getLinks()).thenReturn(links1);
		when(wikiPageMock2.getLinks()).thenReturn(links2);
			
		assertEquals(linkEnComunSut.getSimilarPages(wikiPageMock1, links2).size(), 1);
		
	}

}
