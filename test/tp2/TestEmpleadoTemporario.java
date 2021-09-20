package tp2;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp2_UML.empleado.EmpleadoTemporario;
import tp2_UML.empresa.Empresa;

class TestEmpleadoTemporario {
	
	 EmpleadoTemporario empleadoTemp;
	 Calendar fechaNacimiento;
	 Calendar fechaDeFinPlantaTemp;

	 @BeforeEach
	 public void setUp() throws Exception {
		//Empleado1
		 fechaNacimiento = Calendar.getInstance();
		 fechaDeFinPlantaTemp = Calendar.getInstance();
		 fechaNacimiento.set(1992, 4, 12);
		 empleadoTemp = new EmpleadoTemporario("NicolasF","PedroElustonto", fechaNacimiento,fechaDeFinPlantaTemp,5, 15000.0d);	
	 }
	
	@Test
	public void comprobarEdad() {	
		 assertEquals(empleadoTemp.calcularEdad(), 29);
	}
	
	@Test
	public void sueldoBruto() {	
		assertEquals(empleadoTemp.sueldoBruto(), 15200.d);
	}
	//----
	@Test
	public void retenciones() {	
		assertEquals(empleadoTemp.retenciones(), 3040.d);
	}
	
	@Test
	public void retencionesConEdadMayora50() {	
		fechaNacimiento.set(1950, 4, 12);
		assertEquals(empleadoTemp.retenciones(), 3065.d);
	}
	
	@Test
	public void sueldoNetoParaUnMenorDe50() {	
		assertEquals(empleadoTemp.sueldoNeto(), 12160.0d);
	}
	
	@Test
	public void sueldoNetoParaUnMayorDe50() {	
		fechaNacimiento.set(1950, 4, 12);
		assertEquals(empleadoTemp.sueldoNeto(), 12135.0d);
	}
	
	
}
