package tp9_Patrones2.templateMethod.ejercicio2_SueldosRecargados;

public class Planta extends Empleado {


	private double sueldoBasico;
	private int cantidadHijos;
	private double plusPorHijo;
	
	public Planta(int cantidadHijos) {
		super();
		this.sueldoBasico = 3000;
		this.cantidadHijos = cantidadHijos;
		this.plusPorHijo = 150;
	}


	@Override
	public double sueldoBruto() {
		// TODO Auto-generated method stub
		return this.getSueldoBasico() + this.getCantidadHijos() * this.getPlusPorHijo();
	}
	

	public double getSueldoBasico() {
		return sueldoBasico;
	}


	public void setSueldoBasico(double sueldoBasico) {
		this.sueldoBasico = sueldoBasico;
	}


	public int getCantidadHijos() {
		return cantidadHijos;
	}


	public void setCantidadHijos(int cantidadHijos) {
		this.cantidadHijos = cantidadHijos;
	}


	public double getPlusPorHijo() {
		return plusPorHijo;
	}


	public void setPlusPorHijo(double plusPorHijo) {
		this.plusPorHijo = plusPorHijo;
	}


}
