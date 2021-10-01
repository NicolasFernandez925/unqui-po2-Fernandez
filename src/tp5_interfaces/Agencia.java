package tp5_interfaces;

import java.util.ArrayList;
import java.util.List;

public class Agencia implements IAgencia {

	private String nombre;
	private List<Factura> facturas = new ArrayList<Factura>();
	
	public Agencia(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
	public int getCantidad() {
		return facturas.size();
	}

	@Override
	public void registrarPago(Factura f) {
		facturas.add(f);	
	}

}
