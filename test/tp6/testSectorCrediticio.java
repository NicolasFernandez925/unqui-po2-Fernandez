package tp6;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp6_solid.sistemaBancario.Cliente;
import tp6_solid.sistemaBancario.SectorCrediticio;
import tp6_solid.sistemaBancario.creditos.ISolicitudDeCredito;

class testSectorCrediticio {
	
	SectorCrediticio sectorCrediticio;
	Cliente cliente;
	ISolicitudDeCredito solicitudDeCredito1;

	@BeforeEach
	void setUp() throws Exception {
		
		sectorCrediticio = new SectorCrediticio(); // Sut
		
		solicitudDeCredito1 = mock(ISolicitudDeCredito.class); // Doc
		cliente = mock(Cliente.class); // Doc
		
	}

	@Test
	void testAnalizarCreditoAceptadoAlCliente() {
			
		when(solicitudDeCredito1.esAceptada()).thenReturn(true);
		when(solicitudDeCredito1.monto()).thenReturn(15000.0);
		when(solicitudDeCredito1.getCliente()).thenReturn(cliente);
		when(cliente.acreditarMonto(15000.0)).thenReturn(15000.0);
		
		sectorCrediticio.analizarCredito(solicitudDeCredito1);
		
		verify(solicitudDeCredito1).getCliente();
		verify(cliente).acreditarMonto(15000.0);
			
	}
	
	@Test
	void testAnalizarCreditoQueNoFueAceptadoAlCliente() {
			
		when(solicitudDeCredito1.esAceptada()).thenReturn(false);	
		sectorCrediticio.analizarCredito(solicitudDeCredito1);
		
		verify(solicitudDeCredito1, never()).getCliente();
		verify(cliente, never()).acreditarMonto(15000.0);
			
	}

}
