package tp9_Patrones2.templateMethod.ejercicio2_SueldosRecargados;

public class Pasante extends Empleado {
	
	private double precioPorHora;
	private int horasTrabajadas;
	
	public Pasante(double precioPorHora, int horasTrabajadas) {
		super();
		this.precioPorHora = precioPorHora;
		this.horasTrabajadas = horasTrabajadas;
	}

	@Override
	public double sueldoBruto() {
		return this.getPrecioPorHora() * this.getHorasTrabajadas();
	}
	
	public double getPrecioPorHora() {
		return precioPorHora;
	}



	public void setPrecioPorHora(double precioPorHora) {
		this.precioPorHora = precioPorHora;
	}



	public int getHorasTrabajadas() {
		return horasTrabajadas;
	}



	public void setHorasTrabajadas(int horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}


}
