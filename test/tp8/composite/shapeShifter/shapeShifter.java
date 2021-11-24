package tp8.composite.shapeShifter;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp8_Patrones1.composite.shapeShifter.IShapeShifter;
import tp8_Patrones1.composite.shapeShifter.ShapeShifterCompuesto;
import tp8_Patrones1.composite.shapeShifter.ShapeShifterSimple;

class shapeShifter {

	ShapeShifterSimple sutSimple;
	IShapeShifter mockCompuesto;
	
	@BeforeEach
	void setUp() throws Exception {
		
		 mockCompuesto = mock(IShapeShifter.class);
		 sutSimple = new ShapeShifterSimple(1);
	}

	@Test
	void testConstructorShifterSimple() {
		assertEquals(1,sutSimple.getValue());
	}
	@Test
	void testShifterSimpleMetodoCompose() {
		
		// se hace el casteo a ShapeShifterCompuesto para obtener el size
		ShapeShifterCompuesto ssc= (ShapeShifterCompuesto) sutSimple.compose(mockCompuesto);
		
		assertEquals(2,ssc.getShapeShifters().size());
	}
	
	@Test
	void testProfundidadShapeSimpleEsIgualA0() {		
		assertEquals(0, sutSimple.deepest());
	}
	
	@Test
	void testFlatShapeSimple() {		
		assertEquals(sutSimple, sutSimple.flat());
	}
	
	@Test
	void testListaDeValoresDelShapeSimple() {	
		List<Integer> listaAComparar = new ArrayList<Integer>();
		listaAComparar.add(1);
		assertEquals(listaAComparar, sutSimple.values());
	}

}
