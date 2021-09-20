package tp2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp2_UML.empleado.EmpleadoContratado;

class testEmpleadoContratado {

	 EmpleadoContratado empleadoContratado;
	 Calendar fechaNacimiento;

	 @BeforeEach
	 public void setUp() throws Exception {
		//Empleado1
		 fechaNacimiento = Calendar.getInstance(); 
		 fechaNacimiento.set(1993, 4, 12);
		 empleadoContratado = new EmpleadoContratado("transferencia","Matias Fernandez", "Calle122",fechaNacimiento, 100, 15000.0d);	
	 }
	
	@Test
	public void comprobarEdad() {	
		 assertEquals(empleadoContratado.calcularEdad(), 28);
	}
	
	@Test
	public void sueldoBruto() {	
		assertEquals(empleadoContratado.sueldoBruto(), 15000.0d);
	}
	
	@Test
	public void retenciones() {	
		System.out.println(empleadoContratado.retenciones());
		assertEquals(empleadoContratado.retenciones(), 50.0d);
	}
	
	@Test
	public void sueldoNeto() {	
		System.out.println(empleadoContratado.sueldoNeto());
		assertEquals(empleadoContratado.sueldoNeto(), 14950.0d);
	}
	

}
