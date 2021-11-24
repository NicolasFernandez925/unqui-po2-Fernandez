package tp10_Patrones3.state.videoJuego;

public class MaquinaDeVideoJuego {
	
	private int fichas;
	private EstadoDelJuego estadoJugo;

	public MaquinaDeVideoJuego(int fichas) {
		super();
		this.fichas = fichas;
		this.estadoJugo = new SinFichas();
	}
	
	public void cambiarEstado(EstadoDelJuego nuevoEstado) {
		this.estadoJugo = nuevoEstado;
	}
	public String iniciar() {
		return this.getEstadoJuego().inicio(this);
	}
	
	public String ingresarFichas(int cantidad) {
		return this.getEstadoJuego().ingresarFicha(cantidad, this);
	}
	
	public void descontarFicha(int cant) {
		this.setFichas(this.getFichas() - cant);
	}

	public int getFichas() {
		return fichas;
	}
	
	public void setFichas(int cant) {
		this.fichas = cant;
	}

	public EstadoDelJuego getEstadoJuego() {
		return estadoJugo;
	}
}
