package tp3_introAJava1.persona;

import java.util.Date;

public class Persona {
	private int edad;
	private String nombre;
	private Date fechaNac;
	private String apellido;
	
	public Persona(int edad, Date fechaNac, String nombre, String apellido) {
		this.edad = edad;
		this.apellido = apellido;
		this.fechaNac = fechaNac;
		this.nombre = nombre;
	}
	
	public boolean menorQue(Persona persona) {
		return this.getEdad() < persona.getEdad();
	}
	
	public int getEdad() {
		return edad;
	}
	
	public Date getFechaNac() {
		return fechaNac;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getApellido() {
		return apellido;
	}

}
