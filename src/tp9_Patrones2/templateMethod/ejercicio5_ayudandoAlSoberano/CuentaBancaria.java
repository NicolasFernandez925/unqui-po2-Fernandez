package tp9_Patrones2.templateMethod.ejercicio5_ayudandoAlSoberano;

import java.util.ArrayList;
import java.util.List;

public abstract class CuentaBancaria {
		
	/**
	 * Clase abstracta: CuentaBancaria
	 * Clase concreta: CuentaCorriente, CajaDeAhorro
	 * Template method: extraer()
	 * operaciones primitivas: puedeExtraer()
	 * operaciones concretas: * setSaldo()
			 				  * agregarMovimientos()
	 * Hook method no se utilizo
	 * */

	private String titular;
	private int saldo;
	private List<String> movimientos;
	
	public CuentaBancaria(String titular){
		this.titular=titular;
		this.saldo=0;
		this.movimientos= new ArrayList<String>();
	}
	
	public void agregarMovimientos(String movimiento){
		this.movimientos.add(movimiento);
	}
	
	public void extraer(int monto) {
		 if(this.puedeExtraer(monto)){ 
			 this.setSaldo(this.getSaldo()-monto);
			 this.agregarMovimientos("Extraccion");
		 }
	}
	
	public abstract Boolean puedeExtraer(int monto);
	
	
	public String getTitular(){
		return this.titular;
	}

	public int getSaldo(){
		return this.saldo;
	}
	
	protected void setSaldo(int monto){
		this.saldo=monto;
	}
}
