package tp8_Patrones1.composite.sistemaDeArchivos;


import java.time.LocalTime;
import java.util.ArrayList;

import java.util.stream.Collectors;

public class Directorio implements FyleSystem {
	
	private LocalTime fechaCreacion;
	private String nombre;
	private ArrayList<FyleSystem> archivos;
	
	public Directorio(String nombre) {
		this.archivos = new ArrayList<FyleSystem>();
		this.fechaCreacion = LocalTime.now();
		this.nombre = nombre;
	}
	
	@Override
	public int totalSize() {
		// TODO Auto-generated method stub
		return archivos.stream().mapToInt(a -> a.totalSize()).sum();
	}
	
	public void remove(FyleSystem f) {
		archivos.remove(f);
	}
	
	public void add(FyleSystem f) {
		archivos.add(f);
	}

	@Override
	public FyleSystem lastModified() {
		FyleSystem elemento = this;
		for(FyleSystem file: archivos) {
			elemento = this.ultimoModificado(elemento,file);
		}
		return elemento;
		
	// Es otra forma de hacerlo
	//	LocalTime maxDate = archivos.stream().map(a -> a.getCreationDate()).max(LocalTime::compareTo).get();
	//	return archivos.stream().filter(a -> a.getCreationDate() == maxDate).collect(Collectors.toList()).get(0);
	}
	
	public FyleSystem ultimoModificado(FyleSystem elemento1,FyleSystem elemento2) {
		return elemento1.getCreationDate().isAfter(elemento2.getCreationDate()) ? elemento1 : elemento2;
	}
	
	public FyleSystem masAntiguo(FyleSystem elemento1,FyleSystem elemento2) {
		
		return elemento1.getCreationDate().isBefore(elemento2.getCreationDate()) ? elemento1 : elemento2;
	}

	@Override
	public FyleSystem oldesElement() {
		FyleSystem elemento = this;
		for(FyleSystem file: archivos) {
			System.out.println(file.getCreationDate() + file.getName());
			elemento = this.masAntiguo(elemento,file);
		}
		return elemento;
		
		// Es otra forma de hacerlo
		//LocalTime minDate = archivos.stream().map(a -> a.getCreationDate()).min(LocalTime::compareTo).get();
		//return archivos.stream().filter(a -> a.getCreationDate() == minDate).collect(Collectors.toList()).get(0);
	}

	@Override
	public void printStructure() {	
		System.out.println("Directory: " + getName());   
		for(FyleSystem f : archivos){
			f.printStructure();
		}
	
	}

	@Override
	public LocalTime getCreationDate() {
		// TODO Auto-generated method stub
		return this.fechaCreacion;
	}


	@Override
	public String getName() {
		return this.nombre;
		
	}
	
}