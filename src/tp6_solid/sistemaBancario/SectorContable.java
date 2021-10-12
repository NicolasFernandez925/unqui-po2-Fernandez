package tp6_solid.sistemaBancario;

public class SectorContable {

	public double totalADesenbolsar(Banco banco) {
		return banco.getSolicitudesDeCredito().stream().filter(e -> e.esAceptada()).mapToDouble(e -> e.monto()).sum();
	}
	
}
