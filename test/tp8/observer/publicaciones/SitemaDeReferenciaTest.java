package tp8.observer.publicaciones;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp8_Patrones1.observer.Publicaciones.Articulo;
import tp8_Patrones1.observer.Publicaciones.IInvestigador;
import tp8_Patrones1.observer.Publicaciones.SistemaDeReferencia;

class SitemaDeReferenciaTest {
	
	IInvestigador investigador1;
	IInvestigador investigador2;
	Articulo articulo;	
	SistemaDeReferencia sistema;

	@BeforeEach
	void setUp() throws Exception {
		
		investigador1 = mock(IInvestigador.class);
		investigador2 = mock(IInvestigador.class);
		articulo = mock(Articulo.class);
		
		sistema = new SistemaDeReferencia();
		
		// Suscribir participantes para recibir notificaciones de articulos de interés
		sistema.suscribir(investigador1);
		sistema.suscribir(investigador2);
	}
	
	@Test
	void testCantidadDeSuscriptores() {
		assertEquals(sistema.cantidadSuscriptores(), 2);
	}

	@Test
	void testNotificaALosInvestigadoresInteresadosEnUnArticuloEnEspecial() {
			
		when(investigador1.estaInteresadaEn(articulo)).thenReturn(true);
		when(investigador2.estaInteresadaEn(articulo)).thenReturn(true);
		
		sistema.agregarArticulo(articulo);
		
		verify(investigador1).avisarPorArticulo(articulo);
		verify(investigador2).avisarPorArticulo(articulo);
	}
	
	@Test
	void testNONotificaALosInvestigadoresPorqueNoSonDeInteres() {
			
		when(investigador1.estaInteresadaEn(articulo)).thenReturn(false);
		when(investigador2.estaInteresadaEn(articulo)).thenReturn(false);
		
		sistema.agregarArticulo(articulo);
		
		verify(investigador1, never()).avisarPorArticulo(articulo);
		verify(investigador2, never()).avisarPorArticulo(articulo);
	}
	
	@Test
	void testSoloNotificaAlInvestigador1PorqueLeInteresaRecibirInformacionDelArticulo() {

		when(investigador1.estaInteresadaEn(articulo)).thenReturn(true);
		when(investigador2.estaInteresadaEn(articulo)).thenReturn(false);
		
		sistema.agregarArticulo(articulo);
			
		verify(investigador1).avisarPorArticulo(articulo);
		verify(investigador2, never()).avisarPorArticulo(articulo);
	}
	
	
	@Test
	void testSoloNotificaAlInvestigador2PorqueLeInteresaRecibirInformacionDelArticulo() {
			
		when(investigador1.estaInteresadaEn(articulo)).thenReturn(false);
		when(investigador2.estaInteresadaEn(articulo)).thenReturn(true);
		
		sistema.agregarArticulo(articulo);
		
		verify(investigador1, never()).avisarPorArticulo(articulo);
		verify(investigador2).avisarPorArticulo(articulo);
	}


}
