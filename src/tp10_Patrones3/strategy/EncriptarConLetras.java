package tp10_Patrones3.strategy;

public class EncriptarConLetras implements ModoEncriptacion {
	
	private String vocales = "aeiouAEIOU";
	private StringBuffer textoEncriptado;
	
	public EncriptarConLetras() {
		super();
		textoEncriptado = new StringBuffer();
	}
	
	@Override
	public StringBuffer encriptar(String texto) {
		textoEncriptado.setLength(0);
		char caracter;
		for (int i = 0; i < texto.length(); i++) {
			caracter = texto.charAt(i);
			if(this.hayVocal(caracter, this.getVocales())) {
				textoEncriptado.append(this.siguienteVocal(caracter));
			}
			else {
				textoEncriptado.append(caracter);
			}		
		}
		
		return textoEncriptado;
	}

	private boolean hayVocal(char caracter, String texto) {	
		return texto.contains(String.valueOf(caracter));
	}

	private String siguienteVocal(char caracter) {
		int posicionVocal = vocales.indexOf(caracter);
		
		if(posicionVocal == 4) {
			return "a";
		}
		
		if(posicionVocal == 9) {
			return "A";
		}

		return String.valueOf(vocales.charAt(posicionVocal + 1));
	}
	
	private String anteriorVocal(char caracter) {
		int posicionVocal = vocales.indexOf(caracter);
	
		if(posicionVocal == 0) {
			return "u";
		}
		
		if(posicionVocal == 5) {
			return "U";
		}
		return String.valueOf(vocales.charAt(posicionVocal - 1));
	}

	@Override
	public StringBuffer desencriptar(String texto) {
		textoEncriptado.setLength(0);
		char caracter;
		for (int i = 0; i < texto.length(); i++) {
			caracter = texto.charAt(i);
			if(this.hayVocal(caracter, this.getVocales())) {
				textoEncriptado.append(this.anteriorVocal(caracter));
			}
			else {
				textoEncriptado.append(caracter);
			}		
		}
		
		return textoEncriptado;
	}
	
	public String getVocales() {
		return vocales;
	}

}
