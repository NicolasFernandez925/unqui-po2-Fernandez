package tp8_Patrones1.composite.sistemaDeArchivos;

import java.time.LocalTime;

public class Archivo implements FyleSystem {
	
	private String name;
	private int size;
	private LocalTime ultimaModificacion;
	private LocalTime fechaDeCreacion;
	
	public Archivo(String name, int size) {
		this.size = size;
		this.name = name;
		this.ultimaModificacion = LocalTime.now();
		this.fechaDeCreacion = LocalTime.now();
	}

	@Override
	public int totalSize() {
		// TODO Auto-generated method stub
		return this.size;
	}
	
	public LocalTime getUltimaModificacion() {
		return this.ultimaModificacion;
	}

	@Override
	public FyleSystem lastModified() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public FyleSystem oldesElement() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public void printStructure() {
		System.out.println("File: " + this.name);
		
	}
	

	public String getName() {
		return this.name;
		
	}

	@Override
	public LocalTime getCreationDate() {
		// TODO Auto-generated method stub
		return this.fechaDeCreacion;
	}

}
