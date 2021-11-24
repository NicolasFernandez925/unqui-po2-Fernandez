package tp11_refactor.cuenta;

public abstract class CuentaBancaria {
	protected HistorialMovimientos historialDeMovimientos;
	protected Notificador notificador;
	protected int saldo;
	
	/**
	 * Duplicate code: La clase CajaAhorro y CuentaCorriente estan duplicando lineas de código,
	 * el descuento del saldo, registrar historia de movimientos y la notificación al cliente son
	 * lineas de código que son para todas las cuentas iguales. Lo que si cambiaría es la condición 
	 * de extraccion de cada una:
	 * si dispone de saldo disponible realiza las operaciones concretas.
	 * 
	 * Solución: Se opto por implementar El patrón template Method para solucionar el duplicidad 
	 * de código en la clase CajaAhorro cómo en CuentaCorriente.
	 * 
	 * Extract method : Se aplica para ampliar la reutilización de la extraccion con el método #tieneSuficienteSaldo
	 * 
	 * */
	
	public CuentaBancaria(HistorialMovimientos historialDeMovimientos, Notificador notificador, Integer saldo) {
		super();
		this.historialDeMovimientos = historialDeMovimientos;
		this.notificador = notificador;
		this.saldo = saldo;
	}

	public int getSaldo() {
		return saldo;
	}
	
	// Template method
	public void extraer(Integer monto) {
		if(this.tieneSuficienteSaldo(monto)) { // Operación primitiva
			this.extraccionExitosa(monto); // Operación concreta
		}
	}
	
	public void extraccionExitosa(Integer monto) {
		this.saldo = saldo - monto; 
		this.historialDeMovimientos.registrarMovimiento("ExtracciÃ³n", monto);
		this.notificador.notificarNuevoSaldoACliente(this);
	}

	public abstract boolean tieneSuficienteSaldo(Integer monto);
}
