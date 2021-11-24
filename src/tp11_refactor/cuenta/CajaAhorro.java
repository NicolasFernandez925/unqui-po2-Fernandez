package tp11_refactor.cuenta;

public class CajaAhorro extends CuentaBancaria{

	public CajaAhorro(HistorialMovimientos historialDeMovimientos, Notificador notificador, Integer saldo) {
		super(historialDeMovimientos, notificador, saldo);
	}

	@Override
	public boolean tieneSuficienteSaldo(Integer monto) {
		return this.saldo >= monto;
	}
}
