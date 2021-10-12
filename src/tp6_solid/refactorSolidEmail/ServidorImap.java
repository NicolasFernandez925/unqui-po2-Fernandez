package tp6_solid.refactorSolidEmail;

import java.util.List;

public class ServidorImap implements IServidor, IMantenimiento {

	@Override
	public List<Correo> recibirNuevos(String user, String pass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void conectar(String nombreUsuario, String passusuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enviar(Correo correo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public float tazaDeTransferencia() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void resetear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void realizarBackUp() {
		// TODO Auto-generated method stub
		
	}

}
