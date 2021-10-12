package tp6;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp6_solid.sistemaBancario.Cliente;
import tp6_solid.sistemaBancario.Propiedad;
import tp6_solid.sistemaBancario.creditos.SolicitudDeCreditoHipotecario;

class solicitudCreditoHipotecario {
	
	SolicitudDeCreditoHipotecario credHipotecario;
	Propiedad propiedad;
	Cliente cliente;

	@BeforeEach
	void setUp() throws Exception {
		
		cliente = mock(Cliente.class);
		propiedad = mock(Propiedad.class);
		credHipotecario = new SolicitudDeCreditoHipotecario(cliente, 5000.0, 12, propiedad);		
	}

	@Test
	void testEsCreditoAceptado() {
		when(cliente.getSueldoNeto()).thenReturn(20000.0);
		when(cliente.getEdad()).thenReturn(25);
		when(propiedad.getValorFiscal()).thenReturn(50000.0);
		
		assertTrue(credHipotecario.esAceptada());
	}
	
	@Test
	void testNoEsCreditoAceptadoPorqueElMontoDeLaCuotaDelCreditoEsMayorAlSueldoNetoDelCliente() {
		credHipotecario.setMontoSolicitado(2000000.0);
		when(cliente.getSueldoNeto()).thenReturn(20000.0);
		when(cliente.getEdad()).thenReturn(30);
		when(propiedad.getValorFiscal()).thenReturn(50000.0);
		
		assertFalse(credHipotecario.esAceptada());
	}

}
