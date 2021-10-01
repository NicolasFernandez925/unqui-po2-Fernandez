package tp5_interfaces.practicaEnumerativos;

public enum Deporte {

	RUNNING(1), FUTBOL(2), BASKET(2), TENIS(3), JABALINDA(4);
	
	private int complejidad;
	
	Deporte(int complejidad){
		this.complejidad = complejidad;
	}
	
	public int getComplejidad() {
		return complejidad;
	}

}
