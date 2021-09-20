package tp2_UML.empresa;

import java.util.ArrayList;
import java.util.List;

import tp2_UML.empleado.Empleado;
import tp2_UML.reciboDeHaber.ReciboDeHaber;

public class Empresa {
	
	private int cuit;
	private String nombre;
	private List<Empleado> empleados;
	private List<ReciboDeHaber> recibos;
	
	public Empresa(String nombre, int cuit) {
		this.cuit = cuit;
		this.nombre = nombre;
		this.empleados = new ArrayList<Empleado>();
		this.recibos = new ArrayList<ReciboDeHaber>();
	}
	
	public void agregarEmpleado(Empleado e) {
		empleados.add(e);
	}
	
	public void agregarRecibo(ReciboDeHaber r) {
		recibos.add(r);
	}
	
	public List<Empleado> getEmpleados() {
		return empleados;
	}
	
	public List<ReciboDeHaber> getRecibos() {
		return recibos;
	}
	
	public double montoTotalDeSueldosBrutos() {
		return empleados.stream().mapToDouble(Empleado::sueldoBruto).sum();
	}
	
	public double montoTotalDeRetenciones() {
		return empleados.stream().mapToDouble(Empleado::retenciones).sum();
	}
	public double montoTotalDeSueldosNetos() {
		return empleados.stream().mapToDouble(Empleado::sueldoNeto).sum();
	}
	
	public void liquidarSueldos(List<Empleado> empleados) {
		empleados.stream().forEach( empleado -> {
		    ReciboDeHaber recibo = new ReciboDeHaber(empleado.getNombre(),empleado.getDireccion(), empleado.sueldoBruto(), empleado.sueldoNeto());
		    empleado.generarDesgloceDeConceptos(recibo);
			this.agregarRecibo(recibo);
		});
	}
	
}
