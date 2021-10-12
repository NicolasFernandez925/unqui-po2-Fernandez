package tp6_solid.sistemaBancario;

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
	
}
