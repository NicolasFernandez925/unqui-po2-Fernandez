package tp6_solid.sistemaBancario.creditos;

import tp6_solid.sistemaBancario.Cliente;
import tp6_solid.sistemaBancario.Propiedad;

public class SolicitudDeCreditoHipotecario extends SolicitudDeCredito {
	
	private Propiedad propiedad;

	public SolicitudDeCreditoHipotecario(Cliente cliente, double montoSolicitado, int plazoEnMeses, Propiedad propiedad) {
		super(cliente,montoSolicitado,plazoEnMeses);	
		this.propiedad = propiedad;
		
	}
	
	@Override
	public boolean esAceptada() {
		return (this.montoCuotaMensual() <= (cliente.getSueldoNeto() * 50 / 100) 
							&& this.getMontoSolicitado() <= (propiedad.getValorFiscal() * 70 / 100)
										&& (cliente.getEdad() + (this.montoCuotaMensual() / 12)) <= 65);
	}

}
