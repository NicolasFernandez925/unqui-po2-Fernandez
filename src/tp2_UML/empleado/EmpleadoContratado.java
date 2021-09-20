package tp2_UML.empleado;

import java.util.Calendar;

import tp2_UML.reciboDeHaber.ReciboDeHaber;

public class EmpleadoContratado extends Empleado {
	
	private int nroContrato;
	private String medioDePago;
	private final double gastosAdministrativosContractuales = 50;
	
	public EmpleadoContratado(String medioDePago, String nombre, String direccion, Calendar fechaNacimiento,int nroContrato, Double sueldoBasico ) {
		this.medioDePago = medioDePago;
		this.nroContrato = nroContrato;
		this.nombre = nombre;
		this.sueldoBasico = sueldoBasico;
		this.direccion = direccion;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	@Override
	public Double retenciones() {
		return this.gastosAdministrativosContractuales;
	}
	
	@Override
	public Double sueldoBruto() {
		return this.getSueldoBasico();		
	}

	@Override
	public void generarDesgloceDeConceptos(ReciboDeHaber recibo) {
		recibo.agregarConcepto("SueldoBruto", String.valueOf(this.sueldoBruto()));
		recibo.agregarConcepto("SueldoNeto", String.valueOf(this.sueldoNeto()));
		recibo.agregarConcepto("gastosAdministrativos", String.valueOf(this.gastosAdministrativosContractuales));	
	}
	
}
