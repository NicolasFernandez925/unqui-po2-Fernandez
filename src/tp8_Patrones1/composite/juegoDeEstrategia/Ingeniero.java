package tp8_Patrones1.composite.juegoDeEstrategia;
import java.util.ArrayList;

public class Ingeniero implements IPersonaje {

	private ArrayList<Integer> lajas;
	
	public Ingeniero() {
		this.lajas = new ArrayList<Integer>();
	}
	
	//El ingeniero, pone lajas si no hay ninguna en su ubicacion actual, cuando se queda sin lajas, camina normalmente.;

	@Override
	public void caminar() {
		this.dejarLajas();	
		this.avanzarUnPaso();		
	}
	
	private void dejarLajas() {
		for(int laja : lajas) {
			if(this.hayLajas()) {
				this.ponerLaja();
			}	
		}
	}
	
	private void avanzarUnPaso() {
		
	}

	public void ponerLaja() {
		
	}

	public boolean hayLajas() {
		return false;
	}

}
