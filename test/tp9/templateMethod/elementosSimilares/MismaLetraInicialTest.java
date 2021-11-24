package tp9.templateMethod.elementosSimilares;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp9_Patrones2.templateMethod.ejercicio3_elementosSimilares.LinkEnComun;
import tp9_Patrones2.templateMethod.ejercicio3_elementosSimilares.MismaLetraInicial;
import tp9_Patrones2.templateMethod.ejercicio3_elementosSimilares.WikipediaPage;

class MismaLetraInicialTest {

	MismaLetraInicial mismaLetraInicialSut;
	
	List<WikipediaPage> paginas1;
	List<WikipediaPage> paginas2;
	
	WikipediaPage wikiPageMock1;
	WikipediaPage wikiPageMock2;
	
	WikipediaPage wikiPageMock3;
	WikipediaPage wikiPageMock4;

	@BeforeEach
	void setUp() throws Exception {
		
		mismaLetraInicialSut = new MismaLetraInicial();
		
		wikiPageMock1 = mock(WikipediaPage.class);
		wikiPageMock2 = mock(WikipediaPage.class);
		
		wikiPageMock3 = mock(WikipediaPage.class);
		wikiPageMock4 = mock(WikipediaPage.class);
		
		paginas1 = new ArrayList<WikipediaPage>();
		paginas2 = new ArrayList<WikipediaPage>();
		
		paginas1.add(wikiPageMock1);
		paginas1.add(wikiPageMock2);
		
		paginas2.add(wikiPageMock3);
		paginas2.add(wikiPageMock4);
	}

	@Test
	void testNoTieneNingunaLetraInicialDelTituloWikiPageMock1ConLaListaDeWikiDeLinks2() {
				
		when(wikiPageMock1.getTitle()).thenReturn("Espn");
		when(wikiPageMock2.getTitle()).thenReturn("FoxSports");
		when(wikiPageMock4.getTitle()).thenReturn("Ole");
		when(wikiPageMock3.getTitle()).thenReturn("C5N");
			
		assertEquals(mismaLetraInicialSut.getSimilarPages(wikiPageMock1, paginas2).size(), 0);
		
	}
	
	@Test
	void testTieneLetraInicialDelTituloFoxDeWikiPageMock2SportsConFoxDeWikiPageMock4() {
		
		when(wikiPageMock1.getTitle()).thenReturn("Espn");
		when(wikiPageMock2.getTitle()).thenReturn("FoxSports");
		when(wikiPageMock4.getTitle()).thenReturn("Fox");
		when(wikiPageMock3.getTitle()).thenReturn("C5N");
			
		assertEquals(mismaLetraInicialSut.getSimilarPages(wikiPageMock1, paginas2).size(), 0);
		
	}

}
