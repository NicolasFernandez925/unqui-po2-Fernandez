package tp4_introAJava2.trabajo;

import java.util.ArrayList;
import java.util.List;

public class Trabajador {
	
	private final int impuesto = 2;
	
	private List<Ingreso> ingresos = new ArrayList<Ingreso>();

	public double getTotalPersibido() {
		return ingresos.stream().mapToDouble( i -> i.getMontoPercibido()).sum();
	}
	
	public double getMontoImponible() {
		return ingresos.stream().mapToDouble( i -> i.getMontoImponibleAlImpuesto()).sum();
	}
	
	public double getImpuestoAPagar() {
		return (this.getMontoImponible() * this.impuesto) / 100;
	}
	
	public void addIngreso(Ingreso i) {
		ingresos.add(i);
	}

}
