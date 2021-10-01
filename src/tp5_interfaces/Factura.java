package tp5_interfaces;

public abstract class Factura implements IPagable {

	protected Agencia agencia;
	
	abstract public double montoAPagar();
	
	@Override
	public void registrar() throws Exception {
		agencia.registrarPago(this);	
	}
	
	public IAgencia getAgencia() {
		return this.agencia;
	}
	
}
