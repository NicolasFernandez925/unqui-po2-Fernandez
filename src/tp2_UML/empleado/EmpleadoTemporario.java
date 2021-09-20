package tp2_UML.empleado;

import java.util.Calendar;

import tp2_UML.reciboDeHaber.ReciboDeHaber;

public class EmpleadoTemporario extends Empleado {

	private Calendar fechaDeFinPlantaTemp;
	private int horasExtras;
	
	public EmpleadoTemporario(String nombre, String direccion,Calendar fechaNacimiento, Calendar fechaDeFinPlantaTemp,int horasExtras, Double sueldoBasico ) {
		this.horasExtras = horasExtras;
		this.nombre = nombre;
		this.sueldoBasico = sueldoBasico;
		this.direccion = direccion;
		this.fechaDeFinPlantaTemp = fechaDeFinPlantaTemp;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	private double aportesJubilatoriosMayorA50() {
		Double obraSocial =  this.sueldoBruto() * 0.1;
		if( this.calcularEdad() > 50 ) {
			obraSocial +=  5 * this.horasExtras;
		} 	
		return obraSocial;
	}
	
	private double obraSocial() {
		return this.sueldoBruto() * 0.1;
	}
	
	private Double extraPorHorasExtras() {
		return (double)(40 * this.horasExtras);
	}
	
	@Override
	public Double retenciones() {
		return this.obraSocial() + this.aportesJubilatoriosMayorA50();
	}

	@Override
	public Double sueldoBruto() {
		return this.getSueldoBasico() + this.extraPorHorasExtras();		
	}

	@Override
	public void generarDesgloceDeConceptos(ReciboDeHaber recibo) {
		recibo.agregarConcepto("nombreEmpleado", recibo.getNombreEmpleado());
		recibo.agregarConcepto("direccion", recibo.getDireccion() );
		recibo.agregarConcepto("fechaEmision", String.valueOf(recibo.getFechaEmision()));
		recibo.agregarConcepto("SueldoBruto", String.valueOf(this.sueldoBruto()));
		recibo.agregarConcepto("SueldoNeto",  String.valueOf(this.sueldoNeto()));
		recibo.agregarConcepto("HorasExtras",  String.valueOf(this.extraPorHorasExtras()));
		recibo.agregarConcepto("ObraSocial ",  String.valueOf(this.obraSocial()));
		recibo.agregarConcepto("AporteJubilatorios",  String.valueOf(this.aportesJubilatoriosMayorA50()));
	}
}
