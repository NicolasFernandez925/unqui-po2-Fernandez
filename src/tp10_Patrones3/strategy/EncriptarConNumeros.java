package tp10_Patrones3.strategy;

public class EncriptarConNumeros implements ModoEncriptacion {
	
	private String abecedario = "abcdefghijklmnñopqrstuvwxyz";
	private StringBuffer textoEncriptado;
	
	public EncriptarConNumeros() {
		super();
		textoEncriptado = new StringBuffer();
	}

	@Override
	public StringBuffer encriptar(String texto) {
		textoEncriptado.setLength(0);
		String textoMinusculas = texto.toLowerCase();
		char caracter;
		for (int i = 0; i < textoMinusculas.length(); i++) {
			caracter = textoMinusculas.charAt(i);
			if(caracter == ' ') {
				textoEncriptado.append("0");
				textoEncriptado.append(",");
			}
			else {
				textoEncriptado.append(this.cambiarPorNumero(caracter));
				textoEncriptado.append(",");
			}
		}
		// En este caso se resta 1 para sacar la ultima "," que pone al final del String
		return textoEncriptado.deleteCharAt(textoEncriptado.length() - 1);
	}

	private String cambiarPorNumero(char caracter) {
		int index = this.getAbecedario().indexOf(caracter);
		return String.valueOf(index + 1);
	}

	@Override
	public StringBuffer desencriptar(String texto) {
		textoEncriptado.setLength(0);
		String textoMinusculas = texto.toLowerCase();
		String[] textoList = textoMinusculas.split(",");
		
		for (String string : textoList) {
			textoEncriptado.append(this.cambiarPorLetras(string));
		}	
		return textoEncriptado;
	}
	
	// Nota: Se resta 1 por la posicion de la ",", osea si el caracterIndex es una "," se le resta dicha posicion
	private String cambiarPorLetras(String caracterIndex) {
		char charr = this.getAbecedario().charAt(Integer.valueOf(caracterIndex) - 1);
		return String.valueOf(charr);
		
	}

	public String getAbecedario() {
		return abecedario;
	}


}
