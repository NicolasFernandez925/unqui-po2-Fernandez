package tp2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp2_UML.empleado.EmpleadoContratado;
import tp2_UML.empleado.EmpleadoPermanente;
import tp2_UML.empleado.EmpleadoTemporario;
import tp2_UML.empresa.Empresa;

public class testEmpresa {

	Empresa empresa;
	EmpleadoTemporario empleadoTemp;
	EmpleadoPermanente empleadoPerm;
	EmpleadoContratado empleadoContratado;
	Calendar fechaNacEmpleadoTemporario;
	Calendar fechaDeFinPlantaTemp1;
	Calendar fechaNacEmpleadoPermanente;
	Calendar fechaNacEmpleadContratado;
	
	@BeforeEach
	public void setUp() throws Exception{	
		// Se crea un empleado Temporario
		Calendar fechaNacimiento1 = Calendar.getInstance();
		Calendar fechaDeFinPlantaEmpleadoTemporario = Calendar.getInstance();
		fechaNacimiento1.set(1992, 4, 12);
		empleadoTemp = new EmpleadoTemporario("NicolasF","calleFalsa123", fechaNacimiento1,fechaDeFinPlantaEmpleadoTemporario,5, 15000.0d);
		// Se crea un empleado Permanente
		fechaNacEmpleadoPermanente = Calendar.getInstance();
		fechaNacEmpleadoPermanente.set(1994, 4, 12);
		empleadoPerm = new EmpleadoPermanente(fechaNacEmpleadoPermanente,20,2,"NicolasF","PedroElustonto",20, 15000.0d);
		empleadoPerm.seCaso();
		// Se crea un empleado Contratadp
		fechaNacEmpleadContratado = Calendar.getInstance(); 
		fechaNacEmpleadContratado.set(1993, 4, 12);
		empleadoContratado = new EmpleadoContratado("transferencia","Matias Fernandez", "Calle122",fechaNacEmpleadContratado, 100, 15000.0d);
		//Se cre una Empresa
		empresa = new Empresa("ITResources",2036709258);
		// Se agregan 3 empleado a la empresa
		empresa.agregarEmpleado(empleadoTemp);
		empresa.agregarEmpleado(empleadoPerm);
		empresa.agregarEmpleado(empleadoContratado);
		
	}
	
	@Test
	public void cantidadEmpleadosEnLaEmpresa() {
		assertEquals(empresa.getEmpleados().size(), 3);
	}
	
	
	@Test
	public void montoTotalDeSueldosNetos() {
		assertEquals(empresa.montoTotalDeSueldosNetos(), 38695.0d);
	}
	
	@Test
	public void montoTotalDeSueldosBrutos() {
		assertEquals(empresa.montoTotalDeSueldosBrutos(), 45700.0d);
	}
	
	@Test
	public void montoTotalDeRetenciones() {
		assertEquals(empresa.montoTotalDeRetenciones(), 7005.0d);
	}
	
	@Test
	public void generarRecibos() {
		empresa.liquidarSueldos(empresa.getEmpleados());
		assertEquals(empresa.getRecibos().size(), 3);
	}

}
