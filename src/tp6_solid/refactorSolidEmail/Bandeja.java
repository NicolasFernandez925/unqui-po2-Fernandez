package tp6_solid.refactorSolidEmail;

import java.util.ArrayList;
import java.util.List;

public class Bandeja {
	
	private ArrayList<Correo> inbox;
	private ArrayList<Correo> borrados;
	 
	public Bandeja(){
		this.inbox = new ArrayList<Correo>();
		this.borrados = new ArrayList<Correo>();
	}

	public void borrarCorreo(Correo correo){
		this.inbox.remove(correo);
		this.borrados.remove(correo);
	}
	
	public int contarBorrados(){
		return this.borrados.size();
	}
	
	public int contarInbox(){
		return this.inbox.size();
	}
	
	public void eliminarBorrado(Correo correo){
		this.borrados.remove(correo);
	}
	
	public void mailsNuevos(List<Correo> mails) {
		inbox.addAll(mails);
	}
}
