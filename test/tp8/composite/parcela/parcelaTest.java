package tp8.composite.parcela;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp8_Patrones1.composite.parcela.ParcelaMixta;
import tp8_Patrones1.composite.parcela.Soja;
import tp8_Patrones1.composite.parcela.Trigo;

class parcelaTest {
	
	ParcelaMixta compuesta;
	ParcelaMixta compuesta2;
	Soja simpleSoja1;
	Trigo simpleTrigo1;
	Soja simpleSoja2;
	Trigo simpleTrigo2;

	@BeforeEach
	void setUp() throws Exception {
		
		compuesta = new ParcelaMixta();
		compuesta2 = new ParcelaMixta();
		simpleSoja1 = new Soja();
		simpleSoja2 = new Soja();
		simpleTrigo1 = new Trigo();
		simpleTrigo2 = new Trigo();
		
		compuesta.agregar(simpleSoja1);
		compuesta.agregar(simpleSoja2);
		compuesta.agregar(simpleTrigo1);
		compuesta.agregar(simpleTrigo2);
		
		compuesta2.agregar(compuesta);
		compuesta2.agregar(simpleSoja1);

	}
	
	@Test
	void testGananciaTotalDeUnaParcelaMixtaCompuesta() {
		assertEquals(compuesta.ganancia(), 400);
	}
	
}
