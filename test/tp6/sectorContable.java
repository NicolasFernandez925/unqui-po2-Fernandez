package tp6;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp6_solid.sistemaBancario.Banco;
import tp6_solid.sistemaBancario.Cliente;
import tp6_solid.sistemaBancario.SectorContable;
import tp6_solid.sistemaBancario.creditos.ISolicitudDeCredito;

class sectorContable {
	
	SectorContable sectorContable;
	Cliente cliente;
	ISolicitudDeCredito solicitudDeCredito1;
	ISolicitudDeCredito solicitudDeCredito2;
	Banco banco;


	@BeforeEach
	void setUp() throws Exception {
		
		sectorContable = new SectorContable(); // Sut
		
		solicitudDeCredito1 = mock(ISolicitudDeCredito.class); // Doc
		solicitudDeCredito2 = mock(ISolicitudDeCredito.class); // Doc
		banco = mock(Banco.class); // Dummy
		
	}

	@Test
	void testMontoTotalDeCreditosAceptadosDelBanco() {
		
		List<ISolicitudDeCredito> solicitudes = new ArrayList<ISolicitudDeCredito>();	
		
		solicitudes.add(solicitudDeCredito1);
		solicitudes.add(solicitudDeCredito2);
		
		when(banco.getSolicitudesDeCredito()).thenReturn(solicitudes);
		
		when(solicitudDeCredito1.esAceptada()).thenReturn(true);
		when(solicitudDeCredito1.monto()).thenReturn(15000.0);
		
		when(solicitudDeCredito2.esAceptada()).thenReturn(true);
		when(solicitudDeCredito2.monto()).thenReturn(15000.0);
		
		assertEquals(sectorContable.totalADesenbolsar(banco), 30000.0);
		
	}

}
