package tp8.composite.file;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp8_Patrones1.composite.sistemaDeArchivos.Archivo;
import tp8_Patrones1.composite.sistemaDeArchivos.Directorio;
import tp8_Patrones1.composite.sistemaDeArchivos.FyleSystem;

class FileSystemTest {
	
	FyleSystem archivo1;
	FyleSystem archivo2;
	FyleSystem archivo3;
	FyleSystem archivo4;
	
	Directorio directorio1;
	Directorio directorio2;
	Directorio directorio3;
	Directorio root;
	
	@BeforeEach
	void setUp() throws Exception {
		
		archivo1 = new Archivo("Banco_UML.pdf", 1000);
		archivo2 = new Archivo("DesignPattern.pdf", 1000);
		archivo3 = new Archivo("teorioUml_txt", 1000);
		archivo4 = new Archivo("BestPractice_txt", 1000);
		
		directorio1 = new Directorio("Home");
		directorio2 = new Directorio("Git");
		directorio3 = new Directorio("Azure");
		
		root = new Directorio("Root");
		
		directorio1.add(archivo1);
		directorio1.add(archivo2);
		directorio3.add(archivo3);
		
		root.add(directorio1);
		root.add(directorio3);
				
	}

	@Test
	void testNonmbreDeArchivosYDirectorios() {
		root.printStructure();
	}
	
	@Test
	void testUltimoModificado() {
		
		assertEquals(archivo2, directorio1.lastModified());
	}
	
	@Test
	void testElementoMasAntiguo() {
		assertEquals(archivo1, directorio1.oldesElement());
	}
	

	@Test
	void testTotalPeso() {
		assertEquals(root.totalSize(), 3000);
	}

}
