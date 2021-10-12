package tp6_solid.sistemaBancario;

import tp6_solid.sistemaBancario.creditos.SolicitudDeCreditoHipotecario;
import tp6_solid.sistemaBancario.creditos.SolicitudDeCreditoPersonal;

public class Cliente {
	
	private String nombre;
	private String apellido;
	private int edad;
	private double montoDeCredito;
	private double sueldoNeto;
	private String direccion;

	public Cliente(String nombre, String apellido, int edad, double sueldoNeto, double sueldoNetoAnual,
			String direccion) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.sueldoNeto = sueldoNeto;
		this.direccion = direccion;
		this.montoDeCredito = 0d;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getApellido() {
		return apellido;
	}

	public int getEdad() {
		return edad;
	}

	public double getSueldoNeto() {
		return sueldoNeto;
	}

	public double getSueldoNetoAnual() {
		return this.getSueldoNeto() * 12;
	}

	public String getDireccion() {
		return direccion;
	}
	
	public double acreditarMonto(double montoCredito) {
		return this.montoDeCredito += montoCredito;
	}
	
	/*public void solicitarCreditoPersonal(Banco banco, double monto, int cuotas) {
		SolicitudDeCreditoPersonal solicitud = new SolicitudDeCreditoPersonal(this, monto, cuotas);
		SistemaInformaticoBancario.registrarSolicitud(solicitud, banco);
	}
	
	public void solicitarCreditoHipotecario(Banco banco, double monto, int cuotas, Propiedad propiedad) {
		SolicitudDeCreditoHipotecario solicitud = new SolicitudDeCreditoHipotecario(this, monto, cuotas, propiedad);
		SistemaInformaticoBancario.registrarSolicitud(solicitud, banco);
	}
	*/
	
}
