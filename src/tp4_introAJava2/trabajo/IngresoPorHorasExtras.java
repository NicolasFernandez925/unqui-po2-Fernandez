package tp4_introAJava2.trabajo;

public class IngresoPorHorasExtras extends Ingreso {

	private int horasExtras;
	
	public IngresoPorHorasExtras(String concepto, double montoPercibido, int horasExtras) {
		super(concepto, montoPercibido);
		this.horasExtras = horasExtras;
	}
	
	@Override
	public double getMontoImponibleAlImpuesto() {
		return 0;
	}

}
