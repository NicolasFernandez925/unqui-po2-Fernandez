package tp6;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp6_solid.sistemaBancario.Cliente;
import tp6_solid.sistemaBancario.Propiedad;
import tp6_solid.sistemaBancario.creditos.SolicitudDeCreditoPersonal;

class solicitudCreditoPersonal {
	
	SolicitudDeCreditoPersonal credPersonal;
	Propiedad propiedad;
	Cliente cliente;

	@BeforeEach
	void setUp() throws Exception {
		
		cliente = mock(Cliente.class);
		credPersonal = new SolicitudDeCreditoPersonal(cliente, 50000.0, 12);		
	}

	@Test
	void testEsCreditoAceptado() {
		when(cliente.getSueldoNetoAnual()).thenReturn(240000.0);	
		when(cliente.getSueldoNeto()).thenReturn(20000.0);	
		assertTrue(credPersonal.esAceptada());
	}
	
	@Test
	void testNoEsCreditoAceptadoPorqueElMontoDelSueldoNetoEsMenorA15000() {
		credPersonal.setMontoSolicitado(50000.0);
		when(cliente.getSueldoNetoAnual()).thenReturn(12000.0);
		when(cliente.getSueldoNeto()).thenReturn(1000.0);	
		
		assertFalse(credPersonal.esAceptada());
	}
}
