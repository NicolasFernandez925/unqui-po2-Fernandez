package tp6_solid.sistemaBancario.creditos;

import tp6_solid.sistemaBancario.Cliente;

public class SolicitudDeCreditoPersonal extends SolicitudDeCredito {

	public SolicitudDeCreditoPersonal(Cliente cliente, double montoSolicitado, int plazoEnMeses) {
		super(cliente,montoSolicitado,plazoEnMeses);
	}
	
	@Override
	public boolean esAceptada() {
		return (cliente.getSueldoNetoAnual() > 15000d) && (this.montoCuotaMensual() < cliente.getSueldoNeto() * 70 / 100);
	}
	
}
