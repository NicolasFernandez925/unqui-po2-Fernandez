package tp6_solid.sistemaBancario;

import tp6_solid.sistemaBancario.creditos.ISolicitudDeCredito;

public class SectorCrediticio {

	public void analizarCredito(ISolicitudDeCredito credito) {
		if(credito.esAceptada()) {
			credito.getCliente().acreditarMonto(credito.monto());
		}
	}
}
