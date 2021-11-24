package tp9_Patrones2.templateMethod.ejercicio2_SueldosRecargados;

public class Temporario extends Empleado{
	
	private double precioPorHora;
	private double sueldoBasico;
	private Boolean estaCasado;
	private Boolean tieneHijos;
	private int horasQueTrabajo;
	
	public Temporario(Boolean estaCasado, Boolean tieneHijos, int horasQueTrabajo) {
		super();
		this.precioPorHora = 5;
		this.sueldoBasico = 1000;
		this.estaCasado = estaCasado;
		this.tieneHijos = tieneHijos;
		this.horasQueTrabajo = horasQueTrabajo;
	}

	@Override
	public double sueldoBruto() {
		return this.getPrecioPorHora() * this.gethorasQueTrabajo() + this.sueldoBasico + this.plus();
	}
	
	private double plus() {
		return estaCasado || tieneHijos ? 100.0 : 0.0;
	}

	public double getPrecioPorHora() {
		return precioPorHora;
	}
	
	public int gethorasQueTrabajo() {
		return horasQueTrabajo;
	}


	public void setPrecioPorHora(double precioPorHora) {
		this.precioPorHora = precioPorHora;
	}


	public double getSueldoBasico() {
		return sueldoBasico;
	}


	public void setSueldoBasico(double sueldoBasico) {
		this.sueldoBasico = sueldoBasico;
	}


	public Boolean getEstaCasado() {
		return estaCasado;
	}


	public Boolean getTieneHijos() {
		return tieneHijos;
	}
	
	public void setEstaCasado(Boolean estaCasado) {
		this.estaCasado = estaCasado;
	}


	public void setTieneHijos(Boolean tieneHijos) {
		this.tieneHijos = tieneHijos;
	}

}
