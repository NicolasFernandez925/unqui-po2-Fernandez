package tp11_refactor.cuenta;

public abstract class CuentaBancaria {
	protected HistorialMovimientos historialDeMovimientos;
	protected Notificador notificador;
	protected int saldo;
	
	/**
	 * Duplicate code: La clase CajaAhorro y CuentaCorriente estan duplicando lineas de c�digo,
	 * el descuento del saldo, registrar historia de movimientos y la notificaci�n al cliente son
	 * lineas de c�digo que son para todas las cuentas iguales. Lo que si cambiar�a es la condici�n 
	 * de extraccion de cada una:
	 * si dispone de saldo disponible realiza las operaciones concretas.
	 * 
	 * Soluci�n: Se opto por implementar El patr�n template Method para solucionar el duplicidad 
	 * de c�digo en la clase CajaAhorro c�mo en CuentaCorriente.
	 * 
	 * Extract method : Se aplica para ampliar la reutilizaci�n de la extraccion con el m�todo #tieneSuficienteSaldo
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
		if(this.tieneSuficienteSaldo(monto)) { // Operaci�n primitiva
			this.extraccionExitosa(monto); // Operaci�n concreta
		}
	}
	
	public void extraccionExitosa(Integer monto) {
		this.saldo = saldo - monto; 
		this.historialDeMovimientos.registrarMovimiento("Extracción", monto);
		this.notificador.notificarNuevoSaldoACliente(this);
	}

	public abstract boolean tieneSuficienteSaldo(Integer monto);
}
