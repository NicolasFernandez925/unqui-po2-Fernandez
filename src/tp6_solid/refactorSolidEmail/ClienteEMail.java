package tp6_solid.refactorSolidEmail;

import java.util.ArrayList;

import java.util.List;


public class ClienteEMail {
	
	 IServidor servidor;
	 String nombreUsuario;
	 String passusuario;
	 Bandeja bandejaDeEntrada;
	 Correo correo;
	
	public ClienteEMail(ServidorPop servidor, String nombreUsuario, String pass, Bandeja bandejaDeEntrada, Correo correo){
		this.servidor=servidor;
		this.nombreUsuario=nombreUsuario;
		this.bandejaDeEntrada = bandejaDeEntrada;
		this.correo = correo;
		this.passusuario=pass;
		this.conectar();
	}
	
	public void conectar(){
		this.servidor.conectar(this.nombreUsuario,this.passusuario);
	}
	
	public void recibirNuevos(){
		List<Correo> mails = this.servidor.recibirNuevos(this.nombreUsuario, this.passusuario);
		bandejaDeEntrada.mailsNuevos(mails);
	}
	
	/*public void enviarCorreo(String asunto, String destinatario, String cuerpo){
		Correo correo = new Correo(asunto, destinatario, cuerpo);
		this.servidor.enviar(correo);
	}
	*/
	
	public void enviarCorreo(){
		this.servidor.enviar(correo);
	}

}
