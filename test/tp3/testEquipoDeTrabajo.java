package tp3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp3_introAJava1.equipoDeTrabajo.EquipoDeTrabajo;
import tp3_introAJava1.persona.Persona;

class testEquipoDeTrabajo {

	private Persona nicolas;
	private Persona matias;
	private Persona mauro;
	private EquipoDeTrabajo equipo;

	@BeforeEach
	public void setUp() throws Exception {
		Date fecha = new Date();
		equipo = new EquipoDeTrabajo();
		nicolas = new Persona(20,fecha, "nicolas", "fernandez");
		matias = new Persona(30,fecha,"matias", "fernandez");
		mauro = new Persona(18,fecha,"mauro", "fernandez");
		equipo.addPerson(nicolas);
		equipo.addPerson(mauro);
		equipo.addPerson(matias);
	}
	
	@Test
	void sumar() {
		double average = equipo.promedio();	
		System.out.println("El promedio es: " + average);
		assertEquals(average, 22.666666666666668);
	}

}
