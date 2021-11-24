package tp9_Patrones2.templateMethod.ejercicio2_SueldosRecargados;

public abstract class Empleado {
	
	/**
	 * Clase abstracta: Empleado
	 * Clase concreta: Pasante, Planta, Temporario;
	 * Template method: sueldo();
	 * operaciones primitivas: sueldoBruto();
	 * operaciones concretas: this.descuentoYOBraSocial()
	 * Hook method no se utilizo
	 * */
	
	public double sueldo() {
		return this.sueldoBruto() - this.descuentoYOBraSocial();
	}

	private double descuentoYOBraSocial() {
		// TODO Auto-generated method stub
		return this.sueldoBruto() * 100 / 13;
	}

	protected abstract double sueldoBruto();
	

}
