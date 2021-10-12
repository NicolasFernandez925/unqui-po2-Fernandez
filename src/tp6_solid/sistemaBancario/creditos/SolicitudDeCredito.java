package tp6_solid.sistemaBancario.creditos;

import tp6_solid.sistemaBancario.Cliente;

public abstract class SolicitudDeCredito implements ISolicitudDeCredito{

	protected Cliente cliente;
	protected int plazoEnMeses;
	protected double montoSolicitado;
	
	public SolicitudDeCredito(Cliente cliente, double montoSolicitado, int plazoEnMeses ) {
		super();
		this.cliente = cliente;
		this.montoSolicitado = montoSolicitado;
		this.plazoEnMeses = plazoEnMeses;
	}
	
	protected double montoCuotaMensual() {
		return this.getMontoSolicitado() / this.getPlazoEnMeses();
	}
	
	public abstract boolean esAceptada();
	
	@Override
	public Cliente getCliente() {
		return cliente;
	}
	
	@Override
	public double monto() {
		return this.montoSolicitado;
	}
	
	public void setMontoSolicitado(double montoSolicitado) {
		 this.montoSolicitado = montoSolicitado;
	}

	public int getPlazoEnMeses() {
		return plazoEnMeses;
	}

	public double getMontoSolicitado() {
		return montoSolicitado;
	}


}
