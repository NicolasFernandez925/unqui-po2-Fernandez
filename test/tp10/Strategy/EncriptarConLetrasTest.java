package tp10.Strategy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp10_Patrones3.strategy.EncriptarConLetras;

class EncriptarConLetrasTest {
	
	EncriptarConLetras encriptarConLetras;
	String texto;
	String textoEsperado;

	@BeforeEach
	void setUp() throws Exception {
		texto = "";
		textoEsperado = "";
		encriptarConLetras = new EncriptarConLetras();
	}

	@Test
	void testEncriptarTexto() {
		texto = "NIcolas";
		textoEsperado = "NOcules";
		assertEquals(encriptarConLetras.encriptar(texto).toString(), textoEsperado);
	}
	
	@Test
	void testDesencriptarTexto() {
		texto = "NOcules";
		textoEsperado = "NIcolas";
		assertEquals(encriptarConLetras.desencriptar(texto).toString(), textoEsperado);
	}
	


}
