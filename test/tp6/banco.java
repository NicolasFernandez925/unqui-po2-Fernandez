package tp6;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp6_solid.sistemaBancario.Banco;
import tp6_solid.sistemaBancario.Cliente;
import tp6_solid.sistemaBancario.SectorContable;
import tp6_solid.sistemaBancario.SectorCrediticio;
import tp6_solid.sistemaBancario.creditos.ISolicitudDeCredito;

class banco {
	
	SectorCrediticio sectorCrediticio;
	SectorContable sectorContable;
	Cliente cliente;
	ISolicitudDeCredito solicitudDeCredito1;
	ISolicitudDeCredito solicitudDeCredito2;
	Banco banco;

	@BeforeEach
	void setUp() throws Exception {
		
		sectorCrediticio = mock(SectorCrediticio.class);
		solicitudDeCredito1 = mock(ISolicitudDeCredito.class);
		solicitudDeCredito2 = mock(ISolicitudDeCredito.class);
		sectorContable = mock(SectorContable.class);
		cliente = mock(Cliente.class);
		banco = new Banco(sectorCrediticio,sectorContable);
		
	}

	@Test
	void testAgregarClienteAlBanco() {
		banco.agregarCliente(cliente);	
		assertEquals(banco.getClientes().size(), 1);		
	}
	
	@Test
	void testRegistrarSolicitudAlBanco() {
		banco.registrarSolicitud(solicitudDeCredito1);	
		assertEquals(banco.getSolicitudesDeCredito().size(), 1);		
	}
	
	@Test
	void testTotaADesenbolsarDeCreditosEnElBanco() {
		
		banco.registrarSolicitud(solicitudDeCredito1);
		banco.registrarSolicitud(solicitudDeCredito2);
		
		when(sectorContable.totalADesenbolsar(banco)).thenReturn(30000.0);

		assertEquals(banco.totalADesenbolsar(), 30000.0);		
	}
	
	@Test
	void testOtorgarCreditoAlCliente() {	
		
		//when(solicitudDeCredito1.esAceptada()).thenReturn(true);
		//when(solicitudDeCredito1.getCliente()).thenReturn(cliente);
		//when(solicitudDeCredito1.monto()).thenReturn(10.0);
		when(cliente.acreditarMonto(10.0)).thenReturn(10.0);
		
		banco.otorgarCredito(solicitudDeCredito1);
		
		verify(sectorCrediticio).analizarCredito(solicitudDeCredito1);
		//verify(solicitudDeCredito1).getCliente();
		//verify(cliente).acreditarMonto(10.0);
		
		assertEquals(banco.getSolicitudesDeCredito().size(), 1);		
	}

	
	

}
