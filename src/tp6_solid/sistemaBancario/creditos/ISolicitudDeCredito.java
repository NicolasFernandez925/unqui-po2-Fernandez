package tp6_solid.sistemaBancario.creditos;

import tp6_solid.sistemaBancario.Cliente;

public interface ISolicitudDeCredito {

	public boolean esAceptada();
	public double monto();
	public Cliente getCliente();
	
}
