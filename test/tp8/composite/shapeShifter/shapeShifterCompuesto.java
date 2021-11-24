package tp8.composite.shapeShifter;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp8_Patrones1.composite.shapeShifter.IShapeShifter;
import tp8_Patrones1.composite.shapeShifter.ShapeShifterCompuesto;
import tp8_Patrones1.composite.shapeShifter.ShapeShifterSimple;

class shapeShifterCompuesto {

	IShapeShifter SSsimple;
	ShapeShifterCompuesto SScompuesto; 
	IShapeShifter SScompuestoMock;
	
	@BeforeEach
	void setUp() throws Exception {
		
		SScompuestoMock = mock(ShapeShifterCompuesto.class);
		SSsimple = mock(ShapeShifterSimple.class);
		
		ArrayList<IShapeShifter> listaSS= new ArrayList<IShapeShifter>();
		
		listaSS.add(SSsimple);
		listaSS.add(SScompuestoMock);
		
		SScompuesto= new ShapeShifterCompuesto(listaSS);
	}

	@Test
	void testConstructorShifterCompuesto() {
		
		assertEquals(2,SScompuesto.getShapeShifters().size());
		
	}
	
	@Test
	void testShifterCompuestoMetodoCompose() {
		
		// retorna 3, 2 que agregue previamente en el setUp + el SSsimple que se pasa como argumento
		// en el constructor
		ShapeShifterCompuesto ssc= (ShapeShifterCompuesto) SScompuesto.compose(SSsimple);
		
		assertEquals(3,ssc.getShapeShifters().size());
		
	}
	
	@Test
	void testShifterCompuestoDeepestRetornaLaProfundidad() {	
		
		when(SScompuestoMock.deepest()).thenReturn(1);
		when(SSsimple.deepest()).thenReturn(1);
		assertEquals(2,SScompuesto.deepest());
	}
	
	@Test
	void testShifterCompuestoDevuelveUnArrayListConLosValoresDeSusShiftersSimples() {
		
		List<Integer> listaMocksSimple= new ArrayList<Integer>();
		
		listaMocksSimple.add(1);
		
		when(SSsimple.values()).thenReturn(listaMocksSimple);
		
		List<Integer> listaMockCompuesto= new ArrayList<Integer>();
		
		listaMockCompuesto.add(2);
		listaMockCompuesto.add(3);
		
		when(SScompuestoMock.values()).thenReturn(listaMockCompuesto);
			
		List<Integer> listaEsperada= new ArrayList<Integer>();
		
		listaEsperada.addAll(SSsimple.values());
		listaEsperada.addAll(SScompuestoMock.values());
		
		assertEquals(listaEsperada,SScompuesto.values());
	}
	
}