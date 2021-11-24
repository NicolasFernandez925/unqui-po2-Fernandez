package tp10.Strategy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp10_Patrones3.strategy.EncriptarConNumeros;

class EncriptarConNumerosTest {
	
	String texto;
	String textoEsperado;
	EncriptarConNumeros encriptarConNumeros;

	@BeforeEach
	void setUp() throws Exception {
		
		texto = "";
		textoEsperado = "";
		encriptarConNumeros = new EncriptarConNumeros();
	}

	@Test
	void testEncriptarConNumerosConUnEspacioAlPrincipio() {
		texto = " Nicolas";
		textoEsperado = "0,14,9,3,16,12,1,20";
		assertEquals(encriptarConNumeros.encriptar(texto).toString(), textoEsperado);
	}
	
	@Test
	void testEncriptarConNumerosSinEspacios() {
		texto = "Nicolas";
		textoEsperado = "14,9,3,16,12,1,20";
		assertEquals(encriptarConNumeros.encriptar(texto).toString(), textoEsperado);
	}
	
	@Test
	void testDesencriptarConLetrasLaEncriptacionHechaConNumeroSinEspacios() {
		texto = "14,9,3,16,12,1,20";
		textoEsperado = "nicolas";
		//System.out.println(encriptarConNumeros.desencriptar(texto).toString());
		assertEquals(encriptarConNumeros.desencriptar(texto).toString(), textoEsperado);
	}

}
