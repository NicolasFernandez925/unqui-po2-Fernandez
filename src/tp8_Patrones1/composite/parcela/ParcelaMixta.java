package tp8_Patrones1.composite.parcela;

import java.util.ArrayList;
import java.util.List;

public class ParcelaMixta implements Parcela {

	List<Parcela> parcelas;
	
	public ParcelaMixta() {
		this.parcelas = new ArrayList<Parcela>();
	}

	@Override
	public double ganancia() {
		System.out.println("Parcela mixta" );
		double sum = this.parcelas.stream().mapToDouble(p -> p.ganancia()).sum();
		return sum / 4;
	}
	
	public void agregar(Parcela p) {
		this.parcelas.add(p);
	}
	
	public void borrarParcela(Parcela p) {
		this.parcelas.remove(p);
	}
	
}
