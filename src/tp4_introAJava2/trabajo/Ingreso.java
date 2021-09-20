package tp4_introAJava2.trabajo;

import java.time.Month;
import java.time.LocalDate;

public class Ingreso {

	private Month mesDePercepcion;
	private String concepto;
	private double montoPercibido;
	
	public Ingreso(String concepto, double montoPercibido) {
		super();
		this.mesDePercepcion = LocalDate.now().getMonth();
		this.concepto = concepto;
		this.montoPercibido = montoPercibido;
	}
	
	public Month getMesDePercepcion() {
		return this.mesDePercepcion;
	}
	
	public double getMontoImponibleAlImpuesto() {
		return this.montoPercibido;
	}

	public String getPercepcion() {
		return this.concepto;
	}
	public double getMontoPercibido() {
		return this.montoPercibido;
	}
	
}
