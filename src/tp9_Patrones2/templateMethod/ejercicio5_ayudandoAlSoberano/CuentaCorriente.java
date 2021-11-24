package tp9_Patrones2.templateMethod.ejercicio5_ayudandoAlSoberano;

public class CuentaCorriente extends CuentaBancaria {
	 private int descubierto;
	 
	 public CuentaCorriente(String titular, int descubierto){
		 super(titular);
		 this.descubierto=descubierto;
	 }
	 
	 public int getDescubierto(){
		 return this.descubierto;
	 }
	 
	 @Override
	 public Boolean puedeExtraer(int monto) {
		return this.getSaldo() + this.getDescubierto() >= monto;	
	 }
}
