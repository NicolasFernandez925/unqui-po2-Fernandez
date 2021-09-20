package tp2_UML.reciboDeHaber;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ReciboDeHaber {	
		private String nombreEmpleado;
		private String direccion;
		private Date fechaEmision;
		private Double sueldoBruto;
		private Double sueldoNeto;
		private Map<String, String> desgloce;
		
		public ReciboDeHaber(String nombreEmpleado,String direccion, Double sueldoBruto, Double sueldoNeto) {
			this.direccion = direccion;
			this.nombreEmpleado = nombreEmpleado;
			this.fechaEmision = new Date();
			this.sueldoBruto = sueldoBruto;
			this.sueldoNeto = sueldoNeto;
			this.desgloce = new HashMap<String, String>();
		}
		
		public void agregarConcepto(String concepto, String value) {
			desgloce.put("direccion", this.direccion);
			desgloce.put("nombreEmpleado", this.direccion);
			desgloce.put(concepto, value);
		}

		public String getNombreEmpleado() {
			return nombreEmpleado;
		}

		public String getDireccion() {
			return direccion;
		}

		public Date getFechaEmision() {
			return fechaEmision;
		}	

}


