package tp10_Patrones3.strategy;

public interface ModoEncriptacion {
	StringBuffer encriptar(String texto);
	StringBuffer desencriptar(String texto);
}
