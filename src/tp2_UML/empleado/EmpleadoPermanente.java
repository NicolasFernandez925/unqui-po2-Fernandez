package tp2_UML.empleado;

import java.util.Calendar;

import tp2_UML.reciboDeHaber.ReciboDeHaber;

public class EmpleadoPermanente extends Empleado {
	
	private int cantidadDeHijos;
	private int antiguedad;

	public EmpleadoPermanente(Calendar fechaNacimiento, int antiguedad, int cantidadDeHijos, String nombre, String direccion,int horasExtras, Double sueldoBasico ) {
		this.nombre = nombre;
		this.antiguedad = antiguedad;
		this.cantidadDeHijos = cantidadDeHijos;
		this.direccion = direccion;
		this.sueldoBasico = sueldoBasico;
		this.fechaNacimiento = fechaNacimiento;
	
	}
	
	public double aportesJubilatorios() {
		return (this.sueldoBruto() * 15) / 100;
		
	}
	
	private double obraSocial() {
		return this.sueldoBruto() * 0.1 + 20 * this.cantidadDeHijos;
	}

	public double salarioFamiliar() {
		return this.asignacionporHijo() + this.asignacionPorConyugue() + this.plusPorAntiguedad();
	}
	
	private double asignacionporHijo() {
		return 150 * this.cantidadDeHijos;
	}
	
	private double asignacionPorConyugue() {
		return this.estadoCivil ? 100 : 0;
	}
	
	private double plusPorAntiguedad() {
		return 5 * this.antiguedad;
	}
	
	@Override
	public Double retenciones() {
		return this.obraSocial() + this.aportesJubilatorios();
	}

	@Override
	public Double sueldoBruto() {
		return this.getSueldoBasico() + this.salarioFamiliar();	
	}

	@Override
	public void generarDesgloceDeConceptos(ReciboDeHaber recibo) {
		recibo.agregarConcepto("nombreEmpleado", recibo.getNombreEmpleado());
		recibo.agregarConcepto("direccion", recibo.getDireccion() );
		recibo.agregarConcepto("fechaEmision", String.valueOf(recibo.getFechaEmision()));
		recibo.agregarConcepto("SueldoBruto", String.valueOf(this.sueldoBruto()));
		recibo.agregarConcepto("SueldoNeto", String.valueOf(this.sueldoNeto()));
		recibo.agregarConcepto("Salariofamiliar", String.valueOf(this.salarioFamiliar()));
		recibo.agregarConcepto("ObraSocial ", String.valueOf(this.obraSocial()));	
		recibo.agregarConcepto("AporteJubilatorios ", String.valueOf(this.aportesJubilatorios()));	
	}
}
