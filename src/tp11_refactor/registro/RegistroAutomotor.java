package tp11_refactor.registro;

import java.time.LocalDate;

public class RegistroAutomotor {
	
	/**
	 * Feature Envy : en la clase RegistroAutomotor, est� accediendo a los atributos
	 * del vehiculo para luego calcular si debe realizar o no la vtv.
	 * En tal caso el responsable de verificarlo deberia de realizarlo el vehiculo
	 * ya que es la clase con la cual tiene los atributos para para realizar la verificaci�n 
	 * y no que sea el registro quien lo haga. Ademas la clase Vehiculo antes del refactor
	 * era un Data class, solo sab�a devolver datos.
	 * 
	 * Se opt� por mover la condici�n a la clase Vehiculo.
	 * */

	public Boolean debeRealizarVtv(Vehiculo vehiculo, LocalDate fecha) {
		return vehiculo.verificarVtv(fecha);
	}
}
