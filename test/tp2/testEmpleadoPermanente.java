package tp2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp2_UML.empleado.EmpleadoPermanente;

class testEmpleadoPermanente {

	 EmpleadoPermanente empleadoPerm;
	 Calendar fechaNacimiento;

	 @BeforeEach
	 public void setUp() throws Exception {
		 fechaNacimiento = Calendar.getInstance();
		 fechaNacimiento.set(1994, 4, 12);
		 empleadoPerm = new EmpleadoPermanente(fechaNacimiento,20,2,"NicolasF","PedroElustonto",20, 15000.0d);	
	 }
	
	@Test
	public void comprobarEdad() {	
		 assertEquals(empleadoPerm.calcularEdad(), 27);
	}
	
	@Test
	public void sueldoBrutoCasado() {	
		empleadoPerm.seCaso();
		assertEquals(empleadoPerm.sueldoBruto(), 15500.d);
	}
	@Test
	public void sueldoBrutoSoltero() {	
		empleadoPerm.seDivorcio();
		assertEquals(empleadoPerm.sueldoBruto(), 15400.d);
	}
	
	@Test
	public void salarioFamiliarParaUnSoltero() {	
		empleadoPerm.seDivorcio();
		assertEquals(empleadoPerm.salarioFamiliar(), 400);
	}
	
	@Test
	public void salarioFamiliarParaUnCasado() {	
		empleadoPerm.seCaso();
		assertEquals(empleadoPerm.salarioFamiliar(), 500);
	}
	//----
	@Test
	public void retencionesParaUnCasado() {	
		empleadoPerm.seCaso();
		assertEquals(empleadoPerm.retenciones(), 3915.d);
	}
	
	@Test
	public void retencionesParaUnSoltero() {	
		empleadoPerm.seDivorcio();
		assertEquals(empleadoPerm.retenciones(), 3890.d);
	}
	
	
	@Test
	public void sueldoNetoParaUnCasado() {	
		empleadoPerm.seCaso();
		assertEquals(empleadoPerm.sueldoNeto(), 11585.0d);
	}
	
	@Test
	public void sueldoNetoParaUnSoltero() {
		empleadoPerm.seDivorcio();
		assertEquals(empleadoPerm.sueldoNeto(), 11510.0d);
	}
}
