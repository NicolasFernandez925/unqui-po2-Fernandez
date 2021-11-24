package tp8_Patrones1.composite.sistemaDeArchivos;

import java.time.LocalTime;

public interface FyleSystem {
	
	public int totalSize();
	public LocalTime getCreationDate();
	public FyleSystem lastModified();
	public FyleSystem oldesElement();
	public void printStructure();
	public String getName();

}
