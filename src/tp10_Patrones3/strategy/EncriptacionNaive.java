package tp10_Patrones3.strategy;

public class EncriptacionNaive {

	private ModoEncriptacion modoEncriptacion;
	
	public EncriptacionNaive(ModoEncriptacion modoEncriptacion) {
		super();
		this.modoEncriptacion = modoEncriptacion;
	}
	
	public StringBuffer encriptar(String texto) {
		return this.getModoEncriptacion().encriptar(texto);
	}
	
	public StringBuffer desencriptar(String texto) {
		return this.getModoEncriptacion().desencriptar(texto);
	}

	public ModoEncriptacion getModoEncriptacion() {
		return modoEncriptacion;
	}

	public void setModoEncriptacion(ModoEncriptacion modoEncriptacion) {
		this.modoEncriptacion = modoEncriptacion;
	} 
}
