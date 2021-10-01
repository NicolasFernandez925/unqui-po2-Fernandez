package tp5_interfaces.practicaEnumerativos;

import java.time.LocalTime;

public class ActividadSemanal {
	
	private DiaDeLaSemana dia;
	private LocalTime horaDeInicio;
	private int duracion;
	private Deporte deporte;
	
	public ActividadSemanal(DiaDeLaSemana dia, LocalTime horaDeInicio, int duracion, Deporte deporte) {
		super();
		this.dia = dia;
		this.horaDeInicio = horaDeInicio;
		this.duracion = duracion;
		this.deporte = deporte;
	
	}

	public double costoActividadSemanal() {	
		switch (this.dia) {
		case LUNES, MARTES, MIERCOLES:
			return 500 + deporte.getComplejidad();
		default:
			return 1000 + 200 * deporte.getComplejidad();
		}
	}
	
	public DiaDeLaSemana getDia() {
		return dia;
	}
	
	public int getDuracion() {
		return this.duracion;
	}


	public LocalTime getHoraDeInicio() {
		return horaDeInicio;
	}

	public Deporte getDeporte() {
		return deporte;
	}
	
	@Override
	public String toString() {
		return "Deporte: " + this.deporte + ". " + "Día: " + this.dia + ". " + "Duración: " + this.duracion + " hora(s)";
	}
	
}
