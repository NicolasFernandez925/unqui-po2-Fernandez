package tp2_UML.empleado;

import java.util.Calendar;
import java.util.List;

import tp2_UML.reciboDeHaber.ReciboDeHaber;

public abstract class Empleado {
	
	protected String nombre;
	protected String direccion;
	protected Boolean estadoCivil;
	protected Calendar fechaNacimiento;
	protected Double sueldoBasico;
	protected List<ReciboDeHaber> recibos; 

	public void agregarRecibo(ReciboDeHaber r) {
		recibos.add(r);
	}
	
	public List<ReciboDeHaber> getRecibos(){
		return recibos;
	}
	
	public void seCaso() {
		this.estadoCivil = true;
	}
	
	public void seDivorcio() {
		this.estadoCivil = false;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getEstadoCivil() {
		return nombre;
	}
	
	public String getDireccion() {
		return direccion;
	}

	public Double getSueldoBasico() {
		return sueldoBasico;
	}

	public void setFechaNacimiento(Calendar fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public Integer calcularEdad() {
		Calendar fechaActual = Calendar.getInstance();
		int anio = fechaActual.get(Calendar.YEAR)- this.fechaNacimiento.get(Calendar.YEAR);
	    int mes =fechaActual.get(Calendar.MONTH)- this.fechaNacimiento.get(Calendar.MONTH);
	    int dia = fechaActual.get(Calendar.DATE)- this.fechaNacimiento.get(Calendar.DATE);
	    
	    if(mes < 0 || (mes == 0 && dia <0)) anio--;
	              
		return anio;
	}
	
	public Double sueldoNeto() {
		return this.sueldoBruto() - this.retenciones();
	}
	
	public abstract Double retenciones();	
	public abstract Double sueldoBruto();
	public abstract void generarDesgloceDeConceptos(ReciboDeHaber recibo);
		
   
}
