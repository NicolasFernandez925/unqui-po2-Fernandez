package tp7_tdd;

public class Carta {
	
	private Palo palo;
	private Valor valor;

	public Carta(Valor valor, Palo palo) {
		this.valor = valor;
		this.palo = palo;
	}
	
	public boolean mayorValor(Carta carta) {
		return this.getValor().ordinal() < carta.getValor().ordinal();
	}
	
	public boolean sonDelMismoPalo(Carta carta) {
		return this.getPalo().equals(carta.getPalo());
	}

	public Palo getPalo() {
		return palo;
	}

	public Valor getValor() {
		return valor;
	}
	
}
